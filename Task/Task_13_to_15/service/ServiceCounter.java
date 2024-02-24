package Task.Task_13_to_15.service;

public class ServiceCounter implements AutoCloseable {
    private int count;

    public ServiceCounter() {
        count = 0;
    }

    public int add() {
        count++;
        return count;
    }

    @Override
    public void close() {
        if (count == 0) {
            throw new IllegalStateException("Counter was not used or resource is still open");
        }
    }
}
