import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class EventsPage {
    public SelenideElement getDatePickerButton() {
        SelenideElement datePickerButton = $(By.xpath("//*[contains(@aria-controls, 'date-picker')]"));
        return datePickerButton;
    }

    public SelenideElement getDatePickerField() {
        SelenideElement datePickerField = $(By.id("id_from"));
        return datePickerField;
    }
}
