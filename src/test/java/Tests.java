import com.codeborne.selenide.Selenide;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selenide.open;

public class Tests {

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        open("https://www.johnlewis.com/");
    }

    @Test
    public void addAndRemoveProductFromBasket() {

    }

    @After
    public void tearDown() {
        Selenide.clearBrowserCookies();
        Selenide.closeWebDriver();
    }
}
