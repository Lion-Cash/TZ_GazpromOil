import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class SearchPage {
    public SelenideElement getSearchField() {
        SelenideElement searchField = $(By.id("site-search"));
        return searchField;
    }
}
