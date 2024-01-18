package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reporter
{
        public static ExtentReports getReportObject()
        {
            String path = System.getProperty("user.dir")+"\\src\\main\\java\\reports\\index.html";
            ExtentSparkReporter reporter = new ExtentSparkReporter(path);
            reporter.config().setReportName("Web automation Results");
            reporter.config().setDocumentTitle("Set the document title");

            ExtentReports extentReport = new ExtentReports();
            extentReport = new ExtentReports();
            extentReport.attachReporter(reporter);
            extentReport.setSystemInfo("Tester", "Razak");

            return extentReport;
        }
}

