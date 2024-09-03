package utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Safearth_CommonFiles.BaseTest;

public class testUtils extends BaseTest{
public void getScreenshots () throws IOException {
	Date currentdate=new Date();
	String screenshotFileName=currentdate.toString().replace(" ", "-").replace(":", "-");
	File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(screenshotFile, new File(".//screenshot//"+screenshotFileName+".png"));
}
}
