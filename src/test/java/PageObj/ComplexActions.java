package PageObj;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class ComplexActions {
    //--------------------------------Передача объектов и конструктор для инициализации-------------------------
    private MainPage mainPage;
    private Actions actions;
    private WebDriverWait webDriverWait;
    public ComplexActions(MainPage mainPage, Actions actions, WebDriverWait webDriverWait){
        this.mainPage = mainPage;
        this.actions = actions;
        this.webDriverWait = webDriverWait;
    }
    //----------------------------------------------------------------------------------------------------------

    //--------------------------------------комплексные действия с элементами-----------------------------------
    public boolean hideGroupTimeTable(int numOfElement) { // проверка нажатия на кнопку из выпадающего списка "Список групп"
        System.out.println("Проверка нажатия на " + (numOfElement + 1) + " кнопку из списка \"Список групп\"");
        mainPage.hoverGroupListBtn(actions);
        mainPage.clickGroupListElement(numOfElement);
        switch (numOfElement) {
            case 0:
                return (!mainPage.checkVisibilityOfTimeTablePicture(0) & mainPage.checkVisibilityOfTimeTablePicture(1));
            case 1:
                return (mainPage.checkVisibilityOfTimeTablePicture(0) & !mainPage.checkVisibilityOfTimeTablePicture(1));
            case 2:
                return (!mainPage.checkVisibilityOfTimeTablePicture(0) & !mainPage.checkVisibilityOfTimeTablePicture(1));
            default:
                System.out.println("Данного элемента не существует");
                return false;
        }
    }

    public boolean clickGroupTimeTableSettingsDownloadBtn(int numOfElement) { // проверка нажатия на кнопку из выпадающего списка "Настройки"
        System.out.println("Проверка нажатия на " + (numOfElement + 1) + " кнопку из списка \"Настройки\"");
        mainPage.hoverSettingsListBtn(actions);
        mainPage.clickSettingsListElement(numOfElement);
        ArrayList<String> browserTabs = new ArrayList<>(mainPage.getDriver().getWindowHandles());
        mainPage.getDriver().switchTo().window(browserTabs.get(1));
        boolean check;
        webDriverWait.until(ExpectedConditions.titleIs("Imgur: The magic of the Internet"));
        check = mainPage.getDriver().getTitle().equals("Imgur: The magic of the Internet");
        mainPage.getDriver().close();
        mainPage.getDriver().switchTo().window(browserTabs.get(0));
        return check;
    }

    public boolean clickOtherShareBtn() { // проверка нажатия на кнопку "Поделиться" из выпадающего списка "Прочее"
        System.out.println("Проверка нажатия на кнопку \"Поделиться\" из списка \"Прочее\"");
        mainPage.hoverOtherBtn(actions);
        mainPage.clickOtherListElement(0);
        ArrayList<String> browserTabs = new ArrayList<>(mainPage.getDriver().getWindowHandles());
        mainPage.getDriver().switchTo().window(browserTabs.get(1));
        boolean check;
        webDriverWait.until(ExpectedConditions.titleIs("Imgur: The magic of the Internet"));
        check = mainPage.getDriver().getTitle().equals("Imgur: The magic of the Internet");
        mainPage.getDriver().close();
        mainPage.getDriver().switchTo().window(browserTabs.get(0));
        return check;
    }
    //----------------------------------------------------------------------------------------------------------

}
