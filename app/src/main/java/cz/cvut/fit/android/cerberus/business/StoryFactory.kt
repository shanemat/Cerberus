package cz.cvut.fit.android.cerberus.business

import cz.cvut.fit.android.cerberus.structures.story.node.StoryNode
import cz.cvut.fit.android.cerberus.structures.story.UnknownNode
import cz.cvut.fit.android.cerberus.structures.story.chapters.first.*

object StoryFactory {

    fun getStoryNode(ID: Long, previousID: Long): StoryNode {
        return when (ID) {
            0L -> Beginning()
            1L -> HardLanding(previousID)
            2L -> Parachutes(previousID)
            3L -> DesertAmbush(previousID)
            4L -> ScoutingPaysOff(previousID)
            else -> UnknownNode(previousID)
        }
    }
}