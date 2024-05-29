package Steps;

import org.json.simple.JSONObject;
import org.junit.Assert;
 
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
 
public class UserList {
	RequestSpecification req;
	Response res;
	JsonPath path;
	JSONObject obj;
	String expJ,expN;
	@Given("user is in Reqres URL")
	public void user_is_in_reqres_url() {
		RestAssured.baseURI="https://reqres.in/";
	    req=RestAssured.given();
	    System.out.println("Given Step..");
	}
 
	@When("^User enters the (.*) and (.*)$")
	public void user_enters_the_and(String name, String job) {
	     obj=new JSONObject();
	    obj.put("name",name);
	    obj.put("job",job);
	    expJ=job;
	    expN=name;
	    req.header("Content-Type","application/json");
	    System.out.println(obj);
	    System.out.println("When Step..");
	}
	@And("User hit the users API")
	public void user_hit_the_users_api() {
		res=req.body(obj.toJSONString()).post("api/users");
		System.out.println("And Step...");
	}
	@Then("user added to the list")
	public void user_added_to_the_list() {
		System.out.println(res.asPrettyString());
		path=res.jsonPath();
		String job1=path.getString("job");
		System.out.println(job1);
		Assert.assertEquals(job1,expJ);
	}
}