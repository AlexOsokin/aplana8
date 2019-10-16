package autotest.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class DepositsPage extends BasePage{

    @FindBy(xpath = "//label[@class='calculator__currency-field']")
    private List<WebElement> items;

    @FindBy(xpath = "//input[@name='amount']")
    private WebElement amount;

    @FindBy(xpath = "//select[@name='period']")
    private WebElement period;

    @FindBy(xpath = "//input[@name='replenish']")
    private WebElement replenish;

    @FindBy(xpath = "//input[@name='capitalization']/parent::div")
    private WebElement capitalization;

    @FindBy(xpath = "//span[@class='js-calc-rate']")
    private WebElement calcRate;

    @FindBy(xpath = "//span[@class='js-calc-earned']")
    private WebElement calcEarned;

    @FindBy(xpath = "//span[@class='js-calc-replenish']")
    private WebElement calcReplenish;

    @FindBy(xpath = "//span[@class='js-calc-result']")
    private WebElement calcResult;


    public void clickItem(String stringItem){
        for(WebElement item : items){
            waitForElement(item);
            if(item.findElement(By.xpath(".//span/span")).getText().equalsIgnoreCase(stringItem)){
                waitForClickableElement(item);
                item.click();
                return;
            }
        }
        Assert.fail(String.format("Пунк %s не найден", stringItem));
    }

    public void inputAmount(String stringAmount){
        input(stringAmount, amount);
    }
    public void inputReplenish(String stringReplenish){
        input(stringReplenish, replenish);
    }
    public void selectPeriod(String stringPeriod){
        String rate = checkResult();
        WebElement clickParent = period.findElement(By.xpath(".//parent::div"));
        waitForElement(clickParent);
        clickParent.click();
        period.sendKeys(stringPeriod);
        waitInput(rate);
    }
    public void clickCapitalization(){
        String rate = checkResult();
        waitForClickableElement(capitalization);
        capitalization.click();
        waitInput(rate);
    }
    public String checkRate(){//ставка
        waitForElement(calcRate);
        return calcRate.getText();
    }
    public String checkEarned(){//начислено
        waitForElement(calcEarned);
        return calcEarned.getText();
    }
    public String checkReplenish(){//пополнение за 6 месяцев
        waitForElement(calcReplenish);
        return calcReplenish.getText();
    }

    public String checkResult(){//к снятию через 6 месяцев
        waitForElement(calcResult);
        return calcResult.getText();
    }


    private void input(String stringAmount, WebElement element){
        String rate = checkResult();
        waitForElement(element);
        element.click();
        element.sendKeys(stringAmount);
        waitInput(rate);
    }
    private void waitInput(String rate){
        invisibleCalcResult(rate);
        while (true){
            if(rate.equals(checkResult())){
                break;
            }
            rate = checkResult();
        }
    }
    private void invisibleCalcResult(String text){
        wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//span[@class='js-calc-result']"), text));
    }
}
