package mavensri.mavenproject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class App 
{
	public static WebDriver driver;
	WebDriver driver1;
    public static void main( String[] args ) throws InterruptedException, AWTException
    {
    	ChromeDriver driver=new ChromeDriver();
    	driver.get("https://demo.dealsdray.com/");
    	driver.manage().window().maximize();
    	driver.findElement(By.name("username")).sendKeys("prexo.mis@dealsdray.com");
    	driver.findElement(By.name("password")).sendKeys("prexo.mis@dealsdray.com");
    	Thread.sleep(3000);
    	driver.findElement(By.cssSelector("button[type='submit']")).click();
    	Thread.sleep(3000);
    	driver.findElement(By.cssSelector(".material-icons.notranslate.MuiIcon-root.MuiIcon-fontSizeSmall.css-va0op3")).click();
    	Thread.sleep(3000);
    	driver.findElement(By.xpath("//span[normalize-space()='Orders']")).click();
    	Thread.sleep(5000);
    	
    	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div[2]/div[2]/button")).click();
    	Thread.sleep(3000);
        JavascriptExecutor js=(JavascriptExecutor)driver;
    	WebElement clk=driver.findElement(By.xpath("//input[@type='file']"));
    	js.executeScript("arguments[0].click();", clk);
    	
    	
    	
    	
    	String filePath = "C:\\Users\\akila\\Downloads\\demo-data.xlsx";
    	StringSelection sel=new StringSelection(filePath);
    	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel, null);
    	Robot robot=new Robot();
    	robot.keyPress(KeyEvent.VK_CONTROL);
    	robot.keyRelease(KeyEvent.VK_V);
    	robot.keyRelease(KeyEvent.VK_V);
    	robot.keyPress(KeyEvent.VK_CONTROL);
    	robot.keyPress(KeyEvent.VK_ENTER);
    	robot.keyRelease(KeyEvent.VK_ENTER);
    	
    	
    //	WebElement fileInput = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/input[1]"));
    //	Thread.sleep(10000);
    	//clk.sendKeys(new File(filePath).getAbsolutePath());

    }
}
