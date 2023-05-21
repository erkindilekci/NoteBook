package com.erkindilekci.notebook.presentation.util

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView

@Composable
fun MainBannerAdView() {
    AndroidView(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
        ,
        factory = { context ->
            AdView(context).apply {
                setAdSize(AdSize.BANNER)
                adUnitId = "ca-app-pub-6857571371166228/8686822347"
                loadAd(AdRequest.Builder().build())
            }
        }
    )
}