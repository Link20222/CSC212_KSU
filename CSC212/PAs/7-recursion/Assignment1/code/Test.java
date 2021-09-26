public class Test{
public static void main (String [] args) {
String s = "873-*4+23-*58-+";
System.out.println(Postfix.eval(s));

System.out.println(Postfix.infix(s));
}
}