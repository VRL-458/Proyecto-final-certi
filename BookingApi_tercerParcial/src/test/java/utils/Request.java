package utils;

import constants.BookingEndpoints;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Request {
    public static Response get(String endpoint) {
        RestAssured.baseURI = BookingEndpoints.BASE_URL;
        Response response = RestAssured
                .when().get(endpoint);
        response.then().log().body();
        return response;
    }

    public static Response getById(String endpoint, String id) {
        RestAssured.baseURI = BookingEndpoints.BASE_URL;
        Response response = RestAssured.given().pathParams("id", id).when().get("/{id}");
        return response;
    }

    public static Response post(String endpoint, String payload) {
        RestAssured.baseURI = BookingEndpoints.BASE_URL;
        Response response = RestAssured
                .given().contentType(ContentType.JSON).body(payload)
                .when().post(endpoint);
        response.then().log().body();
        return response;
    }
}
