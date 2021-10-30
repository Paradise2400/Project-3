package test;
import main.BinaryTree;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {

    /**
     * postOrderTraverse() of Tree
     */
    @Test
    void postorderTraverse() {
        // Tree:   A
        //      /    \
        //     B      C
        //    /  \   / \
        //   D    E  F  G
        BinaryTree<String> gTree = new BinaryTree<>("G");
        BinaryTree<String> fTree = new BinaryTree<>("F");
        BinaryTree<String> dTree = new BinaryTree<>("D");
        BinaryTree<String> eTree = new BinaryTree<>("E");
        BinaryTree<String> bTree = new BinaryTree<>("B",dTree,eTree);
        BinaryTree<String> cTree = new BinaryTree<>("C",fTree,gTree);
        BinaryTree<String> aTree = new BinaryTree<>("A",bTree,cTree);
        assertEquals("DEBFGCA", aTree.postorderTraverse());
    }

    @Test
    void postorderTraverse_callBinaryNodeMethod() {
        BinaryTree<String> gTree = new BinaryTree<>("G");
        BinaryTree<String> fTree = new BinaryTree<>("F");
        BinaryTree<String> dTree = new BinaryTree<>("D");
        BinaryTree<String> eTree = new BinaryTree<>("E");
        BinaryTree<String> bTree = new BinaryTree<>("B",dTree,eTree);
        BinaryTree<String> cTree = new BinaryTree<>("C",fTree,gTree);
        BinaryTree<String> aTree = new BinaryTree<>("A",bTree,cTree);
        System.out.println(aTree.postorderTraverse_callBinaryNodeMethod());;
    }

    /**
     * Normal binary tree test case
     */
    @Test
    void getHeight_callBinaryNodeMethod() {
        BinaryTree<String> dTree = new BinaryTree<>("D");
        BinaryTree<String> eTree = new BinaryTree<>("E");
        BinaryTree<String> bTree = new BinaryTree<>("B",dTree,eTree);
        BinaryTree<String> cTree = new BinaryTree<>("C");
        BinaryTree<String> aTree = new BinaryTree<>("A",bTree,cTree);

        // Tree: A
        //      / \
        //     B   C
        //    /  \
        //   D    E
        int test = aTree.getHeight_callBinaryNodeMethod();
        assertEquals(3,test);
    }    /**
     * Null binary tree test case
     */
    @Test
    void getHeight_callBinaryNodeMethod2() {
        BinaryTree<String> aTree = new BinaryTree<>();


        int test = aTree.getHeight_callBinaryNodeMethod();
        assertEquals(0,test);
    }

    /**
     * Test for getting Number of Nodes.
     */
    @Test
    void getNumberOfNodes() {
        // Tree:   A
        //      /    \
        //     B      C
        //    /  \   / \
        //   D    E  F  G
        BinaryTree<String> gTree = new BinaryTree<>("G");
        BinaryTree<String> fTree = new BinaryTree<>("F");
        BinaryTree<String> dTree = new BinaryTree<>("D");
        BinaryTree<String> eTree = new BinaryTree<>("E");
        BinaryTree<String> bTree = new BinaryTree<>("B",dTree,eTree);
        BinaryTree<String> cTree = new BinaryTree<>("C",fTree,gTree);
        BinaryTree<String> aTree = new BinaryTree<>("A",bTree,cTree);
        assertEquals(7,aTree.getNumberOfNodes());
    }
}
