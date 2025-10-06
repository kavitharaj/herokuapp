package utilititiesClass;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class extentReportUtility implements ITestListener {
	public String reportname;
	public ExtentSparkReporter sparkreporter;
	public ExtentReports extentreport;
	public ExtentTest test;

	public void onStart(ITestContext testcontext) {

		String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

		reportname = "Test_report" + timestamp + ".html";

		sparkreporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//reports//" + reportname);

		sparkreporter.config().setDocumentTitle("herokuApp");
		sparkreporter.config().setReportName("Qc Functional Testing");
		sparkreporter.config().setTheme(Theme.DARK);

		extentreport = new ExtentReports();
		extentreport.attachReporter(sparkreporter);

		extentreport.setSystemInfo("Application", "herokuApp");
		extentreport.setSystemInfo("UserName", System.getProperty("user.name"));

	}
	
	public void onTestSuccess(ITestResult result) {
		test=extentreport.createTest(result.getTestClass().getName());
		//test.assignCategory(result.getMethod().getGroups());
		test.log(Status.PASS, result.getName()+"-----------**Success**");
		}
	public void onTestFailure(ITestResult result) {
		test=extentreport.createTest(result.getTestClass().getName());
		//test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, result.getName()+"----Failed");
		test.log(Status.INFO,result.getThrowable().getMessage());
		}
	public void onTestSkipped(ITestResult result) {
		test=extentreport.createTest(result.getTestClass().getName());
		//test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getName()+"----Failed");
		test.log(Status.INFO,result.getThrowable().getMessage());
		}
	public void onFinish(ITestContext testcontext) {
		extentreport.flush();
	}

}
