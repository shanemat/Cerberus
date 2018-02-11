package cz.cvut.fit.android.cerberus.structures.story.chapters.first

import cz.cvut.fit.android.cerberus.R
import cz.cvut.fit.android.cerberus.structures.answers.StoryAnswer
import cz.cvut.fit.android.cerberus.structures.enums.PlayerRole
import cz.cvut.fit.android.cerberus.structures.story.node.StoryNode

class Parachutes(previousID: Long)
    : StoryNode(StoryLinks(2, previousID, 3, false),
                StoryRoles(PlayerRole.BOMB_EXPERT),
                StoryResources(R.string.parachutes_text, 0)) {

    init {
        addAnswer(StoryAnswer(20, R.string.parachutes_go_straight, answeringRole, 5))
        addAnswer(StoryAnswer(21, R.string.parachutes_create_strategy, answeringRole, 6))
    }
}