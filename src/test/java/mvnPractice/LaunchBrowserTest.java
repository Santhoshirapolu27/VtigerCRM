package mvnPractice;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchBrowserTest {
		@Test
		public void launchBrowserTest() throws InterruptedException {
			WebDriver driver = null;
			String browser = System.getProperty("Browser");
			String url = System.getProperty("URL");
			switch(browser) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
				break;
			default:
				System.out.println("Invalid browser info");
			}		
			driver.manage().window().maximize();
			driver.get(url);
			Thread.sleep(3000);
			driver.close();
		}

}
