package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class home {
	
	private static WebElement element = null;
	 
	 public static WebElement busca(WebDriver driver){
	 
	    element = driver.findElement(By.xpath("//*[@id=\'gh-ac\']"));
	    
	
	    return element;
	 
	    }
	 




}