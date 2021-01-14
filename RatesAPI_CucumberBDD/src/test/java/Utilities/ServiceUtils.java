package Utilities;

import RatesAPI.GlobalVariables;
import static org.hamcrest.Matchers.lessThan;
public class ServiceUtils {
	
	public static void validateResponseCode(String responseCode){
		GlobalVariables.resp.then().assertThat().statusCode(Integer.parseInt(responseCode));
		System.out.println("I validated that Response Code is correct Expected"+ responseCode+" Actual: "
				+ GlobalVariables.resp.getStatusCode());
	}
	
	public static void validateResponseTime(String sla){
		GlobalVariables.resp.then().assertThat().time(lessThan(Long.parseLong(sla)*2000));
	}

}
