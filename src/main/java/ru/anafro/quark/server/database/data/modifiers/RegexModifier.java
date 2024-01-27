package ru.anafro.quark.server.database.data.modifiers;

import ru.anafro.quark.server.database.data.ColumnModifier;
import ru.anafro.quark.server.database.data.ColumnModifierApplicationPriority;
import ru.anafro.quark.server.database.data.RecordField;
import ru.anafro.quark.server.database.data.Table;
import ru.anafro.quark.server.database.language.entities.InstructionEntityConstructorArguments;

public class RegexModifier extends ColumnModifier {
    public RegexModifier() {
        super(ColumnModifierApplicationPriority.HIGH, "regex", false, "str");
    }

    @Override
    public boolean isFieldValid(Table table, RecordField field, InstructionEntityConstructorArguments arguments) {
        return field.getEntity().valueAs(String.class).matches(arguments.getString("regex"));
    }

    @Override
    public void prepareField(Table table, RecordField field, InstructionEntityConstructorArguments arguments) {
        //
    }

}
