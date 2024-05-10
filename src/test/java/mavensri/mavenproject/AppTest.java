package mavensri.mavenproject;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.openqa.selenium.TakesScreenshot;

public class AppTest{
	public static WebDriver driver;
	WebDriver driver1;
	public static void main(String[] args) throws InterruptedException, IOException {
		
                  ChromeDriver driver=new ChromeDriver();
                  String csvFile1 = "resolution.csv",csvFile2="locator.csv";
                  String line;
                  String cvsSplitBy = ",";

                  ArrayList<String[]> resolutionList = new ArrayList<>();

                  try (BufferedReader br = new BufferedReader(new FileReader(csvFile1))) {
                      while ((line = br.readLine()) != null) {
                          String[] data = line.split(cvsSplitBy);
                          resolutionList.add(data);
                      }
                  } catch (IOException e) {
                      e.printStackTrace();
                  }
                  
                  ArrayList<String[]> locatorList = new ArrayList<>();

                  try (BufferedReader br = new BufferedReader(new FileReader(csvFile2))) {
                      while ((line = br.readLine()) != null) {
                          String[] data = line.split(cvsSplitBy);
                          locatorList.add(data);
                      }
                  } catch (IOException e) {
                      e.printStackTrace();
                  }
                  driver.get("https://www.getcalley.com/page-sitemap.xml");
                  driver.manage().window().maximize();
                  int width=0,height=0;
                  String folderName;
                  for (String[] data : resolutionList) 
                  { 
                	  width=Integer.parseInt(data[0]);
                	  height=Integer.parseInt(data[1]);
//                	  System.out.println("data[0]"+data[0]);
//                	  System.out.println("data[1]"+data[1]);
                	  folderName=data[0] + "X" + data[1];
                	  for (String[] array : locatorList) 
                	  {
                		  
                    	  driver.findElement(By.xpath("//a[contains(text(),'"+array[0]+"')]")).click();
                    	  Thread.sleep(3000);
                    	  driver.manage().window().setSize(new Dimension(width, height));
                    	  File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                          SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
                          Date currentDate = new Date();
                          String dateTime = formatter.format(currentDate);
                          String folderPath = "C:\\Users\\akila\\eclipse-workspace\\mavenproject\\Desktop\\";
                          String fileName = folderPath+folderName+"\\"+"screenshot-" + dateTime + ".png";
                          System.out.println("fileName"+fileName);
                          File destinationFile = new File(fileName);
                          try {
                        	  FileHandler.copy(screenshotFile, destinationFile);                          
                          } catch (Exception e) {
                              e.printStackTrace();
                          }
                    	  driver.navigate().back();
//                    	  System.out.println("array[0]"+array[0]);
                     }
                 }
                driver.quit();        
     }
}
         /*  FirefoxDriver driver1=new FirefoxDriver();
    driver1.get("https://www.getcalley.com/page-sitemap.xml");
    driver1.manage().window().maximize();

	Thread.sleep(3000);
  driver1.manage().window().setSize);
  driver1.quit();    */


    
    





     
 