package collectPrice;

import org.testng.annotations.Test;

public class SeleniumConnect {
	
	//Singleton Area
	private static SeleniumConnect instance = new SeleniumConnect();
	
	private SeleniumConnect()
	{
		
	}
	
	public static SeleniumConnect getInstance()
	{
		return instance;
	}
	//Singleton Area
	
	
	//method declaration
	@Test
	public void SeleniumActGetPrice()
	{
		
	}
}
