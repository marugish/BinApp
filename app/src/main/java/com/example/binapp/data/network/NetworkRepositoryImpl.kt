package com.example.binapp.data.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import com.example.binapp.data.network.mapper.BinMapper
import com.example.binapp.domain.network.state.BinResource
import com.example.binapp.domain.network.NetworkRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

class NetworkRepositoryImpl(
    private val apiService: ApiService,
    private val mapper: BinMapper,
    private val context: Context
): NetworkRepository {
    override fun getBinInfo(query: String): Flow<BinResource> {
        return flow {
            // Проверка сети
            if (!isNetworkAvailable()) {
                emit(BinResource.Error(NetworkError.NoInternet))
                return@flow
            }
            // Загрузка
            emit(BinResource.Loading)
            // Получение данных
            try {
                val response = withContext(Dispatchers.IO) {
                    apiService.getBinInfo(bin = query)
                }

                if (response.isSuccessful && response.body() != null) {
                    val binInfo = response.body()!!
                    emit(BinResource.Success(mapper.mapToDomain(binInfo, query)))
                } else {
                    val networkError = NetworkError.fromCode(response.code())
                    emit(BinResource.Error(networkError))
                }
            } catch (e: Exception) {
                emit(BinResource.Error(NetworkError.Unknown))
            }
        }
    }

    private fun isNetworkAvailable(): Boolean {
        val connectivityManager = context.getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as? ConnectivityManager ?: return false

        val network = connectivityManager.activeNetwork ?: return false
        val capabilities = connectivityManager.getNetworkCapabilities(network) ?: return false

        return capabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }
}