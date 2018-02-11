package cz.cvut.fit.android.cerberus.structures.story.chapters.second

import cz.cvut.fit.android.cerberus.R
import cz.cvut.fit.android.cerberus.structures.answers.StoryAnswer
import cz.cvut.fit.android.cerberus.structures.enums.PlayerRole
import cz.cvut.fit.android.cerberus.structures.story.node.StoryNode

class ShootASAP(previousID: Long)
    : StoryNode(StoryLinks(12, previousID, 17, true),
                StoryRoles(PlayerRole.POACHER, PlayerRole.PORTER),
                StoryResources(R.string.shoot_asap_text, 0)) {

    init {
        addAnswer(StoryAnswer(120, R.string.porter_call_out, PlayerRole.PORTER, 13, 14))
    }
}