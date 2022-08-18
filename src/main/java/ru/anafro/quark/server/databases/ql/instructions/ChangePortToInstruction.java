package ru.anafro.quark.server.databases.ql.instructions;

import ru.anafro.quark.server.databases.exceptions.QuerySyntaxException;
import ru.anafro.quark.server.databases.ql.Instruction;
import ru.anafro.quark.server.databases.ql.InstructionArguments;
import ru.anafro.quark.server.databases.ql.InstructionParameter;
import ru.anafro.quark.server.databases.ql.InstructionResultRecorder;
import ru.anafro.quark.server.databases.ql.entities.IntegerEntity;
import ru.anafro.quark.server.networking.Ports;
import ru.anafro.quark.server.networking.Server;
import ru.anafro.quark.server.networking.exceptions.PortIsUnavailableException;

public class ChangePortToInstruction extends Instruction {
    public ChangePortToInstruction() {
        super("change port to", "server.port.change",

                InstructionParameter.general("port", InstructionParameter.Types.INT)
        );
    }

    @Override
    public void action(InstructionArguments arguments, Server server, InstructionResultRecorder result) {
        int newPort = arguments.<IntegerEntity>get("port").getValue();

        if(Ports.isInvalid(newPort)) {
            throw new QuerySyntaxException("Port should be between %d and %d, not %d".formatted(Ports.FIRST, Ports.LAST, newPort));
        }

        if(Ports.isUnavailable(newPort)) {
            throw new PortIsUnavailableException(newPort);
        }

        server.getConfiguration().setPort(newPort);
        server.reload();
    }
}
