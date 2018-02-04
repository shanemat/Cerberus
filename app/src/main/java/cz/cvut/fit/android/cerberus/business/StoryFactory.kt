package cz.cvut.fit.android.cerberus.business

import cz.cvut.fit.android.cerberus.structures.story.StoryNode
import cz.cvut.fit.android.cerberus.structures.story.UnknownNode
import cz.cvut.fit.android.cerberus.structures.story.chapters.first.Beginning

object StoryFactory {

    fun getStoryNode(ID: Long, previousID: Long): StoryNode {
        return when (ID) {
            0L -> Beginning()
            else -> UnknownNode(previousID)
        }
    }
}