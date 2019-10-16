package project_tweet;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Sixth_tweet {
	 
	@Test 
	public void triendingTweet() throws Exception {
		
		 
		String ConsumerKey ="2Xtd4ILUtinfACHehAvCNcbjW";
		String ConsumerSecret ="pIHDmJy9fgKlLVuAgG4AuP5rRkaOy6TtWqxLqjVeJ2MywdcGJp";
		String Token ="839104214-h1Kaf8iJW2FAyXzNCZNicI1a4Xb8BMw7ZkFKGzmJ";
		String TokenSecret ="PTvXawkmrK3EZWeLSSmqtD7hisogRC3nqG48FYzNcLfQy";
		
		RestAssured.baseURI="https://api.twitter.com/1.1";
		Response res = given().auth().oauth(ConsumerKey, ConsumerSecret, Token, TokenSecret).
				queryParam("id", "23424848").// Where On Earth IDentification
				when().get("/trends/place.json").then().extract().response();
		String Response = res.asString();
		System.out.println(Response);
		JsonPath js = new JsonPath(Response);

}
	}
