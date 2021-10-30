 package main;

public interface TreeInterface<T>
{
   /**
    *
    * @return root's data
    */
   public T getRootData();
   /**
    @return  The height of the "whole" tree */
   public int getHeight();
   /**
    @return  The number of nodes in the "whole" tree */
   public int getNumberOfNodes();
   /**
    *
    * @return true if tree is empty, else false
    */
   public boolean isEmpty();
   /**
    * Removes root from memory
    */
   public void clear();
} // end TreeInterface
