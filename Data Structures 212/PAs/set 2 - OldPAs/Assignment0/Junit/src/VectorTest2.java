import static org.junit.Assert.*;
import org.junit.Before ;
import org.junit.Test;

	
public class VectorTest2 {


	private Vector vec, vec1;
	
	@Before
	public void setUp() throws Exception {
	vec = new Vector (5) ;
	vec.set (0, 1);
	vec.set (1, 2);
	vec.set (2, 3);
	vec.set (3, 4);
	vec.set (4, 5);
	
	vec1 = new Vector (5) ;
	vec1.set (0, 3);
	vec1.set (1, 3);
	vec1.set (2, 3);
	vec1.set (3, 4);
	vec1.set (4, 5);
	}
	
	@Test
	public void testCount(){
		int c = vec.count(0);
		int c1 = vec.count(2);
		int c2 = vec1.count(3);
		assertEquals (0 , c);
		assertEquals (1 , c1);
		assertEquals (3 , c2);
		
	}

}
