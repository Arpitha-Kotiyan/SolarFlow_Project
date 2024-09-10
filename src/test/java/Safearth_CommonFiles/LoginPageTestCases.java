package Safearth_CommonFiles;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.mailosaur.MailosaurClient;
import com.mailosaur.MailosaurException;
import com.mailosaur.models.MessageSearchParams;
import com.mailosaur.models.SearchCriteria;

public class LoginPageTestCases extends BaseTest {
	String apiKey = "RtPotNNWkSbsScL76S6q7Ha1VdB2dtbz";
    String serverId = "8wtvl4wx";
    String serverDomain = "8wtvl4wx.mailosaur.net";
    public String getRandomEmail() {
    	return "user"+ System.currentTimeMillis()+ "@"+serverDomain;
    }
    String emailId=getRandomEmail();
	@Test
	public void SignupPage() throws InterruptedException, IOException, MailosaurException {
		String tagName = "button"; 
	     java.util.List<WebElement> elements = driver.findElements(By.tagName(tagName));
	     for (int i = 0; i < elements.size(); i++) {
	         WebElement element = elements.get(i);
	         System.out.println("Index: " + i + ", Text: " + element.getText());
	     }
	     
	     if (elements.size() >= 7) {
	         WebElement first = elements.get(1);
	         
	         System.out.println("1st occurrence found: " + first.getText());
	         first.click(); 
	     } else {
	         System.out.println("1th occurrence not found.");
	     }
		String tagname1="h3";
		java.util.List<WebElement> elements1 = driver.findElements(By.tagName(tagname1));
		//for (int i = 0; i < elements1.size(); i++) {
	        //WebElement element3 = elements1.get(i);
	        //System.out.println("Index: " + i + ", Text: " + element3.getText());
	    //}
		if(elements1.size()>3) {
			WebElement e1=elements1.get(3);
			e1.click();
			String emailId=getRandomEmail();
			driver.findElement(By.xpath("(//div[@class='ant-row ant-row-middle user-wrapper'])[1]")).click();
			driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Arpitha_test");
			driver.findElement(By.xpath("//input[@id='companyName']")).sendKeys("demo_test");
			driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("6523564585");
			driver.findElement(By.xpath("//input[@id='email']")).sendKeys(emailId);
			driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default get-otp-btn']")).click();
			Thread.sleep(10000);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
			driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default signup-btn']")).click();
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("solar1234");
			driver.findElement(By.xpath("//input[@id='confirm']")).sendKeys("solar1234");
			MailosaurClient mailosaur = new MailosaurClient(apiKey);

		    MessageSearchParams params = new MessageSearchParams();
		    params.withServer(serverId);

		    SearchCriteria criteria = new SearchCriteria();
		    criteria.withSentTo(emailId);
		    criteria.withSentFrom("info@safearth.in");
		    com.mailosaur.models.Message message = mailosaur.messages().get(params, criteria);
		    System.out.println(message.subject());

		    assertNotNull(message);
		    assertEquals("OTP for Auction Platform", message.subject());
		    System.out.println(message.text().body()); // 

		    //Pattern pattern = Pattern.compile(".*([0-9]{6}).*");
		   // Matcher matcher = pattern.matcher(message.text().body());
		   // matcher.find();

		    //System.out.println(matcher.group(1)); // 

		    System.out.println(message.html().codes().size()); 

		    com.mailosaur.models.Code firstCode = message.html().codes().get(0);
		    System.out.println(firstCode.value());
		    String otp=firstCode.value();
		    driver.findElement(By.xpath("//input[@id='otp']")).sendKeys(otp);
		       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']"))).click();
		     //driver.findElement(By.xpath("//a[normalize-space()='Save for Later']")).click();
				//driver.findElement(By.xpath("//span[normalize-space()='Yes, save for Later']")).click();
		       
		       
		       java.util.List<WebElement> elements2 = driver.findElements(By.cssSelector("span.ant-upload"));
		   	
				for (int i = 0; i < elements2.size(); i++) {
					Thread.sleep(5000);
			        WebElement element3 = elements2.get(i);
			        System.out.println("Index: " + i + ", Text: " + element3.getText());
			        
			    }
				if (elements2.size() > 2) {
		            List<WebElement> fileInputs = driver.findElements(By.cssSelector("input[type='file']"));
		            if (fileInputs.size() > 1) {
		                WebElement e11 = fileInputs.get(0);
		                e11.sendKeys("C:\\Users\\arpit\\OneDrive\\Pictures\\moon-in-space.jpg");
		                WebElement e3 = fileInputs.get(1);
		                e3.sendKeys("C:\\Users\\arpit\\OneDrive\\Documents\\Demo_file.txt");
		            } else {
		                System.out.println("Not enough file input elements found.");
		            }
		        }
				Thread.sleep(5000);
				driver.findElement(By.xpath("//input[@id='founded']")).sendKeys("2017");
				driver.findElement(By.xpath("//input[@id='regionalOffice']")).sendKeys("Bengaluru");
				driver.findElement(By.xpath("//input[@id='headOffice']")).sendKeys("Bengaluru");
				driver.findElement(By.xpath("//input[@id='website']")).sendKeys("www.demo.com");
				driver.findElement(By.xpath("//textarea[@id='description']")).sendKeys("this is a demo project");
				driver.findElement(By.xpath("//input[@id='turnover']")).sendKeys("5000");
				driver.findElement(By.xpath("//input[@id='employees']")).sendKeys("66");
				driver.findElement(By.xpath("//input[@id='capacity']")).sendKeys("1000");
				WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
				WebElement option = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ant-select ant-select-in-form-item ant-select-status-success ant-select-multiple ant-select-show-arrow ant-select-show-search']")));
		        option.click();
		        WebElement dropdownMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ant-select-dropdown")));
		        WebElement secondOption = dropdownMenu.findElements(By.cssSelector(".ant-select-item-option")).get(1);
		        secondOption.click();
		        driver.findElement(By.xpath("//input[@id='minimum']")).sendKeys("100");
				driver.findElement(By.xpath("//input[@id='maximum']")).sendKeys("1000");
				driver.findElement(By.xpath("//textarea[@id='flagshipProjects']")).sendKeys("THIS IS FOR TESTING PURPOSE");
				driver.findElement(By.xpath("//input[@id='balance_sheet']")).sendKeys("C:\\Users\\arpit\\OneDrive\\Desktop\\DEMO_UPLOAD.docx");
				driver.findElement(By.xpath("//input[@value='Commercial']")).click();
				driver.findElement(By.xpath("//input[@id='projectMaxSize']")).sendKeys("2000");
				 WebElement dropdownArrow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='middle-card']//div[1]//div[1]//div[2]//div[1]//div[1]//span[1]//span[1]//span[1]//div[1]//div[1]")));
				 dropdownArrow.click();
				 List<WebElement> w5= driver.findElements(By.xpath("(//div[@class='ant-select-item-option-content'])"));
				 w5.get(1);
				 WebElement element_max = driver.findElement(By.xpath("//div[@title='kW']"));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element_max);
					
				 driver.findElement(By.xpath("//input[@id='projectMinSize']")).sendKeys("100");
				 WebElement dropdownArrow1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[3]/div[1]/form[1]/div[3]/div[1]/div[2]/div[1]/div[1]/span[1]/span[1]/span[1]")));
				 dropdownArrow1.click();
				 List<WebElement> w6= driver.findElements(By.xpath("(//div[@class='ant-select-item-option-content'])"));
				 w6.get(0);
				 WebElement element_min = driver.findElement(By.xpath("//div[@class='ant-select-item ant-select-item-option ant-select-item-option-active']//div[@class='ant-select-item-option-content'][normalize-space()='kW']"));
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", element_min);
				//driver.findElement(By.xpath("//input[@value='OPEX']")).click();
				WebElement w1= driver.findElement(By.xpath("(//div[@class='ant-select-selector'])[5]"));
				w1.click();
				WebElement element6 = driver.findElement(By.xpath("//div[@title='Assam']"));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element6);
				WebElement w2= driver.findElement(By.xpath("(//div[@class='ant-select-selector'])[6]"));
				w2.click();
				WebElement element5 = driver.findElement(By.xpath("//div[@title='Bihar']"));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element5);
				Thread.sleep(1000);
				driver.findElement(By.xpath("//input[@id='international']")).click();
				WebElement w3= driver.findElement(By.xpath("(//div[@class='ant-select-selector'])[7]"));
				w3.click();
				Thread.sleep(5000);
				WebElement element7 = driver.findElement(By.xpath("//div[@title='Benin']"));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element7);
				//driver.findElement(By.xpath("//a[normalize-space()='Save for Later']")).click();
				//driver.findElement(By.xpath("	//span[normalize-space()='Yes, save for Later']")).click();
				
				WebElement nextButton = driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary next-btn']"));
				
				nextButton.click();
				Thread.sleep(1000);
				
				WebElement uploadInput = driver.findElement(By.xpath("//input[@type='file']"));
				((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", uploadInput);
				uploadInput.sendKeys("C:\\Users\\arpit\\OneDrive\\Desktop\\moon-in-space.jpg");


                               Thread.sleep(5000);
				    WebElement nameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='name']")));
				    nameInput.sendKeys("demo demo");

				    WebElement sizeInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='size']")));
				    sizeInput.sendKeys("250");
				    WebElement option1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ant-select-selector']")));
			        option1.click();
			        WebElement dropdownMenu1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ant-select-item ant-select-item-option']")));
			       
			        dropdownMenu1.click();

				    

				    WebElement locationInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='location']")));
				    locationInput.sendKeys("Punjab");
				    WebElement cod = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='date']")));
				       cod.click();
				       driver.findElement(By.xpath("//button[@class='ant-picker-header-prev-btn']")).click();
				    WebElement date_select1=driver.findElement(By.xpath(" //div[normalize-space()='19']"));
				       date_select1.click();

				    WebElement modulesUsedInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='modulesUsed']")));
				    modulesUsedInput.sendKeys("demoo");

				    WebElement invertersUsedInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='invertersUsed']")));
				    invertersUsedInput.sendKeys("String");

				    WebElement kwInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='kw']")));
				    kwInput.sendKeys("20000");
				    
				    driver.findElement(By.xpath("//button[@type='submit']")).click();
				    Thread.sleep(1000);
				    driver.findElement(By.xpath("//span[normalize-space()='Next']")).click();

				    driver.findElement(By.xpath("//button[@type='button']")).click();
				    try {
				        
				        WebElement completeMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[normalize-space()='Complete!']")));
				        if (completeMessage.isDisplayed()) {
				            System.out.println("Signup is completed successfully.");
				        }
				    } catch (TimeoutException e) {
				        System.out.println("Signup failed or is not yet completed.");
				    }}}}
				
		
	
