package commandline;

import controllers.ControlCentre;

import java.util.List;

public abstract class Command {
    protected final int maxArguments;
    protected final int minArguments;
    ControlCentre receiver;

    public Command(int maxArguments, int minArguments, ControlCentre receiver) {
        this.maxArguments = maxArguments;
        this.minArguments = minArguments;
        this.receiver = receiver;
    }

    public Boolean checkArguments(List<String> arguments) {
        return arguments.size() < this.maxArguments && arguments.size() > minArguments;
    }
}
