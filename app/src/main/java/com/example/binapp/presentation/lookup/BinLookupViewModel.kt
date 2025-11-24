package com.example.binapp.presentation.lookup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.binapp.domain.network.state.BinResource
import com.example.binapp.domain.network.usecase.GetBinInfoUseCase
import com.example.binapp.domain.database.usecase.InsertBinIntoDbUseCase
import com.example.binapp.domain.external.usecase.OpenLinkUseCase
import com.example.binapp.domain.external.usecase.OpenMapsUseCase
import com.example.binapp.domain.external.usecase.OpenPhoneUseCase
import com.example.binapp.presentation.general.ExternalAppLauncher
import com.example.binapp.presentation.lookup.state.BinLookupScreenState
import kotlinx.coroutines.launch

class BinLookupViewModel(
    private val insertBinIntoDbUseCase: InsertBinIntoDbUseCase,
    private val getBinInfoUseCase: GetBinInfoUseCase,
    private val openLinkUseCase: OpenLinkUseCase,
    private val openPhoneUseCase: OpenPhoneUseCase,
    private val openMapsUseCase: OpenMapsUseCase
) : ViewModel(), ExternalAppLauncher {

    private val _state = MutableLiveData<BinLookupScreenState>(BinLookupScreenState.Initial)
    val state: LiveData<BinLookupScreenState> = _state

    fun lookupBin(query: String) {
        viewModelScope.launch {
            getBinInfoUseCase.invoke(query = query).collect { state ->
                when(state) {
                    is BinResource.Error -> {
                        _state.value = BinLookupScreenState.Error(state.errorCode.name, state.errorCode.code)
                    }
                    BinResource.Loading -> {
                        _state.value = BinLookupScreenState.Loading
                    }
                    is BinResource.Success -> {
                        _state.value = BinLookupScreenState.Content(state.binInfo)
                        // Загрузка в БД
                        insertBinIntoDbUseCase(state.binInfo)
                    }
                }
            }
        }
    }

    override fun onLinkClick(link: String) {
        openLinkUseCase(link = link)
    }

    override fun onPhoneClick(phone: String) {
        openPhoneUseCase(phone = phone)
    }

    override fun onCoordinatesClick(latitude: Int, longitude: Int) {
        openMapsUseCase(latitude = latitude, longitude = longitude)
    }
}