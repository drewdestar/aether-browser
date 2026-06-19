package com.newr.aether.ui.components

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun WebViewContainer(
    url: String,
    onUrlChange: (String) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        AndroidView(
            factory = { context ->
                WebView(context).apply {
                    webViewClient = AetherWebViewClient(onUrlChange)
                    settings.apply {
                        javaScriptEnabled = true
                        domStorageEnabled = true
                        databaseEnabled = true
                    }
                }
            },
            update = { webView ->
                if (url.isNotEmpty() && url != "about:blank") {
                    webView.loadUrl(url)
                }
            },
            modifier = Modifier.fillMaxSize()
        )
    }
}

class AetherWebViewClient(private val onUrlChange: (String) -> Unit) : WebViewClient() {
    override fun onPageFinished(view: WebView?, url: String?) {
        super.onPageFinished(view, url)
        url?.let { onUrlChange(it) }
    }
}
