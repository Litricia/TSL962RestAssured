package dayTwo;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class GitHub {
	@BeforeTest
	public void beforeTest()
	{
		baseURI="https://api.github.com/user/repos";
		authentication=oauth2("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");
	}
  @Test(enabled =true)
  public void gettingAllRepositories() {
	  given()
	 
	  .when()
	  .get()
	  .then()
	  .log()
	  .body()
	  .statusCode(200);
  }
  @Test(enabled =false)
  public void createRepositories() {
	  JSONObject data = new JSONObject();
	  data.put("name","SampleRestAssured2");
	  data.put("description","created using restassured");
	  data.put("homepage","http://github.com/Litricia");
	  given()
	  	.header("Content_Type","application/json")
	  	.body(data.toJSONString())
	  .when()
	  	.post()
	  .then()
	  	.log()
	  	.body()
	  	.statusCode(201)
	  	.time(Matchers.lessThan(5000L),TimeUnit.MILLISECONDS);
  }
}
