package com.example.binapp.domain.network.state

import com.example.binapp.data.network.NetworkError
import com.example.binapp.domain.model.Bin

sealed class BinResource {
    data object Loading: BinResource()
    data class Success(val binInfo: Bin): BinResource()
    data class Error(val errorCode: NetworkError): BinResource()
}