package mid2Spring2010;

public class Search
{
    private boolean findKey1(BSTNode <T> t,int k)
    {
        if (t == null)
        	return false;
        else if(k > t.key)
        	return findKey(t.right,k);
        else if (k < t.key)
        	return findKey(t.left,k);
        else
        	return true;
    }

    private boolean findKey2(BSTNode<T> b,int tkey)
    {
        if (b.key == tkey)
        {
        	current = b;
        	return true;
        }
        else if (tkey < b.key)
        {
        	if (b.left != null)
        		return findKey3(b.left,tkey);
        	else
        	{
        		current = b;
        		return false;
        	}
        }
        else
        {
        	if (b.right != null)
        		return findKey3(b.right,tkey);
        	else
        	{
        		current = b;
        		return false;
        	}
        }
    }
}