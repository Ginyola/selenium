
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CheckNewMail 
{
    private static WebDriver driver = null;
    private static String m_URL = "https://mail.rambler.ru/";
    private static String m_login = "k.gunya@rambler.ru";
    private static String m_loginId = "login";
    private static String m_password = "Guh93Guh93";
    private static String m_passwordId = "password";
    private static String m_titleSubStr = "Входящие";
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException 
    {
         System.setProperty("webdriver.chrome.driver",
                "C:\\Programming\\Selenium\\webDrivers\\chromedriver_73.exe");
         
        driver = new ChromeDriver();
        driver.get(m_URL);
        
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[src='https://id.rambler.ru/login-20/login?"
                + "rname=mail&back=https%3A%2F%2Fmail.rambler.ru%2F&param=embed&iframeOrigin=https%3A%2F%2Fmail."
                + "rambler.ru']")));
        new WebDriverWait (driver, 7).until(ExpectedConditions.elementToBeClickable(By.id(m_loginId))).click();
        
        WebElement login = driver.findElement(By.id(m_loginId));
        login.sendKeys(m_login);
        
        WebElement password = driver.findElement(By.id(m_passwordId));
        password.sendKeys(m_password);
        
        password.submit();
         
        new WebDriverWait (driver, 5).until(ExpectedConditions.titleContains(m_titleSubStr));
        Thread.sleep(1000);
        
        String currentTitle = driver.getTitle();
        
        if(currentTitle.charAt(0) == '(')
        {
            System.out.print("New Letters!\n");
        }
        else
        {
            System.out.print("No new letters!\n");
        }
        
        driver.close();
    }
    
}
