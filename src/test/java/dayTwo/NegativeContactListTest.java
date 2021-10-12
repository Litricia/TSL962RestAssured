package dayTwo;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class NegativeContactListTest {
  @Test(enabled=false)
  public void recordNotFound() {
	  given()
	  .when()
	  .get("http://3.13.86.142:3000/contacts/5554")
	  .then()
	  .log()
	  .body()
	  .statusCode(404);
  }
  @Test(enabled=false,description="Adding Contact with missing Details ")
  public void UpdatingContact() {
  JSONObject details=new JSONObject();
  JSONObject loc=new JSONObject();
  JSONObject emp=new JSONObject();
  
  loc.put("city", "Chennai");
  loc.put("country", "India");
  emp.put("JobTitle", "GET");
  emp.put("company", "LTI");
  details.put("firstName", "");
  details.put("lastName","Gilbert");
  details.put("email", "litty@gmail.com");
  details.put("location", loc);
  details.put("employer", emp);
  
  	String error=	given()
	 .header("Content-Type","application/json")
	 .body(details.toJSONString())
	 .when()
	 .post("http://3.13.86.142:3000/contacts")
	 .then()
	 .log()
	 .body()
	 .statusCode(400)
	 .extract()
	 .path("err");
  		Assert.assertTrue(error.contains("firstName: First Name is required"));
}
  
  @Test(enabled=false,description="More than the limit")
  public void UpdatingContact2() {
  JSONObject details=new JSONObject();
  JSONObject loc=new JSONObject();
  JSONObject emp=new JSONObject();
  
  loc.put("city", "ChennaiChennaiChennaiChennaiChennaiChennaiChennai");
  loc.put("country", "India");
  emp.put("JobTitle", "GET");
  emp.put("company", "LTI");
  details.put("firstName", "Litricia");
  details.put("lastName","Gilbert");
  details.put("email", "litty@gmail.com");
  details.put("location", loc);
  details.put("employer", emp);
  
  	String error=	given()
	 .header("Content-Type","application/json")
	 .body(details.toJSONString())
	 .when()
	 .post("http://3.13.86.142:3000/contacts")
	 .then()
	 .log()
	 .body()
	 .statusCode(400)
	 .extract()
	 .path("err");
  		Assert.assertTrue(error.contains("is longer than the maximum allowed length"));
}
  @Test(enabled=false,description="More than the limit")
  public void InvalidFirstName() {
  JSONObject details=new JSONObject();
  JSONObject loc=new JSONObject();
  JSONObject emp=new JSONObject();
  
  loc.put("city", "Chennai");
  loc.put("country", "India");
  emp.put("JobTitle", "GET");
  emp.put("company", "LTI");
  details.put("firstName", "1234");
  details.put("lastName","Gilbert");
  details.put("email", "litty@gmail.com");
  details.put("location", loc);
  details.put("employer", emp);
  
  	String error=	given()
	 .header("Content-Type","application/json")
	 .body(details.toJSONString())
	 .when()
	 .post("http://3.13.86.142:3000/contacts")
	 .then()
	 .log()
	 .body()
	 .statusCode(400)
	 .extract()
	 .path("err");
  		Assert.assertTrue(error.contains("firstName: Validator failed for path"));
}
  @Test(enabled=true,description="More than the limit")
  public void notInProperFormat() {
  JSONObject details=new JSONObject();
  JSONObject loc=new JSONObject();
  JSONObject emp=new JSONObject();
  
  loc.put("city", "Chennai");
  loc.put("country", "India");
  emp.put("JobTitle", "GET");
  emp.put("company", "LTI");
  details.put("firstName", "Litricia");
  details.put("lastName","Gilbert");
  details.put("email", "littymailcom");
  details.put("location", loc);
  details.put("employer", emp);
  
  	String error=	given()
	 .header("Content-Type","application/json")
	 .body(details.toJSONString())
	 .when()
	 .post("http://3.13.86.142:3000/contacts")
	 .then()
	 .log()
	 .body()
	 .statusCode(400)
	 .extract()
	 .path("err");
  		Assert.assertTrue(error.contains("email: Validator failed for path"));
}//github - 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
}
