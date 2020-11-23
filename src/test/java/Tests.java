import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Description;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.assertj.core.api.Assertions.assertThat;

public class Tests {
    MainHeaderSteps mainHeaderSteps = new MainHeaderSteps();
    EventsPageSteps eventsPageSteps = new EventsPageSteps();
    MainHeaderElement mainHeaderElement = new MainHeaderElement();
    MainPage mainPage = new MainPage();
    SearchPage searchPage = new SearchPage();
    EventsPage eventsPage = new EventsPage();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDateTime now = LocalDateTime.now();
    String strDate = dtf.format(now);

    @BeforeEach
    public void testSetup(){
        BaseClass.settingsSetup();
        Selenide.open("https://www.last.fm/");
    }
    @Description("Проверяем счетчик прослушанных песен крутится")
    @Test
    public void alltimeListenedCounterRolling(){
        mainHeaderSteps.clickNavigationButton("Live");
        Selenide.sleep(1000);
        mainHeaderElement.getListenedCounter().lastChild().scrollTo();
        mainHeaderElement.getListenedCounter().lastChild().waitUntil(Condition.attributeMatching("class", ".*done.*"), 5000);
    }
    @Description("Проверяем соответствие текста в поисковых полях")
    @ParameterizedTest
    @CsvFileSource(resources = "/values.csv")
    public void searchFieldTests(String searchtext){
        mainHeaderSteps.clickSearchButton();
        mainHeaderSteps.typeInSearchTextfield(searchtext);
        mainHeaderSteps.pressEnterOnSearchTextfield();
        assertThat(searchPage.getSearchField().getAttribute("value")).isEqualTo(searchtext);
    }
    @Description("Проверяем соответствие даты по умолчанию сегодняшней")
    @Test
    public void currentDateInDatePickerIsCorrect(){
        mainHeaderSteps.clickNavigationButton("Events");
        eventsPageSteps.clickDatePickerButton();
        assertThat(eventsPage.getDatePickerField().getAttribute("value")).isEqualTo(strDate);
    }
    @AfterEach
    public void tearUp(){
        Selenide.closeWebDriver();
    }
}
