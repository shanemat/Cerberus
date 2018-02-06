package cz.cvut.fit.android.cerberus.structures.story.chapters.first

import cz.cvut.fit.android.cerberus.R
import cz.cvut.fit.android.cerberus.structures.answers.StoryAnswer
import cz.cvut.fit.android.cerberus.structures.enums.PlayerRole
import cz.cvut.fit.android.cerberus.structures.story.node.StoryLinks
import cz.cvut.fit.android.cerberus.structures.story.node.StoryNode
import cz.cvut.fit.android.cerberus.structures.story.node.StoryResources

class Parachutes(previousID: Long)
    : StoryNode(StoryLinks(2, previousID, 3, false),
                StoryResources(R.string.parachutes_text, PlayerRole.POACHER, awardedPoints = 0)) {

    init {
        addAnswer(StoryAnswer(R.string.parachutes_go_straight, role, 5))
        addAnswer(StoryAnswer(R.string.parachutes_create_strategy, role, 6))
    }
}