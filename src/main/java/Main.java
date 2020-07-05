import Utilites.Driver;
import org.apache.log4j.Logger;

public class Main {
    public static void main(String[] args) {
        Driver.getDriver().get("https://habr.com/ru/");
        Logger logger = Logger.getLogger("new logger");

        MainPage mainPage = new MainPage(Driver.getDriver());

        mainPage.clickSingUpButton();

    }

}
