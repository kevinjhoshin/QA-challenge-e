package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class FindTo {

    private WebDriver driver;

    private String peruanosLocator = "//*[text()='Peruanos en el Extranjero']";
    private String consuladosLocator = "#fondo > table > tbody > tr:nth-child(1) > td > table > tbody > tr > td:nth-child(1) > table > tbody > tr:nth-child(2) > td:nth-child(1) > div > h3:nth-child(8) > a";


    private String inputLocator = "//*[@id=\"txtSearch\"]";
    private String lupaLocator = "#ctl00_PlaceHolderMain_g_f7685c60_a054_442d_bbdf_c5b4207b1300_ctl00_divCuerpo > div.rowSearch1 > div.rowSearchTextBox1 > table > tbody > tr > td > a > img";

    public FindTo (WebDriver driver){
        this.driver = driver;
    }

    public void clickPeruanos (){
        driver.findElement(By.xpath(peruanosLocator)).click();
    }
    public void clickconsulados (){
        WebElement consulados = driver.findElement(By.cssSelector(consuladosLocator));
        consulados.click();
    }
    public void writeInput (String textInput){
        driver.findElement(By.xpath(inputLocator)).sendKeys(textInput);
    }
    public void clickLupa (){
        driver.findElement(By.cssSelector(lupaLocator)).click();

    }

}
