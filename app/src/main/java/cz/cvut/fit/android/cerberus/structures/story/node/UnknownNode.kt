package cz.cvut.fit.android.cerberus.structures.story.node

import cz.cvut.fit.android.cerberus.R
import cz.cvut.fit.android.cerberus.structures.answers.StoryAnswer
import cz.cvut.fit.android.cerberus.structures.enums.PlayerRole

class UnknownNode(previousID: Long)
    : StoryNode(StoryLinks(-1, previousID, 0, false),
                StoryRoles(PlayerRole.POACHER),
                StoryResources(R.string.unknown_node_text, 0)) {

    init {
        addAnswer(StoryAnswer(-10, R.string.unknown_node_answer, PlayerRole.POACHER, 0))
    }
}