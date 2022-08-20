package ru.anafro.quark.server.utils.objects;

import ru.anafro.quark.server.utils.exceptions.CallingUtilityConstructorException;

import java.util.function.Function;

public final class Nulls {
    private Nulls() {
        throw new CallingUtilityConstructorException(getClass());
    }

    public static <T> T nullOrDefault(T object, T defaultValue) {
        return object == null ? defaultValue : object;
    }
    public static <T, U> T evalOrDefault(U nullableObject, Function<U, T> ifNotNull, T ifNull) {
        if(nullableObject == null) {
            return ifNull;
        } else {
            return ifNotNull.apply(nullableObject);
        }
    }
}
