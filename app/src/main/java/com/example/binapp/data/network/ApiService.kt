package com.example.binapp.data.network

import com.example.binapp.data.network.dto.BinInfoDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("{bin}")
    suspend fun getBinInfo(
        @Path("bin") bin: String
    ): Response<BinInfoDto>
}