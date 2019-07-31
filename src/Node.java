public class Node {
    private int number;
    private boolean failed;

    public int getNumber() {
        return number;
    }

    public boolean isFailed() {
        return failed;
    }

    public void setFailed() {
        this.failed = true;
    }

    public Node(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "node #" + number + " failed: " + failed;
    }
}
