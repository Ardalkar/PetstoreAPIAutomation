package api.endpoints;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import io.restassured.http.ContentType;
import api.payload.UserPOJO;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;
public class userEndpoints2 {

	//load properties file & read data from properties file
	static ResourceBundle getURL()
	{
		ResourceBundle routes =ResourceBundle.getBundle("routes");
	
		return routes;
		
	}
	
	//userEndpoints.java is created to perform CRUD - create, read, update & delete requests to the user API
	
	//create user =post
	public static Response createUser(UserPOJO payload)	//payload = request body
	{
		
		String post_Url = getURL().getString("post_url");
		Response response = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(post_Url); //when is sending the request & storing the response in res
		return response;
	}
	
	//read user =get
	
	public static Response readUser(String userName)	//payload = request body
	{
		String update_Url = getURL().getString("get_url");
		Response response = given()
			.pathParam("username",userName)
		.when()
			.get(update_Url); //when is sending the request & storing the response in res
		return response;
	}
	
	//update user
	public static Response updateUser(String userName, UserPOJO payload)	//payload = request body
	{
		String update_Url = getURL().getString("update_url");
		Response response =  given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username",userName)
				.body(payload)
		.when()
			.put(update_Url); //when is sending the request & storing the response in res
		return response;
	}
	
	//delete user =delete
	
		public static Response deleteUser(String userName)	//payload = request body
		{
			String delete_Url = getURL().getString("delete_url");
			Response response =given()
				.pathParam("username",userName)
			.when()
				.delete(delete_Url); //when is sending the request & storing the response in res
			return response;
		}
		
	
	
	
}
