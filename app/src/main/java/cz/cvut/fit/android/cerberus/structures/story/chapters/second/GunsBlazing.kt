package cz.cvut.fit.android.cerberus.structures.story.chapters.second

import cz.cvut.fit.android.cerberus.R
import cz.cvut.fit.android.cerberus.structures.answers.StoryAnswer
import cz.cvut.fit.android.cerberus.structures.enums.PlayerRole
import cz.cvut.fit.android.cerberus.structures.story.node.StoryLinks
import cz.cvut.fit.android.cerberus.structures.story.node.StoryNode
import cz.cvut.fit.android.cerberus.structures.story.node.StoryResources

class GunsBlazing(previousID: Long)
    : StoryNode(StoryLinks(9, previousID,15, true),
                StoryResources(R.string.guns_blazing_text, PlayerRole.PORTER, awardedPoints = 0)) {

    init {
        addAnswer(StoryAnswer(R.string.porter_call_out, PlayerRole.PORTER, 13, 14))
    }
}