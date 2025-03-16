package state;

public interface State {
    void open(Door door);
    void close(Door door);
}
