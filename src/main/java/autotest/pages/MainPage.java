package autotest.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePage{

    @FindBy(xpath = "//div[@class ='service']/div[@class ='service__title']")
    private List<WebElement> items;

    public void clickItem(String stringItem){
        for(WebElement item : items){
            waitForElement(item);
            if(item.findElement(By.xpath(".//div[@class='service__title-text']")).getText().equalsIgnoreCase(stringItem)){
                waitForClickableElement(item);
                item.click();
                return;
            }
        }
        Assert.fail(String.format("Пунк %s не найден", stringItem));
    }
}
