import Utilites.Driver;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SingInTest {
    private SingInPage singInPage;
    private Logger logger;

    @Before
    public void setUp(){
        logger = Logger.getLogger("new Logger");
        Driver.getDriver().get("https://account.habr.com/login/");
        singInPage = new SingInPage(Driver.getDriver());
    }

    @Test
    public void getHeadingTest(){
        logger.info("start SingInTest test getHeadinhTest");
        Assert.assertEquals("Вход", singInPage.getHeadingText());
        logger.info("finish SingInTest test getHeadinhTest");
    }
    @Test
    public void getMailAndPassErrorTest(){
        logger.info("start SingInTest test getMailAndPassErrorTest");
        singInPage.singInArr("", "");
        Assert.assertEquals("Введите корректный e-mail", singInPage.getMailError());
        Assert.assertEquals("Введите пароль", singInPage.getPassError());
        logger.info("finish SingInTest test getMailAndPassErrorTest");
    }

    @Test
    public void getMailErrorTest(){
        logger.info("start SingInTest test getMailErrorTest");
        singInPage.singInArr("", "");
        Assert.assertEquals("Введите корректный e-mail", singInPage.getMailError());
        logger.info("finish SingInTest test getMailErrorTest");
    }
    @Test
    public void getPassErrorTest(){
        logger.info("start SingInTest test getMailErrorTest");
        singInPage.singInArr("test@gmail.com", "");
        Assert.assertEquals("Введите пароль", singInPage.getPassError());
        logger.info("finish SingInTest test getMailErrorTest");
    }
    @Test
    public void getRegTest(){
        logger.info("start SingInTest test getRegTest");
        singInPage.singInArr("Test@gmail.com", "test");
        logger.info("finish SingInTest test getRegTest");
    }


    @After
    public void tearDown(){
        logger.info("start SingInTest test readDown");
        Driver.getDriver().quit();
        logger.info("finish SingInTest test readDown");
    }

}
