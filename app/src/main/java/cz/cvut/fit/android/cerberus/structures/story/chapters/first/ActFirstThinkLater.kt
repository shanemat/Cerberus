package cz.cvut.fit.android.cerberus.structures.story.chapters.first

import cz.cvut.fit.android.cerberus.R
import cz.cvut.fit.android.cerberus.structures.answers.StoryAnswer
import cz.cvut.fit.android.cerberus.structures.enums.PlayerRole
import cz.cvut.fit.android.cerberus.structures.story.node.StoryLinks
import cz.cvut.fit.android.cerberus.structures.story.node.StoryNode
import cz.cvut.fit.android.cerberus.structures.story.node.StoryResources

class ActFirstThinkLater(previousID: Long)
    : StoryNode(StoryLinks(5, previousID, 7, true),
                StoryResources(R.string.act_first_think_later_text, PlayerRole.POACHER, awardedPoints = 1)) {

    init {
        addAnswer(StoryAnswer(R.string.poacher_call_out, role, 7, 8))
    }
}