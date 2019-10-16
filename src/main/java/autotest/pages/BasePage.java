package autotest.pages;

import autotest.util.Init;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    public BasePage(){
        this.driver = Init.getDriver();
        PageFactory.initElements(driver, this);//Драйвер не начинает искать элементы на странице сразу же, а ищет их как только мы обращаемся к полю класса
        wait = new WebDriverWait(driver, 5);
    }

    public WebElement waitForElement(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForClickableElement(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
