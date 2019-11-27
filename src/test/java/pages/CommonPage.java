package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * Created by Maxwell on 20/11/2019.
 */
public class CommonPage {

    @FindBy(how= How.CSS, using="#block_top_menu > ul > li:nth-child(1) > a")
    public static WebElement women;

    @FindBy(how= How.CSS, using="#block_top_menu > ul > li:nth-child(2) > a")
    public static WebElement dresses;

    @FindBy(how= How.CSS, using="#block_top_menu > ul > li:nth-child(3) > a")
    public static WebElement tShirt;


    public void click_women_btn(){
        women.click();
    }

    public void click_dresses(){
        dresses.click();
    }

    public void click_tShirt(){
        tShirt.click();
    }


}
