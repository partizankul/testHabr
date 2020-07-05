import Utilites.Driver;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainPageTest {

    private MainPage mainPage;
    private SingInPage singInPage;
    private SingUpPage singUpPage;
    private Logger logger;


    @Before
    public void setUp(){
        logger = Logger.getLogger("new Logger");
        Driver.getDriver().get("https://habr.com/ru/");
        mainPage = new MainPage(Driver.getDriver());
    }

    @Test
    public void getHeadingTest(){
        logger.info("start MainPage test getHeadinhTest");
        Assert.assertEquals("", mainPage.getHeadingText());
        logger.info("finish MainPage test getHeadinhTest");
    }

    @Test
    public void clickSingInButtonTest(){
        logger.info("start MainPage test clickSingInButtonTest()");
        singInPage = new SingInPage(Driver.getDriver());
        mainPage.clickSingInButton();
        Assert.assertEquals("Вход", singInPage.getHeadingText());
        logger.info("finish MainPage test clickSingInButtonTest()");
    }

    @Test
    public void  clickSingUpButtonTest(){
        logger.info("start MainPage test clickSingUpButtonTest");
        singUpPage = new SingUpPage(Driver.getDriver());
        mainPage.clickSingUpButton();
        Assert.assertEquals("Регистрация", singUpPage.getHeadingText());
        logger.info("finish MainPage test clickSingUpButtonTest");
    }

    @After
    public void tearDown(){
        logger.info("start MainPageTest readDown");
        Driver.close();
        logger.info("finish MainPageTest readDown");
    }
}
