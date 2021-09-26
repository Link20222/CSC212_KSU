
public class Test {

	public static void main(String[] args) {
		LinkedUqueue<Integer> l = new LinkedUqueue<>();
		l.enqueue(1);
		l.enqueue(2);
		if(l.enqueue(2))
			System.out.print("HUH");
		l.enqueue(2);
		l.enqueue(3);
		
		System.out.print(l.serveFirst());
		System.out.print(l.serveFirst());


	}

	public static <T> T enquiry(Queue<T> q) {
		T data = q.serve();
		q.enqueue(data);

		for (int i = 0; i < q.length() - 1; i++) {
			T temp = q.serve();
			q.enqueue(temp);
		}

		return data;
	}
	
	public static<T> void split(Queue<T> q, Queue<T> oq, Queue<T> eq) {
		if(q.length() == 0)
			return;
		if(oq.length()+eq.length() == q.length())
			return;
		q.serve();
	}


}
