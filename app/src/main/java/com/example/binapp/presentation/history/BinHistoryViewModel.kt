package com.example.binapp.presentation.history

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.binapp.domain.database.usecase.GetBinsFromDbUseCase
import com.example.binapp.domain.external.usecase.OpenLinkUseCase
import com.example.binapp.domain.external.usecase.OpenMapsUseCase
import com.example.binapp.domain.external.usecase.OpenPhoneUseCase
import com.example.binapp.presentation.general.ExternalAppLauncher
import com.example.binapp.presentation.history.state.BinHistoryScreenState
import kotlinx.coroutines.launch

class BinHistoryViewModel(
    private val getBinsFromDbUseCase: GetBinsFromDbUseCase,
    private val openLinkUseCase: OpenLinkUseCase,
    private val openPhoneUseCase: OpenPhoneUseCase,
    private val openMapsUseCase: OpenMapsUseCase
) : ViewModel(), ExternalAppLauncher {

    private val _state = MutableLiveData<BinHistoryScreenState>()
    val state: LiveData<BinHistoryScreenState> = _state

    init {
        loadBinList()
    }

    private fun loadBinList() {
        viewModelScope.launch {
            _state.value = BinHistoryScreenState.Loading
            getBinsFromDbUseCase().collect { list ->
                if (list.isEmpty()) {
                    _state.value = BinHistoryScreenState.Empty
                } else {
                    _state.value = BinHistoryScreenState.Content(list = list)
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