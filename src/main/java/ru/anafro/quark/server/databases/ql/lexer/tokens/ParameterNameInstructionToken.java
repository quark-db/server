package ru.anafro.quark.server.databases.ql.lexer.tokens;

public class ParameterNameInstructionToken extends InstructionToken {
    public ParameterNameInstructionToken(String value) {
        super("parameter name", value);
    }

    @Override
    public String getPresentation() {
        return getName();
    }

    @Override
    public boolean isValueValid(String value) {
        return value.equals(getValue());
    }
}
