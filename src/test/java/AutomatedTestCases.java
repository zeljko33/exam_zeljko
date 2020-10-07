import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AutomatedTestCases {
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

		SandboxObjects.openPlayground(driver);
	}

	@Test(priority = 1)
	// Create a team
	
	public void createTeam() {
		SandboxObjects.openTeamTab(driver);
		SandboxObjects.createTeam(driver);
		SandboxObjects.nameTeam(driver);
		SandboxObjects.inputNameTeam(driver, "My Team22");
		SandboxObjects.submitTeam(driver);

		driver.get(SandboxObjects.URL_ROLES);

		sa.assertEquals(SandboxObjects.teamName(driver), "My Team22");
	}

	@Test(priority = 2)
	// Modify a team

	public void modifyTeam() {
		SandboxObjects.openTeamTab(driver);
		SandboxObjects.findTeam(driver);
		wait3();
		SandboxObjects.editTeamA(driver);
		SandboxObjects.renameTeamA(driver, "Your Team");
		SandboxObjects.submitTeam(driver);

		driver.get(SandboxObjects.URL_ROLES);

		sa.assertEquals(SandboxObjects.teamName(driver), "Your Team");
	}

	@Test(priority = 3)
	// Delete a team

	public void deleteTeam() {
		SandboxObjects.openTeamTab(driver);
		SandboxObjects.findTeamDelete(driver);

		driver.get(SandboxObjects.URL_ROLES);

		sa.assertEquals(SandboxObjects.teamName(driver), "Your Team");
	}

	@Test(priority = 4)
	// Retrieve a list of members

	public void retrieveMembers() {
		driver.get(SandboxObjects.URL_PROJECTS);
		SandboxObjects.openPeopleTab(driver);

		sa.assertEquals(SandboxObjects.membersList(driver), "Petar, John Doe, Milutin, Gandalf");
	}

	@Test(priority = 5)
	// wrong credentials for log in

	public void invalidCredentialsForLogIn() {

		SandboxObjects.logOut(driver);
		wait3();
		driver.get(SandboxObjects.HOME_URL);

		SandboxObjects.inputEmail(driver, "qwerty123asdf@abc.com");
		SandboxObjects.inputPassword(driver, "pass123");
		SandboxObjects.clickSubmitButton(driver);
		wait3();

		sa.assertEquals(SandboxObjects.userNotFoundMessage(driver), "User not found");

		driver.getCurrentUrl();
		sa.assertEquals(driver.getCurrentUrl(), SandboxObjects.HOME_URL);
	}

	@AfterClass

	public void close() {
		driver.close();
	}

}