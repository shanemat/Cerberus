package cz.cvut.fit.android.cerberus.structures.story

import cz.cvut.fit.android.cerberus.R
import cz.cvut.fit.android.cerberus.structures.answers.StoryAnswer
import cz.cvut.fit.android.cerberus.structures.enums.PlayerRole
import cz.cvut.fit.android.cerberus.structures.story.node.StoryLinks
import cz.cvut.fit.android.cerberus.structures.story.node.StoryNode
import cz.cvut.fit.android.cerberus.structures.story.node.StoryResources

class UnknownNode(previousID: Long)
    : StoryNode(StoryLinks(-1, previousID, 0, false),
                StoryResources(R.string.unknown_node_text, PlayerRole.POACHER, 0)) {

    init {
        addAnswer(StoryAnswer(R.string.unknown_node_answer, PlayerRole.POACHER, 0))
    }
}