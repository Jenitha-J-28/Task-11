package SeliniumAutomationTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class frameTest {
		WebDriver driver;
		String Url = "http://the-internet.herokuapp.com/nested_frames", firstFrame, SecondFrame, ThirdFrame,BottomFrame,title;

		public void launchBrowser() {
			driver = new ChromeDriver();
					}
		public void launchApp() {
			driver.get(Url);
			driver.manage().window().maximize();
		}
		public void switchFrame() {
			
			driver.switchTo().frame("frame-top");
			//List<WebElement> frameNo = driver.findElements(By.name("frameset-middle"));
			int frameNo = driver.findElements(By.tagName("frame")).size();
			System.out.println("No of frames inside the top frame are: " + frameNo );
			//Switch to LEFT frame
			driver.switchTo().frame("frame-left");
			firstFrame = driver.findElement(By.xpath("//*[contains(text(),'LEFT')]")).getText();
			System.out.println("The text inside the first frame is : " + firstFrame);
			//Switch to TOP Frame
			driver.switchTo().parentFrame();
			
			//Switch to MIDDLE frame
			driver.switchTo().frame("frame-middle");
			SecondFrame = driver.findElement(By.xpath("//*[@id='content']")).getText();
			System.out.println("The text inside the second frame is : " + SecondFrame);
			//Switch to TOP Frame
			driver.switchTo().parentFrame();
			
			//Switch to RIGHT frame
			driver.switchTo().frame("frame-right");
			ThirdFrame = driver.findElement(By.xpath("//*[contains(text(),'RIGHT')]")).getText();
			System.out.println("The text inside the second frame is : " + ThirdFrame);
			//Switch to TOP Frame
			driver.switchTo().parentFrame();
		}
		public void switchToBottom() {
			driver.switchTo().parentFrame();
			//Switch to BOTTOM frame
			driver.switchTo().frame("frame-bottom");
			BottomFrame = driver.findElement(By.xpath("//*[contains(text(),'BOTTOM')]")).getText();
			System.out.println("The text inside the BOTTOM frame is : " + BottomFrame);
			//Switch to TOP Frame
			driver.switchTo().parentFrame();
			driver.switchTo().defaultContent();
			title = driver.getTitle();
			System.out.println("The title of the page is : "+ title);
			driver.quit();
		}
	public static void main(String[] args) {
		frameTest test = new frameTest();
		test.launchBrowser();
		test.launchApp();
		test.switchFrame();
		test.switchToBottom();

	}

}
