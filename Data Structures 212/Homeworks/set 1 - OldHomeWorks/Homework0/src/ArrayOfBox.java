
public class ArrayOfBox {

		   public static void main (String [] args ) {
		      /*Box<String>[] b = new Box <String>[3];
		   
		      b[0] = new Box<String>("A");
		      b[0].update("b");*/
		       final int a =0;
		      GenericArray<Box<String>> b = new GenericArray <Box<String>> (3);
		      Box<String> b1 = new Box<String>("A");
		      b.set(0,b1);
		      b1.update("b");
            
            System.out.print(a);
		   }
		}

