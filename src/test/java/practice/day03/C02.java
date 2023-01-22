package practice.day03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02 extends TestBase {
    /*
     -https://jqueryui.com/slider/#colorpicker adrese gidiniz
     -Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız
     -Sarı olduğunu test edelim
     */

    @Test
    public void name () {

        //-https://jqueryui.com/slider/#colorpicker adrese gidiniz
        driver.get("https://jqueryui.com/slider/#colorpicker");

        //-Kutucuk içindeki rengi önce kırmızı sonra sarı yapınız
        WebElement iframe = driver.findElement(By.xpath("//*[@class='demo-frame']"));
        driver.switchTo().frame(iframe);
        WebElement slider = driver.findElement(By.xpath("(//*[@class='ui-slider-handle ui-corner-all ui-state-default'])[2]"));
        WebElement slider1 = driver.findElement(By.xpath("(//*[@class='ui-slider-handle ui-corner-all ui-state-default'])[3]"));
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(slider,-175,0).perform();//Genellikle slider'lar icin bu method kullanilir
        actions.dragAndDropBy(slider1,-80,0);
        actions.dragAndDropBy(slider,301,0).release().build().perform();

        //-Sarı olduğunu test edelim
        WebElement sari = driver.findElement(By.xpath("//*[@class='ui-widget-content ui-corner-all']"));
        Assert.assertTrue(sari.isDisplayed());
    }
}
