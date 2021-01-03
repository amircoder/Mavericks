package com.multithread.dindinntest.ui.venue

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.airbnb.mvrx.*
import com.multithread.dindinntest.base.BaseFragment
import com.multithread.dindinntest.databinding.FragmentVenueBinding
import com.multithread.dindinntest.util.ImageLoader
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class VenueFragment : BaseFragment() {

    @Inject
    lateinit var imageLoader: ImageLoader
    @Inject
    lateinit var viewModelFactory: VenueViewModel.Factory

    private val viewModel: VenueViewModel by fragmentViewModel()

    private val viewPagerAdapter by lazy {
        MainViewPagerAdapter(requireContext(), imageLoader)
    }

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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initViewPager()
        viewModel.fetchCategories()
    }

    private fun initViewPager() {
        binding.mainTabLayout.setupWithViewPager(binding.mainViewPager)
        binding.mainViewPager.adapter = viewPagerAdapter
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun invalidate() = withState(viewModel) {
        showLoading(it.venues.shouldLoad)
        when (it.venues) {
            is Uninitialized -> {
                // do nothing
            }
            is Fail -> {
                onError(it.venues.error.localizedMessage ?: "")
            }
            is Success -> {
                viewPagerAdapter.itemList = it.venues()!![0].coverImages
            }
            is Loading -> {
                // do nothing
            }
        }
    }

}