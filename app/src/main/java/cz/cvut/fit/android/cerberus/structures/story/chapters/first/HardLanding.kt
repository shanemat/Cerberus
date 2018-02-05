package cz.cvut.fit.android.cerberus.structures.story.chapters.first

import cz.cvut.fit.android.cerberus.R
import cz.cvut.fit.android.cerberus.structures.answers.StoryAnswer
import cz.cvut.fit.android.cerberus.structures.enums.PlayerRole
import cz.cvut.fit.android.cerberus.structures.story.StoryNode

class HardLanding(previousID: Long)
    : StoryNode(1, previousID, R.string.hard_landing_text,
        PlayerRole.POACHER, 3, false) {

    init {
        addAnswer(StoryAnswer(R.string.hard_landing_go_straight, role, 3))
        addAnswer(StoryAnswer(R.string.hard_landing_create_strategy, role, 4))
    }
}