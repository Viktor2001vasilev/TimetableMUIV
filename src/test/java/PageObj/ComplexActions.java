package PageObj;

import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;

public class ComplexActions {
    //--------------------------------Передача объектов и конструктор для инициализации-------------------------
    private MainPage mainPage;
    private Actions actions;
    public ComplexActions(MainPage mainPage, Actions actions){
        this.mainPage = mainPage;
        this.actions = actions;
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

    public boolean clickGroupTimeTableSettingsDownloadBtn(int numOfElement) {
        System.out.println("Проверка нажатия на " + (numOfElement + 1) + " кнопку из списка \"Настройки\"");
        mainPage.hoverSettingsListBtn(actions);
        mainPage.clickSettingsListElement(numOfElement);
        ArrayList<String> browserTabs = new ArrayList<>(mainPage.getDriver().getWindowHandles());
        mainPage.getDriver().switchTo().window(browserTabs.get(1));
        boolean check;
        check = mainPage.getDriver().getTitle().equals("Sign in - Google Accounts");
        mainPage.getDriver().close();
        mainPage.getDriver().switchTo().window(browserTabs.get(0));
        return check;
    }
    //----------------------------------------------------------------------------------------------------------

}
