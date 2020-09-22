package code.bsp;

import static org.testng.Assert.fail;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCode 
{
	public String baseUrl;
    private WebDriver driver;
    private StringBuffer verificationErrors = new StringBuffer();
    
    @BeforeClass(alwaysRun = true)
	  public void setUp() throws Exception 
	  {
		System.setProperty("webdriver.chrome.driver", "driverpath/chromedriver");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    baseUrl="http://jt-dev.azurewebsites.net/#/Signup";
	    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	  }
    
    @Test(priority = 1, description = "Launches the URL in site")

   	public void launcsite() throws IOException, InterruptedException 
       {
   		driver.get(baseUrl);     	
   		Thread.sleep(4000);
   	}
    
    @Test(priority=2, description="Validate the dropdown value")
    
    public void dropdownvalue() throws IOException, InterruptedException 
    {
    	driver.findElement(By.id("dropdown")).click();
    	String s= driver.findElement(By.xpath("English option")).getText();
    	  System.out.println("Default value selected is :"+ s);
    	  String s1= driver.findElement(By.xpath("Dutch option")).getText();
    	  System.out.println("Default value selected is :"+ s1);
    	  

    	

    }
    
@Test(priority=2, description="insert valid details and Validate Sign up")
    
    public void insertvaliddetails() throws IOException, InterruptedException 
    {
	
	    driver.findElement(By.id("name")).sendKeys("Bishnu");
	    driver.findElement(By.id("Organisation name")).sendKeys("Bishnu");
	    driver.findElement(By.id("email")).sendKeys("bspattanaik05@gmail.com");
	    driver.findElement(By.id("Terms Check box")).click();
	    driver.findElement(By.id("signup")).click();
	    
	
    }
    
    
    
    
    @AfterClass(alwaysRun = true)
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }

}
