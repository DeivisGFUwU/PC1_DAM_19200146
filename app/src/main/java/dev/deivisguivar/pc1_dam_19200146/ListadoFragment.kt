package dev.deivisguivar.pc1_dam_19200146

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListadoFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: FutbolistasAdapter
    private lateinit var futbolistasList: List<Futbolista>  // Lista de futbolistas

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflamos el layout del fragmento
        val view = inflater.inflate(R.layout.fragment_listado, container, false)

        // Inicializamos la lista con algunos futbolistas
        futbolistasList = listOf(
            Futbolista("Lionel Messi", 1987, "Lionel Andrés Messi", 36, R.drawable.messi),
            Futbolista("Cristiano Ronaldo", 1985, "Cristiano Ronaldo dos Santos Aveiro", 38, R.drawable.ronaldo),
            Futbolista("Neymar Jr", 1992, "Neymar da Silva Santos Júnior", 32, R.drawable.neymar)
        )

        // Configuramos el RecyclerView
        recyclerView = view.findViewById(R.id.recycler_view_futbolistas)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        adapter = FutbolistasAdapter(futbolistasList)
        recyclerView.adapter = adapter

        return view
    }
}