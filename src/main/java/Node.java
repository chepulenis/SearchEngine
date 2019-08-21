import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

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

    @JsonCreator
    public Node(@JsonProperty("number") int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "node #" + number + " failed: " + failed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return number == node.number &&
                failed == node.failed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, failed);
    }
}
