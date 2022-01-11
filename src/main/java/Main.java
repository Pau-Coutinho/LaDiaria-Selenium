import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ladiaria.Credentials;
import ladiaria.LaDiariaTester;
import ladiaria.TempMailTester;


public class Main {
	
	public static final String WEBDRIVER_PATH = "C:\\Users\\pau\\Desktop\\Estudio\\cd\\chromedriver.exe";
	
	public static void main(String[] args) {
		String ArticuloALeer = "https://ladiaria.com.uy/coronavirus/articulo/2022/1/salinas-le-respondio-a-mujica-por-criticas-en-distribucion-de-vacunas-hay-dosis-para-todos/"; //
		WebDriver tempMailDriver = new ChromeDriver();
		WebDriver laDiariaTester = new ChromeDriver();

		TempMailTester mailTester = new TempMailTester(tempMailDriver);
		mailTester.setUp();
		
		String tempMailAddress = mailTester.getTempMailAddress();
		

		Credentials credentials = new Credentials (tempMailAddress,Credentials.generateRandomPassword());
		LaDiariaTester diariaTester = new LaDiariaTester(laDiariaTester);
		
		diariaTester.performRegistration(credentials);
		diariaTester.shutdown();
		String confirmationLink = mailTester.getConfirmationMailLink();
		
		laDiariaTester = new ChromeDriver();
		diariaTester.setDriver(laDiariaTester);
		diariaTester.navigateTo(confirmationLink);
		//diariaTester.performLogin(credentials); /*It's not necessary as we do not have to login to see the free articles.
		diariaTester.navigateTo(ArticuloALeer);
		
		
	}
}
