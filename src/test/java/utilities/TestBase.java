package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestBase {
    // TestBase i abstract yapmamizin sebebi bu sinifin objesini olusturmak istemiyorum
    // TestBase testbase = new TestBase(); -> Yapilamaz
    // Amacim bu sinifi extend etmek ve icindeki hazir methodlari kullanmak.


    //1- driver objesini olustur. Driver ya public ya da protected olmali.
    // Sebebi; child classlarda gorulebilir olmasi
    protected static WebDriver driver;

    //2- setUp
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


    }

    @After
    public void tearDown(){
        driver.quit();
    }

}
