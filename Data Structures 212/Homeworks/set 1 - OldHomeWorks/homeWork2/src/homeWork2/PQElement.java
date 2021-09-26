package homeWork2;

public class PQElement<T> {
	public T data;
	public double p;
	public PQElement(T e, double pr){
	data=e;
	p=pr;
	}
	
	public String toString(){
		return "\n data: " + data + " p : " +p;
	}
}