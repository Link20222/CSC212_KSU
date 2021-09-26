package mid2Spring2010;

public class TreeOperation
{
    private void copy(BSTNode <T> t1,BST<T> t2)
    {
        if (t1 != null)
        {
        	t2.insert(t1.key,t1.data);
        	copy(t1.left,t2);
        	copy(t1.right,t2);
        }
    }
    
    public void mirror()
    {
        mirror(root);
    }

    private void mirror(BSTNode <T> t)
    {
        if (t != null)
        {
        	mirror(t.left);
        	mirror(t.right);

        	BSTNode <T> temp = t.left;
        	t.left = t.right;
        	t.right = temp;
        }
    }
    public BST<T> reverseBST()
    {
        if (root == null)
        	return null;

        BST<T> t = new BST<T>();
        reverse(root,t);

        return t;
    }

    private void reverse(BSTNode <T> t1,BST<T> t2)
    {
        if (t1 != null)
        {
        	t2.root = t2.insertReverse(t2.root,t1.key,t1.data);
        	reverse(t1.left,t2);
        	reverse(t1.right,t2);
        }
    }

    public boolean equal(BST <T> t2)
    {
        return equal(root,t2.root);
    }

    private boolean equal(BSTNode <T> t1,BSTNode <T> t2)
    {
        if (t1 == null && t2 == null)
        	return true;
        else if (t1 == null || t2 == null)
        	return false;
        else if(t1.key != t2.key)
        	return false;

        return equal(t1.left,t2.left) && equal(t1.right,t2.right);
    }

    public boolean isFull()
    {
        return isFull(root);
    }

    private boolean isFull(BSTNode <T> t)
    {
        return countNodes(t) == Math.pow(2,height(t)) - 1;
    }

    public boolean isDegenrate()
    {
        return isDegenrate(root);
    }
    
    private boolean isDegenrate(BSTNode <T> t)
    {
        return countLeaf(t) == 1;
    }

    private boolean isDegenrate2(BSTNode <T> t)
    {
        return countNodes(t) == height(t);
    }

    public boolean isBSTNoStack()
    {
        return isBSTNoStack(root);
    }

    private boolean isBSTNoStack(BSTNode <T> t)
    {
        boolean bst = true;

        if (t != null)
        {
        	if (t.left != null)
        	{
        		if (t.key < t.left.key)
        			bst = false;

        		bst = bst && isBSTNoStack(t.left);
        	}

        	if (t.right != null)
        	{
        		if (t.key > t.right.key)
        			bst = false;

        		bst = bst && isBSTNoStack(t.right);
        	}
        }

        return bst;
    }
    public boolean isAVL()
    {
        if(! isBST())
        	return false;

        return AVL(root);
    }

    private boolean AVL(BSTNode <T> t)
    {
        if (root == null)
        	return true;
        else
        {
        	if (Math.abs(height(t.left) - height(t.right)) > 1)
        		return false;
        	else
        		return AVL(t.left) && AVL(t.right);
        }
    }
}