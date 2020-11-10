package com.example.mybroadcastreceiver

import android.app.IntentService
import android.content.Intent
import android.content.Context
import android.util.Log

private const val ACTION_FOO = "com.example.mybroadcastreceiver.action.FOO"
private const val ACTION_BAZ = "com.example.mybroadcastreceiver.action.BAZ"

private const val EXTRA_PARAM1 = "com.example.mybroadcastreceiver.extra.PARAM1"
private const val EXTRA_PARAM2 = "com.example.mybroadcastreceiver.extra.PARAM2"

class DownloadService : IntentService("DownloadService") {

    override fun onHandleIntent(intent: Intent?) {
        Log.d(TAG, "Download Service dijalankan")
        if (intent != null) {
            try {
                Thread.sleep(5000)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
            val notifyFinishIntent = Intent(MainActivity.ACTION_DOWNLOAD_STATUS)
            sendBroadcast(notifyFinishIntent)
        }
    }

    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private fun handleActionFoo(param1: String, param2: String) {
        TODO("Handle action Foo")
    }


    private fun handleActionBaz(param1: String, param2: String) {
        TODO("Handle action Baz")
    }

    companion object {

        val TAG = DownloadService::class.java.simpleName

        fun startActionFoo(context: Context, param1: String, param2: String) {
            val intent = Intent(context, DownloadService::class.java).apply {
                action = ACTION_FOO
                putExtra(EXTRA_PARAM1, param1)
                putExtra(EXTRA_PARAM2, param2)
            }
            context.startService(intent)
        }

        // TODO: Customize helper method
        @JvmStatic
        fun startActionBaz(context: Context, param1: String, param2: String) {
            val intent = Intent(context, DownloadService::class.java).apply {
                action = ACTION_BAZ
                putExtra(EXTRA_PARAM1, param1)
                putExtra(EXTRA_PARAM2, param2)
            }
            context.startService(intent)
        }
    }
}