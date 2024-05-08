package com.lavs.seleniumjava;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws InterruptedException, IOException {

        System.setProperty("webdriver.chrome.driver", "/Users/luisvasquez/Development/java/demo/chromedriver");
        
        WebDriver driver = new ChromeDriver();

        // Maximize window
        driver.manage().window().maximize();

        // Launch the Site.
        driver.get("https://www.lambdatest.com/selenium-playground/simple-form-demo");

        // Enter values into form and submit

        driver.findElement(By.id("sum1")).sendKeys("2");
        driver.findElement(By.id("sum2")).sendKeys("5");
        driver.findElement(By.xpath("//*[@id='gettotal']/button")).click();

        // Verify the result
        String result = driver.findElement(By.xpath("//*[@id=\'addmessage\']")).getText();

        if (Integer.parseInt(result) == 7) {
            System.out.println("Test Success");
        } else {
            System.out.println("Test Failed - " + result);
        }

        // Close the browser
        driver.quit();
    }
}
