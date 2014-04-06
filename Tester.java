package mypackage;

public class Calculator {

	public int add (int a, int b) {
	
		return 2*a;
	
	}

}

package mypackage;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalcTest {

	public CalcTest(){}

	@BeforeClass
	public static void setUpClass() {}

	@AfterClass
	public static void tearDownClass() {}

	@Before
	publc void setup(){}

	@After
	public void tearDown() {}

	@Test
	public void test() {
	
		Calculator calc = new Calculator();

		assertEquals (calc.add(1,1),2);
	
	}

}
