package cz.cvut.fit.android.cerberus.business

import cz.cvut.fit.android.cerberus.structures.story.StoryNode
import cz.cvut.fit.android.cerberus.structures.story.UnknownNode

object StoryFactory {

    fun getStoryNode(ID: Long, previousID: Long): StoryNode {
        return UnknownNode(previousID)
    }
}