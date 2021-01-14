package steps;

import javax.xml.ws.Response;

import Utilities.ServiceUtils;
import Utilities.latestDataUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

public class APISteps {

	

	@Given("Rates API should be up and Running")
	public void APICheck() {
		System.out.println("Rates API should be up and running!!!");
	}
	
	@When("I call the Rates API")
	public void APIcall(){
		latestDataUtils.latestDataAPICall();

	}
	
	@When("^I call the Rates API with \"([^\"]*)\"$")
	public void APIcallwithURL(String url){
		latestDataUtils.latestDataAPICallWithURL(url);

	}
	
	@When("^I call the Rates API with \"([^\"]*)\" symbols$")
	public void APIcallwithSymbol(String symbol){
		latestDataUtils.latestDataAPICallWithSymbol(symbol);

	}
	@When("^I call the Rates API with \"([^\"]*)\" Base$")
	public void APIcallwithBase(String base){
		latestDataUtils.latestDataAPICallWithBase(base);

	}
	
	
	@When("^I call the Rates API with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void APIcallwithBaseSymbols(String base, String Symbols){
		latestDataUtils.latestDataAPICallWithBaseAndSymbols(base,Symbols);

	}
	
	@When("^I call the Rates API for particular \"([^\"]*)\"$")
	public void APIcallwithDate(String date){
		latestDataUtils.latestDataAPICallWithDate(date);

	}
	
	
	@When("^I call the Rates API for particular \"([^\"]*)\" and \"([^\"]*)\"")
	public void APIcallwithDateSymbol(String date, String symbol){
		latestDataUtils.latestDataAPICallWithDateandSymbol(date,symbol);

	}
	
	@When("^I call the Rates API for particular \"([^\"]*)\" with \"([^\"]*)\"")
	public void APIcallwithDateBase(String date, String base){
		latestDataUtils.latestDataAPICallWithDateandBase(date,base);

	}
	
	
	@When("^I call the Rates API for particular \"([^\"]*)\" with \"([^\"]*)\" and \"([^\"]*)\" given$")
	public void APIcallwithDateBaseandSymbol(String date, String base, String Symbol){
		latestDataUtils.latestDataAPICallWithDatBaseandSymbol(date,base,Symbol);

	}
	
	
	
	@Then("^I verify API response status as \"([^\"]*)\" within \"([^\"]*)\" second SLA$")
	public void Response_status_check(String responseCode, String sla){
		ServiceUtils.validateResponseCode(responseCode);
		ServiceUtils.validateResponseTime(sla);
		
	}

	@And("^I verify \"([^\"]*)\" should be available in the response$")
	public void INR_should_be_available_in_response(String currency){
		latestDataUtils.currenyCheck(currency);
	}
	
	@And("^I verify latest \"([^\"]*)\" rate in the response$")
	public void Currency_should_be_available_in_response(String currency){
		latestDataUtils.symbolCurrenyCheck(currency);
	}

	@Then("error message is displayed - Invalid Credentials")
	public void error_message_is_displayed_Invalid_Credentials() {
	}


}
