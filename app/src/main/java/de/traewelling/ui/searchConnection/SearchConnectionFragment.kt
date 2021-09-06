package de.traewelling.ui.searchConnection

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import de.traewelling.R
import de.traewelling.adapters.ConnectionAdapter
import de.traewelling.databinding.FragmentSearchConnectionBinding
import de.traewelling.models.Connection
import de.traewelling.ui.include.cardSearchStation.SearchStationCard

class SearchConnectionFragment : Fragment() {

    private lateinit var binding: FragmentSearchConnectionBinding
    private lateinit var searchStationCard: SearchStationCard
    private val connections = mutableListOf(
        Connection(R.drawable.ic_train, "RE 75", "Ulm Hbf", "15:02"),
        Connection(R.drawable.ic_train, "RE 75", "Kempten(Allgäu)Hbf", "15:04"),
        Connection(R.drawable.ic_train, "RE 72", "München Hbf", "15:08"),
        Connection(R.drawable.ic_train, "RB RS 7", "Ulm Hbf", "15:17"),
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchConnectionBinding.inflate(inflater, container, false)
        searchStationCard = SearchStationCard(this, binding.searchCard)
        val connectionRecyclerView = binding.recyclerViewConnections
        connectionRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        connectionRecyclerView.adapter = ConnectionAdapter(connections)
        connectionRecyclerView.addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
        binding.apply {
            searchCard.viewModel = searchStationCard
        }
        return binding.root
    }
}