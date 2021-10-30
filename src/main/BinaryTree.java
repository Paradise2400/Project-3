public class BinaryTree<T> implements BinaryTreeInterface<T>
{
   private BinaryNode<T> root;

   public BinaryTree()
   {
      root = null;
   } // end default constructor

   public BinaryTree(T rootData)
   {
      root = new BinaryNode<>(rootData);
   } // end constructor

   public BinaryTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree)
   {
      initializeTree(rootData, leftTree, rightTree);
   } // end constructor

   public void setTree(T rootData, BinaryTreeInterface<T> leftTree,
                                   BinaryTreeInterface<T> rightTree)
   {
      initializeTree(rootData, (BinaryTree<T>)leftTree,
                               (BinaryTree<T>)rightTree);
   } // end setTree

   public void setRootData(T rootData)
   {
      root.setData(rootData);
   } // end setRootData
   
   public T getRootData()
   {
      if (isEmpty())
         throw new EmptyTreeException();
      else
         return root.getData();
   } // end getRootData
   
   public boolean isEmpty()
   {
      return root == null;
   } // end isEmpty
   
   public void clear()
   {
      root = null;
   } // end clear
   
   protected void setRootNode(BinaryNode<T> rootNode)
   {
      root = rootNode;
   } // end setRootNode
   
   protected BinaryNode<T> getRootNode()
   {
      return root;
   } // end getRootNode
   
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
    * prints (using post-order traversal) all nodes in the "whole" tree */
   public void postorderTraverse()
   {
      if(root!=null)
      {
         postorderTraverse(root);
      }
      else
      {
         System.out.println("Cannot call PostorderTraverse because root node may be missing/null");
      }

   }
   
   /** A Recursive Method in the BinaryTree Class   
    * prints (using post-order traversal) all nodes in the subtree rooted at this node.*/
   private void postorderTraverse(BinaryNode<T> node)
   {
      if(node!=null)
      {
         postorderTraverse(node.getLeftChild());
         postorderTraverse(node.getRightChild());
         System.out.println(node.getData());
      }
   }
 
   /** The following calls postorderTraverse_binaryNodeMethod(), which is a recursive binaryNode class method   
    * prints (using post-order traversal) all nodes in the "whole" tree */
   public void postorderTraverse_callBinaryNodeMethod()
   {
      if(root!=null)
      {
         root.postorderTraverse_binaryNodeMethod();
      }
      else
      {
         System.out.println("Unable to access node. Missing root node. ");
      }
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