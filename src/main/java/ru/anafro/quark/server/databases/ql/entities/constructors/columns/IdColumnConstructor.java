package ru.anafro.quark.server.databases.ql.entities.constructors.columns;

import ru.anafro.quark.server.api.Quark;
import ru.anafro.quark.server.databases.ql.entities.ColumnModifierEntity;
import ru.anafro.quark.server.databases.ql.entities.InstructionEntityConstructorArguments;

import java.util.List;

/**
 * This class represents the id column constructor of Quark QL.
 * <br><br>
 *
 * Note that you should not create instances of this class
 * by your own. Instead, use {@code Quark.constructors().get("id"); }
 * to get an instance of this class.
 *
 * <br><br>
 *
 * You can check out the syntax of this constructor by running
 * <pre>
 * {@code
 * Quark.constructors().get("id").getSyntax();
 * }
 * </pre>
 *
 * @since   Quark 1.1
 * @version Quark 1.1
 * @author  Anatoly Frolov | Анатолий Фролов | <a href="https://anafro.ru">My website</a>
 */
public class IdColumnConstructor extends ColumnConstructor {

    /**
     * Creates a new instance of the id constructor
     * representing object.
     * <br><br>
     *
     * Note that you should not create instances of this class
     * by your own. Instead, use Quark.constructors().get("id");
     * to get an instance of this class.
     * <br><br>
     *
     * You can check out the syntax of this constructor by running
     * <pre>
     * {@code
     * Quark.constructors().get("id").getSyntax();
     * }
     * </pre>
     *
     * @since  Quark 1.1
     * @author Anatoly Frolov | Анатолий Фролов | <a href="https://anafro.ru">My website</a>
     */
    public IdColumnConstructor() {
        super(
                "id",
                Quark.types().get("int"),
                "id",
                List.of(
                        new ColumnModifierEntity("id", Quark.modifiers().get("require unique"), new InstructionEntityConstructorArguments()),
                        new ColumnModifierEntity("id", Quark.modifiers().get("incrementing"), new InstructionEntityConstructorArguments()),
                        new ColumnModifierEntity("id", Quark.modifiers().get("require positive"), new InstructionEntityConstructorArguments()),
                        new ColumnModifierEntity("id", Quark.modifiers().get("require constant"), new InstructionEntityConstructorArguments())
                )
        );
    }
}
