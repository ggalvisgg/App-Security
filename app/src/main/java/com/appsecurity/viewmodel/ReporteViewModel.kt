package com.appsecurity.viewmodel

import android.content.Context
import com.mapbox.geojson.Point
import android.net.Uri
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import com.appsecurity.model.CategoriaReporte
import com.appsecurity.model.Reporte
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import java.util.UUID

class ReporteViewModel : ViewModel() {

    private val auth = FirebaseAuth.getInstance()
    private val db = FirebaseFirestore.getInstance()
    private val storage = FirebaseStorage.getInstance()

    var mensajeError by mutableStateOf<String?>(null)
    var reporteCreado by mutableStateOf<Boolean>(false)

    var listaMisReportes by mutableStateOf<List<Reporte>>(emptyList())
    var listaTodosReportes by mutableStateOf<List<Reporte>>(emptyList())


    fun crearReporte(
        titulo: String,
        descripcion: String,
        categoria: CategoriaReporte,
        point: Point?,
        imagenUri: Uri?,
        context: Context
    ) {
        val uid = auth.currentUser?.uid ?: return

        if (point == null) {
            mensajeError = "Selecciona una ubicación en el mapa"
            return
        }

        if (imagenUri == null) {
            mensajeError = "Selecciona una imagen para el reporte"
            return
        }

        // Subir imagen primero
        val nombreArchivo = UUID.randomUUID().toString()
        val refImagen = storage.reference.child("imagenes_reportes/$nombreArchivo.jpg")

        refImagen.putFile(imagenUri)
            .continueWithTask { task ->
                if (!task.isSuccessful) throw task.exception ?: Exception("Fallo en la carga")
                refImagen.downloadUrl
            }
            .addOnSuccessListener { urlImagen ->

                // 🔧 Generamos el ID desde Firestore
                val docRef = db.collection("reportes").document()
                val id = docRef.id

                val nuevoReporte = Reporte(
                    id = id,
                    titulo = titulo,
                    descripcion = descripcion,
                    categoria = categoria,
                    latitud = point.latitude(),
                    longitud = point.longitude(),
                    urlImagen = urlImagen.toString(),
                    uidUsuario = uid
                )

                docRef.set(nuevoReporte)
                    .addOnSuccessListener {
                        reporteCreado = true
                    }
                    .addOnFailureListener {
                        mensajeError = "Error guardando el reporte: ${it.message}"
                    }

            }
            .addOnFailureListener {
                mensajeError = "Error subiendo la imagen: ${it.message}"
            }
    }

    fun obtenerMisReportes() {
        val uid = auth.currentUser?.uid ?: return

        db.collection("reportes")
            .whereEqualTo("uidUsuario", uid)
            .get()
            .addOnSuccessListener { snapshot ->
                listaMisReportes = snapshot.documents.mapNotNull { doc ->
                    doc.toObject(Reporte::class.java)?.copy(id = doc.id)
                }
            }
            .addOnFailureListener {
                mensajeError = "Error obteniendo tus reportes: ${it.message}"
            }
    }

    fun obtenerTodosLosReportes() {
        db.collection("reportes")
            .get()
            .addOnSuccessListener { snapshot ->
                listaTodosReportes = snapshot.documents.mapNotNull { doc ->
                    doc.toObject(Reporte::class.java)?.copy(id = doc.id)
                }
            }
            .addOnFailureListener {
                mensajeError = "Error obteniendo los reportes: ${it.message}"
            }
    }

    fun actualizarReporte(reporte: Reporte, onSuccess: () -> Unit, onError: (String) -> Unit) {
//        if (reporte.id.isBlank()) {
//            onError("El ID del reporte es inválido")
//            return
//        }

        // Log para depurar
        Log.d("ACTUALIZAR", "Editando reporte con ID: ${reporte.id}")
        Log.d("ACTUALIZAR", "Contenido: $reporte")

        db.collection("reportes").document(reporte.id).set(reporte)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener { ex ->
                Log.e("ACTUALIZAR", "Error: ${ex.message}")
                onError(ex.message ?: "Error al actualizar")
            }
    }



    fun eliminarReporte(id: String, onSuccess: () -> Unit, onError: (String) -> Unit) {
        db.collection("reportes").document(id).delete()
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener { onError(it.message ?: "Error al eliminar") }
    }

    fun limpiarEstado() {
        mensajeError = null
        reporteCreado = false
    }
}
