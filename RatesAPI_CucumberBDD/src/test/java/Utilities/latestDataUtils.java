package Utilities;

import io.restassured.response.Response;

import org.json.JSONObject;

import RatesAPI.GlobalVariables;
import io.restassured.RestAssured;
import  io.restassured.*;
import static org.junit.Assert.assertTrue;

public class latestDataUtils {

	
	public static void latestDataAPICall(){
		 Response res = RestAssured.given().get("https://api.ratesapi.io/api/latest");
		GlobalVariables.resp= res;
		GlobalVariables.statusCode = res.statusCode();
		GlobalVariables.responseBody = res.getBody().asString();
		//System.out.println("Response is:\n"+GlobalVariables.responseBody);
	}
	
	
	
	public static void latestDataAPICallWithSymbol(String symbol){
		Response res = RestAssured.given().get("https://api.ratesapi.io/api/latest?symbols="+symbol);
		GlobalVariables.resp= res;
		GlobalVariables.statusCode = res.statusCode();
		GlobalVariables.responseBody = res.getBody().asString();
		System.out.println("Response is:\n"+GlobalVariables.responseBody);
	}
	
	
	public static void latestDataAPICallWithBase(String base){
		Response res = RestAssured.given().get("https://api.ratesapi.io/api/latest?base="+base);
		GlobalVariables.resp= res;
		GlobalVariables.statusCode = res.statusCode();
		GlobalVariables.responseBody = res.getBody().asString();
		System.out.println("Response is:\n"+GlobalVariables.responseBody);
	}
	
	public static void latestDataAPICallWithBaseAndSymbols(String base,String Symbols){
		Response res = RestAssured.given().get("https://api.ratesapi.io/api/latest?base="+base+"&symbols="+Symbols);
		GlobalVariables.resp= res;
		GlobalVariables.statusCode = res.statusCode();
		GlobalVariables.responseBody = res.getBody().asString();
		System.out.println("Response is:\n"+GlobalVariables.responseBody);
	}
	
	
	public static void latestDataAPICallWithDate(String date){
		Response res = RestAssured.given().get(" https://api.ratesapi.io/api/"+date);
		GlobalVariables.resp= res;
		GlobalVariables.statusCode = res.statusCode();
		GlobalVariables.responseBody = res.getBody().asString();
		System.out.println("Response is:\n"+GlobalVariables.responseBody);
	
		
	}
	
	public static void latestDataAPICallWithDateandSymbol(String date, String symbol){
		Response res = RestAssured.given().get(" https://api.ratesapi.io/api/"+date+"?symbols="+symbol);
		GlobalVariables.resp= res;
		GlobalVariables.statusCode = res.statusCode();
		GlobalVariables.responseBody = res.getBody().asString();
		System.out.println("Response is:\n"+GlobalVariables.responseBody);
	}
	
	public static void latestDataAPICallWithDateandBase(String date, String base){
		Response res = RestAssured.given().get(" https://api.ratesapi.io/api/"+date+"?base="+base);
		GlobalVariables.resp= res;
		GlobalVariables.statusCode = res.statusCode();
		GlobalVariables.responseBody = res.getBody().asString();
		System.out.println("Response is:\n"+GlobalVariables.responseBody);
	}
	
	
	public static void latestDataAPICallWithDatBaseandSymbol(String date, String base, String symbol){
		Response res = RestAssured.given().get(" https://api.ratesapi.io/api/"+date+"?base="+base+"&symbols="+symbol);
		GlobalVariables.resp= res;
		GlobalVariables.statusCode = res.statusCode();
		GlobalVariables.responseBody = res.getBody().asString();
		System.out.println("Response is:\n"+GlobalVariables.responseBody);
	}
	
	
	public static void latestDataAPICallWithURL(String URL){
		 Response res = RestAssured.given().get(URL);
		GlobalVariables.resp= res;
		GlobalVariables.statusCode = res.statusCode();
		GlobalVariables.responseBody = res.getBody().asString();
		//System.out.println("Response is:\n"+GlobalVariables.responseBody);
	}
	
	public static void currenyCheck(String currency){
		org.json.JSONObject jsonpath = new org.json.JSONObject(GlobalVariables.resp.asString());
		JSONObject ratesDetails = jsonpath.getJSONObject("rates");
		//System.out.println("Rates Details: \n"+ratesDetails);
		boolean currencyCheck = ratesDetails.has(currency);
		assertTrue("Currency is not matching",currencyCheck);
		String INR_rate = ratesDetails.get("INR").toString();
		System.out.println("Latest INR rate is: "+ INR_rate);
		
		
	}
	
	
	public static void symbolCurrenyCheck(String currency){
		org.json.JSONObject jsonpath = new org.json.JSONObject(GlobalVariables.resp.asString());
		JSONObject ratesDetails = jsonpath.getJSONObject("rates");
		//System.out.println("Rates Details: \n"+ratesDetails);
		boolean currencyCheck = ratesDetails.has(currency);
		assertTrue("Currency is not matching",currencyCheck);
		String rate = ratesDetails.get(currency).toString();
		System.out.println("Latest "+ currency+ " rate is: "+ rate);
		
		
	}
}
