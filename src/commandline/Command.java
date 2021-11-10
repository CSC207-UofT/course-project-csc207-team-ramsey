package commandline;

public abstract class Command {
    protected final int maxArguments;
    protected final int minArguments;

    public Command(int maxArguments, int minArguments) {
        this.maxArguments = maxArguments;
        this.minArguments = minArguments;
    }
}
