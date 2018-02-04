package cz.cvut.fit.android.cerberus.structures.answers

import android.content.Context
import cz.cvut.fit.android.cerberus.structures.enums.PlayerRole

class StoryAnswer(private val textResourceID: Int,
                  private val currentRole: PlayerRole,
                  val targetID: Long) {

    var isSelected = false

    private val baseName = getBaseName()
    private val calledName = getCalledName()

    fun getText(context: Context): String {
        return context.resources.getString(textResourceID, baseName, calledName)
    }

    private fun getBaseName(): String {
        // TODO add base name retrieval
        return "Unknown"
    }

    private fun getCalledName(): String {
        // TODO add called name retrieval
        return "Unknown"
    }
}