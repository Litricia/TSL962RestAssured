package dayTwo;


import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class PositiveContactListTest {
	String id;
  @Test(enabled=false,description="Getting all Contact List")
  public void getContactListInfo() {
	  given()
	  .when()
	  .get("http://3.13.86.142:3000/contacts\n")
	  
	  .then()
	  .log()
	  .body()
	  .statusCode(200);
  }
  
  
  @Test(enabled=false,description="Getting specific Contact ")
  public void getSpecificContact() {
	  given()
	  .when()
	  .get("http://3.13.86.142:3000/contacts/5e066f8a2369c5050ec00f06\n")
	  .then()
	  .log()
	  .body()
	  .statusCode(200);
  }
  @Test(enabled=false,description="Getting specific Contact ")
  public void getSpecificContact2() {
	  Response res = given()
			  .when()
			  		.get("http://3.13.86.142:3000/contacts/5e066f8a2369c5050ec00f06\n");
	  	System.out.println(res.getTime());
	  	
	   res.then()
	  .log()
	  .body()
	  .statusCode(200);
  }

	  @Test(enabled=false,description="Getting specific Contact ")
	  public void addingContact() {
	  JSONObject details=new JSONObject();
	  JSONObject loc=new JSONObject();
	  JSONObject emp=new JSONObject();
	  
	  loc.put("city", "Chennai");
	  loc.put("country", "India");
	  emp.put("JobTitle", "GET");
	  emp.put("company", "LTI");
	  details.put("firstName", "Litricia");
	  details.put("lastName","G");
	  details.put("email", "lit@gmail.com");
	  details.put("location", loc);
	  details.put("employer", emp);
	  
	ExtractableResponse<Response> ex=	 given()
		 .header("Content-Type","application/json")
		 .body(details.toJSONString())
		 .when()
		 .post("http://3.13.86.142:3000/contacts")
		 .then()
		 .log()
		 .body()
		 .statusCode(200)
		 .extract();
		// .path("_id");
	
		 id=ex.path("_id");
		 System.out.println(ex.path("_id"));
		 System.out.println(ex.path("firstName"));
		 System.out.println(ex.path("lastName"));
		 System.out.println(ex.path("location.city"));
		 
	  }
  
	  @Test(enabled=false,dependsOnMethods="addingContact",description="Getting specific Contact ")
	  public void UpdatingContact() {
	  JSONObject details=new JSONObject();
	  JSONObject loc=new JSONObject();
	  JSONObject emp=new JSONObject();
	  
	  loc.put("city", "Chennai");
	  loc.put("country", "India");
	  emp.put("JobTitle", "GET");
	  emp.put("company", "LTI");
	  details.put("firstName", "Litricia");
	  details.put("lastName","Gilbert");
	  details.put("email", "litty@gmail.com");
	  details.put("location", loc);
	  details.put("employer", emp);
	  
	  		given()
		 .header("Content-Type","application/json")
		 .body(details.toJSONString())
		 .when()
		 .put("http://3.13.86.142:3000/contacts/"+id)
		 .then()
		 .log()
		 .body()
		 .statusCode(204);
}
	  @Test(enabled=false,dependsOnMethods="UpdatingContact",description="Getting specific Contact ")
	  public void getSpecificContact3() {
		  given()
		  .when()
		  .get("http://3.13.86.142:3000/contacts/"+id)
		  .then()
		  .log()
		  .body()
		  .statusCode(200);
	  }// 61602c6df2967f0ec893b2d1
	  
	  
	  @Test(enabled=false,description="Deleting the contact")
	  public void deleteContact()
	  {
		  given()
		  .when()
		  .delete("http://3.13.86.142:3000/contacts/615fdf81f2967f0ec893afa5")
		  .then()
		  .log()
		  .body().statusCode(204);
	  }
	  
	  @Test(enabled=true,description="Deleting the contact")
	  public void getContact3()
	  {
		  given()
		  .when()
		  .get("http://3.13.86.142:3000/contacts/615fdf81f2967f0ec893afa5")
		  .then()
		  .log()
		  .body().statusCode(404);
	  }
	  
}
