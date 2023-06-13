package com.pages.framework;

import org.openqa.selenium.By;

public class RBIPage implements IPage {

    public static By passwordRBI = By.xpath("//input[@name = 'password']");
    public static By submitRBI = By.cssSelector(".button");
    public static By canadaEnglishRBI = By.xpath("//span[starts-with(text(), 'Canada')][1]");
    public static By applyRBI = By.xpath("//button[starts-with(text(), 'Apply')]");
    public static By chooseYourLocation = By.xpath("//button[@data-testid='bottom-service-location']");
    public static By pickUpRBI = By.xpath("//div[starts-with(text(), 'Pick Up')]");
    public static By yourAddressRBI = By.xpath("//input[@id = 'storelocator-input']");
    public static By austin = By.xpath("//button[@data-testid='prediction-0']/child::span[1]");
    public static By austinBtn = By.xpath("//button[@data-storetitle='1 Austin Terrace']");
    public static By order = By.xpath("//button[contains(text(),'Order')][1]");
    public static By emailPassword = By.xpath("//*[contains(text(), 'E-mail / password')]");
    public static By userName = By.xpath("//input[1]");
    public static By password = By.xpath("//input[@type = 'password']");
    public static By logIn = By.xpath("//canvas[1]");
    public static By search = By.xpath("//input");
    public static By rbiOffer = By.xpath("//*[@data-ui='AutocompleteOption']//child::div[@data-ui='Stack']");
    public static By rbiDropDown = By.xpath("(//*[@data-sanity-icon='chevron-down'])[4]");
    public static By duplicate = By.xpath("//span[starts-with(text(),'Duplicate')]");
    public static By delete = By.xpath("//span[starts-with(text(),'Delete')]");
    public static By deleteNow = By.xpath("//span[contains(text(), 'Delete now')]");
    //Offer Name Objects
    public static By offerName = By.xpath("//div[@class='header_mainNav_1CJvv']//child::span[*]//child::span[1]");
    public static By offerNameField = By.xpath("(//*[@data-testid='scroll-container'])[2]");
    public static By rbiOfferNameUpdate = By.xpath("//*[@data-testid='input-name']//child::*[@data-slate-node='text']");
    //Offer Header Text To Update
    public static By rbiOfferHeaderText = By.xpath("(//input[@data-as='input'])[2]");
    public static By rbiOfferImageDesc = By.xpath("//*[@data-testid='input-imageDescription']//input");
    //Offer Short Code Objects
    public static By rbiOfferShortCodeField = By.xpath("//*[@data-testid='input-shortCode']");
    public static By rbiOfferShortCode = By.xpath("//*[@data-testid='input-shortCode']//child::input");
    //Ends
    //Offer Price Objects
    public static By rbiOfferPriceField = By.xpath("//*[@data-testid='input-offerPrice']");
    public static By rbiOfferPrice = By.xpath("//*[@data-testid='input-offerPrice']//child::input");
    public static By rbiForm = By.xpath("//form");
    //Offer Description Objects - Starts
    public static By rbiOfferDescriptionField = By.xpath("//*[@data-testid='input-description']");
    public static By rbiOfferDescription = By.xpath("(//*[@data-testid='scroll-container']//child::span[@data-slate-node = 'text'])[2]");
    //Offer Description Objects - Ends
    public static By rbiOfferAddTags = By.xpath("//*[@data-focus-path='offerTags']//descendant::span[starts-with(text(), 'Add')]");
    public static By rbiOfferAddTagsInput = By.xpath("//h1[contains(text(), 'Reference to tag')]/following::input");
    //More Info Objects Starts
    public static By rbiOfferMoreInfoField = By.xpath("//*[@data-testid='input-moreInfo']");
    public static By rbiOfferMoreInfo = By.xpath("//*[@data-testid='input-moreInfo']//child::*[@data-slate-node='text']");
    //More Info Objects Ends
    //How To Redeem Objects Starts
    public static By rbiOfferHowToRedeemField = By.xpath("//*[@data-testid='input-howToRedeem']");
    public static By rbiOfferHowToRedeem = By.xpath("//*[@data-testid='input-howToRedeem']//child::*[@data-slate-node='text']");
    //How To Redeem Objects Ends
    //UI Patterns Objects
    public static By rbiOfferUIPatternField = By.xpath("//*[@data-testid='input-uiPattern']");
    public static By rbiOfferUIPattern = By.xpath("//*[@data-testid='input-uiPattern']//child::select");
    //Ends
    public static By rbiOfferUIPatternStandardOffer = By.xpath("//*[contains(text(), 'Standard offer')]");
    public static By rbiOfferUIPatternLockedOfferProgressBar = By.xpath("//*[contains(text(), 'Locked offer progress bar')]");
    public static By rbiOfferUIPatternLockedOfferList = By.xpath("//*[contains(text(), 'Locked offer list')]");
    public static By rbiOfferUIPatternPromoCodeOffer = By.xpath("//*[contains(text(), 'Promo code offer')]");
    public static By rbiOfferUIPatternCartPromoCodeOffer = By.xpath("//*[contains(text(), 'Cart promo code')]");
    //Redemption Method Objects
    public static By rbiOfferRedemptionMethodsField = By.xpath("//*[@data-testid='input-redemptionMethod']");
    public static By rbiOfferRedemptionMethodsRestaurant = By.xpath("//*[starts-with(text(), 'Mobile and in restaurant')]//preceding::*[@data-ui = 'Radio'][3]");
    public static By rbiOfferRedemptionMethodsMobile = By.xpath("//*[starts-with(text(), 'Mobile and in restaurant')]//preceding::*[@data-ui = 'Radio'][2]");
    public static By rbiOfferRedemptionMethodsMobileAndRestaurant = By.xpath("//*[starts-with(text(), 'Mobile and in restaurant')]//preceding::*[@data-ui = 'Radio'][1]");
    //Ends
    //Vendor Config Object
    public static By rbiOfferVendorConfig = By.xpath("//*[@data-testid='input-vendorConfigs']");
    public static By rbiOfferVendorConfigArrowIcon = By.xpath("//*[@data-testid='input-vendorConfigs']//child::*[@data-sanity-icon = 'toggle-arrow-right']");
    //Sicom Objects
    public static By rbiOfferVendorConfigSicom = By.xpath("//*[@data-testid='input-sicom']//child::*[@data-sanity-icon = 'toggle-arrow-right']");
    public static By rbiOfferVendorConfigSicomPLUType = By.xpath("//*[@data-testid='input-sicom']//child::select");
    public static By rbiOfferVendorConfigSicomConstantPLUValue = By.xpath("//*[@data-testid='input-sicom']//child::*[@data-testid = 'input-constantPlu']//child::input");
    //Sicom Delivery Objects
    public static By rbiOfferVendorConfigSicomDelivery = By.xpath("//*[@data-testid='input-sicomDelivery']//child::*[@data-sanity-icon = 'toggle-arrow-right']");
    public static By rbiOfferVendorConfigSicomDeliveryPLUType = By.xpath("//*[@data-testid='input-sicomDelivery']//child::select");
    public static By rbiOfferVendorConfigSicomDeliveryConstantPLUValue = By.xpath("//*[@data-testid='input-sicomDelivery']//child::*[@data-testid = 'input-constantPlu']//child::input");
    //Vendor Config NCR Objects
    public static By rbiOfferVendorConfigNCR = By.xpath("//*[@data-testid='input-ncr']//child::*[@data-sanity-icon = 'toggle-arrow-right']");
    public static By rbiOfferNCRSizeBasedPLU = By.xpath("//*[@data-testid='input-ncr']//child::select");
    public static By rbiOfferNCRSizeBasedPLUInput = By.xpath("//*[@data-testid='input-ncr']//child::*[@data-testid='input-sizeBasedPlu']//child::*[@data-sanity-icon = 'toggle-arrow-right']");
    public static By rbiOfferNCRSizeBasedCombo = By.xpath("//*[@data-testid='input-ncr']//child::*[@data-testid='input-sizeBasedPlu']//child::input");
    public static By rbiOfferNCRComboSize = By.xpath("//*[@data-testid='input-ncr']//child::*[@data-testid='input-sizeBasedPlu']//child::select");
    //Vendor Config NCR Delivey Objects
    public static By rbiOfferVendorConfigNCRDelivery = By.xpath("//*[@data-testid='input-ncrDelivery']//child::*[@data-sanity-icon = 'toggle-arrow-right']");
    public static By rbiOfferNCRSizeBasedPLUDelivery = By.xpath("//*[@data-testid='input-ncrDelivery']//child::select");
    public static By rbiOfferNCRSizeBasedPLUInputDelivery = By.xpath("//*[@data-testid='input-ncrDelivery']//child::*[@data-testid='input-sizeBasedPlu']//child::*[@data-sanity-icon = 'toggle-arrow-right']");
    public static By rbiOfferNCRSizeBasedComboDelivery = By.xpath("//*[@data-testid='input-ncrDelivery']//child::*[@data-testid='input-sizeBasedPlu']//child::input");
    public static By rbiOfferNCRComboSizeDelivery = By.xpath("//*[@data-testid='input-ncrDelivery']//child::*[@data-testid='input-sizeBasedPlu']//child::select");
    //Vendor Config Carrols Objects
    public static By rbiOfferVendorConfigCarrols = By.xpath("//*[@data-testid='input-carrols']//child::*[@data-sanity-icon = 'toggle-arrow-right']");
    public static By rbiOfferVendorConfigCarrolsConstantPlu = By.xpath("//*[@data-testid='input-carrols']//child::select");
    public static By rbiOfferVendorConfigCarrolsPluValue = By.xpath("//*[@data-testid='input-carrols']//child::*[@data-testid='input-constantPlu']//child::input");
    // RuleSetObjects
    public static By ruleSet = By.xpath("//*[@data-testid='input-ruleSet']");
    public static By ruleSetDelete = By.xpath("//*[@data-testid='input-ruleSet']//child::*[@data-sanity-icon = 'trash']");
    public static By ruleSetRemoveItem = By.xpath("//*[contains(text(), 'Remove item')]");
    public static By ruleSetAdd = By.xpath("//*[@data-testid='input-ruleSet']//child::*[starts-with(text(), 'Add item')]");
    public static By ruleSetAnd = By.xpath("//*[@data-ui = 'MenuButton__popover']//child::*[starts-with(text(), 'And')]");
    public static By ruleSetAndAddItem = By.xpath("(//*[starts-with(text(), 'Add item')])[6]");
    public static By ruleSetAndLimit = By.xpath("//*[starts-with(text(), 'Limit')]");
    public static By ruleSetAndLimitMaximumRedemptions = By.xpath("//*[@data-testid='input-maximumRedemptions']//child::input");
    public static By ruleSetAndLimitMaximumRedemptionsInterval = By.xpath("//*[@data-testid='input-interval']//child::select");
    public static By ruleSetAndLimitMaximumRedemptionsClose = By.xpath("(//*[@data-sanity-icon='close'])[3]");
    public static By ruleSetAndClose = By.xpath("(//*[@data-sanity-icon='close'])[2]");

    public static By ruleSetOr = By.xpath("//*[@data-ui = 'MenuButton__popover']//child::*[starts-with(text(), 'Or')]");
    public static By ruleSetLimit = By.xpath("//*[@data-ui = 'MenuButton__popover']//child::*[starts-with(text(), 'Limit')]");
    public static By ruleSetEditAndAddItem = By.xpath("//*[@data-ui='Menu']//child::*[contains(text(), 'And')]");
    // RBI Option Objects
    public static By option = By.xpath("//*[@data-testid='input-option']");
    public static By option_Expand = By.xpath("//*[@data-testid='input-option']//child::*[@data-sanity-icon = 'chevron-down']");
    public static By option_SelectFirst = By.xpath("(//*[@data-ui='Popover']//child::h2)[1]");

    //rPin Objects
    public static By rpin_UserName = By.xpath("//*[@class = 'MuiCardContent-root']//input[@type = 'text']");
    public static By rpin_Password = By.xpath("//*[@class = 'MuiCardContent-root']//input[@type = 'password']");
    public static By rpin_Login = By.xpath("//*[@class='MuiButton-label']");
    public static By rpin_BKUS = By.xpath("//table[@class = 'MuiTable-root']//span[. = 'Burger King US']");
    public static By rpin_BKUSMenu = By.xpath("(//button[@aria-label='Menu']//*[local-name()='path'])[2]");
    public static By rpin_BKUSEmployees = By.xpath("//*[@class = 'MuiButton-label']//span[contains(text(),'Employees')]");
    public static By rpin_BKUSNewEmployee = By.xpath("//table//span[contains(text(), 'New Employee')]");
    public static By rpin_BKUSSelectAStore = By.xpath("//span[contains(text(), 'Select')]");
    public static By rpin_BKUSACZStore = By.xpath("//label[normalize-space()='7879 - ACZ']");
    public static By rpin_BKUSEmployeeCode = By.xpath("(//input[@type='number'])[1]");
    public static By rpin_BKUSEmployeeHRCode = By.xpath("(//input[@type='number'])[2]");
    public static By rpin_BKUSEmployeeBadgeNumber = By.xpath("//*[contains(text(),'Generate')]");
    public static By rpin_BKUSEmployeeName = By.xpath("(//input[@type='text'])[2]");
    public static By rpin_BKUSEmployeelevel = By.xpath("(//div[@class = 'MuiSelect-root'])[1]");
    public static By rpin_BKUSEmployeelevelEmployee = By.xpath("//ul[@role='listbox']//li[contains(text(), 'Employee')]");
    public static By rpin_BKUSEmployeePayment = By.xpath("(//div[@class = 'MuiSelect-root'])[2]");
    public static By rpin_BKUSEmployeePaymentRate = By.xpath("//ul[@role='listbox']//li[contains(text(), 'Hourly')]");
    public static By rpin_BKUSEmployeeSalary = By.xpath("(//input[@type='number'])[4]");
    public static By rpin_BKUSEmployeeAdmission = By.xpath("(//input[@type='text'])[3]");
    public static By rpin_BKUSEmployeeTermination = By.xpath("(//input[@type='text'])[4]");
    public static By rpin_BKUSEmployeeBirth = By.xpath("(//input[@type='text'])[5]");
    public static By rpin_BKUSEmployeeJob = By.xpath("(//input[@type='text'])[6]");
    public static By rpin_BKUSEmployeePassword = By.xpath("(//input[@type='password'])[1]");
    public static By rpin_BKUSEmployeeRePassword = By.xpath("(//input[@type='password'])[2]");
    public static By rpin_BKUSEmployeeExpiry = By.xpath("(//input[@type='text'])[7]");
    public static By rpin_Save_Button = By.xpath("(//*[. = 'Save'])[2]");
    public static By rpin_GlobalSearch = By.xpath("//*[@id = 'global-search']");
    public static By rPim_Admission_Calender = By.xpath("(//*[@class = 'MuiIconButton-label'])[4]");
    public static By rPim_Admission_Calender_22 = By.xpath("//*[@class = 'MuiIconButton-label']//p[. = '22']");
    public static By rPim_Termination_Calender = By.xpath("(//*[@class = 'MuiIconButton-label'])[5]");
    public static By rPim_Termination_Calender_30 = By.xpath("//*[@class = 'MuiIconButton-label']//p[. = '30']");
    public static By rPim_Birth_Calender = By.xpath("(//*[@class = 'MuiIconButton-label'])[6]");
    public static By rPim_Birth_Calender_10 = By.xpath("//*[@class = 'MuiIconButton-label']//p[. = '10']");
    public static By rPim_Expiry_Calender = By.xpath("(//*[@class = 'MuiIconButton-label'])[7]");
    // RBI POS Objects
    public static By pos_BreakFast = By.xpath("(//*[normalize-space()='Breakfast'])[2]");
    public static By pos_LunchDinner = By.xpath("(//*[starts-with(text(), 'Lunch')])[1]");
    public static By pos_Whoppers = By.xpath("//button[. = 'Whoppers']");
    public static By pos_SubmenuWhoppers = By.xpath("//button[.='Whopper']");
    public static By pos_SubmenuWhopper_Lane = By.xpath("//button//span[. = 'Lane 1']");
    public  static By pos_whopper_cheese = By.xpath("(//*[. = 'Cheese (1)'])[1]");
    public  static By pos_whopper_pickle = By.xpath("//*[starts-with(text(), 'Pickle')]");
    public  static By pos_whopper_Tomato = By.xpath("(//*[starts-with(text(), 'Tomato')])[1]");
    public  static By pos_whopper_Total = By.xpath("//button[. = 'Total']");
    public  static By pos_whopper_Cash = By.xpath("//span[contains(text(), 'Cash')]");
    public  static By pos_whopper_Cash_Ok = By.xpath("//table//span[.='Ok']");
    public  static By pos_whopper_Cash_PaidText = By.xpath("//span[starts-with(text(), 'Order id')]");
    public  static By pos_whopper_Cash_TotalValue = By.xpath("(//span[starts-with(text(), 'Total   : ')]//parent::div/../div)[1]");


}
