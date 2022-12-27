package day06_;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_Dropdown {

    WebDriver driver;

    //Eger test classinda birden fazla method olusturulmussa, @Before kullanilir.
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @Test
    public void selectByIndexTest() {

        //1. LOCATE dropdown element
        WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
        //2.SELECT objesi olustur
        Select yearDropdown = new Select(year);
        //3.SELECT objecti kullanarak 3 farkli sekilde secim yapabilirim
        yearDropdown.selectByIndex(22); //SECENEK SIRASI 0'DAN BASLAR. 2000 YILI 23.SIRADA


        //Dogum yilini , ayini, ve gununu su sekilde secer : 2000, January, 10

        //AY SECIMI
        WebElement ay = driver.findElement(By.xpath("//*[@id='month']"));
        Select ayDropdown = new Select(ay);
        ayDropdown.selectByValue("0");//OPTION IN VALUE DEGERI ILE SECIM YAPILABILIR.JANUARY SECENEGININ VALUESI 0


        //GUN SECIMI selectByVisibleTest
        WebElement gun = driver.findElement(By.id("day"));
        Select gunDropdown = new Select(gun);
        gunDropdown.selectByVisibleText("10");//CASE SENSETIVE -

    }

    @Test
    public void printAllTest() {


        //Tum eyalet isimlerini konsola yazdiralim
        WebElement state = driver.findElement(By.xpath("//select[@id='state']"));
        Select stateDropdown = new Select(state);
        List<WebElement> stateList = stateDropdown.getOptions();

        for (WebElement eachState : stateList) {
            System.out.println(eachState.getText());
        }

        //stateList.stream().map(WebElement::getText).forEach(System.out::println);
    }

    @Test
    public void getSelectedOptionTest() {

        //State dropdownindaki varsayilan secili secenegin Select a State oldugunu verify edelim


        WebElement state = driver.findElement(By.xpath("//select[@id='state']"));
        Select stateDropdown = new Select(state);
        String defaultText = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals("Select a State", defaultText);
    }

    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3);
       // driver.close();
    }







    /*
    1)What is dropdown? --> Dropdown nedir?
    Dropdown liste olusturmak icin kullanilir.
    2) How to handle dropdown elements? --> Dropdown nasil automate edilir?
    -dropdown'i locate ederim
    -select objesi olustururum
    -select objesi ile istedigim secenegi secerim
    NOT:select objesi olusturma nedenim dropdownlarin Select classi olusturmasi
    3)Tum dropdown seceneklerini nasil print ederiz?
    -Tum dropdown elementlerini getOptions() methodu ile listeye koyariz sonra
     listeyi loop ile yazdiririz
     4)Bir secenegin secili oldugunu automate etmek icin ne yapilir?
     Ornek: Gun olarak 10u sectik ama ya secilmediyse?
      getFirstSelectedOption() secili olan secenegi return eder
     */
}
