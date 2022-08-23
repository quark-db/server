package ru.anafro.quark.server.databases.ql.instructions;

import ru.anafro.quark.server.databases.ql.Instruction;
import ru.anafro.quark.server.databases.ql.InstructionArguments;
import ru.anafro.quark.server.databases.ql.InstructionParameter;
import ru.anafro.quark.server.databases.ql.InstructionResultRecorder;
import ru.anafro.quark.server.networking.Server;

public class EvalInstruction extends Instruction {
    public EvalInstruction() {
        super("eval", "server.eval", InstructionParameter.general("object", "?"));
    }

    @Override
    public void action(InstructionArguments arguments, Server server, InstructionResultRecorder result) {
        // This instruction should not be run. It's used by Quark to evaluate entities.
    }
}
