package mid2Spring2010;

public class Print
{
    private void preorder(BSTNode<T> p)
    {
        if (p != null)
        {
            System.out.println(p.data);
            preorder(p.left);
            preorder(p.right);
        }
    }

    private void inorder(BSTNode<T> p) //asscending order
    {
        if (p != null)
        {
            inorder(p.left);
            System.out.print(p.data);
            inorder(p.right);
        }
    }

    private void inorder(BSTNode<T> p) //descending order
    {
        if (p != null)
        {
        	inorder(p.right);
            System.out.print(p.data);
            inorder(p.left);
        }
    }

    private void postorder(BSTNode<T> p)
    {
        if (p != null)
        {
            postorder(p.left);
            postorder(p.right);
            System.out.println(p.data);
        }
    }

    private void printByLevel(BSTNode <T> t)
    {
        if (t != null)
        {
       	 LinkQueue <BSTNode <T>> q = new LinkQueue<BSTNode <T>>();

       	 q.enqueue(t);

       	 while(q.length() != 0)
       	 {
       		 root = (BSTNode<T>) q.serve();
       		 System.out.println(t.data);

       		 if (t.left != null)
       			 q.enqueue(t.left);

       		 if (t.right != null)
       			 q.enqueue(root.right);
       	 }
        }
    }
    
    private void printLevelRight(BSTNode <T> t)
    {
        if (root != null)
        {
       	 LinkQueue <BSTNode <T>> q = new LinkQueue<BSTNode <T>>();

       	 q.enqueue(t);

       	 while(q.length() != 0)
       	 {
       		 root = (BSTNode<T>) q.serve();
       		 System.out.println(t.data);

       		 if (t.right != null)
       			 q.enqueue(t.right);

       		 if (t.left != null)
       			 q.enqueue(t.left);
       	 }
        }
    }

     private void inOrderNoRecursive(BSTNode<T> t)
     {
         LinkStack <BSTNode <T>> s = new LinkStack<BSTNode <T>>();

         while(t != null || ! s.empty())
         {
             if (t == null) 
             {
                 t = s.pop();
                 System.out.println(t.data);
                 t = t.right;
             }

             if (t != null)
             {
                 s.push(t);
                 t = t.left;
             }
         }
     }

     private void preOrderNoRecursive(BTNode <T> root)
     {
         LinkStack <BTNode <T>> s = new LinkStack<BTNode <T>>();

         while (root != null || ! s.empty())
         {
        	 if (root == null)
        		 root = s.pop();

        	 System.out.println(root.data);

        	 if (root.right != null)
        		 s.push(root.right);

        	 root = root.left;
          }
     }

     private void postOrderNoRecursive(BTNode <T> root)
     {
         LinkStack <BTNode <T>> s = new LinkStack<BTNode <T>>();

         while (root != null || ! s.empty())
         {
             if (root == null)
             {
                 BTNode <T> temp = s.pop();
                 s.push(temp);

                 while (! s.empty() && root == temp.right)
                 {
                     root = s.pop();
                     System.out.println(root.data);

                     if (! s.empty())
                     {
                    	 temp = s.pop();
                    	 s.push(temp);
                     }
                 }

                 if (s.empty())
                	 root = null;
                 else
                 {
                	 root = s.pop();
                	 s.push(root);
                	 root = root.right;
                 }
             }

             if (root != null)
             {
                 s.push(root);
                 root = root.left;
             }
         }

}