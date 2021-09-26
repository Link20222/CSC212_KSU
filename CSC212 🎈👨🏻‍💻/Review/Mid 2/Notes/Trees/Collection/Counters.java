package mid2Spring2010;

public class Counters <T>
{
    private boolean isLeaf(BSTNode <T> t)
    {
        if (t.left == null && t.right == null)
        	return true;
        else
        	return false;
    }

    public int countNodes()
    {
    	return countNodes(root);
    }

    private int countNodes(BSTNode <T> t)
    {
        if (t == null)
                return 0;

        return 1 + countNodes(t.left) + countNodes(t.right);
    }

    public int countParents()
    {
    	return countParents(root);
    }

    private int countParents(BSTNode <T> t)
    {
        if (t == null || (t.left == null && t.right == null))
        	return 0;

        return 1 + countParents(t.left) + countParents(t.right);
    }

    public int countLeaf()
    {
    	return countLeaf(root);
    }

    private int countLeaf(BSTNode <T> t)
    {
        if (t == null)
        	return 0;
        else if (t.left == null && t.right == null)
        	return 1;

        return countLeaf(t.left) + countLeaf(t.right);
    }

    public int countOneChild()
    {
    	return countOneChild(root);
    }

    private int countOneChild(BSTNode <T> t)
    {
        if (t == null)
        	return 0;
        else if ((t.left == null && t.right != null)
        		|| (t.left != null && t.right == null))
        	return 1 + countOneChild(t.left) + countOneChild(t.right);

        return countOneChild(t.left) + countOneChild(t.right);
    }

    public int height()
    {
    	return height(root);
    }

    private int height(BSTNode <T> t)
    {
        if (t == null)
        	return 0;

        return 1 + max(height(t.left),height(t.right));
    }

    public int max(int a,int b)
    {
    	if (a > b)
    		return a;
    	else
    		return b;
    }

     private void printDescendents(BSTNode <T> t)
     {
         if (root != null)
         {
                 printDescendents(t.left);

                 System.out.println("Number of descendebts of node " 
                		             + t.key + " : " + (countNodes(t) - 1));

                 printDescendents(t.right);
         }
     }
}