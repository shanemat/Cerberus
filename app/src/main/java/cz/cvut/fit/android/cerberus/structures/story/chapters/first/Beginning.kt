package cz.cvut.fit.android.cerberus.structures.story.chapters.first

import cz.cvut.fit.android.cerberus.R
import cz.cvut.fit.android.cerberus.structures.answers.StoryAnswer
import cz.cvut.fit.android.cerberus.structures.enums.PlayerRole
import cz.cvut.fit.android.cerberus.structures.story.node.StoryLinks
import cz.cvut.fit.android.cerberus.structures.story.node.StoryNode
import cz.cvut.fit.android.cerberus.structures.story.node.StoryResources
import cz.cvut.fit.android.cerberus.structures.story.node.StoryRoles

class Beginning()
    : StoryNode(StoryLinks(0, 0, 0, false),
                StoryRoles(PlayerRole.BOMB_EXPERT),
                StoryResources(R.string.beginning_text, 0)) {

    init {
        addAnswer(StoryAnswer(R.string.beginning_answer_wait_little_longer, answeringRole, 1))
        addAnswer(StoryAnswer(R.string.beginning_answer_open_parachutes, answeringRole, 2))
    }
}