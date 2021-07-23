package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class NormResourceTest
{
    @Test
    public void testCreateNorm()
    {
        var response = given()
            .body("{\"title\":\"testNorm\"}")
            .contentType(ContentType.JSON)
            .when()
            .post("/norms")
            .then()
            .statusCode(200)
            .extract()
            .as(Norm.class);

        Assertions.assertNotNull(response.getId());
    }
}
