package order;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.example.order.OrderClient;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import static org.apache.http.HttpStatus.SC_OK;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ListOrderTest {
    private OrderClient orderClient;

    @Before
    public void setUp() {

        orderClient = new OrderClient();
    }

    @Test
    @DisplayName("Проверка ответа что возвратится список заказов")
    public void getOrderReturnedOrderList(){
        ValidatableResponse responseOrderList= orderClient.returnOrderList();
        ArrayList actualList = responseOrderList.extract().path("orders");
        int ordersSize = actualList.size();
        boolean actual = ordersSize > 0;
        int actualStatusCode = responseOrderList.extract().statusCode();
        assertEquals("Неверно",SC_OK, actualStatusCode);
        assertTrue( "Список заказов больше 0", actual);
    }
}
