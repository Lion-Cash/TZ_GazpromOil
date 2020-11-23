import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    public SelenideElement getMediatest() {
        SelenideElement mediatest = $(By.xpath("/html/body/span/span[4]"));
        return mediatest;
    }
}
