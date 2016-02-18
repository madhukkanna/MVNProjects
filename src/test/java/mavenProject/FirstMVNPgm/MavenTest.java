package mavenProject.FirstMVNPgm;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MavenTest {
static WebDriver driver;
static int i=1;
	@Test
	public void testname(){
		System.out.println("Welcome to Maven :)");
		driver = new FirefoxDriver();
	/*	driver.get("http://java.com");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();*/
		
		driver.get("http://jqueryui.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.linkText("Draggable")).click();
		snap();
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		WebElement drag = driver.findElement(By.id("draggable"));
		Actions act = new Actions(driver);
		act.dragAndDropBy(drag, 120,140).build().perform();
		snap();
		driver.switchTo().defaultContent();
		driver.findElement(By.linkText("Selectable")).click();
		driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
		WebElement ele1 = driver.findElement(By.xpath("//*[@id='selectable']/li[1]"));
		WebElement ele2 = driver.findElement(By.xpath("//*[@id='selectable']/li[2]"));
		WebElement ele3 = driver.findElement(By.xpath("//*[@id='selectable']/li[3]"));
		WebElement ele4 = driver.findElement(By.xpath("//*[@id='selectable']/li[4]"));
		WebElement ele5 = driver.findElement(By.xpath("//*[@id='selectable']/li[5]"));
		WebElement ele6 = driver.findElement(By.xpath("//*[@id='selectable']/li[6]"));
		WebElement ele7 = driver.findElement(By.xpath("//*[@id='selectable']/li[7]"));
		
		act.keyDown(Keys.CONTROL).click(ele1).click(ele4).click(ele7).build().perform();
		snap();
		driver.close();
		
	}
	private void snap() {
		// TODO Auto-generated method stub
		File src  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("d://screenshots/ image" + i + ".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		i++;
	}

}
