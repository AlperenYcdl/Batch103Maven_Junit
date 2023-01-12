package practice.day02;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDownload extends TestBase {

    //1. 'https://the-internet.herokuapp.com/download' adresine gidiniz
    //2. some-file.txt dosyasini indirelim
    //3. dosyanin basariyla indirilip indirilmedigini test edelim (dosya downloads'a indirilecektir)


    @Test
    public void test() {

        //1. 'https://the-internet.herokuapp.com/download' adresine gidiniz
        driver.get("https://the-internet.herokuapp.com/download");

        //2. some-file.txt dosyasini indirelim
        driver.findElement(By.xpath("//a[text()='some-file.txt']")).click();

        //3. dosyanin basariyla indirilip indirilmedigini test edelim (dosya downloads'a indirilecektir)
        // C:\Users\vysl\Downloads\some-file.txt

        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "\\Downloads\\some-file.txt";
        String dosyaYolu2 = farkliKisim+ortakKisim;
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu2)));


        //2. yol:
//        String dosyaYolu = "C:\\Users\\vysl\\Downloads\\some-file.txt";
//        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));


    }

}
