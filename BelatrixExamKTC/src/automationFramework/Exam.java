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
import extras.SortArrayPrices;
import extras.sortArrayofProducts;
import extras.sortByTitle;
import net.bytebuddy.implementation.ToStringMethod;
import pageObjects.home;
import pageObjects.specificSearch;

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

		home.busca(driver).click();
		Thread.sleep(1000);
		home.busca(driver).sendKeys("shoes");
		home.busca(driver).sendKeys(Keys.RETURN);
		Thread.sleep(6000);


		//shoebrand

		specificSearch.vertodo(driver).click();

		String parentWindow = driver.getWindowHandle();

		for(String winHandle : driver.getWindowHandles()){
			if(!winHandle.equals(parentWindow)) {
				driver.switchTo().window(winHandle);
			}
		}

		specificSearch.shoeBrand(driver).sendKeys("Puma");
		Thread.sleep(3000);
		specificSearch.shoeBrandPopUp(driver);
		specificSearch.shoeBrandBtn(driver);

		driver.switchTo().window(parentWindow);

		//shoesize
		specificSearch.shoeSizepopUp(driver);

		for(String winHandle : driver.getWindowHandles()){
			if(!winHandle.equals(parentWindow)) {
				driver.switchTo().window(winHandle);
			}
		}


		specificSearch.shoeSize(driver);
		specificSearch.shoeBrandBtn(driver);



		//5-	Print the number of results

		System.out.println(specificSearch.shoeTotal(driver).getText());

		//6-	Order by price ascendant


		specificSearch.shoeOrder(driver).click();
		specificSearch.shoeCriteria(driver, 4);

		System.out.println("punto numero 7 y 8");
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
		System.out.println("punto numero 9");
		//9-	Order and print the products by name (ascendant)

		sortArrayofProducts sortArray = new sortArrayofProducts();
		productArray = sortArray.compare(productArray);

		System.out.println("aca viene ordenado por nombre..con modificaciones");
		for (int i = 1; i < 6; i++) 
		{

			System.out.println("este el el item numero:  " + i);
			System.out.println(productArray[i].getTitulo());
			System.out.println(productArray[i].getPrecio());		 	
		}

		Thread.sleep(2000);
		//10-	Order and print the products by price in descendant mode

		System.out.println("entra a ordenarse por precio");
		SortArrayPrices sortArrayprice = new SortArrayPrices();
		productArray = sortArrayprice.compare(productArray);
		System.out.println("sale de ordenarse por precio");

		System.out.println("aca viene ordenado por precio con modificaciones");
		for (int i = 1; i < 6; i++) 
		{

			System.out.println("este el el item numero:  " + i);
			System.out.println(productArray[i].getTitulo());
			System.out.println(productArray[i].getPrecio());		 	
		}


		driver.quit();	
	}

}
