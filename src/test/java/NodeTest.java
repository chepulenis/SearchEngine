import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    @Test
    void getNumberTest() {
        Node node = new Node(22);
        assertEquals(22,node.getNumber());
    }

    @Test
    void isFailedTest() {
        Node node = new Node(1);
        node.setFailed();
        assertEquals(true, node.isFailed());
    }

    @Test
    void toStringTest() {
        Node node = new Node(2);
        System.out.println(node);
        String toString = "node #2 failed: false";
        assertEquals(toString, node.toString());
    }

}