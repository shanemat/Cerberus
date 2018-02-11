package cz.cvut.fit.android.cerberus.structures.answers

import android.content.Context
import cz.cvut.fit.android.cerberus.business.ManagerFactory
import cz.cvut.fit.android.cerberus.structures.enums.PlayerRole

class StoryAnswer(val ID: Long,
                  private val textResourceID: Int,
                  private val currentRole: PlayerRole,
                  val targetID: Long,
                  val alternativeID: Long = targetID) {

    var isSelected = false

    fun getText(context: Context): String {
        val manager = ManagerFactory.getPlayerManager()
        val player = manager.getPlayer(context, currentRole)

        val baseName = player?.name ?: "---"
        val calledName = manager.getCalledName(baseName)

        return context.resources.getString(textResourceID, baseName, calledName)
    }
}