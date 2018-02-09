package cz.cvut.fit.android.cerberus.business

import cz.cvut.fit.android.cerberus.structures.story.node.StoryNode
import cz.cvut.fit.android.cerberus.structures.story.node.UnknownNode
import cz.cvut.fit.android.cerberus.structures.story.chapters.first.*
import cz.cvut.fit.android.cerberus.structures.story.chapters.second.PoacherSuccess

object StoryFactory {

    fun getStoryNode(ID: Long, previousID: Long): StoryNode {
        return when (ID) {
            0L -> Beginning()
            1L -> HardLanding(previousID)
            2L -> Parachutes(previousID)
            3L -> DesertAmbush(previousID)
            4L -> ScoutingPaysOff(previousID)
            5L -> ActFirstThinkLater(previousID)
            6L -> PatrolAmbush(previousID)

            7L -> PoacherSuccess(previousID)
            else -> UnknownNode(previousID)
        }
    }
}