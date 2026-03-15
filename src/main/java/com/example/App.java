package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import java.time.Duration;

public class App {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://automationexercise.com/products");

        driver.manage().window().maximize();

        // Hover over product
        WebElement product = driver.findElement(By.xpath("(//div[@class='product-image-wrapper'])[4]"));

        Actions actions = new Actions(driver);
        actions.moveToElement(product).perform();

        // Hover and click Add to Cart
        WebElement addToCart = driver.findElement(By.xpath("(//a[@data-product-id='4'])[1]"));
        actions.moveToElement(addToCart).click().perform();

        // Click Continue Shopping
        driver.findElement(By.xpath("//button[text()='Continue Shopping']")).click();

        Thread.sleep(2000);

        driver.quit();
    }
}
