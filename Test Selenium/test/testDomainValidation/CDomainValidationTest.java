/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testDomainValidation;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


/**
 *
 * @author Костя
 */
public class CDomainValidationTest extends CWebDriver
{
    private static WebDriver driver = null;
    private static WebElement testingElement = null;
    private static WebElement checkedElement = null;
    private static final CInputDataDomain data = new CInputDataDomain();
    private int secondsOfSleep = 600;
    
    @BeforeClass
    public static void PrepareTestEnviroment()
    {
        CDomainValidationTest context = new CDomainValidationTest();
        
        driver = new ChromeDriver();
        driver.get(data.testingURL);
        
        testingElement = driver.findElement(By.id(data.testingIdString));
    }
    
    @Test
    public void InputValidDomain() throws InterruptedException
    {
        boolean testIsFailed = false;
        System.out.print("Testing valid mail login...\n");
        for(String input : data.inputValidDomainData)
        {                 
            testingElement.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            testingElement.sendKeys(Keys.BACK_SPACE);
            testingElement.sendKeys(input);
            testingElement.sendKeys(Keys.TAB);
            Thread.sleep(secondsOfSleep);

            checkedElement = driver.findElement(By.xpath(data.checkingClassDomainXpathString));
            if(checkedElement.getAttribute(data.checkingAttribute).contains(data.checkingClassString))
            {
                testIsFailed = true;
                System.out.print("Error: " + testingElement.getAttribute("value")+ "\n");
            }
        }
        
        assertFalse(testIsFailed);
    }
    
    @Test
    public void InputInvalidDomain() throws InterruptedException
    {
        boolean testIsFailed = false;
        System.out.print("Testing invalid mail login...\n");
        
        for(String input : data.inputInvalidDomainData)
        {                 

            testingElement.sendKeys(Keys.chord(Keys.CONTROL, "a"));
            testingElement.sendKeys(Keys.BACK_SPACE);
            testingElement.sendKeys(input);
            testingElement.sendKeys(Keys.TAB);
            Thread.sleep(secondsOfSleep);
            
            checkedElement = driver.findElement(By.xpath(data.checkingClassDomainXpathString));
            if(!checkedElement.getAttribute(data.checkingAttribute).contains(data.checkingClassString))
            {
                testIsFailed = true;
                System.out.print("Error: " + testingElement.getAttribute("value")+ "\n");
            }
            
            testingElement.clear();
            testingElement.click();
        }
        
        assertFalse(testIsFailed);
    }
    
    
    @Test
    public void InputEmptyString()
    {   
        testingElement.sendKeys(" ");
        testingElement.clear();
         
        checkedElement = driver.findElement(By.xpath(data.checkingClassDomainXpathString));   
        assertTrue("space", checkedElement.getAttribute(data.checkingAttribute).contains(data.checkingClassString));
    }
    
    @Test
    public void SpaceIsTrimmed()
    {   
        testingElement.click();
        testingElement.sendKeys("    ");
        
        checkedElement = driver.findElement(By.xpath(data.checkingClassDomainXpathString));   
        assertFalse("space trim", checkedElement.getAttribute(data.checkingAttribute).contains(data.checkingClassString));     
    }
    
    @Test
    public void DomainComboboxClick()
    {   
        WebElement element = driver.findElement(By.xpath("//input[@value='@rambler.ru']"));      
        element.click();
    }
    
    @After
    public void CleanAfterTest()
    {
        testingElement.clear();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }
    
    @AfterClass
    public static void CloseTestEnviroment()
    {
        driver.close();
    }
}
