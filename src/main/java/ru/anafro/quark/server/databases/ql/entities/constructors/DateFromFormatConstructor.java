package ru.anafro.quark.server.databases.ql.entities.constructors;

import ru.anafro.quark.server.databases.ql.entities.DateEntity;
import ru.anafro.quark.server.databases.ql.entities.Entity;
import ru.anafro.quark.server.databases.ql.entities.EntityConstructor;
import ru.anafro.quark.server.databases.ql.entities.InstructionEntityConstructorArguments;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static ru.anafro.quark.server.databases.ql.entities.InstructionEntityConstructorParameter.required;
import static ru.anafro.quark.server.databases.ql.entities.InstructionEntityConstructorReturnDescription.returns;

public class DateFromFormatConstructor extends EntityConstructor {

    public DateFromFormatConstructor() {
        super(
                "date from format",

                returns("the date from the format passed in", "date"),

                required("date format", "str"),
                required("formatted date", "str")
        );
    }

    @Override
    protected Entity invoke(InstructionEntityConstructorArguments arguments) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(arguments.getString("date format"));
        ZonedDateTime zonedDateTime = ZonedDateTime.parse(arguments.getString("formatted date"), formatter);

        return new DateEntity(Date.from(zonedDateTime.toInstant()));
    }
}
