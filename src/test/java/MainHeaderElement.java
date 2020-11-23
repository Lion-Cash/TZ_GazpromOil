import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MainHeaderElement {

    public SelenideElement getSearchButton() {
        SelenideElement searchButton = $(By.className("masthead-search-toggle"));
        return searchButton;
    }

    public SelenideElement getSearchTextfield() {
        SelenideElement searchTextfield = $(By.className("masthead-search-field"));
        return searchTextfield;
    }

    public SelenideElement getListenedCounter(){
        SelenideElement listenedCounter = $(By.className("alltime_count"));
        return listenedCounter;
    }

    public SelenideElement getNavButton(String navButtonName) {
        SelenideElement navButton = $(By.xpath("//a[contains(text(),'"+navButtonName+"')]"));
        return navButton;
    }

}
