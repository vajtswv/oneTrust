package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by ksong on 1/5/2017.
 */
public class Home_Page {

    private static WebElement element = null;

    public static WebElement company(WebDriver driver){

        element = driver.findElement(By.linkText("COMPANY"));

        return element;

    }

    public static WebElement career(WebDriver driver){

        element = driver.findElement(By.linkText("Careers"));

        return element;

    }

    public static List<WebElement> cities(WebDriver driver){

        //get all cities
        List<WebElement> allcity = driver.findElements(By.xpath("/html/body/section[2]/div/div/ul"));

        return (List<WebElement>) allcity;

    }
}
