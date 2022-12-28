import PageObject.FindTo;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.sql.SQLOutput;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class NavigationToReniec {

    private  WebDriver driver;
    @BeforeEach
    public void beforeReniec (){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.reniec.gob.pe/portal/masServiciosLinea.htm");
    }

    @AfterEach
    public void afterReniec () throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void navigationCuenca (){

        FindTo findTo = new FindTo(driver);
        findTo.clickPeruanos();
        findTo.clickconsulados();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5L));

        String mainTab = driver.getWindowHandle();
        String newTam = "";

        System.out.println("Main tab" + mainTab);

        driver.findElement(By.cssSelector("#fondo > table > tbody > tr:nth-child(1) > td > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(2) > td:nth-child(1) > div > ul:nth-child(9) > li > a")).click();

        Set<String> handles = driver.getWindowHandles();

        for (String actual : handles){
            System.out.println("-- Handled ID: " + actual);
            if (!actual.equalsIgnoreCase(mainTab)){
                System.out.println(" -- Changing Tab ---");
                driver.switchTo().window(actual);
                newTam = actual;
            }
        }
        findTo.writeInput("Cuenca");
        findTo.clickLupa();

    }




}
