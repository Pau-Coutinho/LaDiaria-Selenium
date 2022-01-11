package ladiaria;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public  class LaDiariaTester {
	private WebDriver driver;
	
	
	public LaDiariaTester(WebDriver driver) {
		this.driver = driver;	
	}
	
	public void performLogin(Credentials cs) {
		driver.get("https://ladiaria.com.uy/usuarios/entrar/");
		System.out.println("Starting login");
		
		driver.findElement(By.id("id_name_or_mail")).sendKeys(cs.getEmail());
		driver.findElement(By.id("id_password")).sendKeys(cs.getPassword());
		driver.findElement(By.className("form-submit-login")).click();
	}
	
	public void performRegistration (Credentials cs) {
		driver.get("https://ladiaria.com.uy/usuarios/registrate/");
		// Mandatory fields are first name, email address, telephone and password
		this.driver.findElement(By.id("id_first_name")).sendKeys("Testname");
		this.driver.findElement(By.id("id_email")).sendKeys(cs.getEmail());
		this.driver.findElement(By.id("id_phone")).sendKeys("099123456");
		this.driver.findElement(By.id("id_password")).sendKeys(cs.getPassword());
		
		this.driver.findElement(By.id("submit-id-save")).click();// Another way is to use this.driver.findElement(By.id("signup_form")).submit();
		

	}
	
	public void navigateTo (String link) { //todo: make it better
		driver.get(link);
	}
	
	
	public void performLogout () {
		System.out.println("Logging out... ");
		this.navigateTo("https://ladiaria.com.uy/usuarios/salir");
	} 
	
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	
	public void shutdown () {
		this.driver.quit();
	}
	
	
	
}
