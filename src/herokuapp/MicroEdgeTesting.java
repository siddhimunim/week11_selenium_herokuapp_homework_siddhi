package herokuapp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class MicroEdgeTesting {
    //declare new method//
    public static void main(String[] args) {
        String baseUrl = "http://the-internet.herokuapp.com/login";
        System.setProperty("webdriver.msedge.driver","drivers/msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        //launch url //
        driver.get(baseUrl);
        //maximise window//
        driver.manage().window().maximize();
        //implicit time//
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        // title of the page //
        System.out.println("Title of the page : " + driver.getTitle());
        //current Url //
        System.out.println("Current url : " + driver.getCurrentUrl());
        //page source//
        System.out.println("page source : " + driver.getPageSource());
        //username into userfield//
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("tomsmith");
        //password into password field//
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("SuperSecretPassword");
        //close browser//
        driver.quit();

    }
}
