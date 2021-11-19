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
    public WebDriver getDriver() {
        return driver;
    }
    //----------------------------------------------------------------------------------------------------------

    //---------------------------------------------------Элементы-----------------------------------------------
    @FindBy (xpath = "//button[text()='Список групп']")
    private WebElement groupListBtn;

    @FindBys( { @FindBy (xpath = "//div[@class='dropdown-con']//button") } )
    private List <WebElement> groupList;

    @FindBys( { @FindBy (xpath = "//table//td//div") } )
    private List <WebElement> timeTablePictureList;

    @FindBy (xpath = "//button[text () = 'Настройки']")
    private WebElement settingsListBtn;

    @FindBys ( { @FindBy (xpath = "//div[@class='dropdown-con2']//a") } )
    private List<WebElement> settingsList;

    @FindBy (xpath = "//button[text() = 'Прочее']")
    private WebElement otherBtn;

    @FindBys ( { @FindBy (xpath = "//div[@class = 'dropdown-con3']//a") } )
    private List<WebElement> otherList;
    //----------------------------------------------------------------------------------------------------------

    //------------------------------------------простые действия с элементами-----------------------------------
    public WebElement getGroupListBtn() {
        return groupListBtn;
    }
    public List<WebElement> getGroupList() {
        return groupList;
    }
    public List<WebElement> getTimeTablePictureList() {
        return timeTablePictureList;
    }
    public List<WebElement> getSettingsList() {
        return settingsList;
    }
    public WebElement getSettingsListBtn() {
        return settingsListBtn;
    }
    public WebElement getOtherBtn() {
        return otherBtn;
    }
    public List<WebElement> getOtherList() {
        return otherList;
    }
    public void hoverGroupListBtn(Actions actions) { // установить фокус на кнопку "список групп"
        actions.moveToElement(groupListBtn).perform();
    }
    public void clickGroupListElement(int numOfElement) { // нажать на выбранную кнопку из выпадающего списка "список групп"
        groupList.get(numOfElement).click();
    }
    public boolean checkVisibilityOfTimeTablePicture(int numOfElement) { // проверка отображения изображения с расписанием
        return timeTablePictureList.get(numOfElement).isDisplayed();
    }
    public void hoverSettingsListBtn(Actions actions) {
        actions.moveToElement(settingsListBtn).perform();
    }
    public void clickSettingsListElement(int numOfElement) {
        settingsList.get(numOfElement).click();
    }
    public void hoverOtherBtn(Actions actions) {
        actions.moveToElement(otherBtn).perform();
    }
    public void clickOtherListElement(int numOfElement) {
        otherList.get(numOfElement).click();
    }
    //----------------------------------------------------------------------------------------------------------
}
