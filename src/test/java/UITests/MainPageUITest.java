package UITests;

import PageObj.ComplexActions;
import PageObj.MainPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;

public class MainPageUITest {
    private WebDriver mainPageUITestDriver;
    private WebDriverWait webDriverWait;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("http://f0591005.xsph.ru/mainT.html");
        driver.manage().window().maximize();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.mainPageUITestDriver = driver;
        this.webDriverWait = webDriverWait;
    }
    @AfterClass
    public void close() {
        mainPageUITestDriver.close();
    }

    @Test
    public void mainPageUITest() {
        MainPage mainPage = PageFactory.initElements(mainPageUITestDriver, MainPage.class);
        Actions actions = new Actions(mainPageUITestDriver);
        ComplexActions complexActions = new ComplexActions(mainPage, actions, webDriverWait);

        // проверка нажатия на кнопку "Скрыть группу" 1
        Assert.assertTrue(complexActions.hideGroupTimeTable(0));
        mainPage.clickGroupListElement(0); //возврат к первоначальному состоянию
        // проверка нажатия на кнопку "Скрыть группу" 2
        Assert.assertTrue(complexActions.hideGroupTimeTable(1));
        mainPage.clickGroupListElement(1); //возврат к первоначальному состоянию
        // проверка нажатия на кнопку "Скрыть обе группы"
        Assert.assertTrue(complexActions.hideGroupTimeTable(2));
        mainPage.clickGroupListElement(2); //возврат к первоначальному состоянию

        // проверка нажатия на кнопку "Настройки" -> "Скачать группа.." 1
        Assert.assertTrue(complexActions.clickGroupTimeTableSettingsDownloadBtn(0));
        // проверка нажатия на кнопку "Настройки" -> "Скачать группа.." 2
        Assert.assertTrue(complexActions.clickGroupTimeTableSettingsDownloadBtn(1));

        // проверка нажатия нна кнопку "Прочее" -> "Поделиться"
        Assert.assertTrue(complexActions.clickOtherShareBtn());
    }
}
