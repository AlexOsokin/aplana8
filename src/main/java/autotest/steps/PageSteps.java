package autotest.steps;

import autotest.pages.DepositsPage;
import autotest.pages.MainPage;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import org.junit.Assert;

public class PageSteps {

    DepositsPage depositsPage = new DepositsPage();

    @Когда("Кликаем на пункт меню: \"(.*)\"")
    public void clickItemMenuStep(String item){
        MainPage mainPage = new MainPage();
        mainPage.clickItem(item);
    }
    @Тогда("Кликаем на пункт вкладку: \"(.*)\"")
    public void clickItemStep(String item){
        depositsPage.clickItem(item);
    }
    @Когда("Вводим сумму вклада: \"(.*)\"")
    public void inputAmountStep(String item){
        depositsPage.inputAmount(item);
    }
    @Когда("Вводим срок: \"(.*)\"")
    public void selectPeriodStep(String item){
        depositsPage.selectPeriod(item);
    }
    @Когда("Вводим ежемесячное пополнение: \"(.*)\"")
    public void inputReplenishStep(String item){
        depositsPage.inputReplenish(item);
    }
    @Когда("Выбрать \"ежемесячная капитализация\"")
    public void clickCapitalizationStep(){
        depositsPage.clickCapitalization();
    }
    @Тогда("Проверка ставки: \"(.*)\"")
    public void checkRateStep(String itemString){
        String item = depositsPage.checkRate();
        System.out.println("Проверка ставки: " + item);
        check(item, itemString);
    }
    @Тогда("Проверка сколько начислено: \"(.*)\"")
    public void checkEarnedStep(String itemString){
        String item = depositsPage.checkEarned();
        System.out.println("Проверка сколько начислено: " + item);
        check(item, itemString);
    }
    @Тогда("Проверка пополнения за 6 месяцев: \"(.*)\"")
    public void checkReplenishStep(String itemString){
        String item = depositsPage.checkReplenish();
        System.out.println("Проверка пополнения за 6 месяцев: " + item);
        check(item, itemString);
    }
    @Тогда("Проверка суммы к снятию через 6 месяцев: \"(.*)\"")
    public void checkResultStep(String itemString){
        String item = depositsPage.checkResult();
        System.out.println("Проверка суммы к снятию через 6 месяцев: " + item);
        check(item, itemString);
    }
    private void check(String item, String stringItem){
        if(item.equals(stringItem)){
            System.out.println("Значение верно");
        }
        else{
            Assert.fail(String.format("Значение на странице не правильно: %s", stringItem));
        }
    }

}
