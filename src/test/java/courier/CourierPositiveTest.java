package courier;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.example.courier.Courier;
import org.example.courier.CourierClient;
import org.example.courier.CourierGenerator;
import org.example.courier.Credentials;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CourierPositiveTest {
    private CourierClient courierClient;
    private Courier courier;
    private int id;

   @Before
    public void setUp() {
       courierClient = new CourierClient();
       courier = CourierGenerator.defaultCourier;
    }

    @After
    public void cleanUp(){

       courierClient.delete(id);
    }

    @Test
    @DisplayName("Проверка ответа когда курьер содан" )
    public void courierCanBeCreated(){
       ValidatableResponse responseCreate = courierClient.create(courier);
       ValidatableResponse responseLogin = courierClient.login(Credentials.from(courier));
       id = responseLogin.extract().path("id");
       int actualStatusCode = responseCreate.extract().statusCode();
       boolean isCourierCreated = responseCreate.extract().path("ok");
       assertEquals("Некорректно",actualStatusCode, SC_CREATED);
       assertTrue("Корректно",isCourierCreated);
    }

    @Test
    @DisplayName("Проверка ответа при входе курьера в систему" )
    public void courierCanBeLoginAndCheckResponse(){
        ValidatableResponse responseCreate = courierClient.create(courier);
        ValidatableResponse responseLogin = courierClient.login(Credentials.from(courier));
        id = responseLogin.extract().path("id");
        int actualStatusCode = responseLogin.extract().statusCode();
        assertEquals("Неверно",actualStatusCode,SC_OK);
        assertThat("Вошел",id, notNullValue());
    }
}
