package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private SelenideElement cookieBanner = $("[data-test='cookie-banner']");
    private SelenideElement allowAllButton = $("[data-test='allow-all']");
    private SelenideElement serachProductTextField = $("#mobileSearch");

    public void acceptAllCookies() {
        cookieBanner.shouldBe(visible);
        allowAllButton.click();
        cookieBanner.shouldNotBe(visible);
    }

    public void searchProductByName(String productName) {
        serachProductTextField.sendKeys(productName);
        serachProductTextField.pressEnter();
    }
}
