import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pages.BasketPage;
import pages.MainPage;
import pages.SearchResultPage;

import static com.codeborne.selenide.Selenide.open;

public class Tests {

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        open("https://www.johnlewis.com/");
    }

    @Test
    public void addAndRemoveProductFromBasket() {
        String expectedProduct = "John Lewis & Partners Synthetic Soft Like Down Standard Pillow, Soft/Medium/Firm";
        MainPage mainPage = new MainPage();
        mainPage.acceptAllCookies();
        mainPage.searchProductByName(expectedProduct);

        SearchResultPage searchResultPage = new SearchResultPage();
        searchResultPage.checkIfExpectedProductExist(expectedProduct);
        searchResultPage.openFirstProductFromResults();

        BasketPage basketPage = new BasketPage();
        basketPage.setProductQuantity("20");
        basketPage.addProductToBasket();
        basketPage.deleteProductFromBasket();
    }

    @After
    public void tearDown() {
        Selenide.clearBrowserCookies();
        Selenide.closeWebDriver();
    }
}
