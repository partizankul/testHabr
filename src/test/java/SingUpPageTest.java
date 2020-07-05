import Utilites.Driver;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SingUpPageTest {
    private SingUpPage singUpPage;
    private Logger logger;

    @Before
    public void setUp(){
        logger = Logger.getLogger("new Logger");
        Driver.getDriver().get("https://account.habr.com/register/");
        singUpPage = new SingUpPage(Driver.getDriver());
    }
    @Test
    public void regAccTest(){
        singUpPage.regAkk("test@test.com", "test", "test", "test");
    }

    /*@After
    public void tearDown(){
        logger.info("start SingUpTest test readDown");
        Driver.getDriver().quit();
        logger.info("finish SingUpTest test readDown");
    }*/
}
