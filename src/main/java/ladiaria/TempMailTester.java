package ladiaria;
/* Clipboard dependencies */
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class TempMailTester {
	private WebDriver driver;
	
	public TempMailTester (WebDriver driver) {
		this.driver = driver;
	}
	
	public void setUp() {
		driver.get("https://tempmailo.com/");
	}
	
	public String getTempMailAddress () {
		/*
		 * I have to do it this way as the webpage is explicitly made to prevent reading the contents of the input.
		 * I am pretty sure that making this work with the javascript bindings of selenium is possible, this just works... 
		 */
		
		 driver.findElement(By.className("iconx")).click(); 
		
		 try {
		 return (String) Toolkit.getDefaultToolkit().getSystemClipboard().getData(DataFlavor.stringFlavor);
		 }
		 catch (Exception e) {
			 return null; // C type error handling (to change)
		 }
	}
	
	
	public String getConfirmationMailLink() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.xpath("//*[contains(text(), 'la diaria <suscripciones@ladiaria.com.uy>')]")).click();
		driver.switchTo().frame("fullmessage");
		return driver.findElement(By.xpath("//*[contains(@href, 'https://ladiaria.com.uy/usuarios/completar-registro/')]")).getAttribute("href");
	
	}
	
	public void confirmAccount(String confirmationLink) {
		this.driver.get(confirmationLink);
	}
	
	public void shutdown () {
		driver.quit();
	}
}



