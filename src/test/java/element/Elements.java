package element;
import org.openqa.selenium.By;

public class Elements {
	
	public final By passwordTextBox = By.cssSelector("input[name='password']");
	public final By submitBtn = By.xpath("//button[contains(.,'Submit')]");
	public final By radioCanEn = By.xpath("//label[@for='radio-button-0']");
	public final By radioCanFr = By.xpath("//label[@for='radio-button-2']");
	public final By radioUsEn = By.xpath("//div[@data-testid='dialog-button-en-us_label']");
	public final By applyBtn = By.xpath("//button[contains(.,'Apply')]");
	//public final By loginBtn = By.xpath("//button[contains(.,'Log In')]");
	public final By loginBtn = By.xpath("//button[@class='build__BaseButton1-b7zorw-15 hcBewk build__OutlineButton-b7zorw-16 build__BaseInverseButton-b7zorw-20 jZrbNj liRVIx']");
	public final By emailTextBox = By.xpath("(//input[@type='email'])[2]");
	//public final By signInBtn = By.xpath("(//button[contains(.,'Log In')])[2]");
	public final By signInBtn = By.xpath("//button[@type='submit'][normalize-space()='Sign In']");
	public final By verifyText = By.xpath("//p[contains(.,'We sent an email with login instructions')]");
	public final By verifyLocText = By.xpath("//h1[contains(.,'Locations')]");
	public final By verifyMenuText = By.xpath("//h1[contains(.,'Menu')]");
	public final By pickupLink = By.xpath("//label[contains(.,'Pick Up')]");
	public final By deliveryLink = By.xpath("//label[contains(.,'Delivery')]");
	public final By favouritesLink = By.cssSelector("button#tab-1");
	public final By locationsList = By.xpath("//button[@class='unstyled-button__UnstyledButton-sc-15lagcm-0 store-cardstyled__CardButton-sc-1s810z7-1 jglWIF jqQWFE']");
	public final By accountLink = By.xpath("//div[contains(text(),'Sanket')]");
	//public final By accountLink = By.xpath("//div[contains(text(),'Priyo')]");
	public final By OtpTextBox = By.cssSelector("input[data-testid='OTP-code-input']");
	public final By locationLink = By.xpath("//button[@data-testid='bottom-service-location']");
	public final By orderBtn = By.xpath("(//button[@data-testid='store-action-button']/div)[2]");
	public final By addToCartBtn = By.xpath("//button[contains(.,'Add ')]");
	public final By cartIcon = By.xpath("//button[@data-testid='cart-button-desktop']");
	public final By checkoutBtn = By.xpath("//button[contains(.,'Checkout')]");
	public final By continueBtn = By.xpath("//button[contains(.,'Continue')]");
	public final By placeDuplicateOrder = By.xpath("//button[contains(.,'Place Order')]");
	public final By placeOrderBtn = By.xpath("//button[contains(.,' Place Secure Order')]");
	public final By relodplaceOrderBtn = By.xpath("//button[contains(.,'place order')]");
	public final By viewRecieptLink = By.xpath("//a[contains(.,'View Receipt')]");
	public final By homeBtn = By.xpath("//button[contains(.,'Home')]");
	public final By orderNo = By.xpath("//p[@data-testid='order-number']");
	//public final By orderNo = By.xpath("//p[@data-testid='order-number']");
	public final By ordrHeaderBtn = By.xpath("//a[@data-testid='Menu']");
	//public final By ordrHeaderBtn = By.xpath("//a[@data-testid='Order']");
	public final By sizesAccordion = By.xpath("//div[@aria-controls='Size-selection-content']");
	public final By sizeOptions = By.xpath("//input[@type='radio' and @name='Size']/parent::div");
	public final By cartPrice = By.xpath("//div[starts-with(@class,'indexth__PriceContainer')]/span");
	public final By subTotalPrice = By.xpath("//span[@data-testid='subtotal']");
	public final By storeCloseOkBtn = By.xpath("//button[contains(.,'Okay')]");
	public final By languageFooter = By.xpath("//span[contains(.,'en/US')]");
	public final By locationLinkFooter = By.xpath("//button[@data-testid='bottom-service-location']");
	public final By orderConfirmationPrice = 
			By.xpath("//div[starts-with(@class,'cart-entry')]/div[contains(.,'Price: $')]");

}
