package com.multithread.dindinntest.ui.venue.category

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.multithread.dindinntest.databinding.FragmentCategoryBinding
import com.multithread.dindinntest.domain.entity.CategoryEntity
import com.multithread.dindinntest.domain.entity.FoodEntity
import dagger.android.support.AndroidSupportInjection


class CategoryFragment : Fragment() {


    private var category: CategoryEntity = CategoryEntity()

    private var _binding: FragmentCategoryBinding? = null
    private val binding
        get() = _binding!!

    private lateinit var foodListAdapter: FoodRecyclerViewAdapter

    val callback: (FoodEntity) -> Unit = {

    }

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

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        getInfo()
        setupRecycler()
    }

    private fun setupRecycler() {
        foodListAdapter = FoodRecyclerViewAdapter(category.products, callback)
    }

    private fun getInfo() {
        arguments?.apply {
            category = getParcelable<CategoryEntity>(CATEGORY_KEY) ?: CategoryEntity()
        }
    }

    companion object {
        private const val CATEGORY_KEY = "CATEGORY_KEY"
        fun createsInstance(categoryEntity: CategoryEntity) = CategoryFragment().apply {
            arguments = Bundle().apply {
                putParcelable(CATEGORY_KEY, categoryEntity)
            }
        }
    }
}