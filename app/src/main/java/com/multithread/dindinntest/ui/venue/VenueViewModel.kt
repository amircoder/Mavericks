package com.multithread.dindinntest.ui.venue

import com.airbnb.mvrx.FragmentViewModelContext
import com.airbnb.mvrx.MvRxViewModelFactory
import com.airbnb.mvrx.ViewModelContext
import com.multithread.dindinntest.base.AnyParam
import com.multithread.dindinntest.base.MvRxViewModel
import com.multithread.dindinntest.base.RepositoryStrategy
import com.multithread.dindinntest.base.SingleUseCase
import com.multithread.dindinntest.data.dto.DeliveryDTO
import com.multithread.dindinntest.domain.entity.VenueEntity
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import io.reactivex.android.schedulers.AndroidSchedulers


typealias VenueUseCaseAlias = SingleUseCase<AnyParam, List<VenueEntity>>

class VenueViewModel @AssistedInject constructor(
    @Assisted state: VenueState,
    private val venueUseCase: VenueUseCaseAlias,
) : MvRxViewModel<VenueState>(state) {

    fun fetchCategories() {
        venueUseCase
            .invokeOperation(AnyParam(), RepositoryStrategy.Remote)
            .execute {
                copy(venues = it)
            }
    }

    @AssistedInject.Factory
    interface Factory {
        fun create(state: VenueState): VenueViewModel
    }

    companion object : MvRxViewModelFactory<VenueViewModel, VenueState> {
        override fun create(
            viewModelContext: ViewModelContext,
            state: VenueState
        ): VenueViewModel? {
            val fragment = (viewModelContext as FragmentViewModelContext).fragment<VenueFragment>()
            return fragment.viewModelFactory.create(state)
        }
    }

}