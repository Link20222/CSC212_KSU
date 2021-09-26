import static org.junit.Assert.*;
import org.junit.Before ;
import org.junit.Test;

public class VectorTest {

	private Vector vec;
	
	@Before
	public void setUp() throws Exception {
	vec = new Vector (5) ;
	vec.set (0, 1);
	vec.set (1, 2);
	vec.set (2, 3);
	vec.set (3, 4);
	vec.set (4, 5);
	}
	
	@Test
	public void testSum () {
	int s = vec.sum ();
	assertEquals (15 , s);
	
	}
	
	
	@Test
	public void testProd () {
	int p = vec. prod ();
	assertEquals (120 , p);
	}
	
	@Test
	public void testAverage () {
	double v = vec.average();
	assertEquals(3, v, 1.0e-8);
	}
}

