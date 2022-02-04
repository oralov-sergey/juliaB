package test;

import core.PropertyReader;
import core.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class SpotifyTest extends TestBase {

    public final String MESSAGE = "//div[contains(@class,'Wrapper-sc')]";

    @Test
    public void loginToSpotifyAndChangingPassword() {

        spotifyPage.loginToSpotify(PropertyReader.login, PropertyReader.password)
                .getProfile();
        try {
            spotifyPage.closeMessage();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        accountPage.changePassword(PropertyReader.password, accountPage.NEW_PASSWORD);

        // на этотм месте скрипт выполнить дальше невозможно, так как бага при смене пароля.

        accountPage.exit();
        spotifyPage.loginToSpotify("", PropertyReader.password);

        Assert.assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(MESSAGE))).isDisplayed());

        spotifyPage.loginToSpotify("", accountPage.NEW_PASSWORD);
        accountPage.changePassword(accountPage.NEW_PASSWORD, PropertyReader.password);
    }
}
