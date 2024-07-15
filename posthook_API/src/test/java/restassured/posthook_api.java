package restassured;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class posthook_api {
	
String url="https://posthook-api.mock.beeceptor.com";
	
	@Test(enabled = true)
	public void scheduleHook() {
		
		
		RestAssured.baseURI=url;
		given().contentType(ContentType.JSON).when().post("/v1/hooks").then().log().all();
		
		
	}
	
	@Test(enabled = false)
	public void getHooks() {
		RestAssured.baseURI=url;
		given().get("/v1/hooks").then().log().all();
		
	}
	
	//.extract.response (for fetching one response from console)
	
	//.header
	@Test(enabled = false)
	public void getHook() {
		RestAssured.baseURI=url;
		given().get("/v1/hooks/8e3aa909-fb84-4495-944d-a4c192defe66").then().log().all();
	}
	
@Test(enabled = false)
public void deleteHook() {
	RestAssured.baseURI=url;
	given().get("/v1/hooks/8e3aa909-fb84-4495-944d-a4c192defe66").then().log().all();

}

@Test(enabled = true)
public void updateHook() {
	RestAssured.baseURI=url;
	
	JSONObject js=new JSONObject(); 
			js.put("name", "updated-project");
			js.put("domain", "api.example.com");
			js.put("headerAuthorization", " ");
			js.put("minRetries", 1);
			js.put("retryDelaySecs", 5);
			
			
			
			given().contentType(ContentType.JSON).body(js.toJSONString()).when().put("/v1/projects/");
			
}
}
