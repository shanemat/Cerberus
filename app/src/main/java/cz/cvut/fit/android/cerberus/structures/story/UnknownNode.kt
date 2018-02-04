package cz.cvut.fit.android.cerberus.structures.story

import cz.cvut.fit.android.cerberus.R
import cz.cvut.fit.android.cerberus.structures.answers.StoryAnswer
import cz.cvut.fit.android.cerberus.structures.enums.PlayerRole

class UnknownNode(previousID: Long)
    : StoryNode(-1, previousID, R.string.unknown_node_text, PlayerRole.POACHER, 0) {

    init {
        addAnswer(StoryAnswer(R.string.unknown_node_answer, PlayerRole.POACHER, 0))
    }
}