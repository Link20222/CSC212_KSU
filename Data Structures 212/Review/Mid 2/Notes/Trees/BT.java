package ADT;

public class BT<T> 
{
    BTNode<T> root, current;

    public BT()
    {
        root = current = null;
    }

    public void traverse(Order ord)
    {
        switch (ord)
        {
            case preOrder:  preorder(root);
                            break;

            case inOrder:   inorder(root);
                            break;

            case postOrder: postorder(root);
                            break;
        }

        return;
    }
    
    private void preorder(BTNode<T> p)
    {
        if (p != null)
        {
            System.out.println(p.data);
            preorder(p.left);
            preorder(p.right);
        }
    }

    private void inorder(BTNode<T> p)
    {
        if (p != null)
        {
            inorder(p.left);
            System.out.println(p.data);
            inorder(p.right);
        }
    }

    private void postorder(BTNode<T> p)
    {
        if (p != null)
        {
            postorder(p.left);
            postorder(p.right);
            System.out.println(p.data);
        }
    }

    public boolean empty()
    {
        return root == null;
    }

    private BTNode<T> findparent(BTNode<T> p)
    {
        LinkStack<BTNode<T>> stack = new LinkStack<BTNode<T>>();
        BTNode<T> q = root;

        while (q.right != p && q.left != p)
        {
            if (q.right != null)
            	stack.push(q.right);

            if (q.left != null)
                q = q.left;
            else
                q = stack.pop();
        }

        return q;
    }

    private BTNode<T> findparent (BTNode<T> p, BTNode<T> t)
    {
        if (t == null)
        	return null;

        if (t.right == null && t.left == null)
            return null;
        else if (t.right == p || t.left == p)
            return t;
        else
        {
            BTNode<T> q = findparent(p, t.left);

            if (q != null)
                return q;
            else
                return findparent(p, t.right);
        }
    }

    public boolean find (Relative rel)
    {
        switch (rel) 
        {
            case Root:	current = root;

            			return true;

            case Parent:	if (current == root)
            					return false;

            				current = findparent(current, root);

            				return true;

            case LeftChild:	if (current.left == null)
            					return false;

            				 current = current.left;

            				 return true;

            case RightChild: if (current.right == null)
            					return false;

            				 current = current.right;

            				 return true;
        }

        return false;
    }

    public boolean insert (Relative rel, T val)
    {
        switch (rel)
        {
        	case Root:	if (! empty())
        					return false;

        				current = root = new BTNode<T>(val);

        				return true;

        	case Parent:return false;

        	case LeftChild:	if (current.left != null)
        						return false;

                			current.left = new BTNode<T>(val);
                			current = current.left;

                			return true;

        	case RightChild: if (current.right != null)
        						return false;

                			 current.right = new BTNode<T> (val);
                			 current = current.right;

                			 return true;
        }

        return false;
    }

    public T retrieve ()
    {
    	return current.data;
    }

    public void update (T val)
    {
    	current.data = val;
    }

    public void delete_subtree()
    {
        if (current == root)
            current = root = null;
        else
        {
            BTNode<T> p = current;
            find(Relative.Parent);

            if (current.left == p)
                current.left = null;
            else 
                current.right = null;

            current = root;
        }
    }
    
///////////////////////////////////////////////////

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