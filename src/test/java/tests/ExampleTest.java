package tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExampleTest {

    private static WebDriver driver;

    @BeforeAll
    static void setUp() {
        driver = new ChromeDriver();
    }

    @Test
    void testGoogleTitle() {
        driver.get("https://www.google.com");

        String title = driver.getTitle();

        System.out.println("Page Title: " + title);

        assertTrue(title.toLowerCase().contains("google"));
    }

    @Test
    void testGoogleSearch() {
        driver.get("https://www.google.com");

        driver.findElement(By.name("q"))
                .sendKeys("Jenkins");

        driver.findElement(By.name("btnK"))
                .click();

        String title = driver.getTitle();

        System.out.println("Search Page Title: " + title);

        assertTrue(title.toLowerCase().contains("jenkins"));
    }

    @AfterAll
    static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}