package pompages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class EnterTimeTrackPAge {
	@FindBy(xpath="//span[contains(text(), 'Help')]")
	WebElement helpmenu;
	@FindBy(xpath="//div[contains(text(), 'About actiTIME')]")
	WebElement AboutActitimeLink;
	@FindBy(xpath="(//span[contains(text(),'actiTIME')])[1]")
	WebElement productVersion;
	@FindBy(xpath="//img[contains(@ class , 'close')]")
	WebElement closepopWindow;
	@FindBy(xpath="//a[contains(text(), 'Logout')]")
	WebElement LogoutBun;
	public EnterTimeTrackPAge(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	public void ClickHelpMenu(){
		helpmenu.click();
	}
	public void ClickAboutActiTImeLink(){
		AboutActitimeLink.click();
	}
	public String getProductVersion(){
		return productVersion.getText();
	}
	public void ClickClosePopup(){
		closepopWindow.click();
	}
	public void ClickLogout(){
		LogoutBun.click();
	}
}
