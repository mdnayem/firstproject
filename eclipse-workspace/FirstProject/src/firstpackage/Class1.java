package firstpackage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Class1 {
	
	
	@Before
	public void setUp() throws Exception {
		String myname;
		myname = "Farhana";
		myname.getBytes();
		System.out.println("My class1 at before " + myname + myname.getBytes());
		
		
	}
	
	@Test
	public void Class1test() throws Exception {
		System.out.println("My class1 at test");
		
	}
	
	@After 
	public void tearDown() throws Exception {
		
		System.out.println("My class1 at after");
	}
	
	
	
	

}
