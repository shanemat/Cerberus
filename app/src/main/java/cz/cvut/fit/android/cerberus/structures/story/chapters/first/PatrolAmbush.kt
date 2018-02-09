package cz.cvut.fit.android.cerberus.structures.story.chapters.first

import cz.cvut.fit.android.cerberus.R
import cz.cvut.fit.android.cerberus.structures.answers.StoryAnswer
import cz.cvut.fit.android.cerberus.structures.enums.PlayerRole
import cz.cvut.fit.android.cerberus.structures.story.node.StoryLinks
import cz.cvut.fit.android.cerberus.structures.story.node.StoryNode
import cz.cvut.fit.android.cerberus.structures.story.node.StoryResources
import cz.cvut.fit.android.cerberus.structures.story.node.StoryRoles

class PatrolAmbush(previousID: Long)
    : StoryNode(StoryLinks(6, previousID, 7, true),
                StoryRoles(PlayerRole.BOMB_EXPERT, PlayerRole.POACHER),
                StoryResources(R.string.patrol_ambush_text, 0)) {

    init {
        addAnswer(StoryAnswer(R.string.poacher_call_out, PlayerRole.POACHER, 7, 8))
    }
}