package cz.cvut.fit.android.cerberus.business.managers.interfaces

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap

interface IPhotoManager {

    fun prepareCameraIntent(context: Context): Intent?

    fun getTeamPhoto(activity: Activity): Bitmap?
}