import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//This class contains xPaths and methods used in test classes

public class SandboxObjects {

	public static final String HOME_URL = "https://qa-sandbox.apps.htec.rs/login";
	public static final String URL_ROLES = "https://qa-sandbox.apps.htec.rs/roles";
	public static final String URL_PROJECTS = "https://qa-sandbox.apps.htec.rs/projects";

	public static final String EMAIL_FIELD = "/html[1]/body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/input[1]";
	public static final String PASSWORD_FIELD = "//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/div[2]/input[1]";
	public static final String SUBMIT_BTN_LOGIN = "//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/form[1]/button[1]";

	public static final String USE_CASE_OPTION1 = "//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]";
	public static final String USE_CASE_OPTION = "//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/a[1]/div[1]/div[1]";

	public static final String CREATE_USE_CASE = "//body/div[@id='root']/div[1]/div[2]/div[1]/a[2]";
	public static final String GET_USE_CASE = "//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/a[1]"; // from the use case list get the 1st one
																											
	public static final String SUBMIT_CASE = "//button[contains(text(),'Submit')]";

	public static final String TEAM_NAME = "//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[2]";
	public static final String EDIT_TEAM_NAME = "//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/div[1]/input[1]";

	public static final String CREATE_TEAM = "//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/a[2] ";
	public static final String SUBMIT_NEW_TEAM = "//button[contains(text(),'Submit')]";

	public static final String MEMBERS_LIST = "//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[2]";

	public static final String DELETE_USE_CASE = "//body/div[@id='root']/div[1]/div[2]/div[1]/div[1]/div[1]/form[1]/span[2]/button[1]";
	public static final String DELETE_CONFIRM = "//button[contains(text(),'Delete')]";

	public static String visibleText;
	public static String visibleTextList;
	public static String message;

	public static String teamName(WebDriver driver) {
		return visibleText = driver.findElement(By.xpath(TEAM_NAME)).getText();
	}

	public static String membersList(WebDriver driver) {
		return visibleTextList = driver.findElement(By.xpath(MEMBERS_LIST)).getText();
	}

	public static String userNotFoundMessage(WebDriver driver) {

		return message = driver.findElement(By.className("invalid-feedback")).getText();
	}

	// Methods to input email

	public static WebElement getEmailField(WebDriver driver) {
		return driver.findElement(By.name("email"));

	}

	public static void clickEmail(WebDriver driver) {
		getEmailField(driver).click();
	}

	public static void inputEmail(WebDriver driver, String data) {
		getEmailField(driver).sendKeys(data);
	}

	// Methods to input password

	public static WebElement getPasswordField(WebDriver driver) {
		return driver.findElement(By.name("password"));
	}

	public static void clickPasswordField(WebDriver driver) {
		getPasswordField(driver).click();
	}

	public static void inputPassword(WebDriver driver, String data) {
		getPasswordField(driver).sendKeys(data);
	}

	// click submit for log in

	public static void clickSubmitButton(WebDriver driver) {
		driver.findElement(By.xpath(SUBMIT_BTN_LOGIN)).click();
	}
	// select use Case menu

	public static void openUseCasesMenu(WebDriver driver) {
		driver.findElement(By.xpath(USE_CASE_OPTION)).click();
	}

	// create a use case
	public static void clickCreateUseCaseButton(WebDriver driver) {
		driver.findElement(By.xpath(CREATE_USE_CASE)).click();
	}

	// fill in the fields for use case
	public static WebElement findTitle(WebDriver driver) {
		return driver.findElement(By.name("title"));
	}

	public static void inputTitle(WebDriver driver, String data) {
		findTitle(driver).click();
		findTitle(driver).sendKeys(data);
	}

	public static WebElement findDescription(WebDriver driver) {
		return driver.findElement(By.name("description"));
	}

	public static void inputDescription(WebDriver driver, String data) {
		findDescription(driver).click();
		findDescription(driver).sendKeys(data);
	}

	public static WebElement findExpectedResult(WebDriver driver) {
		return driver.findElement(By.name("expected_result"));
	}

	public static void inputExpectedResult(WebDriver driver, String data) {
		findExpectedResult(driver).click();
		findExpectedResult(driver).sendKeys(data);
	}

	// fill in use case steps

	public static WebElement addStepsField(WebDriver driver) {
		return driver.findElement(By.name("testStepId-0"));
	}

	public static void addStepsInput(WebDriver driver, String data) {
		addStepsField(driver).click();
		addStepsField(driver).sendKeys(data);
	}

	public static void submitCase(WebDriver driver) {
		driver.findElement(By.xpath(SUBMIT_CASE)).click();
	}

	// count and replace text in use cases

	public static void readField(WebDriver driver, String data) {

		int length = data.length();
		String newData = "This field previously had " + length + " characters.";

		newData.replace(data, newData);
	}

	// open playground option from the dashboard menu

	public static void openPlayground(WebDriver driver) {
		driver.findElement(By.cssSelector("[data-testid='playground_card_id']")).click();
	}

	// open team tab
	public static void openTeamTab(WebDriver driver) {
		driver.findElement(By.id("test1")).click();
	}

	// create a team
	public static void createTeam(WebDriver driver) {
		driver.findElement(By.xpath(CREATE_TEAM)).click();
	}

	// add a team's name
	public static WebElement nameTeam(WebDriver driver) {
		return driver.findElement(By.name("role_name"));
	}

	public static void inputNameTeam(WebDriver driver, String data) {
		nameTeam(driver).click();
		nameTeam(driver).clear();
		nameTeam(driver).sendKeys(data);
	}

	// submit a team
	public static void submitTeam(WebDriver driver) {
		driver.findElement(By.xpath(SUBMIT_NEW_TEAM)).click();
	}

	// modify team

	public static void findTeam(WebDriver driver) {
		driver.findElement(By.xpath("//a[contains(text(),'My Team')]")).click();
	}

	public static WebElement editTeamA(WebDriver driver) {

		return driver.findElement(By.xpath(EDIT_TEAM_NAME));
	}

	public static void renameTeamA(WebDriver driver, String data) {
		editTeamA(driver).click();
		editTeamA(driver).clear();
		editTeamA(driver).sendKeys(data);

		driver.findElement(By.xpath(SUBMIT_NEW_TEAM)).click();
	}

	// delete team
	public static void wait5() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public static void findTeamDelete(WebDriver driver) {
		driver.findElement(By.xpath("//a[contains(text(),'Your Team')]")).click();
		wait5();

		driver.findElement(By.xpath("//button[@id='button__project-delete']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Delete')]")).click();
	}

	// open people tab
	public static void openPeopleTab(WebDriver driver) {
		driver.findElement(By.id("test2")).click();
	}

	// logout
	public static void logOut(WebDriver driver) {
		driver.findElement((By.xpath("//a[contains(text(),'Logout')]"))).click();
	}

	// delete use case
	public static void deleteUseCases(WebDriver driver) {

		driver.findElement(By.xpath(GET_USE_CASE)).click();

		driver.findElement(By.xpath(DELETE_CONFIRM)).click();

	}
}