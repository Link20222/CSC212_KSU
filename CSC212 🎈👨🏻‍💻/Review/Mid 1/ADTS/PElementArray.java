package ADTS;

public class PElementArray <T>
{
	private T data;
	private int priority;
	
	public PElementArray(T d,int prio)
	{
		data = d;
		priority = prio;
	}

	public int getPriority()
	{
		return priority;
	}
	
	public T getData()
	{
		return data;
	}
	
	public void setPriority(int prio)
	{
		priority = prio;
	}
	
	public void setData(T d)
	{
		data = d;
	}
}