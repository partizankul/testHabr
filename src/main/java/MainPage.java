import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private WebDriver driver;


    public MainPage(WebDriver driver){
        this.driver = driver;
    }
    private By logotip = By.xpath("//a[@class=\"logo\"]");
    private By singInButton = By.xpath("//*[@id=\"login\"]");
    private By singUpButton = By.xpath("//*[@class=\"btn btn_medium btn_navbar_registration\"]");




    public String getHeadingText(){
        return driver.findElement(logotip).getText();
    }

    public SingInPage clickSingInButton(){
      driver.findElement(singInButton).click();
      return new SingInPage(driver);
    }

    public SingUpPage clickSingUpButton(){
        driver.findElement(singUpButton).click();
        return new SingUpPage(driver);
    }


}
