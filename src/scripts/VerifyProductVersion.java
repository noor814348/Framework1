package scripts;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import generic.BaseTest;
import generic.Lib;
import pompages.EnterTimeTrackPAge;
import pompages.LoginPage;
public class VerifyProductVersion extends BaseTest{

	WebDriverWait wait;
	@Test
	public void testProductVersion() throws Exception{
		LoginPage l= new LoginPage(driver);

		String username=Lib.getCellValue("ValidLogin", 1, 0);
		l.setUsername(username);
		String password =Lib.getCellValue("ValidLogin", 1, 1);
		l.setPassword(password);
		l.clickLogin();
		System.out.println(driver.getTitle());
		wait=new WebDriverWait(driver, 30);
		String title = Lib.getCellValue("ProductVersion", 1, 0);
		System.out.println(title);
		wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.titleIs(title));
		EnterTimeTrackPAge e=new EnterTimeTrackPAge(driver);
		e.ClickHelpMenu();
		e.ClickAboutActiTImeLink();
		String ExpectedProductVersion = Lib.getCellValue("ProductVersion", 1, 1);
		System.out.println(ExpectedProductVersion);
		String ActualProductVersion = e.getProductVersion();
		System.out.println(ActualProductVersion);

		SoftAssert s =new SoftAssert();
		s.assertEquals(ExpectedProductVersion, ActualProductVersion);
		e.ClickClosePopup();
		//Thread.sleep(20000);
		e.ClickLogout();
		s.assertAll();

	}

}
