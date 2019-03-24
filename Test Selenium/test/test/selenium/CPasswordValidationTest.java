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
    public void InputValidPassword()
    {
        boolean testIsFailed = false;
        System.out.print("Testing valid passwords...\n");
        for(String input : data.inputValidData)
        {                 
            testingElement.click();
            testingElement.clear();
            testingElement.sendKeys(input);
            
            checkedElement = driver.findElement(By.xpath(data.checkingClassXpathString));
            if(checkedElement.getAttribute(data.checkingAttribute).contains(data.checkingClassString))
            {
                testIsFailed = true;
                System.out.print("Error: " + testingElement.getAttribute("value")+ "\n");
            }
            
            testingElement.click();
            testingElement.clear();           
        }
        
        assertFalse(testIsFailed);
    }
    
    @Test
    public void InputInvalidPassword()
    {
        boolean testIsFailed = false;
        System.out.print("Testing Invalid passwords...\n");
        for(String input : data.inputInvalidData)
        {                 
            testingElement.click();
            testingElement.clear();
            testingElement.sendKeys(input);
            
            checkedElement = driver.findElement(By.xpath(data.checkingClassXpathString));
            if(!checkedElement.getAttribute(data.checkingAttribute).contains(data.checkingClassString))
            {
                testIsFailed = true;
                System.out.print("Error: " + testingElement.getAttribute("value")+ "\n");
            }
            
            testingElement.click();
            testingElement.clear();           
        }
        
        assertFalse(testIsFailed);
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
