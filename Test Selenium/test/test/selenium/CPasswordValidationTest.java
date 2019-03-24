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
    private static WebElement testingElement = null;
    private static WebElement checkedElement = null;
    private static final CInputData data = new CInputData();
    
    @BeforeClass
    public static void PrepareTestEnviroment()
    {
        CPasswordValidationTest context = new CPasswordValidationTest();
        
        driver = new ChromeDriver();
        driver.get(data.testingURL);
        
        testingElement = driver.findElement(By.id(data.testingIdString));
    }
    
    @Test
    public void InputValidPassword() throws InterruptedException
    {
        System.out.print("Testing valid passwords:\n");
        for(String input : data.inputData)
        {
           
            testingElement.sendKeys(input);
            System.out.print("\t" + input + "\n");
            checkedElement = driver.findElement(By.xpath(data.checkingClassXpathString));
            assertFalse(input,checkedElement.getAttribute(data.checkingAttribute).contains(data.checkingClassString));
            
            testingElement.clear();
        }
    }
    
    @Test
    public void InputInvalidPassword()
    {
        testingElement.sendKeys(" ");
        checkedElement = driver.findElement(By.xpath(data.checkingClassXpathString));
        assertTrue(checkedElement.getAttribute(data.checkingAttribute).contains(data.checkingClassString));
    }
    
    
    @Test
    public void InputEmptyString()
    {   
        testingElement.sendKeys(" ");
        testingElement.clear();
         
        checkedElement = driver.findElement(By.xpath(data.checkingClassXpathString));   
        assertTrue(checkedElement.getAttribute(data.checkingAttribute).contains(data.checkingClassString));
    }
    
    @After
    public void CleanAfterTest()
    {
        testingElement.clear();
    }
    
    @AfterClass
    public static void CloseTestEnviroment()
    {
        driver.close();
    }
}
