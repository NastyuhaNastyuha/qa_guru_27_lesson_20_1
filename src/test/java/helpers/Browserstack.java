package helpers;

import static io.restassured.RestAssured.given;

public class Browserstack {
    public static String videoUrl(String sessionId) {

//        curl -u "test_wKpihI:9EsbRa9BoEa8EkFsZTo1" -X GET "https://api.browserstack.com/app-automate/sessions/<session-id>.json"


        String url = String.format("https://api.browserstack.com/app-automate/sessions/%s.json", sessionId);
        return given()
                .auth().basic("test_wKpihI", "9EsbRa9BoEa8EkFsZTo1")
                .get(url)
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .extract().path("automate_session.video_url");
    }
}
