package day11;

import com.beust.ah.A;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions5 extends TestBase {
    @Test
    public void keyboardActionsTest() {
//
//        Google a gidin https://www.google.com
        driver.get("https://www.google.com");

//      ‘iPhone X fiyatlari’ yazdir (SHIFT TUSUNA BASILARAK)
//      ‘ cok pahali!’ Yazdır (SHIFT TUSUNA BASILMAYARAK)
//        Ve ENTER tusuna bas
        WebElement aramaKutusu = driver.findElement(By.name("q"));
//        aramaKutusu.sendKeys("IPHONE X FIYATLARI" + Keys.ENTER);  Hard coging oluyor bu sekilde.
        Actions actions = new Actions(driver);
        actions
                .keyDown(aramaKutusu, Keys.SHIFT)//arama kutusunun ustunde Shist tusuna bas
                .sendKeys("iPhone X fiyatlari")//shifte basiliyken yazi yaz
                .keyUp(aramaKutusu, Keys.SHIFT)//shift de artik basma
                .sendKeys("  cok pahali!" + Keys.ENTER)//normal halde yaz ve Enter tusuna bas
                .build()// birden fazla actions methodu kullanildiginda build() kullanilmasi onerilir
                .perform();
    }




    /*
    Interview olasi sorulari;

   ------ Actions nedir? Actions Class nedir?

    Actions selenium dan gelen bir kütüphanderi. Mouse ve Keyboard islemlerini gerceklestirmek icin kullandigimiz hazir bir selenium kütüphanesidir.
    Ornegin , sag tiklamak , cift tiklamak(contextClick), cift tiklama elementin üzerine gitme gibi mouse islemlerini gerceklestirebiliriz.
    Ayni zamanda shift control delete enter gibi keyboard tuslatinada actions yardimiyla basabiliriz. Bu tür islemlerde sendKeys methodu kullanilir.


   ------ Ne tur Methodlar kullandin?
   Actions methotlari onemlidir. ve tekrar tekrar kullanmam gerektiginden Actions methodlarini iceren Reuable methodlarini olusturdum.
   Ve gerektiginde bu Resuable(tekrar kullanilabilir) methodlarini kullaniyorum.
   Ornegin; rigtClick methodum bir elemente sag tiklamak icin test classimda cagirabilirim.

  ------- Hangi methodlari kullandin ne ise yarar?
   Ornegin , sag tiklamak , cift tiklamak(contextClick), cift tiklama elementin üzerine gitme gibi mouse islemlerini gerceklestirebiliriz.
    Ayni zamanda shift control delete enter gibi keyboard tuslatinada actions yardimiyla basabiliriz. Bu tür islemlerde sendKeys methodu kullanilir.



     */
}
