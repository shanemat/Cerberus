package cz.cvut.fit.android.cerberus.structures.story

import android.content.Context
import cz.cvut.fit.android.cerberus.structures.enums.PlayerRole
import cz.cvut.fit.android.cerberus.structures.answers.StoryAnswer

abstract class StoryNode(val ID: Long,
                         val previousID: Long,
                         private val textResourceID: Int,
                         val role: PlayerRole,
                         val progress: Int,
                         val leadsToGame: Boolean) {

    private val baseName = getBaseName()

    var answers: ArrayList<StoryAnswer> = ArrayList()
        private set

    fun addAnswer(answer: StoryAnswer) {
        answers.add(answer)
    }

    fun getText(context: Context): String {
        return context.resources.getString(textResourceID, baseName)
    }

    private fun getBaseName(): String {
        // TODO add base name retrieval
        return "Unknown"
    }
}