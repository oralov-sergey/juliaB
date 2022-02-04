package pageObject;

import core.CommonActions;
import core.PropertyReader;
import core.TestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.ArrayList;


public class SpotifyPage extends TestBase {

    CommonActions commonActions = new CommonActions();

    public final String LOGIN_BUTTON = "//button[@data-testid='login-button']";
    public final String INNER_BUTTON = "//div[contains(@class,'ButtonInner')]";
    public final String ACCOUNT_BUTTON = "//span[contains(@class,'ellipsis-one-line')]";
    public final String PROFILE_BUTTON = "//div[@class='hOWUEV7wHgfYPPLcnNXt']";
    public final String LOGIN_FIELD = "//input[@id='login-username']";
    public final String PASSWORD_FIELD = "//input[@id='login-password']";

    @Step("Login to Spotify")
    public SpotifyPage loginToSpotify(String correctLogin, String correctPassword) {
        commonActions.getUrl(PropertyReader.baseUrl)
                .clickButton(LOGIN_BUTTON)
                .enterData(LOGIN_FIELD, correctLogin)
                .enterData(PASSWORD_FIELD, correctPassword)
                .clickButton(INNER_BUTTON);
        return this;
    }

    @Step("Go to Spotify profile")
    public SpotifyPage getProfile() {
        commonActions.clickButton(PROFILE_BUTTON)
                .clickButton(ACCOUNT_BUTTON);
        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        return this;
    }

    @Step("Close message")
    public void closeMessage() throws InterruptedException {
        driver.findElement(By.cssSelector(".onetrust-close-btn-ui")).click();
    }
}
