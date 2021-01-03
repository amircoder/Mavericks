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

    private val venueCategoryListViewPager: VenueCategoryViewPagerAdapter by lazy {
        VenueCategoryViewPagerAdapter(parentFragmentManager)
    }

    private var _binding: FragmentVenueBinding? = null
    private val binding get() = _binding!!


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
        binding.venueTabLayout.setupWithViewPager(binding.venueViewPager, true)
        binding.venueViewPager.adapter = viewPagerAdapter
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
                it.venues()!![0].let {venue ->
                    binding.venueTitleTextView.text = venue.name
                    viewPagerAdapter.itemList = venue.coverImages
                }
            }
            is Loading -> {
                // do nothing
            }
        }
    }

}