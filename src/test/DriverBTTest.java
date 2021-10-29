import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DriverBTTest {
    @Test
    void createTree2() {
        BinaryTree<String> aTree = new BinaryTree<>();
        DriverBT.createTree2(aTree);
        String root = aTree.getRootData();
        String lChild = aTree.getLeftChild().getData();
        String rChild = aTree.getRightChild().getData();
        String cLeftChild = aTree.getRightChild().getLeftChild().getData();
        String cRightChild = aTree.getRightChild().getRightChild().getData();
        String dLeftChild = aTree.getRightChild().getLeftChild().getLeftChild().getData();
        String eLeftChild = aTree.getRightChild().getRightChild().getLeftChild().getData();
        String eRightChild = aTree.getRightChild().getRightChild().getRightChild().getData();

        assertEquals("A",root);
        assertEquals("B",lChild);
        assertNull(aTree.getLeftChild().getLeftChild()); //Test for B children, which is null
        assertNull(aTree.getLeftChild().getRightChild());
        assertEquals("C",rChild);
        assertEquals("D",cLeftChild);
        assertNull(aTree.getRightChild().getLeftChild().getRightChild()); //Test for D right child, null
        assertEquals("E",cRightChild);
        assertEquals("F",dLeftChild);
        assertEquals("G",eLeftChild);
        assertNull(aTree.getRightChild().getRightChild().getLeftChild().getLeftChild()); //Test for G left child, null
        assertNull(aTree.getRightChild().getRightChild().getLeftChild().getRightChild()); //Test for G right child, null
        assertEquals("H",eRightChild);
        assertNull(aTree.getRightChild().getRightChild().getRightChild().getLeftChild()); //Test for H left child, null
        assertNull(aTree.getRightChild().getRightChild().getRightChild().getRightChild()); //Test for H right child, null



    }
}