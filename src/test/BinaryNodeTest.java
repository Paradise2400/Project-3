import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryNodeTest {

    @Test
    void postorderTraverse_binaryNodeMethod() {
    }

    @Test
    void getHeight_binaryNodeMethod() {
        BinaryNode<String> eNode = new BinaryNode<>("E");
        BinaryNode<String> dNode = new BinaryNode<>("D");
        BinaryNode<String> bNode = new BinaryNode<>("B",dNode,eNode);
        BinaryNode<String> cNode = new BinaryNode<>("C");
        BinaryNode<String> aNode = new BinaryNode<>("A", bNode, cNode);
        // Tree: A
        //      / \
        //     B   C
        //    /  \
        //   D    E
        int test = bNode.getHeight_binaryNodeMethod();
        assertEquals(2,test);
    }
}