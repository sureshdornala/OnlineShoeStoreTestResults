package com.adp.wfnddt.components.people.benefits.OnlineShoeStore;


import java.io.IOException;
import java.net.MalformedURLException;
import javax.xml.datatype.DatatypeConfigurationException;
import org.openqa.selenium.WebDriver;
import com.adp.wfnddt.aspects.Component;
import com.adp.wfnddt.commonmethods.General;
import com.adp.wfnddt.core.BrowserManager;
import com.adp.wfnddt.core.DDTComponentBase;
import com.adp.wfnddt.core.DDTController;
import com.adp.wfnddt.core.DDTFrameworkException;
import com.adp.wfnddt.objectmanager.ObjectTypes;
import com.adp.wfnddt.objectmanager.WebObject;
import com.adp.wfnddt.parammanager.ParamManager;
import com.adp.wfnddt.results.DDTResultsReporter;


public class OnlineShoeStore  extends DDTComponentBase {

	protected static WebDriver m_webdriver = DDTController.getWebDriver();
	private static final String OR_Path = "/Objects/Benefits/OnlineShoeStore/OnlineShoeStore.json";
	private DDTResultsReporter m_results = DDTController.getResultsReporter();

	public OnlineShoeStore() throws DDTFrameworkException {
		loadObjectRepository(OR_Path);
	}

	
	//Component Template for Verify 
	@Component(Name = "Verify Template", Params = {"label1","label2","label3","label4","label5","label6","label7","label8","label9"})
	public void verifyTemplate(ParamManager pm) throws DDTFrameworkException, DatatypeConfigurationException, IOException {
		ObjectTypes Page = Browser.Page("HomePage");
		m_results.startVerificationLogStep();
		
		
		m_results.endVerificationLogStep();
	
	}
	
	
	
	
// Launch OnlineShoeStore 
	
	@Component(Name = "Launch OnlineShoeStore", Params = {})
	public void launchOnlineShoeStore(ParamManager pm) throws DDTFrameworkException {
		
		try {
			m_webdriver = BrowserManager.setupWebDriver();
			m_webdriver.get( "https://rb-shoe-store.herokuapp.com/" );
			General.sleep(5);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DDTFrameworkException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
/// Verify HomePage
	
	@Component(Name = "Verify HomePage", Params = {"label1","label2","label3","label4","label5","label6","label7","label8","label9"})
	public void verifyHomePage(ParamManager pm) throws DDTFrameworkException, DatatypeConfigurationException, IOException {
		
		ObjectTypes Page = Browser.Page("HomePage");

		m_results.startVerificationLogStep();

		Page.WebObject("Welcome to Shoe Store!").verifyValue(pm.Parameter("label1"));
		Page.WebObject("Pre-Order your shoes today").verifyValue(pm.Parameter("label2"));
		Page.WebObject("Choose a brand").verifyValue(pm.Parameter("label3"));
		Page.WebObject("Remind me of new shoes").verifyValue(pm.Parameter("label4"));
		Page.WebObject("Promotional Code").verifyValue(pm.Parameter("label5"));
		
			
		m_results.endVerificationLogStep();
		
	}
	
	@Component(Name = "Go Home", Params = {})
	public void goHome(ParamManager pm) throws DDTFrameworkException, DatatypeConfigurationException, IOException {
		
		ObjectTypes Page = Browser.Page("HomePage");
		Page.WebLink("Home").click();

		General.sleep(2);
	}
	
	//Enter Email Address
	@Component(Name = "Enter an Email Address", Params = {"label1"})
	public void enterAnEmailAddress(ParamManager pm) throws DDTFrameworkException, DatatypeConfigurationException, IOException {
		ObjectTypes Page = Browser.Page("HomePage");
		m_results.startVerificationLogStep();

		if (Page.WebTextBox("Enter Email Address").exists()) {
			Page.WebTextBox("Enter Email Address").click();
			Page.WebTextBox("Enter Email Address").set(pm.Parameter("label1"));
			Page.WebButton("Remind Email Submit").click();
		}
		else {
			System.out.println("Enter Email Address Textbox is not Available");
			}
		
		m_results.endVerificationLogStep();
	
	}
	
	//Enter Promotional Code
	@Component(Name = "Enter a Promotional Code", Params = {"label1"})
	public void enteraPromotionalCode(ParamManager pm) throws DDTFrameworkException, DatatypeConfigurationException, IOException {
		ObjectTypes Page = Browser.Page("HomePage");
		m_results.startVerificationLogStep();
		if (Page.WebTextBox("Enter Promotional Code").exists()) {
				Page.WebTextBox("Enter Promotional Code").click();
				Page.WebTextBox("Enter Promotional Code").set(pm.Parameter("label1"));
				Page.WebButton("Promotional Code Submit").click();
			}
		else {
				System.out.println("Enter Promotional Code TextBox is not Available");
			}
		
		m_results.endVerificationLogStep();
	
	}
	
	//Verify Alerts
	@Component(Name = "Verify Alerts", Params = {"label1"})
	public void verifyAlerts(ParamManager pm) throws DDTFrameworkException, DatatypeConfigurationException, IOException {
		ObjectTypes Page = Browser.Page("HomePage");
		m_results.startVerificationLogStep();
		Page.WebStatic("Alert Message").verifyValue(pm.Parameter("label1"));
		m_results.endVerificationLogStep();
	
	}
	
	//Verify Notice
	@Component(Name = "Verify Notice", Params = {"label1"})
	public void verifyNotice(ParamManager pm) throws DDTFrameworkException, DatatypeConfigurationException, IOException {
		ObjectTypes Page = Browser.Page("HomePage");
		m_results.startVerificationLogStep();
		Page.WebStatic("Notice Message").verifyValue(pm.Parameter("label1"));
		
		m_results.endVerificationLogStep();
	
	}
	
	
	@Component(Name = "Search By Brand", Params = {"label1" })
	public void seachByBrand(ParamManager pm) throws DDTFrameworkException, DatatypeConfigurationException, IOException {
		
		ObjectTypes Page = Browser.Page("HomePage");
		Page.WebComboBox("BrandName").select(pm.Parameter("label1"));
		General.sleep(2);
		Page.WebButton("Search By Brand").click();
		General.sleep(2);
	}
	
	/// Choose Option 
	//  option[contains(text(),'Select Brand')]  
	// option[contains(text(),pm.Parameter("label1")]  
	
	// Verify Results By Brand
	@Component(Name = "Verify Results By Brand", Params = {"label1","label2","label3","label4","label5","label6","label7","label8","label9"})
	public void verifyResultsByBrand(ParamManager pm) throws DDTFrameworkException, DatatypeConfigurationException, IOException {
		//ObjectTypes Page = Browser.Page("HomePage");
		
		
		//td[@class='shoe_result_value shoe_name']
		//td[@class='shoe_result_value shoe_price']
		String ShoeName =  "XPATH://td[@class='shoe_result_value shoe_name']";
		String ShoePrice =  "XPATH://td[@class='shoe_result_value shoe_price']";
		
		m_results.startVerificationLogStep();
		new WebObject(ShoeName).verifyValue(pm.Parameter("label1"));
		new WebObject(ShoePrice).verifyValue(pm.Parameter("label2"));
		m_results.endVerificationLogStep();
	}
	
	
	/// Page.WebLink("January").click();
	
	@Component(Name = "Search By Month", Params = {"label1" })
	public void seachByMonth(ParamManager pm) throws DDTFrameworkException, DatatypeConfigurationException, IOException {
		
		ObjectTypes Page = Browser.Page("HomePage");
		Page.WebLink(pm.Parameter("label1")).click();

		General.sleep(2);
	}
	
	//Component Template for Verify 
	@Component(Name = "Verify Results By Month", Params = {"label1","label2","label3","label4","label5","label6","label7","label8","label9"})
	public void verifyResultsByMonth(ParamManager pm) throws DDTFrameworkException, DatatypeConfigurationException, IOException {
//		ObjectTypes Page = Browser.Page("HomePage");
		m_results.startVerificationLogStep();
		String ShoeName =  "XPATH://td[@class='shoe_result_value shoe_name'][contains(text(),'" + pm.Parameter("label1") + "')]";
	//	//ShoeName//following::tr/td[@class='shoe_result_value shoe_price']
		String ShoePrice =  ShoeName + "//following::tr/td[@class='shoe_result_value shoe_price']";
		
		m_results.startVerificationLogStep();
		new WebObject(ShoeName).verifyValue(pm.Parameter("label1"));
		new WebObject(ShoePrice).verifyValue(pm.Parameter("label2"));
		
		m_results.endVerificationLogStep();
	
	}
	
	
	
	
}
