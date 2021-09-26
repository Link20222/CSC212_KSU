package mid2Spring2010;

public class MaxAndMin
{
    public T findMax()
    {
        return findMax(root);
    }

    private T findMax(BSTNode <T> t)
    {
        while(t.right != null)
        	t = t.right;

        return t.data;
    }

    public T findMin()
    {
        return findMin(root);
    }

    private T findMin(BSTNode <T> t)
    {
        while(t.left != null)
        	t = t.left;

        return t.data;
    }
    
    private BSTNode <T> findKthSmallest(BSTNode <T> root, int k)
    {
         if (root == null)
        	 return null;  // can't find anything, empty

         int numLeft = countNodes(root.left);

         if (numLeft + 1 == k) // current node
            return root;           
         else if (numLeft >= k) // in left subtree
            return findKthSmallest(root.left, k);
         else
            return findKthSmallest(root.right, k - (numLeft + 1));
     }

     public BSTNode <T> findLargestKth(int k)
     {
    	 return findKthLargest(root,k);
     }

     private BSTNode <T> findKthLargest(BSTNode <T> root, int k)
     {
         if (root == null) 
             return null;  // can't find anything, empty

         int numRight = countNodes(root.right);

         if (numRight + 1 == k) // current node
            return root;           
         else if (numRight >= k) // in right subtree
            return findKthLargest(root.right, k);
         else
            return findKthLargest(root.left, k - (numRight + 1));
     }

////////////////////////////////////////////////////
// min and max in binary tree
////////////////////////////////////////////////////

     public T findMinKey()
     {
         if (root == null)
         	return null;

         T m = root.data;
         return findMinKey(root,m);
     }

     private Integer findMinKey(BTNode<T> t,Integer minValue)
     {
         if (t != null)
         {
         	minValue = findMinKey(t.left,minValue);
         	minValue = findMinKey(t.right,minValue);

         	if (t.data < minValue)
         		minValue = t.data;
         }

         return minValue;
     }

}