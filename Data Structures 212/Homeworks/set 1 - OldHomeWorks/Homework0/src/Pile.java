
public class Pile <T> {

		   public  T [] p;
		   static int i=0;
		   public Pile(int maxSize){
		      p=(T[]) new Object[maxSize];
		   }
		   public   boolean  empty(){
		      if(p[0]!=null)
		        return false;
		        
		        return true;
		      
		   }
		   public   boolean   full(){
		  
		   
		      if(p[p.length-1]!=null)
		   return true;
		   
		   return false;}
		   
		   
		   public void add(T e){
		   if(!full())
		  for(int i=0;i<p.length;i++)
		      if(p[i]== null)
		       p[i]=e;
		   }
		   
		   public T remove (){
		   
		    T e;
		    e=null;
		    
		   if(!empty())
		   for(int i=0;i<p.length;i++)
		      if(p[i]== null)
		      { e=p[i-1];
		        p[i-1]=null;}
		    return e;
		   }
		   }

