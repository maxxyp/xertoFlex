package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by Maxwell on 20/11/2019.
 */
public class HomePage {

    //This is Locator Identification
    @FindBy(how=How.LINK_TEXT, using="Sign in")
    public static WebElement signIn;

    //This is Locator Identification
    @FindBy(how=How.LINK_TEXT, using="Contact us")
    public static WebElement contactUs;


    public void click_signin(){
        signIn.click();
    }

    public void click_contactus(){
        contactUs.click();
    }



}
