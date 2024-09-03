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
	String apiKey = "xbSxLyfgDYULM39uY1Hr6oc5BHMbxdAf";
    String serverId = "jedfm1s4";
    String serverDomain = "jedfm1s4.mailosaur.net";
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
		     driver.findElement(By.xpath("//a[normalize-space()='Save for Later']")).click();
				driver.findElement(By.xpath("//span[normalize-space()='Yes, save for Later']")).click();
		       
		       
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
				/*Thread.sleep(5000);
				driver.findElement(By.xpath("//p[normalize-space()='Project Site Image']")).sendKeys("C:\\Users\\arpit\\OneDrive\\Desktop\\Picture1.png");
				driver.findElement(By.xpath("//input[@id='name']")).sendKeys("demo demo");
				driver.findElement(By.xpath("//input[@id='size']")).sendKeys("250");
				WebElement dropdownMenu_model = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ant-select-item ant-select-item-option ant-select-item-option-active")));
		        WebElement secondOption_model = dropdownMenu_model.findElements(By.cssSelector(".ant-select-item-option-content")).get(1);
		        secondOption_model.click();
				driver.findElement(By.xpath("//input[@id='location']")).sendKeys("Punjab");
				driver.findElement(By.xpath("//input[@id='modulesUsed']")).sendKeys("demoo");
				driver.findElement(By.xpath("//input[@id='invertersUsed']")).sendKeys("String");
				driver.findElement(By.xpath("//input[@id='kw']")).sendKeys("20000");*/
				WebElement uploadButton = driver.findElement(By.xpath("//p[normalize-space()='Project Site Image']"));
				uploadButton.click();

				WebElement uploadInput = driver.findElement(By.xpath("//input[@type='file']"));
				uploadInput.sendKeys("C:\\Users\\arpit\\OneDrive\\Pictures\\moon-in-space.jpg");

				    WebElement nameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='name']")));
				    nameInput.sendKeys("demo demo");

				    WebElement sizeInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='size']")));
				    sizeInput.sendKeys("250");

				    WebElement dropdownMenu_model = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ant-select-item.ant-select-item-option.ant-select-item-option-active")));
				    WebElement secondOption_model = dropdownMenu_model.findElements(By.cssSelector(".ant-select-item-option-content")).get(1);
				    secondOption_model.click();

				    WebElement locationInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='location']")));
				    locationInput.sendKeys("Punjab");

				    WebElement modulesUsedInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='modulesUsed']")));
				    modulesUsedInput.sendKeys("demoo");

				    WebElement invertersUsedInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='invertersUsed']")));
				    invertersUsedInput.sendKeys("String");

				    WebElement kwInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='kw']")));
				    kwInput.sendKeys("20000");
				    driver.findElement(By.xpath("//button[@type='submit']")).click();

				    driver.findElement(By.xpath("//button[@type='button']")).click();
				    driver.findElement(By.xpath(" //button[@title='SKIP']")).click();
				    //driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default go-back-btn']")).click();
				    driver.findElement(By.xpath("//p[normalize-space()='My Projects']")).click();
				    driver.findElement(By.xpath("//button[@title='SKIP']")).click();
				  
				 
				
		}
	}

	
	
		

	@Test
	public void LoginPageComapnyForm() throws InterruptedException {
		String TagName="button";
		java.util.List<WebElement> element1=driver.findElements(By.xpath("//button[normalize-space()='Login']"));
		//for(int i=0;i<element1.size();i++) {
			//WebElement ele=element1.get(i);
		element1.get(0).click();
		//System.out.println("Index: " + i + ", Text: " + ele.getText());
		//input[@id='login-form_email']
		driver.findElement(By.xpath("//input[@id='login-form_email']")).sendKeys("user1723184475481@jedfm1s4.mailosaur.net");
		driver.findElement(By.xpath("//input[@id='login-form_password']")).sendKeys("solar1234");
		driver.findElement(By.xpath("//span[@class='ant-checkbox-inner']")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement nextButton = driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary next-btn']"));
			//nextButton.click();
			//Thread.sleep(5000);
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
			
			WebElement nextButton1 = driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary next-btn']"));
			
			nextButton1.click();
			Thread.sleep(5000);
			driver.findElement(By.xpath("//p[normalize-space()='Project Site Image']")).sendKeys("C:\\Users\\arpit\\OneDrive\\Desktop\\Picture1.png");
			driver.findElement(By.xpath("//input[@id='name']")).sendKeys("demo demo");
			driver.findElement(By.xpath("//input[@id='size']")).sendKeys("250");
			WebElement dropdownMenu_model = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ant-select-item ant-select-item-option ant-select-item-option-active")));
	        WebElement secondOption_model = dropdownMenu_model.findElements(By.cssSelector(".ant-select-item-option-content")).get(1);
	        secondOption_model.click();
			driver.findElement(By.xpath("//input[@id='location']")).sendKeys("Punjab");
			driver.findElement(By.xpath("//input[@id='modulesUsed']")).sendKeys("demoo");
			driver.findElement(By.xpath("//input[@id='invertersUsed']")).sendKeys("String");
			driver.findElement(By.xpath("//input[@id='kw']")).sendKeys("20000");
			 WebElement uploadButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='site-image-wrapper']")));
			    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", uploadButton);
			    uploadButton.sendKeys("C:\\Users\\arpit\\OneDrive\\Pictures\\moon-in-space.jpg");

			    WebElement nameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='name']")));
			    nameInput.sendKeys("demo demo");

			    WebElement sizeInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='size']")));
			    sizeInput.sendKeys("250");

			    WebElement dropdownMenu_model1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ant-select-item.ant-select-item-option.ant-select-item-option-active")));
			    WebElement secondOption_model1 = dropdownMenu_model.findElements(By.cssSelector(".ant-select-item-option-content")).get(1);
			    secondOption_model1.click();

			    WebElement locationInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='location']")));
			    locationInput.sendKeys("Punjab");

			    WebElement modulesUsedInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='modulesUsed']")));
			    modulesUsedInput.sendKeys("demoo");

			    WebElement invertersUsedInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='invertersUsed']")));
			    invertersUsedInput.sendKeys("String");

			    WebElement kwInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='kw']")));
			    kwInput.sendKeys("20000");
			    driver.findElement(By.xpath("//button[@type='submit']")).click();

			    driver.findElement(By.xpath("//button[@type='button']")).click();
			    driver.findElement(By.xpath(" //button[@title='SKIP']")).click();
			    //driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default go-back-btn']")).click();
			    driver.findElement(By.xpath("//p[normalize-space()='My Projects']")).click();
			    driver.findElement(By.xpath("//button[@title='SKIP']")).click();
			  
			 
			
	}
	       //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='ant-btn ant-btn-primary next-btn']"))).click();   
	       /*driver.findElement(By.xpath("//div[@class='site-image-wrapper']")).sendKeys("C:\\Users\\arpit\\OneDrive\\Pictures\\moon-in-space.jpg");
	       driver.findElement(By.xpath("//input[@id='name']")).sendKeys("demo demo");
			driver.findElement(By.xpath("//input[@id='size']")).sendKeys("250");
			WebElement dropdownMenu_model = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ant-select-item ant-select-item-option ant-select-item-option-active")));
	        WebElement secondOption_model = dropdownMenu_model.findElements(By.cssSelector(".ant-select-item-option-content")).get(1);
	        secondOption_model.click();
			driver.findElement(By.xpath("//input[@id='location']")).sendKeys("Punjab");
			driver.findElement(By.xpath("//input[@id='modulesUsed']")).sendKeys("demoo");
			driver.findElement(By.xpath("//input[@id='invertersUsed']")).sendKeys("String");
			driver.findElement(By.xpath("//input[@id='kw']")).sendKeys("20000");
			driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary next-btn']")).click();*/
			/*WebElement uploadButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='site-image-wrapper']")));
		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", uploadButton);
		    uploadButton.sendKeys("C:\\Users\\arpit\\OneDrive\\Pictures\\moon-in-space.jpg");

		    WebElement nameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='name']")));
		    nameInput.sendKeys("demo demo");

		    WebElement sizeInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='size']")));
		    sizeInput.sendKeys("250");

		    WebElement dropdownMenu_model = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ant-select-item.ant-select-item-option.ant-select-item-option-active")));
		    WebElement secondOption_model = dropdownMenu_model.findElements(By.cssSelector(".ant-select-item-option-content")).get(1);
		    secondOption_model.click();

		    WebElement locationInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='location']")));
		    locationInput.sendKeys("Punjab");

		    WebElement modulesUsedInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='modulesUsed']")));
		    modulesUsedInput.sendKeys("demoo");

		    WebElement invertersUsedInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='invertersUsed']")));
		    invertersUsedInput.sendKeys("String");

		    WebElement kwInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='kw']")));
		    kwInput.sendKeys("20000");
		    driver.findElement(By.xpath("//button[@type='submit']")).click();

		    driver.findElement(By.xpath("//button[@type='button']")).click();
		    driver.findElement(By.xpath(" //button[@title='SKIP']")).click();
		    //driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default go-back-btn']")).click();
		    driver.findElement(By.xpath("//p[normalize-space()='My Projects']")).click();
		    driver.findElement(By.xpath("//button[@title='SKIP']")).click();*/
			
		
	//}
			
	@Test
		public void FirstTimeLoginRegistration() throws InterruptedException {
		String TagName="button";
		java.util.List<WebElement> element1=driver.findElements(By.xpath("//button[normalize-space()='Login']"));
		element1.get(0).click();
		driver.findElement(By.xpath("//input[@id='login-form_email']")).sendKeys("user1723184475481@jedfm1s4.mailosaur.net");
		driver.findElement(By.xpath("//input[@id='login-form_password']")).sendKeys("solar1234");
		driver.findElement(By.xpath("//span[@class='ant-checkbox-inner']")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//driver.findElement(By.xpath("//a[normalize-space()='Save for Later']")).click();
		
		java.util.List<WebElement> elements2 = driver.findElements(By.cssSelector("span.ant-upload"));
	
		for (int i = 0; i < elements2.size(); i++) {
			Thread.sleep(5000);
	        WebElement element3 = elements2.get(i);
	        System.out.println("Index: " + i + ", Text: " + element3.getText());
	        
	    }
		if (elements2.size() > 2) {
            List<WebElement> fileInputs = driver.findElements(By.cssSelector("input[type='file']"));
            if (fileInputs.size() > 1) {
                WebElement e1 = fileInputs.get(0);
                e1.sendKeys("C:\\Users\\arpit\\OneDrive\\Pictures\\moon-in-space.jpg");
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
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ant-select ant-select-in-form-item ant-select-status-success ant-select-multiple ant-select-show-arrow ant-select-show-search']")));
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
		WebElement nextButton = driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary next-btn']"));
		nextButton.click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//p[normalize-space()='Project Site Image']")).sendKeys("C:\\Users\\arpit\\OneDrive\\Desktop\\Picture1.png");
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("demo demo");
		driver.findElement(By.xpath("//input[@id='size']")).sendKeys("250");
		WebElement dropdownMenu_model = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ant-select-item ant-select-item-option ant-select-item-option-active")));
        WebElement secondOption_model = dropdownMenu_model.findElements(By.cssSelector(".ant-select-item-option-content")).get(1);
        secondOption_model.click();
		driver.findElement(By.xpath("//input[@id='location']")).sendKeys("Punjab");
		driver.findElement(By.xpath("//input[@id='modulesUsed']")).sendKeys("demoo");
		driver.findElement(By.xpath("//input[@id='invertersUsed']")).sendKeys("String");
		driver.findElement(By.xpath("//input[@id='kw']")).sendKeys("20000");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	    driver.findElement(By.xpath("//button[@type='button']")).click();
	    driver.findElement(By.xpath(" //button[@title='SKIP']")).click();
	    //driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default go-back-btn']")).click();
	    driver.findElement(By.xpath("//p[normalize-space()='My Projects']")).click();
	    driver.findElement(By.xpath("//button[@title='SKIP']")).click();
		
		
	}
	@Test
	public void FirstTimeLoginRegistration_withoutDetails() {
		java.util.List<WebElement> element1=driver.findElements(By.xpath("//button[normalize-space()='Login']"));
		element1.get(0).click();
		driver.findElement(By.xpath("//input[@id='login-form_email']")).sendKeys("bexelara@clip.lat");
		driver.findElement(By.xpath("//input[@id='login-form_password']")).sendKeys("solar1234");
		driver.findElement(By.xpath("//span[@class='ant-checkbox-inner']")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		WebElement nextButton = driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary next-btn']"));
		nextButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<By> errorLocators = List.of(
                By.xpath("//div[contains(text(),'Please enter founded year!')]"),
                By.xpath("//div[contains(text(),'Please enter head office!')]"),
                By.xpath("//div[contains(text(),'Please upload a brochure file!')]"),
                By.xpath("//div[contains(text(),'Please enter capacity of projects installed!')]"),
                By.xpath("//div[@class='ant-form-item-explain-error'][normalize-space()='Please select a project type that would interest you!']"));
        boolean allErrorsDisplayed = true;
        for (By locator : errorLocators) {
            WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            if (!errorMessage.isDisplayed()) {
                allErrorsDisplayed = false;
                System.out.println("Test Failed: Error message for " + locator + " is not displayed.");
            }
        }

        if (allErrorsDisplayed) {
            System.out.println("Test Passed: All error messages are displayed as expected.");
        }
	}
	@Test
	public void FirstTimeLoginRegistration1() throws InterruptedException {
		String TagName="button";
		java.util.List<WebElement> element1=driver.findElements(By.xpath("//button[normalize-space()='Login']"));
		element1.get(0).click();
		driver.findElement(By.xpath("//input[@id='login-form_email']")).sendKeys("user1723012537904@jedfm1s4.mailosaur.net");
		driver.findElement(By.xpath("//input[@id='login-form_password']")).sendKeys("solar1234");
		driver.findElement(By.xpath("//span[@class='ant-checkbox-inner']")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	        driver.manage().window().maximize();
		java.util.List<WebElement> elements2 = driver.findElements(By.cssSelector("span.ant-upload"));
		for (int i = 0; i < elements2.size(); i++) {
            Thread.sleep(5000);
            WebElement element3 = elements2.get(i);
            System.out.println("Index: " + i + ", Text: " + element3.getText());
        }

       
        if (elements2.size() > 2) {
            List<WebElement> fileInputs = driver.findElements(By.cssSelector("input[type='file']"));
            if (fileInputs.size() > 1) {
                WebElement e1 = fileInputs.get(0);
                e1.sendKeys("C:\\Users\\arpit\\OneDrive\\Pictures\\moon-in-space.jpg");
                WebElement e3 = fileInputs.get(1);
                e3.sendKeys("C:\\Users\\arpit\\OneDrive\\Documents\\Demo_file.txt");
            } else {
                System.out.println("Not enough file input elements found.");
            }
        }

        Thread.sleep(5000);
       
        WebElement foundedField = driver.findElement(By.xpath("//input[@id='founded']"));
        foundedField.clear();
        foundedField.sendKeys("2017");

        WebElement regionalOfficeField = driver.findElement(By.xpath("//input[@id='regionalOffice']"));
        regionalOfficeField.clear();
        regionalOfficeField.sendKeys("Bengaluru");

        WebElement headOfficeField = driver.findElement(By.xpath("//input[@id='headOffice']"));
        headOfficeField.clear();
        headOfficeField.sendKeys("Bengaluru");

        WebElement websiteField = driver.findElement(By.xpath("//input[@id='website']"));
        websiteField.clear();
        websiteField.sendKeys("www.demo.com");

        WebElement descriptionField = driver.findElement(By.xpath("//textarea[@id='description']"));
        descriptionField.clear();
        descriptionField.sendKeys("this is a demo project");

        WebElement turnoverField = driver.findElement(By.xpath("//input[@id='turnover']"));
        turnoverField.clear();
        turnoverField.sendKeys("5000");

        WebElement employeesField = driver.findElement(By.xpath("//input[@id='employees']"));
        employeesField.clear();
        employeesField.sendKeys("66");

        WebElement capacityField = driver.findElement(By.xpath("//input[@id='capacity']"));
        capacityField.clear();
        capacityField.sendKeys("1000");

        // Interact with dropdown
        try {
            WebElement dropdownArrow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ant-select ant-select-in-form-item ant-select-status-success ant-select-multiple ant-select-show-arrow ant-select-show-search']")));
            dropdownArrow.click();
            WebElement dropdownMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ant-select-dropdown")));
            WebElement secondOption = dropdownMenu.findElements(By.cssSelector(".ant-select-item-option")).get(1);
            secondOption.click();
        } catch (StaleElementReferenceException e) {
            WebElement dropdownArrow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ant-select ant-select-in-form-item ant-select-status-success ant-select-multiple ant-select-show-arrow ant-select-show-search']")));
            dropdownArrow.click();
            WebElement dropdownMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ant-select-dropdown")));
            WebElement secondOption = dropdownMenu.findElements(By.cssSelector(".ant-select-item-option")).get(1);
            secondOption.click();
        }

        WebElement minimumField = driver.findElement(By.xpath("//input[@id='minimum']"));
        minimumField.clear();
        minimumField.sendKeys("100");

        WebElement maximumField = driver.findElement(By.xpath("//input[@id='maximum']"));
        maximumField.clear();
        maximumField.sendKeys("1000");

        WebElement flagshipProjectsField = driver.findElement(By.xpath("//textarea[@id='flagshipProjects']"));
        flagshipProjectsField.clear();
        flagshipProjectsField.sendKeys("THIS IS FOR TESTING PURPOSE");

        WebElement balanceSheetField = driver.findElement(By.xpath("//input[@id='balance_sheet']"));
        balanceSheetField.clear();
        balanceSheetField.sendKeys("C:\\Users\\arpit\\OneDrive\\Desktop\\DEMO_UPLOAD.docx");

        WebElement commercialRadioButton = driver.findElement(By.xpath("//input[@value='Commercial']"));
        commercialRadioButton.click();

        WebElement projectMaxSizeField = driver.findElement(By.xpath("//input[@id='projectMaxSize']"));
        projectMaxSizeField.clear();
        projectMaxSizeField.sendKeys("2000");

        // Interact with another dropdown
        try {
            WebElement dropdownArrow1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='middle-card']//div[1]//div[1]//div[2]//div[1]//div[1]//span[1]//span[1]//span[1]//div[1]//div[1]")));
            dropdownArrow1.click();
            WebElement element_max = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@title='kW']")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element_max);
        } catch (StaleElementReferenceException e) {
            WebElement dropdownArrow1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='middle-card']//div[1]//div[1]//div[2]//div[1]//div[1]//span[1]//span[1]//span[1]//div[1]//div[1]")));
            dropdownArrow1.click();
            WebElement element_max = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@title='kW']")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element_max);
        }

        WebElement projectMinSizeField = driver.findElement(By.xpath("//input[@id='projectMinSize']"));
        projectMinSizeField.clear();
        projectMinSizeField.sendKeys("100");

        try {
            WebElement dropdownArrow2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[3]/div[1]/form[1]/div[3]/div[1]/div[2]/div[1]/div[1]/span[1]//span[1]//span[1]")));
            dropdownArrow2.click();
            WebElement element_min = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ant-select-item ant-select-item-option ant-select-item-option-active']//div[@class='ant-select-item-option-content'][normalize-space()='kW']")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element_min);
        } catch (StaleElementReferenceException e) {
            WebElement dropdownArrow2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[3]/div[1]/form[1]/div[3]/div[1]/div[2]/div[1]/div[1]/span[1]//span[1]//span[1]")));
            dropdownArrow2.click();
            WebElement element_min = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ant-select-item ant-select-item-option ant-select-item-option-active']//div[@class='ant-select-item-option-content'][normalize-space()='kW']")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element_min);
        }

        // Interact with more dropdowns and buttons
        WebElement w1 = driver.findElement(By.xpath("(//div[@class='ant-select-selector'])[5]"));
        w1.click();
        WebElement element6 = driver.findElement(By.xpath("//div[@title='Assam']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element6);

        WebElement w2 = driver.findElement(By.xpath("(//div[@class='ant-select-selector'])[6]"));
        w2.click();
        WebElement element5 = driver.findElement(By.xpath("//div[@title='Central']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element5);

        WebElement nameField = driver.findElement(By.xpath("//input[@id='name']"));
        nameField.clear();
        nameField.sendKeys("demo demo");

        WebElement sizeField = driver.findElement(By.xpath("//input[@id='size']"));
        sizeField.clear();
        sizeField.sendKeys("250");

        // Interact with another dropdown
        try {
            WebElement dropdownMenu_model = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ant-select-item ant-select-item-option ant-select-item-option-active")));
            WebElement secondOption_model = dropdownMenu_model.findElements(By.cssSelector(".ant-select-item-option-content")).get(1);
            secondOption_model.click();
        } catch (StaleElementReferenceException e) {
            WebElement dropdownMenu_model = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ant-select-item ant-select-item-option ant-select-item-option-active")));
            WebElement secondOption_model = dropdownMenu_model.findElements(By.cssSelector(".ant-select-item-option-content")).get(1);
            secondOption_model.click();
        }

        WebElement locationField = driver.findElement(By.xpath("//input[@id='location']"));
        locationField.clear();
        locationField.sendKeys("Punjab");

        WebElement modulesUsedField = driver.findElement(By.xpath("//input[@id='modulesUsed']"));
        modulesUsedField.clear();
        modulesUsedField.sendKeys("demoo");

        WebElement invertersUsedField = driver.findElement(By.xpath("//input[@id='invertersUsed']"));
        invertersUsedField.clear();
        invertersUsedField.sendKeys("String");

        WebElement kwField = driver.findElement(By.xpath("//input[@id='kw']"));
        kwField.clear();
        kwField.sendKeys("20000");

     
    }
	@Test
	public void FirstTimeLoginRegistration2() throws InterruptedException {
		String TagName="button";
		java.util.List<WebElement> element1=driver.findElements(By.xpath("//button[normalize-space()='Login']"));
		element1.get(0).click();
		driver.findElement(By.xpath("//input[@id='login-form_email']")).sendKeys("kipsahepsa@gufum.com");
		driver.findElement(By.xpath("//input[@id='login-form_password']")).sendKeys("solar1234");
		driver.findElement(By.xpath("//span[@class='ant-checkbox-inner']")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		 
	        driver.manage().window().maximize();
	        try {
	           

	            
	            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	            // Locate elements with a retry mechanism
	            List<WebElement> elements2 = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(".span.ant-upload")));
	            
	            // Debugging output
	            System.out.println("Found " + elements2.size() + " 'span.ant-upload' elements.");

	            for (int i = 0; i < elements2.size(); i++) {
	                try {
	                    Thread.sleep(5000);
	                    // Re-locate the elements in each iteration to avoid StaleElementReferenceException
	                    elements2 = driver.findElements(By.cssSelector("span.ant-upload"));
	                    WebElement element3 = elements2.get(i);
	                    System.out.println("Index: " + i + ", Text: " + element3.getText());
	                } catch (org.openqa.selenium.StaleElementReferenceException e) {
	                    System.out.println("StaleElementReferenceException caught at index " + i + ". Retrying...");
	                    i--; // Retry the same index
	                }
	            }

	            // Handle file upload if more than 2 elements are found
	            if (elements2.size() > 3) {
	                // Wait until the 'input[type='file']' elements are visible
	                List<WebElement> fileInputs = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("input[type='file']")));
	                
	                // Debugging output
	                System.out.println("Found " + fileInputs.size() + " 'input[type='file']' elements.");

	                if (fileInputs.size() > 1) {
	                    WebElement e1 = fileInputs.get(0);
	                    clearAndUploadFile(driver, e1, "C:\\Users\\arpit\\OneDrive\\Pictures\\moon-in-space.jpg");
	                    WebElement e3 = fileInputs.get(1);
	                    clearAndUploadFile(driver, e3, "C:\\Users\\arpit\\OneDrive\\Documents\\Demo_file.txt");
	                } else {
	                    System.out.println("Not enough file input elements found.");
	                }
	            } else {
	                System.out.println("Not enough 'span.ant-upload' elements found.");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            // Close the browser
	            driver.quit();
	        }
	    }

	    private static void clearAndUploadFile(WebDriver driver, WebElement fileInput, String filePath) {
	        try {
	            // Clear the file input using JavaScript
	            ((JavascriptExecutor) driver).executeScript("arguments[0].value=''", fileInput);
	            // Set the new file path
	            fileInput.sendKeys(filePath);
	        } catch (Exception e) {
	            System.out.println("Failed to upload file: " + filePath);
	            e.printStackTrace();
	        }
	    }
	    @Test
	    public void demo1() throws InterruptedException {
	    	String TagName="button";
			java.util.List<WebElement> element1=driver.findElements(By.xpath("//button[normalize-space()='Login']"));
			element1.get(0).click();
	    	driver.findElement(By.xpath("//input[@id='login-form_email']")).sendKeys("user1723184475481@jedfm1s4.mailosaur.net");
			driver.findElement(By.xpath("//input[@id='login-form_password']")).sendKeys("solar1234");
			driver.findElement(By.xpath("//span[@class='ant-checkbox-inner']")).click();
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			
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
			WebElement nextButton = driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-primary next-btn']"));
			
			nextButton.click();
			
			WebElement uploadButton = driver.findElement(By.xpath("//p[normalize-space()='Project Site Image']"));
			uploadButton.click();

			WebElement uploadInput = driver.findElement(By.xpath("//input[@type='file']"));
			uploadInput.sendKeys("C:\\Users\\arpit\\OneDrive\\Pictures\\moon-in-space.jpg");

		    WebElement nameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='name']")));
		    nameInput.sendKeys("demo demo");

		    WebElement sizeInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='size']")));
		    sizeInput.sendKeys("250");
		    //WebElement option = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ant-select ant-select-in-form-item ant-select-status-success ant-select-multiple ant-select-show-arrow ant-select-show-search']")));
		    //option.click();
		    //WebElement dropdownMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ant-select-dropdown")));
		    //WebElement secondOption = dropdownMenu.findElements(By.cssSelector(".ant-select-item-option")).get(1);

		    WebElement dropdownMenu_model1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ant-select ant-select-in-form-item ant-select-single ant-select-show-arrow']")));
		    WebElement secondOption_model = dropdownMenu_model1.findElements(By.cssSelector(".ant-select-item-option-content")).get(1);
		    secondOption_model.click();

		    WebElement locationInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='location']")));
		    locationInput.sendKeys("Punjab");

		    WebElement modulesUsedInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='modulesUsed']")));
		    modulesUsedInput.sendKeys("demoo");

		    WebElement invertersUsedInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='invertersUsed']")));
		    invertersUsedInput.sendKeys("String");

		    WebElement kwInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='kw']")));
		    kwInput.sendKeys("20000");
		    driver.findElement(By.xpath("//button[@type='submit']")).click();

		    driver.findElement(By.xpath("//button[@type='button']")).click();
		    driver.findElement(By.xpath(" //button[@title='SKIP']")).click();
		    //driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default go-back-btn']")).click();
		    driver.findElement(By.xpath("//p[normalize-space()='My Projects']")).click();
		    driver.findElement(By.xpath("//button[@title='SKIP']")).click();
		  
	    }
	    
	    

	        
	        
	}
	
	
	    

	    

	    
	        



	

