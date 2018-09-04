package firstpackage;

import org.junit.After;
import org.junit.Test;

public class FirstClass {
	
	@Test
	public void myfunction() throws Exception {
		
		int age;
		int myage = 17;
		       age = 18;
		  if (myage > age)
		  {System.out.println("congrats youre eligible");}
		  else if (myage < age)
		   {System.out.println("Sorry youre not eligible");}
		 
		
		int myzip;
		myzip = 11432;
		int myoffice;
		myoffice = 17514;
		int mytotal;
		String myname;
		myname = "Farhana";
		mytotal = myzip + myoffice;
		
		
		System.out.println("Hello " + myname + ", having fun with JAVA? Your total is " + mytotal);
		System.out.println("thumbs up from function 1");
		
		

}
	@Test
	public void myfunction2() {
		System.out.println("thumbs up from function 2");
		
	}
	
	
	@After 
	public void leaving() throws Exception {
		System.out.println("I am at After and Browser is being closed");
	}
	
	
}