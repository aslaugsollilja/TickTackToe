package bjorklubburinn.tictactoe;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class resetGameIT {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://localhost:4567/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void resetGameIT() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.cssSelector("input[type='submit']")).click();
    driver.findElement(By.name("boardValues")).click();
    driver.findElement(By.cssSelector("input[type='submit']")).click();
    try 
    {
      assertEquals("X", driver.findElement(By.id("c0")).getText());
    }
    catch (Error e) 
    {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.xpath("//input[@value='Reset game']")).click();
    try 
    {
      assertEquals("", driver.findElement(By.id("c0")).getText());
    } 
    catch (Error e) 
    {
      verificationErrors.append(e.toString());
    }
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) 
    {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try 
    {
      driver.findElement(by);
      return true;
    } 
    catch (NoSuchElementException e) 
    {
      return false;
    }
  }
}
