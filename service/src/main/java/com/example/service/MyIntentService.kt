package com.example.service

import android.app.IntentService
import android.content.Intent


// TODO: Rename actions, choose action names that describe tasks that this
// IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
const val ACTION_FOO = "com.example.service.action.FOO"
const val ACTION_BAZ = "com.example.service.action.BAZ"

// TODO: Rename parameters
const val EXTRA_PARAM1 = "com.example.service.extra.PARAM1"
const val EXTRA_PARAM2 = "com.example.service.extra.PARAM2"

/**
 * An [IntentService] subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * TODO: Customize class - update intent actions and extra parameters.
 */
class MyIntentService : IntentService("MyIntentService") {

    override fun onHandleIntent(intent: Intent?) {

    }
}
