package cz.cvut.fit.android.cerberus.structures.story.chapters.first

import cz.cvut.fit.android.cerberus.R
import cz.cvut.fit.android.cerberus.structures.answers.StoryAnswer
import cz.cvut.fit.android.cerberus.structures.enums.PlayerRole
import cz.cvut.fit.android.cerberus.structures.story.node.StoryNode

class DesertAmbush(previousID: Long)
    : StoryNode(StoryLinks(3, previousID, 7, true),
                StoryRoles(PlayerRole.BOMB_EXPERT, PlayerRole.POACHER),
                StoryResources(R.string.desert_ambush_text, 0)) {

    init {
        addAnswer(StoryAnswer(30, R.string.poacher_call_out, PlayerRole.POACHER, 7, 8))
    }
}