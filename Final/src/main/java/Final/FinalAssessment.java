package Final;

import java.util.Set;
import java.time.Duration;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FinalAssessment {
	
	@Test 
	
public  <WebElemant> void CreateEditDeleteEvent() throws InterruptedException {
 
	
     WebDriverManager.chromedriver().setup(); 
     ChromeOptions options = new ChromeOptions();
     options.addArguments("--disable-notifications");
     ChromeDriver driver=new ChromeDriver(options);
     driver.manage().window().maximize();
     
     
     driver.get("https://login.salesforce.com/?locale=in");
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

     driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
     driver.findElement(By.name("pw")).sendKeys("Tuna@123"); 
     driver.findElement(By.id("Login")).click(); 
     String title = driver.getTitle();
     System.out.println(title);//login to salesforce
     
     
      if(title.contains("Home Page ~ Salesforce - Developer Edition")) {
      System.out.println("Inside IF");
      driver.findElement(By.xpath("//a[@title='Home Tab']")).click();
      Thread.sleep(3000);
      driver.findElement(By.xpath("//input[@value='No Thanks']")).click();
      Thread.sleep(3000);
      driver.findElement(By.xpath("//input[@value='Send to Salesforce']")).click();
      }
      else {
      System.out.println("Inside else");
      driver.findElement(By.xpath("(//span[@class='uiImage'])[1]")).click();
      Thread.sleep(1000); 
      driver.findElement(By.xpath("//a[@class='profile-link-label switch-to-aloha uiOutputURL']")).click();
      Thread.sleep(2000); }//classic or lightning page
      
      
       driver.findElement(By.xpath("//div[@class='createNewModule sidebarModule']")).click();
       driver.findElement(By.linkText("Event")).click();//selecting event from drop-down

       driver.findElement(By.xpath("//input[@spellcheck=\"true\"]")).sendKeys("Ritusree");
       driver.findElement(By.xpath("//input[@value='Attach File']")).click();//setting subject as Ritusree
       
       Set<String> windows = driver.getWindowHandles();
       Iterator<String>it = windows.iterator(); 
       String parentId = it.next(); 
       String childId = it.next(); 
       driver.switchTo().window(childId);
       System.out.println(driver.switchTo().window(childId).getTitle());
       WebElement uploadFile = driver.findElement(By.xpath("//input[@id='file']"));
       uploadFile.sendKeys("C:\\Users\\YV557NN\\OneDrive - EY\\Documents\\manual testing");
       String windowHandle = driver.getWindowHandle();
       System.out.println(windowHandle);
       Set<String> windowHandles = driver.getWindowHandles();
       System.out.println(windowHandles.size());
       List<String>windows1=new ArrayList<String>(windowHandles);
       driver.switchTo().window(windows1.get(1));
       String title1 = driver.getTitle();
       System.out.println(title1);
       driver.findElement(By.name("file")).sendKeys("C:\\Users\\YV557NN\\OneDrive - EY\\Documents\\manual testing");
       Thread.sleep(3000);//attaching a file
       
       
       driver.findElement(By.xpath("//input[@title='Done']")).click();
       driver.switchTo().window(windows1.get(0));
       driver.findElement(By.name("save")).click();//,creating event 
       
       
       Thread.sleep(3000);
       driver.findElement(By.xpath("(//div[@class='mruItem']//a)[1]")).click();
       Thread.sleep(3000);
       driver.findElement(By.name("edit")).click();
       Thread.sleep(3000);
       driver.findElement(By.id("EndDateTime")).clear();
       driver.findElement(By.id("EndDateTime")).sendKeys("5/21/2022");
       driver.findElement(By.name("save")).click();//edit event 
       
       
       driver.findElement(By.xpath("(//div[@class='mruItem']//a)[1]")).click();
       driver.findElement(By.name("del")).click();
       String recent = driver.findElement(By.xpath("(//div[@class='mruItem']//a)[1]")).getText();
       if(!recent.contains("event1")) {
       System.out.println("Successfully deleted");//delete event 
       
       
       }
       }
 
}

