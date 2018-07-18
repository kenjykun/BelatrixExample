package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class specificSearch {
	
	
	private static WebElement element = null;
	 
	 public static WebElement vertodo(WebDriver driver) throws InterruptedException{
	 
	    element = driver.findElement(By.xpath("/html/body/div[3]/div[2]/ul/div/div/li[2]/div[1]/div/button"));
	    element.click();
	    Thread.sleep(4000);
	
	    return element;
	 
	    }
	 
	 public static WebElement shoeBrand(WebDriver driver) throws InterruptedException{
		 
		    element = driver.findElement(By.xpath("//*[@id=\'refineOverlay-subPanel-_x-searchable-0[0]\']"));
		    element.click();
		    Thread.sleep(4000);
		
		    return element;
		 
		    }
	 
	 
	 public static WebElement shoeBrandPopUp(WebDriver driver) throws InterruptedException{
		 
		    element = driver.findElement(By.xpath("//*[@id='refineOverlay-subPanel-_x-searchable-w0_cbx']"));
		    element.click();
		    Thread.sleep(4000);
		
		    return element;
}
	 
	 public static WebElement shoeBrandBtn(WebDriver driver) throws InterruptedException{
		 
		    element = driver.findElement(By.xpath("/html/body/div[12]/div/div/form/div[3]/div[2]/button"));
		    element.click();
		    Thread.sleep(4000);
		
		    return element;
}
	
	 public static WebElement shoeSizepopUp(WebDriver driver) throws InterruptedException{
		 
		    element = driver.findElement(By.xpath("/html/body/div[3]/div[2]/ul/div/div/li[1]/div/div/button"));
		    element.click();
		    Thread.sleep(3000);
		
		    return element;
		
}
	 
	 public static WebElement shoeSize(WebDriver driver) throws InterruptedException{
		 
		 
		 String xpathSizePart1 = "//*[@id='refineOverlay-subPanel-US%20Shoe%20Size%20%28Men%27s%29_";
		 	int desiredSize = 10;
		 	String xpathSizePart2	=	"_cbx']";
		 	String shoeSizePath = xpathSizePart1 + desiredSize + xpathSizePart2;
		 	
		 	
		    element = driver.findElement(By.xpath(shoeSizePath));
		    element.click();
		    Thread.sleep(3000);
		
		    return element;
		
}
	 
	 public static WebElement shoeSizeBtn(WebDriver driver) throws InterruptedException{
		 
		 
		 	
		    element = driver.findElement(By.xpath("/html/body/div[11]/div/div/form/div[3]/div[2]/button"));
		    element.click();
		    Thread.sleep(3000);
		
		    return element;
		
}
		
	
	 public static WebElement shoeTotal (WebDriver driver) throws InterruptedException{
		 
		 
		 	
		    element = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[1]/div[1]/div/ul/div[1]/div/div[2]/div[1]/div[1]/h1"));
		    Thread.sleep(1000);
		
		    return element;
		
}
	 
	 public static WebElement shoeOrder (WebDriver driver) throws InterruptedException{
		 
		 
		 	
		    element = driver.findElement(By.xpath("//*[@id='srp-river-results-SEARCH_STATUS_MODEL_V2-w0-w1_btn']"));
		    Thread.sleep(1000);
		
		    return element;
		
}
	 
	 public static WebElement shoeCriteria (WebDriver driver, int a) throws InterruptedException{
		 
			String SortCriteriaPath = "/html/body/div[3]/div[3]/div[1]/div[1]/div/ul/div[1]/div/div[1]/div[3]/div[1]/div/div/div/ul/li[";
		 	int criteria = a;
		 	String SortCriteriaPathComplete = SortCriteriaPath + criteria + "]"	;
		 
		 	
		    element = driver.findElement(By.xpath(SortCriteriaPathComplete));
		    Thread.sleep(6000);
		
		    return element;
		
}
	 
}
