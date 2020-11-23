import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import io.qameta.allure.Step;

public class MainHeaderSteps {
    MainHeaderElement mainHeaderElement = new MainHeaderElement();

    @Description("клик на кнопку")
    @Step
    public void clickNavigationButton(String navButtonName){
        Selenide.executeJavaScript("arguments[0].click();", mainHeaderElement.getNavButton(navButtonName));
    }
    @Step
    public void clickSearchButton() {
        mainHeaderElement.getSearchButton().click();
    }
    @Step
    public void typeInSearchTextfield(String searchText) {
        mainHeaderElement.getSearchTextfield().setValue(searchText);
    }
    @Step
    public void pressEnterOnSearchTextfield() {
        mainHeaderElement.getSearchTextfield().pressEnter();
    }
}
