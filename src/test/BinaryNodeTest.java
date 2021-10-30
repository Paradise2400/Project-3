 package test;

//import main.BinaryNode;
import org.junit.jupiter.api.Test;
import main.BinaryNode;

import static org.junit.jupiter.api.Assertions.*;

class BinaryNodeTest {

    /**
     * Check method implemented for postorderTraverse_binaryNodeMethod
     */
    @Test
    void postorderTraverse_binaryNodeMethod() {
        BinaryNode<String> fNode = new BinaryNode<>("F");
        BinaryNode<String> eNode = new BinaryNode<>("E");
        BinaryNode<String> dNode = new BinaryNode<>("D");
        BinaryNode<String> cNode = new BinaryNode<>("C",fNode,null);
        BinaryNode<String> bNode = new BinaryNode<>("B",dNode,eNode);
        BinaryNode<String> aNode = new BinaryNode<>("A", bNode, cNode);
        // Tree:  A
        //      /    \
        //     B      C
        //    / \    /
        //   D   E  F
        String s = "" + aNode.postorderTraverse_binaryNodeMethod();
        assertEquals(aNode.postorderTraverse_binaryNodeMethod(), "DEBFCA");
    }

    /**
     * Check method for getHeight_binaryNodeMethod
     */
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