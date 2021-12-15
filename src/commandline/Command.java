package commandline;

import java.util.List;

public abstract class Command<T>{
    protected final int maxArguments;
    protected final int minArguments;
    protected T receiver;

    public Command(int maxArguments, int minArguments, T receiver) {
        this.maxArguments = maxArguments;
        this.minArguments = minArguments;
        this.receiver = receiver;
    }

    public Boolean checkArguments(List<String> arguments) {
        return arguments.size() < this.maxArguments && arguments.size() > minArguments;
    }
}
