package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SearchResultPage {
    private SelenideElement searchResultInformation = $("[data-test='heading-term']");
    private SelenideElement searchResultSection = $("[data-test='component-grid-row']");
    private ElementsCollection findingElements = $$("[data-test='product-card']");

    public void checkIfExpectedProductExist(String expectedText) {
        searchResultInformation.shouldHave(Condition.text(expectedText));
    }

    public void openFirstProductFromResults() {
        searchResultSection.shouldBe(Condition.visible);
        findingElements.get(0).click();
    }
}
