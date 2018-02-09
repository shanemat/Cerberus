package cz.cvut.fit.android.cerberus.structures.story.chapters.first

import cz.cvut.fit.android.cerberus.R
import cz.cvut.fit.android.cerberus.structures.answers.StoryAnswer
import cz.cvut.fit.android.cerberus.structures.enums.PlayerRole
import cz.cvut.fit.android.cerberus.structures.story.node.StoryLinks
import cz.cvut.fit.android.cerberus.structures.story.node.StoryNode
import cz.cvut.fit.android.cerberus.structures.story.node.StoryResources
import cz.cvut.fit.android.cerberus.structures.story.node.StoryRoles

class ActFirstThinkLater(previousID: Long)
    : StoryNode(StoryLinks(5, previousID, 7, true),
                StoryRoles(PlayerRole.BOMB_EXPERT, PlayerRole.POACHER),
                StoryResources(R.string.act_first_think_later_text, 1)) {

    init {
        addAnswer(StoryAnswer(R.string.poacher_call_out, answeringRole, 7, 8))
    }
}