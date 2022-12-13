package com.example.kotlintest

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationManager
import androidx.core.content.ContextCompat


object LocationUtils {
    @SuppressLint("ServiceCast")
    fun getLastKnownLocation(c: Context): Location? {
        if (ContextCompat.checkSelfPermission(c, Manifest.permission.ACCESS_FINE_LOCATION)
            == PackageManager.PERMISSION_DENIED) {
            return null
        }

        val lm = c.getSystemService(Context.LOCATION_SERVICE) as LocationManager

        return lm.getProviders(true).map { lm.getLastKnownLocation(it) }
            .minByOrNull { it?.accuracy ?: Float.MAX_VALUE }
    }
}