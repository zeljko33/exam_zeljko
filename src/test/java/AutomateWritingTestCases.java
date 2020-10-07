import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AutomateWritingTestCases {

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

		//SandboxObjects.openPlayground(driver);
		//SandboxObjects.openUseCasesMenu(driver);
		driver.manage().window().maximize();
	}

	@Test
	public void createTeam() {
		SandboxObjects.openUseCasesMenu(driver);

		SandboxObjects.clickCreateUseCaseButton(driver);
		SandboxObjects.inputTitle(driver, "Create a new Team3");
		SandboxObjects.inputDescription(driver, "This is to check if a new Team can be created via GUI");
		SandboxObjects.inputExpectedResult(driver, "New Team titled \"My Team\" is created");

		SandboxObjects.addStepsInput(driver,
				"log in to https://qa-sandbox.apps.htec.rs/ , click \"Playground\" icon , click \"Teams\" tab , "
						+ "click \"Create Team\" btn , in \"Team Title\" enter \"My Team\" , click \"Submit\" btn");
		SandboxObjects.submitCase(driver);

		sa.assertEquals(driver.getCurrentUrl(), "https://qa-sandbox.apps.htec.rs/use-cases");

	}

	@Test

	public void modifyTeam() {
		SandboxObjects.openUseCasesMenu(driver);

		SandboxObjects.clickCreateUseCaseButton(driver);
		SandboxObjects.inputTitle(driver, "Modify a Team1");
		SandboxObjects.inputDescription(driver,
				"This is to check if existing Team can be successfuly modified (Team Title)");
		SandboxObjects.inputExpectedResult(driver, "Team \"My Team\" is renamed to \"Your Team\"");

		SandboxObjects.addStepsInput(driver,
				"log in to https://qa-sandbox.apps.htec.rs/ , click \"Playground\" icon , click \"Teams\" tab , "
						+ "click \"My Team\" from the list of teams (create new if not already created) , in input field change the team name to \"Your Team\" , click \"Submit\" btn");
		SandboxObjects.submitCase(driver);

		sa.assertEquals(driver.getCurrentUrl(), "https://qa-sandbox.apps.htec.rs/use-cases");
	}

	@Test

	public void deleteTeam() {
		SandboxObjects.openUseCasesMenu(driver);

		SandboxObjects.clickCreateUseCaseButton(driver);
		SandboxObjects.inputTitle(driver, "Delete a Team1");
		SandboxObjects.inputDescription(driver,
				"This test case is used to check if data is successfully deleted - existing team in this use case");
		SandboxObjects.inputExpectedResult(driver, "Team titled \"Your Team\" is successfully deleted");

		SandboxObjects.addStepsInput(driver,
				"log in to https://qa-sandbox.apps.htec.rs/ , click \"Playground\" icon , click \"Teams\" tab , "
						+ "click on a team titled \"Your Team\" (if does not exist it should be created first) , in the upper-right part of the screen click the \"Bin\" icon (delete) , click \"Submit\" btn");
		SandboxObjects.submitCase(driver);

		sa.assertEquals(driver.getCurrentUrl(), "https://qa-sandbox.apps.htec.rs/use-cases");
	}

	@Test

	public void retreive() {
		SandboxObjects.openUseCasesMenu(driver);

		SandboxObjects.clickCreateUseCaseButton(driver);
		SandboxObjects.inputTitle(driver, "Delete a Team1");
		SandboxObjects.inputDescription(driver,
				"This test case is used to check if data is successfully deleted - existing team in this use case");
		SandboxObjects.inputExpectedResult(driver, "Team titled \"Your Team\" is successfully deleted");

		SandboxObjects.addStepsInput(driver,
				"log in to https://qa-sandbox.apps.htec.rs/ , click \"Playground\" icon , click \"Teams\" tab , "
						+ "click on a team titled \"Your Team\" (if does not exist it should be created first) , in the upper-right part of the screen click the \"Bin\" icon (delete) , click \"Submit\" btn");
		SandboxObjects.submitCase(driver);

		sa.assertEquals(driver.getCurrentUrl(), "https://qa-sandbox.apps.htec.rs/use-cases");
	}

	@Test

	public void members() {
		SandboxObjects.openUseCasesMenu(driver);

		SandboxObjects.clickCreateUseCaseButton(driver);
		SandboxObjects.inputTitle(driver,
				"Check correct error message is displayed when logging in with non-existing user1");
		SandboxObjects.inputDescription(driver,
				"This (negative) test case is used to make sure correct msg is displayed to the user if credentials are not valid. In this case, Username is not valid, that is, we are trying to log in with the user that does not exist in the DB");
		SandboxObjects.inputExpectedResult(driver, "Message \"User not found\" is displayed and user is not logged in");

		SandboxObjects.addStepsInput(driver,
				"navigate to \"https://qa-sandbox.apps.htec.rs/\" , in the \"Email Address\" field enter \"qwerty123asdf@abc.com\" (omit quote marks) , "
						+ "in the \"Password\" field enter \"pass123\" (omit quotes), click \"Submit\" btn ");
		SandboxObjects.submitCase(driver);

		sa.assertEquals(driver.getCurrentUrl(), "https://qa-sandbox.apps.htec.rs/use-cases");
	}

	

	@AfterClass
	// close webdriver
	public void close() {
		driver.close();

	}

}