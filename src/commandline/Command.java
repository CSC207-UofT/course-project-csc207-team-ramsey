package commandline;

import java.util.List;

public abstract class Command {
    protected final int maxArguments;
    protected final int minArguments;

    public Command(int maxArguments, int minArguments) {
        this.maxArguments = maxArguments;
        this.minArguments = minArguments;
    }

    public Boolean checkArguments(List<String> arguments) {
        return arguments.size() < this.maxArguments && arguments.size() > minArguments;
    }
}
