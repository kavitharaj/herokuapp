package testCases;
import org.testng.TestNG;

import testCases.TC_LO_001_Login;
import utilititiesClass.extentReportUtility;

public class TestRunner {
	static TestNG testng;

	public static void main(String[] args) {
		/*
		 * // TODO Auto-generated method stub extentReportUtility ext=new
		 * extentReportUtility(); testng = new TestNG(); 
		 * testng.setTestClasses(new class[]{ homepage.class }); testng.addListener(ext); testng.run();
		 */
		
		extentReportUtility tla = new extentReportUtility();
	    TestNG testng = new TestNG();
	    testng.setTestClasses(new Class[] { TC_LO_001_Login.class });
	    testng.addListener(tla);
	    testng.run();

	}

}
