import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ServerTest {

    @Test
    void isFailedTest() {
        Server server = new Server(0,1);
        server.setFailed();
        assertEquals(true, server.isFailed());
    }

    @Test
    void getNodeListTest() {
        Server server = new Server(0, 3);
        List list = Arrays.asList(new Node(0), new Node(1), new Node(2));
        assertEquals(list, server.getNodeList());
    }

    @Test
    void toStringTest() {
        Server server = new Server(1,2);
        String toString = "\n" + "Server #1 failed: false, nodeList=[node #0 failed: false, node #1 failed: false]";
        assertEquals(toString, server.toString());
    }
}