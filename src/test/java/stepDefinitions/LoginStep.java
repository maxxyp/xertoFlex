package stepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helper.testBase;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pages.HomePage;
import pages.LoginPage;

import java.awt.print.Pageable;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

/**
 * Created by Maxwell on 09/11/2019.
 */
public class LoginStep extends testBase {

    public WebDriver driver;
    public int random;

    @Given("^I am on the Homepage$")
    public void i_am_on_the_Homepage() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.navigate().to("http://carguruji.com/shop/");

       // driver.get(CONFIG.getProperty("URL"));

    }

    @Given("^I click on sign in$")
    public void i_click_on_sign_in() throws Throwable {
        HomePage homepage  = PageFactory.initElements(driver, HomePage.class);
        homepage.click_signin();
    }

    @Given("^I enter my email \"([^\"]*)\" address$")
    public void i_enter_my_email_address(String email) throws Throwable {
       LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
       loginpage.type_email_address(email);

    }

    @Given("^I enter my password \"([^\"]*)\"$")
    public void i_enter_my_password(String password) throws Throwable {
        LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
        loginpage.type_password(password);

    }

    @When("^I click on te sign in button$")
    public void i_click_on_te_sign_in_button() throws Throwable {
        LoginPage loginpage = PageFactory.initElements(driver, LoginPage.class);
        loginpage.click_loginBtn();
    }

    @Then("^I should be logged in$")
    public void i_should_be_logged_in() throws Throwable {
        driver.findElement(By.linkText("David Mike")).isDisplayed();
    }

    @Then("^I sign out$")
    public void i_sign_out() throws Throwable {
        driver.findElement(By.linkText("Sign out")).click();
    }

    @Then("^I verify that my \"([^\"]*)\" is displayed$")
    public void iVerifyThatMyIsDisplayed(String actual_name) throws Throwable {
        String expected_name = driver.findElement(By.cssSelector("a > span")).getText();
        System.out.println(expected_name);
        assertEquals(expected_name, actual_name);
    }

    @When("^I click on the create account button$")
    public void i_click_on_the_create_account_button() throws Throwable {
        driver.findElement(By.cssSelector("#SubmitCreate > span")).click();
    }

    @Then("^I should see an error message$")
    public void i_should_see_an_error_message() throws Throwable {
        //assertEquals("An account using this email address has already been registered. Please enter a valid password or request a new one.", driver.findElement(By.cssSelector("ol > li")).getText());
        String ExpectedResult = "An account using this email address has already been registered. Please enter a valid password or request a new one.";
        String ActualResult = driver.findElement(By.cssSelector("ol > li")).getText();
        assertEquals(ExpectedResult,ActualResult);

    }

    @And("^I enter my new \"([^\"]*)\" address$")
    public void iEnterMyNewAddress(String value) throws Throwable {
        random = 100 + (int)(Math.random()* ((1000-1)+ 1));
        System.out.println(random);
        driver.findElement(By.id("email_create")).sendKeys(value + random + "@gmail.com");
    }


    @And("^I click on the male radio button$")
    public void iClickOnTheMaleRadioButton() throws Throwable {
        driver.findElement(By.id("id_gender1")).click();
    }

    @And("^I enter a firstname \"([^\"]*)\"$")
    public void iEnterAFirstname(String firstname) throws Throwable {
        driver.findElement(By.id("customer_firstname")).sendKeys(firstname);
    }

    @And("^I enter a lastname \"([^\"]*)\"$")
    public void iEnterALastname(String lastname) throws Throwable {
        driver.findElement(By.id("customer_lastname")).sendKeys(lastname);
    }

    @And("^I enter a password \"([^\"]*)\"$")
    public void iEnterAPassword(String password) throws Throwable {
        driver.findElement(By.id("passwd")).sendKeys(password);
    }

    @And("^I enter date of birth$")
    public void iEnterDateOfBirth() throws Throwable {
        new Select (driver.findElement(By.id("days"))).selectByValue("5");
        new Select(driver.findElement(By.id("months"))).selectByValue("8");
        new Select(driver.findElement(By.id("years"))).selectByValue("1992");
    }

    @When("^I click on register button$")
    public void iClickOnRegisterButton() throws Throwable {
        driver.findElement(By.cssSelector("#submitAccount > span")).click();

    }

    @Then("^I am registered successfully$")
    public void iAmRegisteredSuccessfully() throws Throwable {
        driver.findElement(By.linkText("Sign out")).click();
    }

    @And("^I enter email addres that is already in use$")
    public void iEnterEmailAddresThatIsAlreadyInUse() throws Throwable {
        driver.findElement(By.id("email_create")).sendKeys( "automationsoftskills@gmail.com");
    }

    @Given("^I search for \"([^\"]*)\" in the search input box$")
    public void i_search_for_in_the_search_input_box(String value) throws Throwable {
        driver.findElement(By.id("search_query_top")).click();
        driver.findElement(By.id("search_query_top")).sendKeys(value);
        driver.findElement(By.name("submit_search")).click();
    }

    @Given("^I see search product listing page$")
    public void i_see_search_product_listing_page() throws Throwable {
        driver.findElement(By.cssSelector("#center_column > h1 > span.lighter")).isDisplayed();
    }

    @When("^I click on the first item on page$")
    public void i_click_on_the_first_item_on_page() throws Throwable {
        driver.findElement(By.cssSelector("a.product_img_link > img.replace-2x.img-responsive")).click();
    }

    @Then("^I verify search description \"([^\"]*)\" on the product page$")
    public void i_verify_search_description_on_the_product_page(String arg1) throws Throwable {
        assertEquals("Faded Short Sleeves T-shirt", driver.findElement(By.cssSelector("h1")).getText());
    }

    @Then("^I also see option to slect sizes$")
    public void i_also_see_option_to_slect_sizes() throws Throwable {
//        driver.findElement(By.id("group_1")).click();
        new Select(driver.findElement(By.id("group_1"))).selectByVisibleText("M");
    }

}
