package ru.anafro.quark.server.databases.data.exceptions;

import ru.anafro.quark.server.databases.data.Table;
import ru.anafro.quark.server.databases.data.TableRecord;
import ru.anafro.quark.server.databases.exceptions.DatabaseException;
import ru.anafro.quark.server.databases.ql.entities.ColumnModifierEntity;

public class ColumnModifierValidityCheckFailedException extends DatabaseException {
    public ColumnModifierValidityCheckFailedException(TableRecord record, Table table, ColumnModifierEntity modifierEntity) {
        super("A table modifier %s checked the validity of a record %s in the table %s, but the validation failed.".formatted(modifierEntity.getModifier().getName(), record.toTableLine(), table.getName()));
    }
}
