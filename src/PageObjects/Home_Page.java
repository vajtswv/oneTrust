package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

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

}

