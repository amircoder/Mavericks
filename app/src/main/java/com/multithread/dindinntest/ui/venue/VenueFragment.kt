package com.multithread.dindinntest.ui.venue

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.mvrx.BaseMvRxFragment
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.multithread.dindinntest.base.BaseFragment
import com.multithread.dindinntest.databinding.FragmentVenueBinding
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class VenueFragment : BaseFragment() {

    @Inject
    lateinit var viewModelFactory: VenueViewModel.Factory
    private val viewModel: VenueViewModel by fragmentViewModel()

    private var _binding: FragmentVenueBinding? = null
    private val binding get() = _binding!!

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentVenueBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun invalidate() = withState(viewModel) {
        showLoading(it.categories.shouldLoad)

    }

}