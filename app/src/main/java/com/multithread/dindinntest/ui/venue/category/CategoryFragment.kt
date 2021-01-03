package com.multithread.dindinntest.ui.venue.category

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.multithread.dindinntest.databinding.FragmentCategoryBinding
import com.multithread.dindinntest.domain.entity.CategoryEntity
import dagger.android.support.AndroidSupportInjection


class CategoryFragment : Fragment() {

    private var _binding: FragmentCategoryBinding? = null
    private val binding
        get() = _binding!!

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCategoryBinding.inflate(inflater, container, false)
        return binding.root
    }


    companion object {
        fun createsInstance(categoryEntity: CategoryEntity) = CategoryFragment().apply {
            arguments = Bundle().apply {

            }
        }
    }
}