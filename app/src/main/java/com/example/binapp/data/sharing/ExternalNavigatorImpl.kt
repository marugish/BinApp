package com.example.binapp.data.sharing

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import com.example.binapp.domain.external.ExternalNavigator

class ExternalNavigatorImpl(private val context: Context): ExternalNavigator {
    override fun openLink(link: String) {
        try {
            Intent(Intent.ACTION_VIEW, Uri.parse(link)).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }.also { context.startActivity(it) }
        } catch(e: Exception) {
            Log.d("ExternalNavigatorImpl", "openLink() ${e.message}")
        }
    }

    override fun openPhone(phone: String) {
        try {
            val cleanPhone = phone.filter { it.isDigit() }
            Intent(Intent.ACTION_DIAL, Uri.parse("tel:$cleanPhone")).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }.also { context.startActivity(it) }
        } catch (e: Exception) {
            Log.d("ExternalNavigatorImpl", "openPhone() ${e.message}")
        }
    }

    override fun openMaps(latitude: Int, longitude: Int) {
        try {
            val uri = Uri.parse("geo:${latitude.toDouble()},${longitude.toDouble()}")
            Intent(Intent.ACTION_VIEW, uri).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }.also { context.startActivity(it) }
        } catch (e: Exception) {
            Log.d("ExternalNavigatorImpl", "openMaps() ${e.message}")
        }
    }
}