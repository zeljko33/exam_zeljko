import java.awt.Dimension;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class RemoveTestCases {

	WebDriver driver;
	SoftAssert sa;

	@BeforeClass
	private void tools() {
		System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");

		driver = new ChromeDriver();
		sa = new SoftAssert();

		driver.get(SandboxObjects.HOME_URL);
		SandboxObjects.inputEmail(driver, "zeljko33@gmail.com");
		SandboxObjects.inputPassword(driver, "generic99");
		SandboxObjects.clickSubmitButton(driver);
		driver.manage().window().maximize();


		//	SandboxObjects.openPlayground(driver); //treba da ide na use cases, a ne na playground
		driver.get("https://qa-sandbox.apps.htec.rs/use-cases");
		
	}

	/*
	 * @Test
	 *
	 * public void deleteUseCases() { for (int i = 0; i<5; i++) {
	 * SandboxObjects.deleteUseCases(driver); } Dimension size =
	 * driver.findElement(By.xpath(
	 * "//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]")).getSize();
	 * sa.assertEquals(size, 0); }
	 *
	 */

/*	@AfterClass
	// close webdriver

	public void close() {
		driver.close();

	}*/
}
