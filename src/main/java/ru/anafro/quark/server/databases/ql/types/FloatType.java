package ru.anafro.quark.server.databases.ql.types;

import ru.anafro.quark.server.databases.ql.entities.FloatEntity;
import ru.anafro.quark.server.databases.ql.entities.Entity;
import ru.anafro.quark.server.utils.strings.Converter;

public class FloatType extends EntityType {
    public FloatType() {
        super("float");
    }

    @Override
    public FloatEntity makeEntity(String string) {
        return new FloatEntity(Converter.toFloat(string));
    }

    @Override
    public String toInstructionForm(Entity entity) {
        return String.valueOf(entity.valueAs(Float.class));
    }
}
