package dev.ifrs;

import io.quarkus.test.junit.QuarkusTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ResourceTest {

    @Test
    @DisplayName("testAPILbtoKgNoArguments")
    @Order(1)
    public void testAPILbtoKgNoArguments() {
        given()
          .when().get("/api/lbtokg/0")
          .then()
             .statusCode(502);
    }

    @Test
    @DisplayName("testAPILbtoKgNoArguments")
    @Order(2)
    public void testAPILbtoKgWithString() {
        given()
          .when().get("/api/lbtokg/alexandre")
          .then()
             .statusCode(404);
    }


    @Test
    @DisplayName("testAPI LbtoKg valor baixo")
    @Order(3)
    public void testAPILbtoKgEndpoint() {
        final String response = "0.4535970244035199";
        given()
          .when().get("/api/lbtokg/1")
          .then()
             .statusCode(200).body(is(response));
    }

    @Test
    @DisplayName("testAPI LbtoKg valor Alto")
    @Order(4)
    public void testAPILbtoKg() {
        final String response = "4535.970244035198";
        given()
          .when().get("/api/lbtokg/10000")
          .then()
             .statusCode(200).body(is(response));
    }

    @Test
    @DisplayName("testAPIKgtoLbNoArguments")
    @Order(5)
    public void testAPIKgtoLbNoArguments() {
        given()
          .when().get("/api/kgtolb")
          .then()
             .statusCode(404);
    }
    
    @Test
    @DisplayName("testAPIKgtoLbWithString")
    @Order(6)
    public void testAPIKgtoLbWithString() {
        given()
          .when().get("/api/kgtolb/alexandre")
          .then()
             .statusCode(404);
    }
    @Test
    @DisplayName("testAPI kgtolb valor baixo")
    @Order(7)
    public void testAPIKgtoLbEndpoint() {
        final String response = "2.2046";
        given()
          .when().get("/api/kgtolb/1")
          .then()
             .statusCode(200).body(is(response));
    }

    @Test
    @DisplayName("testAPI kgtolb valor Alto")
    @Order(8)
    public void testAPIKgtoLb() {
        final String response = "220.46";
        given()
          .when().get("/api/kgtolb/100")
          .then()
             .statusCode(200).body(is(response));
    }

   
}