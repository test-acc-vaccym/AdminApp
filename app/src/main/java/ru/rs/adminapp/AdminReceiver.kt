package ru.rs.adminapp

import android.app.admin.DeviceAdminReceiver
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.util.Log

/**
 * Created by Artem Botnev on 08/23/2018
 */
class AdminReceiver : DeviceAdminReceiver() {
    companion object {
        private const val TAG = "AdminReceiver"

        fun getComponentName(context: Context): ComponentName =
                ComponentName(context.applicationContext, AdminReceiver::class.java)
    }

    override fun onEnabled(context: Context?, intent: Intent?) {
        Log.i(TAG, "Enabled")
        showShortToast(context!!, R.string.app_enable)

        MainActivity.launch(context)

        super.onEnabled(context, intent)
    }

    override fun onDisabled(context: Context?, intent: Intent?) {
        Log.i(TAG, "Disabled")
        showShortToast(context!!, R.string.app_enable)
        super.onDisabled(context, intent)
    }
}