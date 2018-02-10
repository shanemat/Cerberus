package cz.cvut.fit.android.cerberus.data.database.tables

import cz.cvut.fit.android.cerberus.data.database.prototype.Column
import cz.cvut.fit.android.cerberus.data.database.prototype.Column.*
import cz.cvut.fit.android.cerberus.data.database.prototype.Table

class PlayerTable
    : Table(TABLE_NAME) {

    companion object {
        const val TABLE_NAME = "players"

        const val ID = "id"
        const val TEAM_ID = "team_id"
        const val ROLE_ID = "role_id"

        const val NAME = "name"
        const val SURNAME = "surname"
    }

    init {
        addColumn(Column(ID, ValueType.INTEGER, KeyType.PRIMARY, Incrementation.AUTOINCREMENT, Nullability.NOT_NULL))

        addColumn(Column(TEAM_ID, ValueType.INTEGER, nullability = Nullability.NOT_NULL))
        addColumn(Column(ROLE_ID, ValueType.INTEGER, nullability = Nullability.NOT_NULL))

        addColumn(Column(NAME, ValueType.TEXT, nullability = Nullability.NOT_NULL))
        addColumn(Column(SURNAME, ValueType.TEXT, nullability = Nullability.NOT_NULL))
    }
}