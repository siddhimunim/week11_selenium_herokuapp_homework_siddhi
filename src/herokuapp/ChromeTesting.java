package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ChromeTesting {
    //declare main method//
    public static void main(String[] args) {

        String baseUrl = "http://the-internet.herokuapp.com/login";
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //launch URL//
        driver.get(baseUrl);
        //maximize window//
        driver.manage().window().maximize();
        //implicit window//
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //print the title of the page//
        System.out.println("Title of the page : " + driver.getTitle());
        //print the current url //
        System.out.println("Current url : " + driver.getCurrentUrl());
        //print the page source//
        System.out.println("Page source : " + driver.getPageSource());
        //username  to userfield//
      WebElement userField = driver.findElement(By.id("username"));
      userField.sendKeys("tomsmith");
      // password to password field//
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("SuperSecretpassword");
        //close the browser//
        driver.quit();

    }
}
