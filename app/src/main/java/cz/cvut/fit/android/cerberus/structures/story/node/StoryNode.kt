package cz.cvut.fit.android.cerberus.structures.story.node

import android.content.Context
import cz.cvut.fit.android.cerberus.business.ManagerFactory
import cz.cvut.fit.android.cerberus.structures.enums.PlayerRole
import cz.cvut.fit.android.cerberus.structures.answers.StoryAnswer

abstract class StoryNode(links: StoryLinks,
                         roles: StoryRoles,
                         resources: StoryResources) {

    val ID = links.ID
    val previousID = links.previousID
    val progress = links.progress
    val leadsToGame = links.leadsToGame

    val answeringRole = roles.answeringRole
    val gameRole = roles.gameRole

    val awardedPoints = resources.awardedPoints

    private val textResourceID = resources.textResourceID
    private val textRole = roles.textRole

    var answers: ArrayList<StoryAnswer> = ArrayList()
        private set

    fun addAnswer(answer: StoryAnswer) {
        answers.add(answer)
    }

    fun getText(context: Context): String {
        val baseName = getBaseName(context)
        return context.resources.getString(textResourceID, baseName)
    }

    private fun getBaseName(context: Context): String {
        val manager = ManagerFactory.getPlayerManager()
        val player = manager.getPlayer(context, textRole)

        return player?.name ?: "---"
    }

    data class StoryLinks(val ID: Long,
                          val previousID: Long,
                          val progress: Int,
                          val leadsToGame: Boolean)

    data class StoryRoles(val answeringRole: PlayerRole,
                          val gameRole: PlayerRole = answeringRole,
                          val textRole: PlayerRole = answeringRole)

    data class StoryResources(val textResourceID: Int,
                              val awardedPoints: Int)
}