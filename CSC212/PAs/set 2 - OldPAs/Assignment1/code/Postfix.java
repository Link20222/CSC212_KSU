class MyInt {
   public int val;
}

public class Postfix {
	// Public recursive method.
   public static double recEval(String exp, MyInt i) {
   if (i.val < 0 )
   return 0;
      if (!Character.isDigit(exp.charAt(i.val))){
         char c = exp.charAt(i.val);
         i.val--;
         double a = recEval(exp, i);
         i.val--;
         double b = recEval(exp, i);
         
         switch (c){
            case '+':
               return b + a;
            case '-':
               return b - a;
            case '*':
               return b * a;
            case '/': 
               return b / a;
         }
      }
   
      return Character.getNumericValue(exp.charAt(i.val));
   
   }

	// Public non-recursive
   public static double eval(String exp) {
      MyInt i = new MyInt();
      i.val = exp.length() - 1;
      return recEval(exp, i);
   }

// Public recursive method.
   public static String recInfix(String exp, MyInt i) {
      if (i.val < 0 )
   return "" ;
      if (!Character.isDigit(exp.charAt(i.val))){
         char c = exp.charAt(i.val);
         i.val--;
         String a = recInfix(exp, i);
         i.val--;
         String b = recInfix(exp, i);
      
         return "("+ b + c + a + ")";
      }
   
      return exp.charAt(i.val)+ "";
   
   
   }

	// Public non-recursive
   public static String infix(String exp) {
      MyInt i = new MyInt();
      i.val = exp.length() - 1;
      return recInfix(exp, i);
   }
}
