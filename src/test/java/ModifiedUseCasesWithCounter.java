import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ModifiedUseCasesWithCounter {
	
	public static void wait3() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}


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
		wait3();
		driver.manage().window().maximize();

		//	SandboxObjects.openPlayground(driver); //treba da ide na cases, a jok na igraliste
		driver.get("https://qa-sandbox.apps.htec.rs/use-cases");

	}

	@Test
	public void createTeam() {
		//SandboxObjects.openUseCasesMenu(driver);

		//driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/a[1]")).click(); //ulazi u test case
		driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/a[5]")).click();
		
		String text = SandboxObjects.findTitle(driver).getText();
		SandboxObjects.readField(driver, text);

		text = SandboxObjects.findDescription(driver).getText();
		SandboxObjects.readField(driver, text);

		text = SandboxObjects.findExpectedResult(driver).getText();
		SandboxObjects.readField(driver, text);

		text = SandboxObjects.addStepsField(driver).getText();
		SandboxObjects.readField(driver, text);

		SandboxObjects.submitCase(driver); //submit, odnosno da izadje nazad na spisak use case-ova

		sa.assertEquals(driver.getCurrentUrl(), "https://qa-sandbox.apps.htec.rs/use-cases");

	}

/*	@Test

	public void modifyTeam() {
		SandboxObjects.openUseCasesMenu(driver);

		driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/a[2]")).click();

		String text = SandboxObjects.findTitle(driver).getText();
		SandboxObjects.readField(driver, text);

		text = SandboxObjects.findDescription(driver).getText();
		SandboxObjects.readField(driver, text);

		text = SandboxObjects.findExpectedResult(driver).getText();
		SandboxObjects.readField(driver, text);

		text = SandboxObjects.addStepsField(driver).getText();
		SandboxObjects.readField(driver, text);

		SandboxObjects.submitCase(driver);

		sa.assertEquals(driver.getCurrentUrl(), "https://qa-sandbox.apps.htec.rs/use-cases");

	}

	@Test

	public void deleteTeam() {
		SandboxObjects.openUseCasesMenu(driver);

		driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/a[3]")).click();

		String text = SandboxObjects.findTitle(driver).getText();
		SandboxObjects.readField(driver, text);

		text = SandboxObjects.findDescription(driver).getText();
		SandboxObjects.readField(driver, text);

		text = SandboxObjects.findExpectedResult(driver).getText();
		SandboxObjects.readField(driver, text);

		text = SandboxObjects.addStepsField(driver).getText();
		SandboxObjects.readField(driver, text);

		SandboxObjects.submitCase(driver);

		sa.assertEquals(driver.getCurrentUrl(), "https://qa-sandbox.apps.htec.rs/use-cases");

	}

	@Test

	public void retreive() {
		SandboxObjects.openUseCasesMenu(driver);

		driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/a[4]")).click();

		String text = SandboxObjects.findTitle(driver).getText();
		SandboxObjects.readField(driver, text);

		text = SandboxObjects.findDescription(driver).getText();
		SandboxObjects.readField(driver, text);

		text = SandboxObjects.findExpectedResult(driver).getText();
		SandboxObjects.readField(driver, text);

		text = SandboxObjects.addStepsField(driver).getText();
		SandboxObjects.readField(driver, text);

		SandboxObjects.submitCase(driver);

		sa.assertEquals(driver.getCurrentUrl(), "https://qa-sandbox.apps.htec.rs/use-cases");

	}

	@Test

	public void members() {
		SandboxObjects.openUseCasesMenu(driver);

		driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/a[5]")).click();

		String text = SandboxObjects.findTitle(driver).getText();
		SandboxObjects.readField(driver, text);

		text = SandboxObjects.findDescription(driver).getText();
		SandboxObjects.readField(driver, text);

		text = SandboxObjects.findExpectedResult(driver).getText();
		SandboxObjects.readField(driver, text);

		text = SandboxObjects.addStepsField(driver).getText();
		SandboxObjects.readField(driver, text);

		SandboxObjects.submitCase(driver);

		sa.assertEquals(driver.getCurrentUrl(), "https://qa-sandbox.apps.htec.rs/use-cases");

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
	
//	@AfterClass

//	public void close() {
//		driver.close();
//	}

}
