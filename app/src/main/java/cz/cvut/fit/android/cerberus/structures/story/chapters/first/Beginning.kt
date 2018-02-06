package cz.cvut.fit.android.cerberus.structures.story.chapters.first

import cz.cvut.fit.android.cerberus.R
import cz.cvut.fit.android.cerberus.structures.answers.StoryAnswer
import cz.cvut.fit.android.cerberus.structures.enums.PlayerRole
import cz.cvut.fit.android.cerberus.structures.story.node.StoryLinks
import cz.cvut.fit.android.cerberus.structures.story.node.StoryNode
import cz.cvut.fit.android.cerberus.structures.story.node.StoryResources

class Beginning()
    : StoryNode(StoryLinks(0, 0, 0, false),
                StoryResources(R.string.beginning_text, PlayerRole.POACHER, awardedPoints = 0)) {

    init {
        addAnswer(StoryAnswer(R.string.beginning_answer_wait_little_longer, role, 1))
        addAnswer(StoryAnswer(R.string.beginning_answer_open_parachutes, role, 2))
    }
}