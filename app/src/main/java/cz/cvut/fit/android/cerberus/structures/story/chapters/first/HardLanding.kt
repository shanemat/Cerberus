package cz.cvut.fit.android.cerberus.structures.story.chapters.first

import cz.cvut.fit.android.cerberus.R
import cz.cvut.fit.android.cerberus.structures.answers.StoryAnswer
import cz.cvut.fit.android.cerberus.structures.enums.PlayerRole
import cz.cvut.fit.android.cerberus.structures.story.node.StoryLinks
import cz.cvut.fit.android.cerberus.structures.story.node.StoryNode
import cz.cvut.fit.android.cerberus.structures.story.node.StoryResources

class HardLanding(previousID: Long)
    : StoryNode(StoryLinks(1, previousID, 3, false),
                StoryResources(R.string.hard_landing_text, PlayerRole.POACHER, awardedPoints = 1)) {

    init {
        addAnswer(StoryAnswer(R.string.hard_landing_go_straight, role, 3))
        addAnswer(StoryAnswer(R.string.hard_landing_create_strategy, role, 4))
    }
}