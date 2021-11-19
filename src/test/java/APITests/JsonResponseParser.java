package APITests;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class JsonResponseParser {
    public static String parse(Response response, String key) {
        String jsonResponse = response.asString();
        JsonPath jsonPath = new JsonPath(jsonResponse);
        return jsonPath.getString(key);
    }
}
