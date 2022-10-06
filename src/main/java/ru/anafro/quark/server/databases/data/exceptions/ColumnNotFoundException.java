package ru.anafro.quark.server.databases.data.exceptions;

import ru.anafro.quark.server.databases.data.Table;
import ru.anafro.quark.server.databases.exceptions.DatabaseException;

public class ColumnNotFoundException extends DatabaseException {
    public ColumnNotFoundException(Table table, String columnName) {
        super("No such column '%s' inside table '%s.%s'.".formatted(
                columnName,
                table.getDatabase().getName(),
                table.getName()
        ));
    }
}
