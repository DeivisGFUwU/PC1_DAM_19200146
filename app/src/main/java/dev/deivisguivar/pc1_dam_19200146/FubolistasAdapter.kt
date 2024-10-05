package dev.deivisguivar.pc1_dam_19200146

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FutbolistasAdapter(private val futbolistasList: List<Futbolista>) :
    RecyclerView.Adapter<FutbolistasAdapter.FutbolistaViewHolder>() {

    // ViewHolder para manejar las vistas de cada item
    class FutbolistaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nombreTextView: TextView = view.findViewById(R.id.nombre_jugador)
        val anioNacimientoTextView: TextView = view.findViewById(R.id.anio_nacimiento_jugador)
        val edadTextView: TextView = view.findViewById(R.id.edad_jugador)
        val nombreCompletoTextView: TextView = view.findViewById(R.id.nombre_completo_jugador)
        val fotoImageView: ImageView = view.findViewById(R.id.foto_jugador)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FutbolistaViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_futbolista, parent, false)
        return FutbolistaViewHolder(view)
    }

    override fun onBindViewHolder(holder: FutbolistaViewHolder, position: Int) {
        val futbolista = futbolistasList[position]
        holder.nombreTextView.text = futbolista.nombre
        holder.anioNacimientoTextView.text = "Año de nacimiento: ${futbolista.anioNacimiento}"
        holder.edadTextView.text = "Edad: ${futbolista.edad}"
        holder.nombreCompletoTextView.text = futbolista.nombreCompleto
        holder.fotoImageView.setImageResource(futbolista.foto)
    }

    override fun getItemCount() = futbolistasList.size
}