package com.dogapi.tests;

import com.dogapi.base.BaseAPITest;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class DogAPITests extends BaseAPITest {

    @Test(description = "Cenário 1: Validar a lista de todas as raças")
    public void testListAllBreeds() {
        given()
                .when()
                .get("/breeds/list/all")
                .then()
                .statusCode(200)
                .body("status", equalTo("success"))
                .body("message", not(empty()))
                .body("message.hound", notNullValue());
    }

    @Test(description = "Cenário 2.1: Validar imagens de uma raça válida")
    public void testGetImagesForValidBreed() {
        String breed = "hound";
        given()
                .when()
                .get("/breed/" + breed + "/images")
                .then()
                .statusCode(200)
                .body("status", equalTo("success"))
                .body("message", isA(java.util.List.class))
                .body("message", not(empty()));
    }

    @Test(description = "Cenário 2.2: Validar erro para uma raça inválida")
    public void testGetImagesForInvalidBreed() {
        String breed = "gato";
        given()
                .when()
                .get("/breed/" + breed + "/images")
                .then()
                .statusCode(404)
                .body("status", equalTo("error"));
    }

    @Test(description = "Cenário 3: Validar a busca por uma imagem aleatória")
    public void testGetRandomImage() {
        given()
                .when()
                .get("/breeds/image/random")
                .then()
                .statusCode(200)
                .body("status", equalTo("success"))
                .body("message", isA(String.class))
                .body("message", endsWith(".jpg"));
    }

    @Test(description = "Cenário 4: Validar a lista de sub-raças de uma raça")
    public void testListSubBreeds() {
        String breed = "bulldog";
        given()
                .when()
                .get("/breed/" + breed + "/list")
                .then()
                .statusCode(200)
                .body("status", equalTo("success"))
                .body("message", isA(java.util.List.class))
                .body("message", hasItem("boston"));
    }

    @Test(description = "Cenário 5: Validar o retorno de múltiplas imagens aleatórias")
    public void testGetMultipleRandomImages() {
        String breed = "hound";
        int imageCount = 3;
        given()
                .when()
                .get("/breed/" + breed + "/images/random/" + imageCount)
                .then()
                .statusCode(200)
                .body("status", equalTo("success"))
                .body("message", isA(java.util.List.class))
                .body("message", hasSize(imageCount));
    }
}