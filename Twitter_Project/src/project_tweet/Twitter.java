package project_tweet;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.util.Properties;

public class Twitter {
String ConsumerKey = "2Xtd4ILUtinfACHehAvCNcbjW";
String ConsumerSecret = "pIHDmJy9fgKlLVuAgG4AuP5rRkaOy6TtWqxLqjVeJ2MywdcGJp";
String Token = "839104214-h1Kaf8iJW2FAyXzNCZNicI1a4Xb8BMw7ZkFKGzmJ";
String TokenSecret = "PTvXawkmrK3EZWeLSSmqtD7hisogRC3nqG48FYzNcLfQy";
@Test
public void getTweet() {
	/*Properties prop = new Properties(); 
	 * FileInputStream  fis = new FileInputStream("C:\\Twitter_Project\\src\\Files\\base.properties");
	prop.load(fis);*/
	RestAssured.baseURI="https://api.twitter.com/1.1/statuses/";
	Response res = given().auth().oauth(ConsumerKey, ConsumerSecret, Token, TokenSecret).
			queryParam("count", "1")
			.when().get("/home_timeline.json").then().extract().response();
	String Response = res.asString();
	System.out.println(Response);
	JsonPath js = new JsonPath(Response);
	String id = js.get("id").toString();
	System.out.println(id);
	String text = js.get("text").toString();
	System.out.println(text);
}
}
