package automationFramework;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import extras.producto;
import extras.sortArrayofPrices;
import extras.sortArrayofProducts;
import extras.sortByTitle;
import net.bytebuddy.implementation.ToStringMethod;

public class Exam {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "/BelatrixExamKTC/seleniumLib/geckodriver.exe"); 
		WebDriver driver = new FirefoxDriver();
		
		JavascriptExecutor js = (JavascriptExecutor) driver; //anotacion, esto se [puede remover si no funciona
		
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
				capabilities.setCapability("marionette", true);
		
				
				String url = "https://www.ebay.com/";
				driver.get(url);
			    WebElement searchtext = driver.findElement(By.xpath("//*[@id=\'gh-ac\']"));
				searchtext.click();
				Thread.sleep(1000);
				searchtext.sendKeys("shoes");
				searchtext.sendKeys(Keys.RETURN);
				Thread.sleep(6000);
				
		
			
			
			//shoebrand
			
					
				
				
				
				WebElement btnVerTodo = driver.findElement(By.xpath("/html/body/div[3]/div[2]/ul/div/div/li[2]/div[1]/div/button"));
				btnVerTodo.click();
				Thread.sleep(4000);
				
				String parentWindow = driver.getWindowHandle();
				
				for(String winHandle : driver.getWindowHandles()){
				    if(!winHandle.equals(parentWindow)) {
				        driver.switchTo().window(winHandle);
				    }
				}
				
			WebElement shoeBrand = driver.findElement(By.xpath("//*[@id=\'refineOverlay-subPanel-_x-searchable-0[0]\']"));
			
			shoeBrand.sendKeys("Puma");
			Thread.sleep(3000);
			
			WebElement shoeBrand2 = driver.findElement(By.xpath("//*[@id='refineOverlay-subPanel-_x-searchable-w0_cbx']"));
		 	shoeBrand2.click();
		 	Thread.sleep(3000);
		 	WebElement btnOk = driver.findElement(By.xpath("/html/body/div[12]/div/div/form/div[3]/div[2]/button"));
		 	btnOk.click();
		 	Thread.sleep(3000);
		 	
			
		//colocar algo si es necesarioi regresar
		 	driver.switchTo().window(parentWindow);
			
		 	
		 	//shoesize

		 	String xpathSizePart1 = "//*[@id='refineOverlay-subPanel-US%20Shoe%20Size%20%28Men%27s%29_";
		 	int desiredSize = 10;
		 	String xpathSizePart2	=	"_cbx']";
		 	String shoeSizePath = xpathSizePart1 + desiredSize + xpathSizePart2;
		 	System.out.println(shoeSizePath);

		 	
		 	WebElement btnVerTodoSize = driver.findElement(By.xpath("/html/body/div[3]/div[2]/ul/div/div/li[1]/div/div/button"));
			btnVerTodoSize.click();
			Thread.sleep(3000);
			
			//String parentWindow = driver.getWindowHandle();
			
			for(String winHandle : driver.getWindowHandles()){
			    if(!winHandle.equals(parentWindow)) {
			        driver.switchTo().window(winHandle);
			    }
			}
			WebElement shoeSize = driver.findElement(By.xpath(shoeSizePath));
		 	shoeSize.click();
		 	Thread.sleep(3000);
		 	WebElement btnSizeOk = driver.findElement(By.xpath("/html/body/div[11]/div/div/form/div[3]/div[2]/button"));
		 	btnSizeOk.click();
		 	Thread.sleep(3000);
		 	
		 	//5-	Print the number of results
		 	
		 	WebElement shoeResultsNumber = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[1]/div[1]/div/ul/div[1]/div/div[2]/div[1]/div[1]/h1"));
		 	System.out.println(shoeResultsNumber.getText());
		 	
		 	
		 	
		 	
		 	//6-	Order by price ascendant
		 	
		 	WebElement sortCriteriaCmb = driver.findElement(By.xpath("//*[@id='srp-river-results-SEARCH_STATUS_MODEL_V2-w0-w1_btn']"));
		 	sortCriteriaCmb.click();
		 	
		 	String SortCriteriaPath = "/html/body/div[3]/div[3]/div[1]/div[1]/div/ul/div[1]/div/div[1]/div[3]/div[1]/div/div/div/ul/li[";
		 	int criteria = 4;
		 	String SortCriteriaPathComplete = SortCriteriaPath + criteria + "]"	;
		 	
		 	WebElement sortCriteria = driver.findElement(By.xpath(SortCriteriaPathComplete));
		 	sortCriteria.click();
		 	Thread.sleep(6000);
		 	/*
		 	mejor resultado
		 	/html/body/div[3]/div[3]/div[1]/div[1]/div/ul/div[1]/div/div[1]/div[3]/div[1]/div/div/div/ul/li[1]/div
		 	
		 	duracion
		 	/html/body/div[3]/div[3]/div[1]/div[1]/div/ul/div[1]/div/div[1]/div[3]/div[1]/div/div/div/ul/li[2]/a/span
		 	
		 	anuncios mas recientes
		 	
		 	/html/body/div[3]/div[3]/div[1]/div[1]/div/ul/div[1]/div/div[1]/div[3]/div[1]/div/div/div/ul/li[3]/a
		 	
		 	precio+envio mas bajo primero
		 	precio + envio mas alto primero
		 	distancia mas cercanos primero
		 	*/
		 	
		 	System.out.println("punto numero 7");
		 	//7-	Assert the order taking the first 5 results
		 	//8-	Take the first 5 products with their prices and print them in console.
		 	//inicializar el arreglo de la clase producto que contiene titulo y precio
		 	
		 	producto [] productArray = new producto[6];
		 	for (int i = 1; i < 6; i++) 
		 	{
		 	producto aux = new producto();
		 	
		 	//para hacer scroll de la pagina
		 	WebElement Element = driver.findElement(By.xpath("//*[@id=\'srp-river-results-listing"+ i + "\']"));
		 	js.executeScript("arguments[0].scrollIntoView();", Element);
		 	
		 	
		 	String ProductTitlePath = "	/html/body/div[3]/div[3]/div[1]/div[1]/div/ul/li[" + i + "]/div/div[2]/a/h3";
		 	WebElement ProductTitle = driver.findElement(By.xpath(ProductTitlePath));
		 	//ProductTitle.getText(); // queda almacenarlo en un string, consigo el titulo del aviso
		 	aux.setTitulo(ProductTitle.getText());
		 	
		 	String ProductPricePath = "	/html/body/div[3]/div[3]/div[1]/div[1]/div/ul/li[" + i + "]/div/div[2]/div[3]/div[1]/span";
		 	WebElement ProductPrice = driver.findElement(By.xpath(ProductPricePath));
		 	ProductPrice.getText(); // queda almacenarlo en un string, consigo el precio del aviso
		 	aux.setPrecio(new Float(ProductPrice.getText().substring(4,ProductPrice.getText().length() )));
		 
		 
		 	productArray[i]=new producto();
		 	productArray[i]=aux;
		 	System.out.println("este el el item numero:  " + i);
		 	System.out.println(productArray[i].getTitulo());
		    System.out.println(productArray[i].getPrecio());
		 	Thread.sleep(2000);
		 	}
		 	
		 	//9-	Order and print the products by name (ascendant)
		 	
		 	sortArrayofProducts sortArray = new sortArrayofProducts();
		 	productArray = sortArray.compare(productArray);
		 	
		 	System.out.println("aca viene ordenado por nombre");
		 	for (int i = 1; i < 6; i++) 
		 	{
		 			
		 		System.out.println("este el el item numero:  " + i);
			 	System.out.println(productArray[i].getTitulo());
			    System.out.println(productArray[i].getPrecio());		 	
		 	}
		 	
		 	
		 	//10-	Order and print the products by price in descendant mode
		
		 	sortArrayofPrices sortArrayprice = new sortArrayofPrices();
		 	productArray = sortArrayprice.compare(productArray);
		 	
		 	System.out.println("aca viene ordenado por precio");
		 	for (int i = 1; i < 6; i++) 
		 	{
		 			
		 		System.out.println("este el el item numero:  " + i);
			 	System.out.println(productArray[i].getTitulo());
			    System.out.println(productArray[i].getPrecio());		 	
		 	}
		 	
	
			driver.quit();	
	}
  
}
