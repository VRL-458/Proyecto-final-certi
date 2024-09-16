package stepDefinitions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import constants.BookingEndpoints;
import entities.Booking;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import utils.Request;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class BoikingSteps {

    Response response;



    @Given("Request getids end point")
    public void requestGetidsEndPoint() {
        response = Request.get(BookingEndpoints.Get_BookingIds);
    }

    @Then("check the status code {int}")
    public void checkTheStatusCode(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @And("chek the response size not {int}")
    public void chekTheResponseSizeNot(int size) {
        response.then().assertThat().body("size()", not(0));

    }

    @Given("Request by id {int}")
    public void requestById(int id) {
        response = Request.getById(BookingEndpoints.Get_BookingIds, String.valueOf(id));
    }

    @And("check the response is not null in some parameters")
    public void checkTheResponseIsNotNullInSomeParameters() {
        response.then().log().body();
        //revisamos los campos del json que no esten vacios
        response.then().assertThat()
                .body("firstname", Matchers.not(Matchers.isEmptyOrNullString()))
                .body("lastname", Matchers.not(Matchers.isEmptyOrNullString()))
                .body("totalprice", Matchers.notNullValue()) // Verifica que no sea nulo (totalprice es numérico)
                .body("depositpaid", Matchers.notNullValue()) // Verifica que no sea nulo (depositpaid es booleano)
                .body("bookingdates.checkin", Matchers.not(Matchers.isEmptyOrNullString()))
                .body("bookingdates.checkout", Matchers.not(Matchers.isEmptyOrNullString()));
    }

    @Given("Request by id <{string}>")
    public void requestById(String id) {
        response = Request.getById(BookingEndpoints.Get_BookingIds, id);
    }

    @And("check the response size {int}")
    public void checkTheResponseSize(int arg0) {
        response.then().assertThat().body("size()", equalTo(0));
    }

    @Given("Request create")
    public void requestCreate(io.cucumber.datatable.DataTable BokingData) throws JsonProcessingException {

        List<String> booking_atributs = BokingData.transpose().asList(String.class);
        Booking booking = new Booking();
        booking.setFirstname(booking_atributs.get(0));
        booking.setLastname(booking_atributs.get(1));
        booking.setTotalprice(Integer.parseInt(booking_atributs.get(2)));
        booking.setDepositpaid(Boolean.parseBoolean(booking_atributs.get(3)));

        Booking.BookingDates dates = new Booking.BookingDates();
        dates.setCheckin(booking_atributs.get(4));
        dates.setCheckout(booking_atributs.get(5));
        booking.setBookingdates(dates);

        booking.setAdditionalneeds(booking_atributs.get(6));

        ObjectMapper mapper = new ObjectMapper();
        String payload = mapper.writeValueAsString(booking);

        response = Request.post(BookingEndpoints.Create_Booking, payload);


    }


    @Given("Request create with empty booking")
    public void requestCreateWithEmptyBooking() throws JsonProcessingException {

        Booking booking = new Booking();
        booking.setFirstname("");
        booking.setLastname("booking_atributs.get(1)");
        booking.setTotalprice(1234);
        booking.setDepositpaid(false);

        Booking.BookingDates dates = new Booking.BookingDates();
        dates.setCheckin("");
        dates.setCheckout("");
        booking.setBookingdates(dates);

        booking.setAdditionalneeds("");

        ObjectMapper mapper = new ObjectMapper();
        String payload = mapper.writeValueAsString(booking);

        response = Request.post(BookingEndpoints.Create_Booking, payload);
    }
}
