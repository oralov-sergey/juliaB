package core;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CommonActions extends TestBase {

    public CommonActions getUrl(String url) {
        driver.get(url);
        return this;
    }

    public CommonActions enterData(String xpath, String data) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).sendKeys(data);
        return this;
    }

    public CommonActions clickButton(String xpath) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).click();
        return this;
    }
}
