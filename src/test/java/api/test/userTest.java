package api.test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import api.endpoints.userEndpoints;
import api.payload.UserPOJO;
import io.restassured.response.Response;
import com.github.javafaker.Faker;

public class userTest {

	Faker faker;
	UserPOJO userPayload;
	
	public Logger logger;
	//created data by using pojo
	@BeforeClass
	public void setupData()
	{
		faker = new Faker();
		userPayload= new UserPOJO();
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setLastname(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password());
		userPayload.setPhone(faker.phoneNumber().phoneNumber());
		
		//log
		logger= LogManager.getLogger(this.getClass());
		
		
	}
	@Test(priority=1)
	public void testPostUser()
	{
		logger.info("********************Creating User Info***********************************");
		Response res =userEndpoints.createUser(userPayload);
		res.then().log().all();
		
		Assert.assertEquals(res.getStatusCode(),200);
		logger.info("******************** User Created***********************************");
	}
	@Test(priority=2 )
	public void testGetUsername()
	{
		logger.info("********************Reading User Info***********************************");
			Response res = userEndpoints.readUser(userPayload.getUsername()); //extracting data from user by using username = Ensure this method returns io.restassured.response.Response
	        res.then().log().all();

	        Assert.assertEquals(res.getStatusCode(), 200);
	        logger.info("******************** User Info is displayed***********************************");
	}
	
	@Test(priority=3 )
	public void testUpdateUserByname()
	{
		logger.info("********************Updating User Info***********************************");
		
		//update data using payload = generating new data
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setLastname(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		
		 	Response res = userEndpoints.updateUser(this.userPayload.getUsername(),userPayload);//updated payload = firstName,lastName,safeEmailAddress// Ensure this method returns io.restassured.response.Response
	        res.then().log().body(); //to check updated data

	        Assert.assertEquals(res.getStatusCode(), 200);
	        
	        //checking data after update
	        Response responseAfterUpdate = userEndpoints.readUser(this.userPayload.getUsername());
	        Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);
	        logger.info("******************** User Updated***********************************");
	}
	@Test(priority=4 )
	public void DeleteUserByname()
	{
		logger.info("********************Deleting User Info***********************************");
			Response res = userEndpoints.deleteUser(this.userPayload.getUsername());
	        Assert.assertEquals(res.getStatusCode(), 200);
	        logger.info("******************** User deleted***********************************");
	}
	
	
}
