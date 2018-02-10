package cz.cvut.fit.android.cerberus.business

import cz.cvut.fit.android.cerberus.structures.story.node.StoryNode
import cz.cvut.fit.android.cerberus.structures.story.node.UnknownNode
import cz.cvut.fit.android.cerberus.structures.story.chapters.first.*
import cz.cvut.fit.android.cerberus.structures.story.chapters.second.*
import cz.cvut.fit.android.cerberus.structures.story.chapters.third.PorterGameFailure
import cz.cvut.fit.android.cerberus.structures.story.chapters.third.PorterGameSuccess

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
            8L -> PoacherFailure(previousID)

            9L -> GunsBlazing(previousID)
            10L -> SneakySneaky(previousID)
            11L -> ComeInside(previousID)
            12L -> ShootASAP(previousID)

            13L -> PorterGameSuccess(previousID)
            14L -> PorterGameFailure(previousID)

            else -> UnknownNode(previousID)
        }
    }
}