import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class SingUpPage {

    private WebDriver driver;

    public SingUpPage(WebDriver driver){
        this.driver = driver;
    }

    private By heading = By.xpath("//*[text()=\"Регистрация\"]");
    private By mailField = By.xpath("//*[@id=\"email_field\"]");
    private By nicknameField = By.xpath("//*[@id=\"nickname_field\"]");
    private By passwordField = By.xpath("//*[@id=\"password_field\"]");
    private By passwordRepeatField = By.xpath("//*[@id=\"password_repeat\"]");
    private By iAmNotRobot = By.xpath("//*[@id=\"agree\"]");
    private By regButton = By.xpath("//*[@id=\"registration_button\"]");
    private By mailError = By.xpath("//*[text()=\"Введите корректный e-mail\"]");
    private By nicnameError = By.xpath("//*[contains(text(), \"Только буквы\")]");
    private By passwordError = By.xpath("//*[contains(text(), \"Длина пароля\")]");

    public String getHeadingText(){
        return driver.findElement(heading).getText();
    }
    public SingUpPage typeMail(String mail){
        driver.findElement(mailField).sendKeys(mail);
        return this;
    }
    public SingUpPage typeNickname(String nickname){
        driver.findElement(nicknameField).sendKeys(nickname);
        return this;
    }
    public SingUpPage typePassword(String pass){
        driver.findElement(passwordField).sendKeys(pass);
        return this;
    }
    public SingUpPage typePasswordRepeat(String passRepeat){
        driver.findElement(passwordRepeatField).sendKeys(passRepeat);
        return this;
    }
    public SingUpPage iAmNotRobotCheckbox(){
        WebElement checkbox = driver.findElement(iAmNotRobot);
        if (!checkbox.isSelected()){
            checkbox.click();
        }return new SingUpPage(driver);
    }
    public SingUpPage clickRegButton(){
        driver.findElement(regButton).click();
        return new SingUpPage(driver);
    }
    public SingUpPage regAkk(String sendMail, String sendNickname, String sendPass, String sendPassRepeat){
        this.typeMail(sendMail);
        this.typeNickname(sendNickname);
        this.typePassword(sendPass);
        this.typePasswordRepeat(sendPassRepeat);
        iAmNotRobotCheckbox();
        clickRegButton();
        return new SingUpPage(driver);
    }


}
