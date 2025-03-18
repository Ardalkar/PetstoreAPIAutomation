package api.endpoints;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import io.restassured.http.ContentType;
import api.payload.UserPOJO;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class userEndpoints {

	//userEndpoints.java is created to perform CRUD - create, read, update & delete requests to the user API
	
	//create user =post
	public static Response createUser(UserPOJO payload)	//payload = request body
	{
		Response response = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(payload)
		.when()
			.post(Routes.post_Url); //when is sending the request & storing the response in res
		return response;
	}
	
	//read user =get
	
	public static Response readUser(String userName)	//payload = request body
	{
		Response response = given()
			.pathParam("username",userName)
		.when()
			.get(Routes.get_Url); //when is sending the request & storing the response in res
		return response;
	}
	
	//update user
	public static Response updateUser(String userName, UserPOJO payload)	//payload = request body
	{
		Response response =  given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.pathParam("username",userName)
				.body(payload)
		.when()
			.put(Routes.put_Url); //when is sending the request & storing the response in res
		return response;
	}
	
	//delete user =delete
	
		public static Response deleteUser(String userName)	//payload = request body
		{
			Response response =given()
				.pathParam("username",userName)
			.when()
				.delete(Routes.delete_Url); //when is sending the request & storing the response in res
			return response;
		}
		
	
	
	
}
