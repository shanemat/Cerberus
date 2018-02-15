package cz.cvut.fit.android.cerberus.structures.enums

enum class Team(val ID: Long, val codeName: String) {

    ALPHA(1, "Alpha"),
    BRAVO(2, "Bravo"),
    CHARLIE(3, "Charlie"),
    DELTA(4, "Delta"),
    ECHO(5, "Echo"),
    FOXTROT(6, "Foxtrot"),
    GOLF(7, "Golf"),
    HOTEL(8, "Hotel"),
    INDIA(9, "India"),
    JULIET(10, "Juliet");

    companion object {
        fun getTeam(roleID: Long): Team? {
            return Team.values().firstOrNull { it.ID == roleID }
        }
    }
}