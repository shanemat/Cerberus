package cz.cvut.fit.android.cerberus.structures.story.chapters.second

import cz.cvut.fit.android.cerberus.R
import cz.cvut.fit.android.cerberus.structures.answers.StoryAnswer
import cz.cvut.fit.android.cerberus.structures.enums.PlayerRole
import cz.cvut.fit.android.cerberus.structures.story.node.StoryNode

class ComeInside(previousID: Long)
    : StoryNode(StoryLinks(11, previousID, 17, true),
                StoryRoles(PlayerRole.POACHER, PlayerRole.PORTER),
                StoryResources(R.string.come_inside_text, 1)) {

    init {
        addAnswer(StoryAnswer(110, R.string.porter_call_out, PlayerRole.PORTER, 13, 14))
    }
}