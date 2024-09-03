package Safearth_CommonFiles;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import utilities.testUtils;

public class Listeners extends testUtils implements ITestListener {
public void onTestFailure(ITestResult result) {
	System.out.println("Test failed -screenshot captured");
	try {
		getScreenshots();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
