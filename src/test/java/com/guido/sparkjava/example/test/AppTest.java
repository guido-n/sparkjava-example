package com.guido.sparkjava.example.test;

import com.guido.sparkjava.example.App;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import spark.Spark;

import static io.restassured.RestAssured.when;

import static org.hamcrest.CoreMatchers.containsString;

public class AppTest {

    @BeforeAll
    public static void startSparkjava() {
        App.main(new String[]{"empty"});
    }

    @AfterAll
    public static void stopSparkjava() {
        Spark.stop();
    }

    @Test
    public void basicTest() {

        when()
                .get("http://localhost:4567/hello/sparkjava")
        .then()
                .log().all()
                .statusCode(200)
                .body("greeting",    containsString("Ciao sparkjava"))
                .body("received-at", containsString(LocalDate.now().toString()));

    }

}
