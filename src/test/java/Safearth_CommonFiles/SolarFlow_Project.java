package Safearth_CommonFiles;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SolarFlow_Project extends BaseTest {
@Test
	public void ProjectCreation() throws InterruptedException {
	
		// TODO Auto-generated method stub
		String TagName="button";
		java.util.List<WebElement> element1=driver.findElements(By.xpath("//button[normalize-space()='Login']"));
		element1.get(0).click();
		driver.findElement(By.xpath("//input[@id='login-form_email']")).sendKeys("kaustubh@safearth.in");
		driver.findElement(By.xpath("//input[@id='login-form_password']")).sendKeys("solar1234");
		
		driver.findElement(By.xpath("//span[@class='ant-checkbox-inner']")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
	
		 WebElement button1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@type='button'])[6]")));
		 button1.click();

		
		 Set<String> windowHandles = driver.getWindowHandles();
		 List<String> windowHandlesList = new ArrayList<>(windowHandles);

		 
		 driver.switchTo().window(windowHandlesList.get(windowHandlesList.size() - 1));

		
		 wait.until(ExpectedConditions.urlToBe("https://pmt.safearth.in/dashboard"));

		
		 WebElement startNewProjectButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ant-btn.ant-btn-button.add-project-button")));
		 startNewProjectButton.click();
		 WebElement j = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='projectName']")));
			j.click();
         WebElement projectNameInput = driver.findElement(By.xpath("//input[@id='projectName']"));
         projectNameInput.sendKeys("Arpitha_demo");
         String projectNameValue = projectNameInput.getAttribute("value");
         System.out.println("Project Name entered: " + projectNameValue);
	       driver.findElement(By.xpath("//input[@id='teamSize']")).sendKeys("100");
	       WebElement date_startdate_Picker = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='Start Date']")));
	       date_startdate_Picker.click();
	       driver.findElement(By.xpath("//button[@class='ant-picker-header-prev-btn']")).click();
	    WebElement date_select=driver.findElement(By.xpath(" //div[normalize-space()='18']"));
	       date_select.click();
	       
	       WebElement date_enddate_Picker = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='End Date']")));
	       date_enddate_Picker.click();
	  
	        WebElement date_End1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@aria-disabled='false']")));
	       ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", date_End1); 
	       date_End1.click();
	      
	       
	       
	       
	       driver.findElement(By.xpath("//div[contains(@class,'stakeholders-wrapper-container')]//div[contains(@class,'stakeholders-wrapper')]//div[1]//label[1]//span[1]//input[1]")).click();
	       
	      driver.findElement(By.xpath("//body/div[@id='root']/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[3]/div[1]/div[2]/label[1]/span[1]/input[1]")).click();
	      driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary next-btn']")).click();
	      WebElement dropdown_role = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ant-select ant-select-borderless main-project-team-custom-select ant-select-multiple ant-select-show-arrow ant-select-show-search']"))); 
          dropdown_role.click();
          List<WebElement> options1 = driver.findElements(By.xpath("//div[@class='ant-select-item-option-content']"));
          options1.get(0).click();
          options1.get(3).click();
          driver.findElement(By.xpath(" //button[@class='ant-btn ant-btn-primary next-btn']")).click();
          driver.findElement(By.xpath("//input[@placeholder='Customer Name*']")).sendKeys("arpitha");
          driver.findElement(By.xpath(" //input[@placeholder='Company Name*']")).sendKeys("Test_demo");
          driver.findElement(By.xpath("//input[@placeholder='Email Id']")).sendKeys("arpithakotiyan20@gmail.com");
          driver.findElement(By.xpath("  //div[@class='bottom-email-text']//button[@type='button']")).click();
    
          driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();


          driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default add-subcontractor-btn']")).click();
          driver.findElement(By.xpath(" //input[@id='name']")).sendKeys("demooo");
          driver.findElement(By.xpath("//input[@id='email']")).sendKeys("arpithakotiyan@gmail.com");
          driver.findElement(By.xpath(" //button[@type='submit']")).click();
          WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='ant-btn ant-btn-primary next-button']")));
          ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton); 
          ((JavascriptExecutor) driver).executeScript("arguments[0].click();", nextButton);
          driver.findElement(By.xpath("//input[@value='Rooftop']")).click();
        driver.findElement(By.xpath("//input[@value='Commercial']")).click();
        driver.findElement(By.xpath("//input[@value='RCC']")).click();
        driver.findElement(By.xpath("//input[@value='OnSite']")).click();
        driver.findElement(By.xpath(" //p[normalize-space()='CEIG']")).click();
        WebElement Next1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='ant-btn ant-btn-primary action-button-next-project-specification']")));
	       Next1.click();
        Thread.sleep(2000);
         WebElement Createproject_button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='ant-btn ant-btn-default go-to-dashboard-btn']")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Createproject_button ); 
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", Createproject_button );
        WebElement Confirm_button = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(" //span[normalize-space()='Yes']")));
        Confirm_button.click();
        WebElement noActivitiesMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[normalize-space()='No Activities to display.']")));
     if(noActivitiesMessage.isDisplayed()) {
         System.out.println("Project successfully created, 'No Activities to display' message is visible.");
     } else {
         System.out.println("Project creation failed or the page did not load correctly.");
     }
      
     
     
        
       
     
        
      
        
       
       
	        }
	    




	               
	 


	        	
	        
}
	 	        
	           

	       



