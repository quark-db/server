package ru.anafro.quark.server.database.data.modifiers;

import ru.anafro.quark.server.database.data.ColumnModifier;
import ru.anafro.quark.server.database.data.ColumnModifierApplicationPriority;
import ru.anafro.quark.server.database.data.RecordField;
import ru.anafro.quark.server.database.data.Table;
import ru.anafro.quark.server.database.language.entities.InstructionEntityConstructorArguments;

/**
 * Represents the {@code require negative} column modifier.
 *
 * @author Anatoly Frolov | Анатолий Фролов | <a href="https://anafro.ru">My website</a>
 * @version Quark 1.1
 * @since Quark 1.1
 */
public class NegativeColumnModifier extends ColumnModifier {
    public NegativeColumnModifier() {
        super(ColumnModifierApplicationPriority.HIGH, "require negative", false, "int", "float");
    }

    @Override
    public boolean isFieldValid(Table table, RecordField field, InstructionEntityConstructorArguments arguments) {
        float value = field.getEntity().hasType("float") ? field.getEntity().valueAs(Float.class) : field.getEntity().valueAs(Integer.class);
        return value < 0;
    }

    @Override
    public void prepareField(Table table, RecordField field, InstructionEntityConstructorArguments arguments) {
        // Nothing.
    }

}
