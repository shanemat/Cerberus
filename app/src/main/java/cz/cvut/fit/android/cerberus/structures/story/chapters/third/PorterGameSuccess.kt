package cz.cvut.fit.android.cerberus.structures.story.chapters.third

import cz.cvut.fit.android.cerberus.R
import cz.cvut.fit.android.cerberus.structures.answers.StoryAnswer
import cz.cvut.fit.android.cerberus.structures.enums.PlayerRole
import cz.cvut.fit.android.cerberus.structures.story.node.StoryNode

class PorterGameSuccess(previousID: Long)
    : StoryNode(StoryLinks(13, previousID, 20, false),
                StoryRoles(PlayerRole.PORTER),
                StoryResources(R.string.porter_game_success_text, 0)) {

    init {
        addAnswer(StoryAnswer(130, R.string.porter_game_pedal_to_the_metal, answeringRole, 15))
        addAnswer(StoryAnswer(131, R.string.porter_game_board_inside, answeringRole, 16))
        addAnswer(StoryAnswer(132, R.string.porter_game_board_outside, answeringRole, 17))
    }
}