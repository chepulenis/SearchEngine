import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Node {
    private int number;
    private boolean failed;
    private boolean present;

    public boolean isPresent() {
        return present;
    }

    public int getNumber() {
        return number;
    }

    public boolean isFailed() {
        return failed;
    }

    public void setFailed() {
        this.failed = true;
    }

    @JsonCreator
    public Node(@JsonProperty("number") int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "node #" + number + " failed: " + failed;
    }
}
