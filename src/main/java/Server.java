import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Server {

    private int number;
    private boolean failed;

    public boolean isFailed() {
        return failed;
    }

    public void setFailed() {
        this.failed = true;
    }

    private List<Node> nodeList = new ArrayList<>();

    @JsonCreator
    public Server(@JsonProperty("number") int number, @JsonProperty("maxNodesQuantity") int maxNodesQuantity) {
        this.number = number;
        for (int i = 0; i<maxNodesQuantity;i++){
            nodeList.add(new Node(i));
        }

    }

    public List<Node> getNodeList() {
        return nodeList;
    }

    @Override
    public String toString() {
        return "\n" + "Server #" + + number +
                " failed: " + failed +
                ", nodeList=" + nodeList;
    }

}
