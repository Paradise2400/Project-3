 package main;

public class BinaryTree<T> implements BinaryTreeInterface<T>
{
   private BinaryNode<T> root;

   /**
    * Initializing constructor
    */
   public BinaryTree()
   {
      root = null;
   } // end default constructor

   /**
    * Initializes new tree with param rootData
    * @param rootData is root of the tree
    */
   public BinaryTree(T rootData)
   {
      root = new BinaryNode<>(rootData);
   } // end constructor

   /**
    * Initializes tree with:
    * @param rootData as root of tree
    * @param leftTree as left child of root
    * @param rightTree as right right child of root
    */
   public BinaryTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree)
   {
      initializeTree(rootData, leftTree, rightTree);
   } // end constructor

   /**
    * Calls initializeTree
    * @param rootData   The object that is the data for the new tree's root.
    * @param leftTree   The left subtree of the new tree.
    * @param rightTree  The right subtree of the new tree.
    */
   public void setTree(T rootData, BinaryTreeInterface<T> leftTree,
                                   BinaryTreeInterface<T> rightTree)
   {
      initializeTree(rootData, (BinaryTree<T>)leftTree,
                               (BinaryTree<T>)rightTree);
   } // end setTree

   /**
    * Sets root data
    * @param rootData  The object that is the data for the tree's root.
    */
   public void setRootData(T rootData)
   {
      root.setData(rootData);
   } // end setRootData

   /**
    *
    * @return root's data
    */
   public T getRootData()
   {
      if (isEmpty())
         throw new EmptyTreeException();
      else
         return root.getData();
   } // end getRootData

   /**
    *
    * @return true if tree is empty, else false
    */
   public boolean isEmpty()
   {
      return root == null;
   } // end isEmpty

   /**
    * Removes root from memory
    */
   public void clear()
   {
      root = null;
   } // end clear

   /**
    * Sets root node to be param
    * @param rootNode of type BinaryNode
    */
   protected void setRootNode(BinaryNode<T> rootNode)
   {
      root = rootNode;
   } // end setRootNode

   /**
    *
    * @return this tree's root node
    */
   protected BinaryNode<T> getRootNode()
   {
      return root;
   } // end getRootNode

   /**
    * Creates tree with its rootData and leftTree as its left Child and rightTree as its rightChild
    * @param rootData
    * @param leftTree
    * @param rightTree
    */
   private void initializeTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree)
   {
      root = new BinaryNode<>(rootData);
      
      if ((leftTree != null) && !leftTree.isEmpty())
         root.setLeftChild(leftTree.root);
      
      if ((rightTree != null) && !rightTree.isEmpty())
      {
         //To prevent user from setting the leftTree and rightTree to refer the same Tree(same memory location).
         if (rightTree != leftTree) 
            root.setRightChild(rightTree.root); //
         else
         //If they are the same tree then we make a copy because if we remove a node/tree from either side then we remove both left and right trees/nodes
            root.setRightChild(rightTree.root.copy()); 
      } // end if
      
      // The user can pass the same tree itself 
      if ((leftTree != null) && (leftTree != this))
         leftTree.clear();
      
      if ((rightTree != null) && (rightTree != this))
         rightTree.clear();
   } // end initializeTree
   
   /** -------------------------------------------------------------------- */
   /** Task 1: Implement the 4 methods
    *     . In BinaryTree.java
    *          1. public void postorderTraverse();
    *          2. private void postorderTraverse(BinaryNode<T> node)
    *          3. public void postorderTraverse_callBinaryNodeMethod()
    *     . In BinaryNode.java
    *          4. public void postorderTraverse_binaryNodeMethod() */
   
   /** calls postorderTraverse(BinaryNode<T> node)
    * @return (using post-order traversal) all nodes in the "whole" tree */
   public String postorderTraverse()
   {
      String s = "";
      if(root!=null)
      {
         s = postorderTraverse(root);
      }
      return s;
   }
   
   /** A Recursive Method in the BinaryTree Class   
    * @return (using post-order traversal) all nodes in the subtree rooted at this node.*/
   private String postorderTraverse(BinaryNode<T> node)
   {
      String s = "";
      if(node!=null)
      {
         String traversalLeft = "";
         String traversalRight = "";
         traversalLeft = postorderTraverse(node.getLeftChild());
         traversalRight = postorderTraverse(node.getRightChild());
         s = traversalLeft + traversalRight + node.getData();
//         System.out.print(node.getData());
      }
      return s;
   }
 
   /** The following calls postorderTraverse_binaryNodeMethod(), which is a recursive binaryNode class method   
    * @return (using post-order traversal) all nodes in the "whole" tree */
   public String postorderTraverse_callBinaryNodeMethod()
   {
      String s ="";
      if(root!=null)
      {
         s = root.postorderTraverse_binaryNodeMethod();
      }
      return s;
   }
   
   /** -------------------------------------------------------------------- */
   /** Task 2: Implement the 2 methods
    *     . In BinaryTree.java
    *          1. public int getHeight_callBinaryNodeMethod()
    *     . In BinaryNode.java
    *          2. public int getHeight_binaryNodeMethod()*/
   
   /** calls getHeight(BinaryNode<T> node)
   @return  The height of the "whole" tree */
   public int getHeight()
   {
	   return getHeight(root);
   } // end getHeight
   
   /** A Recursive Method in the BinaryTree Class  
    * Computes the height of the subtree rooted at this node.
   @return  The height of the subtree rooted at this node. */
   private int getHeight(BinaryNode<T> node)
   {
      int height = 0;
      if (node != null)
         height = 1 + Math.max(getHeight(node.getLeftChild()),
                               getHeight(node.getRightChild()));
      return height;
   } // end getHeight
   
   /** The following calls getHeight_binaryNodeMethod() which is a recursive binaryNode class method
    * Computes the height of the "whole" tree.
   @return  The height of the "whole" tree. */
   public int getHeight_callBinaryNodeMethod()
   {
      if(root != null)
	   return root.getHeight_binaryNodeMethod();
      else
         return 0;
   } // end getHeight_callBinaryNodeMethod

   /** -------------------------------------------------------------------- */
   /** Task 3: Implement the 2 methods
    *     . In BinaryTree.java
    *          1. public int getNumberOfNodes()
    *          2. private int getNumberOfNodes(BinaryNode<T> node)*/
   
   /** calls getNumberOfNodes(BinaryNode<T> node) 
   @return  The number of nodes in the "whole" tree */
   public int getNumberOfNodes()
   {
      if(root != null)
         return getNumberOfNodes(root);
      return 0;
   } // end getNumberOfNodes
   
   /** A Recursive Method in the BinaryTree Class   
    * Counts the nodes in the subtree rooted at this node.
   @return  The number of nodes in the subtree rooted at this node. */
   private int getNumberOfNodes(BinaryNode<T> node)
   {
      int numberOfNodes = 1; //this node
      //for each child, call this method and add it to non
      if (node != null) {
         if (node.hasLeftChild()) {
            numberOfNodes += getNumberOfNodes(node.getLeftChild());
         }
         if (node.hasRightChild()) {
            numberOfNodes += getNumberOfNodes(node.getRightChild());
         }
      }
      return numberOfNodes;
   } // end getNumberOfNodes
   
   /** The following calls getNumberOfNodes_binaryNodeMethod() which is a recursive binaryNode class method
    * Counts the nodes in the "whole" tree
   @return  The number of nodes in the "whole" tree. */
   public int getNumberOfNodes_callBinaryNodeMethod()
   {
	   int numberOfNodes = 0;
	   if (root != null)
		   numberOfNodes = root.getNumberOfNodes_binaryNodeMethod();
	   return numberOfNodes;
   } // end getNumberOfNodes_callBinaryNodeMethod

   public BinaryNode<T> getLeftChild(){
      BinaryNode<T> lChild = root.getLeftChild();
      return lChild;
   }
   public BinaryNode<T> getRightChild(){
      BinaryNode<T> rChild = root.getRightChild();
      return rChild;
   }
   public T getData(){
      return this.getData();
   }

} // end BinaryTree
