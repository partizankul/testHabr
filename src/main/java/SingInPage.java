import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SingInPage {

    private WebDriver driver;

    public SingInPage(WebDriver driver){
        this.driver = driver;
    }

    private By heading = By.xpath("//*[text()=\"Вход\"]");
    private By mailField = By.xpath("//*[@id=\"email_field\"]");
    private By passwordField = By.xpath("//*[@id=\"password_field\"]");
    private By singInButton = By.xpath("//*[contains(text(), \"Войти\")]");
    private By mailError = By.xpath("//*[contains(text(), \"Введите корректный e-mail\")]");
    private By passError = By.xpath("//*[contains(text(), \"Введите пароль\")]");


    public String getHeadingText(){
        return driver.findElement(heading).getText();
    }
    public SingInPage typeMail (String mail){
        driver.findElement(mailField).sendKeys(mail);
        return this;
    }
    private SingInPage typePassword (String pass){
        driver.findElement(passwordField).sendKeys(pass);
        return this;
    }
    public SingInPage clickSingInButton(){
        driver.findElement(singInButton).click();
        return new SingInPage(driver);
    }
    public String getMailError(){
        return driver.findElement(mailError).getText();
    }
    public String getPassError(){
        return driver.findElement(passError).getText();
    }
    public SingInPage singInArr(String sendmail, String sendPass){
        this.typeMail(sendmail);
        this.typePassword(sendPass);
        clickSingInButton();

        return new SingInPage(driver);
    }

}
