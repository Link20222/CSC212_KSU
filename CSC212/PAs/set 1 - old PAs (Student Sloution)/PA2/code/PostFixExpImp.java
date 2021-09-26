public class PostFixExpImp implements PostFixExp{

   private String exp;
      
   public void setExp(String exp){
      this.exp = exp;
   }

   public String getExp(){
      return exp;
   }

   public Stack<Integer> evaluate(int k){
      String[] tokens = exp.split(" ");
      LinkedStack<Integer> operands = new LinkedStack<Integer>();
      for (int i=0; i<k; i++){ 
         if (Character.isDigit(tokens[i].charAt(0)))
            operands.push(Integer.parseInt(tokens[i]));
         else if (doMath(operands, tokens[i]));
         else
            return null;
         
      } // End of for
      return operands;
   }
   
   public int validate(){
      String[] tokens = exp.split(" ");
      for (int i=0; i<tokens.length; i++){ 
         LinkedStack<Integer> operands = new LinkedStack<Integer>();
         if (Character.isDigit(tokens[i].charAt(0)))
            operands.push(Integer.parseInt(tokens[i]));
         else if (doMath(operands, tokens[i]));
         else
            return i;
      }
      return -1;
   }
   
   public InFixExp toInFix(){
      String[] tokens = exp.split(" ");
      InFixExp in = new InFixExpImp();
      LinkedStack<String> expression = new LinkedStack<String>();
      for (int i=0; i<tokens.length; i++){
         if (Character.isDigit(tokens[i].charAt(0)))
            expression.push(tokens[i]);
         else { 
            boolean oprator = (tokens[i].equals("*") || tokens[i].equals("/") || tokens[i].equals("%") || tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals(">=") || tokens[i].equals("<=") || tokens[i].equals(">") || tokens[i].equals("<") || tokens[i].equals("==") || tokens[i].equals("!="));
            if (oprator){
               String v1 = expression.pop();
               String v2 = expression.pop();
               String v = "("+v2+tokens[i]+v1+")";
               expression.push(v);
            }
         }
      }
      in.setExp(expression.pop());
      return in;
   }
   
   public boolean doMath (LinkedStack<Integer> op, String opreation){
      int v1 = op.pop(), v2 = op.pop(), result;
      switch (opreation){
         case "+": result = v1+v2; break;
         case "-": result = v1-v2; break;
         case "*": result = v1*v2; break;
         case "/": if (v2==0)
                     return false;
                   result = v1/v2; break;
         case "%": if (v2==0)
                     return false;
                   result = v1%v2; break;
         case ">=": result = (v1>=v2)? 1:0; break;
         case "<=": result = (v1<=v2)? 1:0; break;
         case ">": result = (v1>v2)? 1:0; break;
         case "<": result = (v1<v2)? 1:0; break;
         case "==": result = (v1==v2)? 1:0; break;
         case "!=": result = (v1!=v2)? 1:0; break;
         default: return false;
      }
      op.push(result);
      return true;
   }
}