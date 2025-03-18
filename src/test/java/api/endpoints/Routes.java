package api.endpoints;

public class Routes {

	//Maintain only URL's -Urls will get from Swagger UI
	/*
	 * Swagger URI = https://petstore.swagger.io/v2
	 * 
	create User =Post = https://petstore.swagger.io/v2/user
	get user = Get = https://petstore.swagger.io/v2/user/{username}
	update user = put = https://petstore.swagger.io/v2/user/{username}
	delete user =delete = https://petstore.swagger.io/v2/user/{username}
	 */
	
	
	public static String base_Url = "https://petstore.swagger.io/v2/";
	
	//USER Model
	public static String post_Url = base_Url+"user";
	public static String get_Url = base_Url+"user/{username}";
	public static String put_Url = base_Url+"user/{username}";
	public static String delete_Url = base_Url+"user/{username}";
	
	
	
	//store module Urls
	
	
	
	//pet module Urls
	
}
