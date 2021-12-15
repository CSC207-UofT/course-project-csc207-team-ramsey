package commandline;

public abstract class Command<T>{
    protected final int maxArguments;
    protected final int minArguments;
    protected final T receiver;

    public Command(int maxArguments, int minArguments, T receiver) {
        this.maxArguments = maxArguments;
        this.minArguments = minArguments;
        this.receiver = receiver;
    }
}
