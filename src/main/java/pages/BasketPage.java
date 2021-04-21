package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class BasketPage {
    private SelenideElement productQuantity = $("#quantity");
    private SelenideElement addToYourBasketButton = $("#button--add-to-basket");
    private SelenideElement loadingBasketContent = $(".button--loading");
    private SelenideElement addToBasketConfirmationMessage = $(".add-to-basket-form.js-enabled");

    private SelenideElement goToBasketButton = $(".add-to-basket-confirmation-message .add-to-basket-view-basket-link");
    private SelenideElement deleteItemFromBasket = $(".remove-basket-item-form .remove-basket-item-form-button");
    private SelenideElement basketStatus = $(".basket-empty h2");

    public void setProductQuantity(String quantity) {
        productQuantity.setValue(quantity);
    }

    public void addProductToBasket() {
        addToYourBasketButton.click();
        loadingBasketContent.waitUntil(Condition.hidden, 50000);
        addToBasketConfirmationMessage.shouldBe(Condition.visible);
        goToBasketButton.click();
    }

    public void deleteProductFromBasket() {
        deleteItemFromBasket.click();
        basketStatus.shouldHave(Condition.text("Your basket is empty."));
    }
}
