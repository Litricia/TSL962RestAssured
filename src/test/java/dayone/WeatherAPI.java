package dayone;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
public class WeatherAPI {
  @Test(enabled = false,description = "Getting weather information of specific city")
  public void getWeather1() {
	  RestAssured.given()//pre condition
	  			 .when()//perform step
	  			 	.get("https://api.openweathermap.org/data/2.5/weather?q=Chennai&appid=d1cf4f39e60b4047345f6a8a1038f989")
	  			 	.then()//post condition
	  			 	.log()//print
	  			 	.body()
	  			 	.statusCode(200);
  }
  
  @Test(enabled= false,description = "Getting weather information of specific city")
  public void getWeather2() {
	 Response res = RestAssured.given()//pre condition
	  			 .when()//perform step
	  			 	.get("https://api.openweathermap.org/data/2.5/weather?q=Mumbai&appid=d1cf4f39e60b4047345f6a8a1038f989");
	 System.out.println(res.prettyPrint());
	 System.out.println(res.getTime());
	 System.out.println(res.getStatusCode());
	 System.out.println(res.getContentType());
	 
	 Assert.assertEquals(res.getStatusCode(),200);
  }
  @Test(enabled = true,description = "Getting weather information of specific city")
  public void getWeather3() {
	  RestAssured.given()//pre condition
	  				.queryParam("q", "Mumbai")
	  				.queryParam("appid", "d1cf4f39e60b4047345f6a8a1038f989")
	  .when()//perform step
	  			 	.get("https://api.openweathermap.org/data/2.5/weather")
	  			 	.then()//post condition
	  			 	.log()//print
	  			 	.body()
	  			 	.statusCode(200);
  }
  
  @Test(enabled = true,description = "Getting weather information of specific city")
  public void getWeather4() {
	  Map<String,String> param = new HashMap<String,String>();
	  param.put("q","Mumbai");
	  param.put("appid","d1cf4f39e60b4047345f6a8a1038f989");
	  RestAssured.given()//pre condition
	  				.queryParams(param)
	  				 .when()//perform step
	  			 	.get("https://api.openweathermap.org/data/2.5/weather")
	  			 	.then()//post condition
	  			 	.log()//print
	  			 	.body()
	  			 	.statusCode(200);
  }
}
