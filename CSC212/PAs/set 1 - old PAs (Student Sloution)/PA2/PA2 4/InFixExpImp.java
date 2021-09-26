public class InFixExpImp implements InFixExp{
   
   private String exp;
   
      
   public void setExp(String exp){
      this.exp = exp;
   }
   
   public String getExp(){
      return exp;
   }
   
   public int getNbTokens(){
      return tokens.length;
   }
   
   public Pair<Stack<Integer>, Stack<String>> evaluate(int k){
      String[] tokens = exp.split(" ");
      LinkedStack<Integer> operands = new LinkedStack<Integer>();
      LinkedStack<String> opertors = new LinkedStack<String>();
      for (int i=0; i<k; i++){
         if (Character.isDigit(tokens[i]))
            operands.push(Integer.parseInt(tokens[i]));
         else if (tokens[i].equals("("))
            opertors.push("(");
         else if (tokens[i].equals(")")){
            while (!opertors.peek().equals(")")){
               int result = doMath(opertors.pop(), operands.pop(), operands.pop());
               if (result == -1) 
                  return null;
               operands.push(result);
               }
            opertors.pop();   
               
         }
      }
      Pair<Stack<Integer>,Stack<String>> toReturn = new Pair<Stack<Integer>,Stack<String>>(operands, opertors);
      return toReturn;
   }
   
   public int validate(){
      return -1;
   }
   
   public PostFixExp toPostFix(){
      PostFixExp post = new PostFixExpImp();
      return post;
   }
   
   public int doMath(String opreator, int v1, int v2){
      switch(opreator){
         case "+": return v1+v2;
         case "-": return v2-v1;
         case "*": return v2*v1;
         case "/": if (v1==0)
                     return -1;
                   return v2/v1;
         case "%": if (v1==0)
                     return -1;
                   return v2%v1;
         case ">=": return v2>=v1? 1:0;
         case "<=": return v2<=v1? 1:0;
         case ">": return v2>v1? 1:0;
         case "<": return v2<v1? 1:0;
         case "==": return v2==v1? 1:0;
         case "!=": return v2!=v1? 1:0;
         default: return -1;
      }
   }
}