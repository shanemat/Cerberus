package cz.cvut.fit.android.cerberus.structures.story.chapters.third

import cz.cvut.fit.android.cerberus.R
import cz.cvut.fit.android.cerberus.structures.answers.StoryAnswer
import cz.cvut.fit.android.cerberus.structures.enums.PlayerRole
import cz.cvut.fit.android.cerberus.structures.story.node.StoryLinks
import cz.cvut.fit.android.cerberus.structures.story.node.StoryNode
import cz.cvut.fit.android.cerberus.structures.story.node.StoryResources
import cz.cvut.fit.android.cerberus.structures.story.node.StoryRoles

class PorterGameFailure(previousID: Long)
    : StoryNode(StoryLinks(14, previousID, 20, false),
                StoryRoles(PlayerRole.PORTER),
                StoryResources(R.string.porter_game_failure_text, 0)) {

    init {
        addAnswer(StoryAnswer(R.string.porter_game_pedal_to_the_metal, answeringRole, 15))
        addAnswer(StoryAnswer(R.string.porter_game_board_inside, answeringRole, 16))
        addAnswer(StoryAnswer(R.string.porter_game_board_outside, answeringRole, 17))
    }
}