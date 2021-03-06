

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalendarCoverageTest {
	FirefoxDriver driver;
	String baseUrl = "http://localhost/wordpress";

	@Before
	public void initDriver() throws Exception {
		Proxy proxy = new Proxy().setHttpProxy("localhost:8080");
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.PROXY, proxy);
		driver = new FirefoxDriver(cap);
		//driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@After
	public void close() {
		driver.get("http://localhost/jscoverage.html");

		new WebDriverWait(driver, 1).until(ExpectedConditions
				.elementToBeClickable(By.id("storeTab")));
		driver.findElement(By.id("storeTab")).click();

		new WebDriverWait(driver, 10)
				.until(ExpectedConditions.textToBePresentInElementLocated(
						By.id("progressLabel"), "Done"));
		new WebDriverWait(driver, 10).until(ExpectedConditions
				.elementToBeClickable(By.id("storeButton")));
		driver.findElement(By.id("storeButton")).click();
		new WebDriverWait(driver, 10).until(ExpectedConditions
				.textToBePresentInElementLocated(By.id("storeDiv"),
						"Coverage data stored at"));
		driver.quit();
	}

	@Test
	public void login() throws Exception {
		driver.get(baseUrl);
		//driver.findElement(By.xpath("//*[@id=\"post-15\"]/div/p/div/div/span[2]")).click();
	}
}
