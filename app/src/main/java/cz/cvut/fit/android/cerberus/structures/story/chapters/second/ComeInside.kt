package cz.cvut.fit.android.cerberus.structures.story.chapters.second

import cz.cvut.fit.android.cerberus.R
import cz.cvut.fit.android.cerberus.structures.answers.StoryAnswer
import cz.cvut.fit.android.cerberus.structures.enums.PlayerRole
import cz.cvut.fit.android.cerberus.structures.story.node.StoryLinks
import cz.cvut.fit.android.cerberus.structures.story.node.StoryNode
import cz.cvut.fit.android.cerberus.structures.story.node.StoryResources

class ComeInside(previousID: Long)
    : StoryNode(StoryLinks(11, previousID, 17, true),
                StoryResources(R.string.come_inside_text, PlayerRole.PORTER, awardedPoints = 1)) {

    init {
        addAnswer(StoryAnswer(R.string.porter_call_out, PlayerRole.PORTER, 13, 14))
    }
}