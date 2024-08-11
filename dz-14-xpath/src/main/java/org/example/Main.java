package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup(); // This line will set up the ChromeDriver automatically.
        WebDriver driver = new ChromeDriver();

        driver.get("https://example.com");
        System.out.println("Page title is: " + driver.getTitle());

        driver.quit();
    }
}
