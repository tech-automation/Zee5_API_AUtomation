package co.Zee5.api.user_login_register;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import co.Zee5.api.config.Constants;
import co.Zee5.api.helper.RestBaseClass;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Zee5 extends RestBaseClass implements Constants{
	@SuppressWarnings("unchecked")
	@Test
	public void Zee5_inValidLogin() {
		RestAssured.baseURI = "https://userapi.zee5.com/v1/user";
		RequestSpecification request = RestAssured.given();
		JSONObject requestParams = new JSONObject();
		requestParams.put("mobile", "919916458736");
		requestParams.put("password", "Zxcv@1234");
		request.body(requestParams.toJSONString());
		Response response = request.post("/loginmobile");
		int statuscode=response.getStatusCode();
		Assert.assertEquals(statuscode,404);
		String statusline = response.getStatusLine();
		Assert.assertEquals(statusline,"HTTP/1.1 404 Not Found");
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void Zee5_inValidRegister() {
		RestAssured.baseURI = "https://userapi.zee5.com/v2/user";
		RequestSpecification request = RestAssured.given();
		JSONObject requestParams = new JSONObject();
		requestParams.put("mobile", "919916458736");
		requestParams.put("password", "Zxcv@1234");
		requestParams.put("first_name","");
		requestParams.put("last_name","");
		request.body(requestParams.toJSONString());
		Response response = request.post("/registermobile");
		int statuscode=response.getStatusCode();
		Assert.assertEquals(statuscode,415);
		String statusline = response.getStatusLine();
		Assert.assertEquals(statusline,"HTTP/1.1 415 Unsupported Media Type");
	}
	
	@Test
	public void Zee5_Campaigns() {
		RestAssured.baseURI = "https://app.adoric-om.com/v1";
		Response response=null;
		try {
			response=RestAssured.given().when()
					.queryParam("user", "32c01e9524a754197cc7b77e5fa8c340")
					.queryParam("language","en")
					.queryParam("countryCode","IN")
					.queryParam("browser","chrome")
					.queryParam("os","win")
					.queryParam("href","https%3A%2F%2Fwww.zee5.com%2Ftvshows")
					.queryParam("device","desktop")
					.queryParam("currentShowsPerSession","1")
					.queryParam("partDay","A")
					.queryParam("newVisit","true")
					.queryParam("tz","-330")
					.queryParam("cIds","%5B%5D").get("/campaigns");
		} catch (Exception e) {
			e.printStackTrace();
		}
		String body = response.getBody().asString();
		Assert.assertEquals(body.contains("planLimits"), true,"Response body contains planLimits");
		int statuscode=response.getStatusCode();
		Assert.assertEquals(statuscode, 200);
		String statusline = response.getStatusLine();
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
	}
}
