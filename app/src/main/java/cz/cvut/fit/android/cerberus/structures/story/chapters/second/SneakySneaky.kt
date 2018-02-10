package cz.cvut.fit.android.cerberus.structures.story.chapters.second

import cz.cvut.fit.android.cerberus.R
import cz.cvut.fit.android.cerberus.structures.answers.StoryAnswer
import cz.cvut.fit.android.cerberus.structures.enums.PlayerRole
import cz.cvut.fit.android.cerberus.structures.story.node.StoryNode

class SneakySneaky(previousID: Long)
    : StoryNode(StoryLinks(10, previousID, 13, false),
                StoryRoles(PlayerRole.POACHER, PlayerRole.PORTER),
                StoryResources(R.string.sneaky_sneaky_text, 1)) {

    init {
        addAnswer(StoryAnswer(R.string.sneaky_sneaky_come_inside, PlayerRole.PORTER, 11))
        addAnswer(StoryAnswer(R.string.sneaky_sneaky_shoot_asap, PlayerRole.PORTER, 12))
    }
}