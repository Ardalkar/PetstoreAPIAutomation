package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.userEndpoints;
import api.payload.UserPOJO;
import io.restassured.response.Response;
import api.utilities.DataProviders;
public class dataDrivenTests {

	//read only username
	//create multiple user by fetching data from excel one by one  & using post request
	
	//captured data from dataProvider =dataProvider captured data from excel =then dataProvider passing data to postrequest below
	@Test(priority=1,dataProvider="Data", dataProviderClass=DataProviders.class)
	public void testPostUser(String UserID, String Username,String FirstName,String LastName,String Email,String pwd,String ph)
	{

		UserPOJO userPayload = new UserPOJO();
		userPayload.setId(Integer.parseInt(UserID));
		userPayload.setUsername(Username);
		userPayload.setFirstname(FirstName);
		userPayload.setLastname(LastName);
		userPayload.setEmail(Email);
		userPayload.setPassword(pwd);
		userPayload.setPhone(ph);
		
		Response res =userEndpoints.createUser(userPayload);
		Assert.assertEquals(res.getStatusCode(),200);
		
	}
	
	
	//pass username to dataprovider method to delete data
	@Test(priority=1,dataProvider="UserNames", dataProviderClass=DataProviders.class)	
	public void testDeleteUserbyUsername(String Username)
	{
		Response res =userEndpoints.deleteUser(Username);
		Assert.assertEquals(res.getStatusCode(),200);
	}
}
