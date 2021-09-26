public class SearchHello {
	public static void main(String[] args) {
		List<String> l = new LinkedList<String>();
		l.insert("cat");
		l.insert("hello");
      l.insert("this is me");
		l.insert("dog");
      l.remove();
      l.insert("cat");
      l.insert("cat");
		StringEqualCond cnd = new StringEqualCond("hello");
		System.out.println(l.findFirstEle(cnd)); // prints true
      List<String> cat = l.findAllEle(cnd);
	}
}
