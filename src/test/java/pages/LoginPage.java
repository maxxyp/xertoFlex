package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by Maxwell on 20/11/2019.
 */
public class LoginPage {

    @FindBy(how= How.ID, using="email")
    public static WebElement myemail;

    @FindBy(how= How.ID, using="passwd")
    public static WebElement mypassword;

    @FindBy(how= How.ID, using="SubmitLogin")
    public static WebElement login_button;


    public void type_email_address(String email){
        myemail.sendKeys(email);
    }

    public void type_password(String password){
        myemail.sendKeys(password);
    }

    public void click_loginBtn(){
        login_button.click();
    }


}
