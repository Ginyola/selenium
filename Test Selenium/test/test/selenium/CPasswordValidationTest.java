/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.selenium;

import org.junit.*;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Поправить чек-лист. Подсказка с планшетом
 * @author Костя
 */
public class CPasswordValidationTest extends CWebDriver{
    
    private static WebDriver driver = null;
    
    @BeforeClass
    public static void PrepareTestEnviroment()
    {
        CPasswordValidationTest context = new CPasswordValidationTest();
        
        driver = new ChromeDriver();
        driver.get("https://id.rambler.ru/account/registration");
    }
    
    @Test
    public void PasswordValidate()
    {
        WebElement testingElement = driver.findElement(By.id("newPassword"));
        testingElement.clear();
        testingElement.sendKeys("Selenium");
         
        WebElement checkedElement = driver.findElement(By.xpath("//input[@id='newPassword']/.."));
         
        System.out.print(checkedElement.getAttribute("outerHTML")); 
        assertTrue(checkedElement.getAttribute("class").contains("rui-Input-error"));
    }
    
    @Test
    public void PasswordValidate_1()
    {
        WebElement testingElement = driver.findElement(By.id("newPassword"));
        testingElement.clear();
        testingElement.sendKeys("Selenium");
         
        WebElement checkedElement = driver.findElement(By.xpath("//input[@id='newPassword']/.."));
         
        System.out.print(checkedElement.getAttribute("outerHTML")); 
        assertFalse(checkedElement.getAttribute("class").contains("rui-Input-error"));

    }
    
    
    @AfterClass
    public static void CloseTestEnviroment()
    {
        driver.close();
    }
}
