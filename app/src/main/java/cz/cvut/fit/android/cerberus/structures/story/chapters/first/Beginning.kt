package cz.cvut.fit.android.cerberus.structures.story.chapters.first

import cz.cvut.fit.android.cerberus.R
import cz.cvut.fit.android.cerberus.structures.answers.StoryAnswer
import cz.cvut.fit.android.cerberus.structures.enums.PlayerRole
import cz.cvut.fit.android.cerberus.structures.story.StoryNode

class Beginning()
    : StoryNode(0, 0, R.string.beginning_text,
        PlayerRole.POACHER, 0, false) {

    init {
        addAnswer(StoryAnswer(R.string.beginning_answer_wait_little_longer, role, 1))
        addAnswer(StoryAnswer(R.string.beginning_answer_open_parachutes, role, 2))
    }
}