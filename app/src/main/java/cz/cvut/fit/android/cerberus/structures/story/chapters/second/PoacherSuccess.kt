package cz.cvut.fit.android.cerberus.structures.story.chapters.second

import cz.cvut.fit.android.cerberus.R
import cz.cvut.fit.android.cerberus.structures.answers.StoryAnswer
import cz.cvut.fit.android.cerberus.structures.enums.PlayerRole
import cz.cvut.fit.android.cerberus.structures.story.node.StoryLinks
import cz.cvut.fit.android.cerberus.structures.story.node.StoryNode
import cz.cvut.fit.android.cerberus.structures.story.node.StoryResources
import cz.cvut.fit.android.cerberus.structures.story.node.StoryRoles

class PoacherSuccess(previousID: Long)
    : StoryNode(StoryLinks(7, previousID, 10, false),
                StoryRoles(PlayerRole.POACHER),
                StoryResources(R.string.poacher_game_success_text, 0)) {

    init {
        addAnswer(StoryAnswer(R.string.poacher_game_guns_blazing, PlayerRole.PORTER, 9))
        addAnswer(StoryAnswer(R.string.poacher_game_sneaky_sneaky, PlayerRole.PORTER, 10))
    }
}