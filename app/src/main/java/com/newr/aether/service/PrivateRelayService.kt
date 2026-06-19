package com.newr.aether.service

import android.content.Intent
import android.net.VpnService
import android.os.IBinder
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PrivateRelayService : VpnService() {
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        startVpn()
        return START_STICKY
    }

    private fun startVpn() {
        val builder = Builder()
        builder.setSession("Aether Private Relay")
        builder.addAddress("10.0.0.2", 24)
        builder.addRoute("0.0.0.0", 0)
        builder.addDnsServer("1.1.1.1")
        builder.addDnsServer("1.0.0.1")
        
        try {
            val vpnInterface = builder.establish()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onBind(intent: Intent?): IBinder? = null
}
