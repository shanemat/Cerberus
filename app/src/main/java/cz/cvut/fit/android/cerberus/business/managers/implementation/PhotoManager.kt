package cz.cvut.fit.android.cerberus.business.managers.implementation

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Environment
import android.provider.MediaStore
import cz.cvut.fit.android.cerberus.business.managers.interfaces.IPhotoManager
import cz.cvut.fit.android.cerberus.business.utils.PictureUtils
import java.io.File

object PhotoManager : IPhotoManager {

    private const val TEAM_PHOTO_FILE_NAME = "IMG_TEAM_PHOTO.jpg"

    override fun prepareCameraIntent(context: Context): Intent? {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        val photoFile = getPhotoFile(context)

        return if (canTakePhoto(context, intent, photoFile)) {
            val uri = Uri.fromFile(photoFile)
            intent.putExtra(MediaStore.EXTRA_OUTPUT, uri)

            intent
        } else {
            null
        }
    }

    override fun getTeamPhoto(activity: Activity): Bitmap? {
        val photoFile = getPhotoFile(activity)
        return if (photoFile != null && photoFile.exists()) {
            PictureUtils.getScaledBitmap(photoFile.path, activity)
        } else {
            null
        }
    }

    private fun getPhotoFile(context: Context): File? {
        val externalDirectory = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return if (externalDirectory != null) {
            File(externalDirectory, TEAM_PHOTO_FILE_NAME)
        } else {
            null
        }
    }

    private fun canTakePhoto(context: Context, intent: Intent, photoFile: File?): Boolean {
        return intent.resolveActivity(context.packageManager) != null && photoFile != null
    }
}