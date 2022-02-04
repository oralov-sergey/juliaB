package core;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.AccountPage;
import pageObject.SpotifyPage;

public class TestBase {

    private static final int TIME_OUT_IN_SECONDS = 20;
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    public SpotifyPage spotifyPage;
    public PropertyReader propertyReader;
    public AccountPage accountPage;

    @Before
    public void startWebDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, TIME_OUT_IN_SECONDS);
        spotifyPage = new SpotifyPage();
        propertyReader = new PropertyReader();
        accountPage = new AccountPage();
    }

    @After
    public void quiteDriver() {
        driver.quit();
    }
}

