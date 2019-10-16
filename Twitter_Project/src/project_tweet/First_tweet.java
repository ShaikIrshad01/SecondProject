package project_tweet;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class First_tweet {

	@Test 
	public void postTweet() throws Exception  {
		
		
		String ConsumerKey ="2Xtd4ILUtinfACHehAvCNcbjW";
		String ConsumerSecret ="pIHDmJy9fgKlLVuAgG4AuP5rRkaOy6TtWqxLqjVeJ2MywdcGJp";
		String Token ="839104214-h1Kaf8iJW2FAyXzNCZNicI1a4Xb8BMw7ZkFKGzmJ";
		String TokenSecret ="PTvXawkmrK3EZWeLSSmqtD7hisogRC3nqG48FYzNcLfQy";
		
		RestAssured.baseURI="https://api.twitter.com/1.1/statuses/";
		Response res = given().auth().oauth(ConsumerKey, ConsumerSecret, Token, TokenSecret).
				queryParam("q", "I am learning API testing using RestAssured Java #Qualitest")
				.when().post("/update.json").then().extract().response();
		String Response = res.asString();
		System.out.println(Response);
		JsonPath js = new JsonPath(Response);
		String id = js.get("id").toString();
		System.out.println(id);
		String text = js.get("text").toString();
		System.out.println(text);
		
		given().auth().oauth(ConsumerKey, ConsumerSecret, Token, TokenSecret).
		when().post("/destroy/"+id+".json").then().assertThat().statusCode(200);
		
		/*
		  String ConsumerKey = "2Xtd4ILUtinfACHehAvCNcbjW";
		String ConsumerSecret = "pIHDmJy9fgKlLVuAgG4AuP5rRkaOy6TtWqxLqjVeJ2MywdcGJp";
		String Token = "839104214-h1Kaf8iJW2FAyXzNCZNicI1a4Xb8BMw7ZkFKGzmJ";
		String TokenSecret = "PTvXawkmrK3EZWeLSSmqtD7hisogRC3nqG48FYzNcLfQy";
		
		RestAssured.baseURI="https://api.twitter.com/1.1/statuses/";
		Response res = given().auth().oauth(ConsumerKey, ConsumerSecret, Token, TokenSecret).
				queryParam("status", "First_tweet using API")
				.when().post("/update.json").then().extract().response();
		String Response = res.asString();
		System.out.println(Response);
		JsonPath js = new JsonPath(Response);
		String id = js.get("id").toString();
		System.out.println(id);
		String text = js.get("text").toString();
		System.out.println(text);
		
		given().auth().oauth(ConsumerKey, ConsumerSecret, Token, TokenSecret).
		when().post("/destroy/"+id+".json").then().assertThat().statusCode(200);
		*/
	}
}


