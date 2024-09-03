package Safearth_CommonFiles;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.io.IOException;
import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

public class demo {
	public class LoginPageTestCases111 extends BaseTest {
		String apiKey = "xbSxLyfgDYULM39uY1Hr6oc5BHMbxdAf";
	    String serverId = "jedfm1s4";
	    String serverDomain = "jedfm1s4.mailosaur.net";
	    public String getRandomEmail1() {
	    	return "user"+ System.currentTimeMillis()+ "@"+serverDomain;
	    }

	@Test
	public void Signup1() throws InterruptedException, IOException, MailosaurException {
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
			//String emailId=getRandomEmail();
			driver.findElement(By.xpath("(//div[@class='ant-row ant-row-middle user-wrapper'])[1]")).click();
			driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Arpitha_test");
			driver.findElement(By.xpath("//input[@id='companyName']")).sendKeys("demo_test");
			driver.findElement(By.xpath("//input[@id='phone']")).sendKeys("6523564585");
			driver.findElement(By.xpath("//input[@id='email']")).sendKeys("level-tried@"+serverDomain);
			driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default get-otp-btn']")).click();
			Thread.sleep(10000);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(80));
			driver.findElement(By.xpath("//button[@class='ant-btn ant-btn-default signup-btn']")).click();
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("solar1234");
			driver.findElement(By.xpath("//input[@id='confirm']")).sendKeys("solar1234");
			MailosaurClient mailosaur = new MailosaurClient(apiKey);

		    MessageSearchParams params = new MessageSearchParams();
		    params.withServer(serverId);

		    SearchCriteria criteria = new SearchCriteria();
		    criteria.withSentTo("level-tried@"+serverDomain);
		    com.mailosaur.models.Message message = mailosaur.messages().get(params, criteria);
		    System.out.println(message.subject());

		    assertNotNull(message);
		    assertEquals("OTP for Auction Platform", message.subject());
		    System.out.println(message.text().body()); // "Your access code is 243546."

		    //Pattern pattern = Pattern.compile(".*([0-9]{6}).*");
		   // Matcher matcher = pattern.matcher(message.text().body());
		   // matcher.find();

		    //System.out.println(matcher.group(1)); // "243546"

		    System.out.println(message.html().codes().size()); // 2

		    com.mailosaur.models.Code firstCode = message.html().codes().get(0);
		    System.out.println(firstCode.value());
		    String otp=firstCode.value();
		    driver.findElement(By.xpath("//input[@id='otp']")).sendKeys(otp);
		       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		       //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']"))).click();   
		}
	}

	@Test
	public void Signup11() throws InterruptedException, IOException, MailosaurException {
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
			String emailId=getRandomEmail1();
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

		    //System.out.println(matcher.group(1)); // "243546"

		    System.out.println(message.html().codes().size()); // 2

		    com.mailosaur.models.Code firstCode = message.html().codes().get(0);
		    System.out.println(firstCode.value());
		    String otp=firstCode.value();
		    driver.findElement(By.xpath("//input[@id='otp']")).sendKeys(otp);
		       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		       //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']"))).click();   
		}
	}
	/*public Object waitForEmail(String emailId,MailosaurClient mailosaur)throws MailosaurException {
	Wait<MailosaurClient> wait=new FluentWait<>(mailosaur)
			.withTimeout(Duration.ofSeconds(30))
			.pollingEvery(Duration.ofMillis(100))
			.ignoring(Exception.class);
	return wait.until(mailosaurClient -> {
		try {
			MessageSearchParams params=new MessageSearchParams();
			params.withServer(serverId);
			SearchCriteria criteria=new SearchCriteria();
			criteria.withSentTo(emailId);
		com.mailosaur.models.Message message =mailosaurClient.messages().get(params,criteria);
		return message;
		}catch(MailosaurException | IOException e) {
			return null;
			
		}
		
	});
*/
	}
	


}

