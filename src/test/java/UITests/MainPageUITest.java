package UITests;

import PageObj.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class MainPageUITest {
    private WebDriver MainPageUITestDriver;


    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("http://f0591005.xsph.ru/mainT.html");
        driver.manage().window().maximize();
        this.MainPageUITestDriver = driver;
    }
    @AfterTest
    public void close() {
        MainPageUITestDriver.close();
    }

    @Test
    public void mainPageUITest() {
        MainPage mainPage = PageFactory.initElements(MainPageUITestDriver, MainPage.class);
        Actions actions = new Actions(MainPageUITestDriver);
        mainPage.hoverGroupListBtn(actions);
        mainPage.pressGroupListElement(0);
        Assert.assertFalse(mainPage.checkVisibilityOfTimeTablePicture(0));
        Assert.assertTrue(mainPage.checkVisibilityOfTimeTablePicture(1));
    }
}
