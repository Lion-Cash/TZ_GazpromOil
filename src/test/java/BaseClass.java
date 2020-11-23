import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BaseClass {
    public static void settingsSetup(){
        try (InputStream input = new FileInputStream("src/test/resources/config.properties")) {

            Properties prop = new Properties();
            prop.load(input);
            Configuration.headless = Boolean.valueOf(prop.getProperty("headless"));
            Configuration.browserSize = prop.getProperty("browserSize");
            SelenideLogger.addListener("AllureSelenide", new AllureSelenide().screenshots(true).savePageSource(false));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
