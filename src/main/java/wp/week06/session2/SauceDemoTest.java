package wp.week06.session2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SauceDemoTest {
	
	@Test

	public void validateProductNameInCartPage() {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.cssSelector("input#user-name")).sendKeys("standard_user");
		driver.findElement(By.cssSelector("input#password")).sendKeys("secret_sauce");
		driver.findElement(By.cssSelector("input#login-button")).click();
		String item_name = driver.findElement(By.cssSelector("div.inventory_item:first-child > div.inventory_item_description > div.inventory_item_label > a > div.inventory_item_name")).getText();
		driver.findElement(By.cssSelector("div.inventory_item:first-child > div.inventory_item_description >  div.pricebar > button")).click();
	    driver.findElement(By.cssSelector("div#shopping_cart_container > a")).click();
	   Assert.assertEquals(driver.findElement(By.cssSelector("div.inventory_item_name")).getText(), item_name);
	   
		
	}
}
