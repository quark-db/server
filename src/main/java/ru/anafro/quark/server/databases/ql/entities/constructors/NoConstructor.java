package ru.anafro.quark.server.databases.ql.entities.constructors;

import ru.anafro.quark.server.databases.ql.entities.BooleanEntity;
import ru.anafro.quark.server.databases.ql.entities.Entity;
import ru.anafro.quark.server.databases.ql.entities.EntityConstructor;
import ru.anafro.quark.server.databases.ql.entities.InstructionEntityConstructorArguments;

import static ru.anafro.quark.server.databases.ql.entities.InstructionEntityConstructorReturnDescription.returns;

/**
 * This class represents the no constructor of Quark QL.
 * <br><br>
 *
 * Note that you should not create instances of this class
 * by your own. Instead, use {@code Quark.constructors().get("no"); }
 * to get an instance of this class.
 *
 * <br><br>
 *
 * You can check out the syntax of this constructor by running
 * <pre>
 * {@code
 * Quark.constructors().get("no").getSyntax();
 * }
 * </pre>
 *
 * @since   Quark 1.1
 * @version Quark 1.1
 * @author  Anatoly Frolov | Анатолий Фролов | <a href="https://anafro.ru">My website</a>
 */
public class NoConstructor extends EntityConstructor {

    /**
     * Creates a new instance of the no constructor
     * representing object.
     * <br><br>
     *
     * Note that you should not create instances of this class
     * by your own. Instead, use Quark.constructors().get("no");
     * to get an instance of this class.
     * <br><br>
     *
     * You can check out the syntax of this constructor by running
     * <pre>
     * {@code
     * Quark.constructors().get("no").getSyntax();
     * }
     * </pre>
     *
     * @since  Quark 1.1
     * @author Anatoly Frolov | Анатолий Фролов | <a href="https://anafro.ru">My website</a>
     */
    public NoConstructor() {
        super(
                "no",

                returns("the false value", "boolean")
        );
    }

    /**
     * Invokes the @no constructor programmatically with arguments.
     * <br><br>
     *
     * You can check out the syntax of this constructor by running
     * <pre>
     * {@code
     * Quark.constructors().get("no").getSyntax();
     * }
     * </pre>
     *
     * @param arguments the arguments this constructor needs to be invoked with.
     *
     * @since  Quark 1.1
     * @author Anatoly Frolov | Анатолий Фролов | <a href="https://anafro.ru">My website</a>
     */
    @Override
    protected Entity invoke(InstructionEntityConstructorArguments arguments) {
        return new BooleanEntity(false);
    }
}
