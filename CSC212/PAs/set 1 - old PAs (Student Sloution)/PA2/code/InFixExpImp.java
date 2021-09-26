public class InFixExpImp implements InFixExp{
   
   private String exp;
   public String[] tokens = exp.split(" ");
      
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
      Stack<Integer> operands = new LinkedStack<Integer>();
      Stack<String> opertors = new LinkedStack<String>();
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
}