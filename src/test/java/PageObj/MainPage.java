package PageObj;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;

public class MainPage {
    //--------------------------------Объявление драйвера и конструктор для инициализации-----------------------
    private WebDriver driver;
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    //----------------------------------------------------------------------------------------------------------

    //---------------------------------------------------Элементы-----------------------------------------------
    @FindBy (xpath = "//button[text()='Список групп']")
    private WebElement groupListBtn;

    @FindBys( { @FindBy (xpath = "//div[@class='dropdown-con']//button") } )
    private List <WebElement> groupList;

    @FindBys( { @FindBy (xpath = "//table//td//div") } )
    private List <WebElement> timeTablePictureList;
    //----------------------------------------------------------------------------------------------------------

    //---------------------------------------------------действия-----------------------------------------------
    public WebElement getGroupListBtn() {
        return groupListBtn;
    }
    public List<WebElement> getGroupList() {
        return groupList;
    }
    public List<WebElement> getTimeTablePictureList() {
        return timeTablePictureList;
    }
    public void hoverGroupListBtn(Actions actions) {
        actions.moveToElement(groupListBtn).perform();
    }
    public void pressGroupListElement(int numOfElement) {
        groupList.get(numOfElement).click();
    }
    public boolean checkVisibilityOfTimeTablePicture(int numOfElement) {
        return timeTablePictureList.get(numOfElement).isDisplayed();
    }
    //----------------------------------------------------------------------------------------------------------
}
