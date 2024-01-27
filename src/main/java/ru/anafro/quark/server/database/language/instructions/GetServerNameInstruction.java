package ru.anafro.quark.server.database.language.instructions;

import ru.anafro.quark.server.database.language.Instruction;
import ru.anafro.quark.server.database.language.InstructionArguments;
import ru.anafro.quark.server.database.language.InstructionResultRecorder;
import ru.anafro.quark.server.facade.Quark;
import ru.anafro.quark.server.security.TokenPermission;

public class GetServerNameInstruction extends Instruction {
    /**
     * Creates a new instruction object. You should not use it anywhere
     * but in the registering ({@code Quark.instructions().add(new YourInstruction()}).
     *
     * @author Anatoly Frolov | Анатолий Фролов | <a href="https://anafro.ru">My website</a>
     * @since Quark 1.1
     */
    public GetServerNameInstruction() {
        super(
                "get server name",

                "Returns the server name",

                TokenPermission.ALLOWED_FOR_ALL_TOKENS
        );
    }

    @Override
    protected void performAction(InstructionArguments arguments, InstructionResultRecorder result) {
        var configuration = Quark.configuration();

        result.header("server name");
        result.row(configuration.getName());
        result.ok("The server name has been returned.");
    }
}
