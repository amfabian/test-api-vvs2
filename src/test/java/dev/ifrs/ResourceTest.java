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
          .when().get("/api/lbtokg")
          .then()
             .statusCode(404);
    }

    @Test
    @DisplayName("testAPIKgtoLbNoArguments")
    @Order(2)
    public void testAPIKgtoLbNoArguments() {
        given()
          .when().get("/api/kgtolb")
          .then()
             .statusCode(404);
    }

    @Test
    @DisplayName("testAPI kgtolb valor baixo")
    @Order(3)
    public void testAPIKgtoLbEndpoint() {
        final String response = "2.2046";
        given()
          .when().get("/api/kgtolb/1")
          .then()
             .statusCode(200).body(is(response));
    }

    @Test
    @DisplayName("testAPI kgtolb valor Alto")
    @Order(4)
    public void testAPIKgtoLb() {
        final String response = "220.46";
        given()
          .when().get("/api/kgtolb/100")
          .then()
             .statusCode(200).body(is(response));
    }

    @Test
    @DisplayName("testAPI LbtoKg valor baixo")
    @Order(5)
    public void testAPILbtoKgEndpoint() {
        final String response = "0.4535970244035199";
        given()
          .when().get("/api/lbtokg/1")
          .then()
             .statusCode(200).body(is(response));
    }

    @Test
    @DisplayName("testAPI LbtoKg valor Alto")
    @Order(6)
    public void testAPILbtoKg() {
        final String response = "4535.970244035198";
        given()
          .when().get("/api/lbtokg/10000")
          .then()
             .statusCode(200).body(is(response));
    }
}