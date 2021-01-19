import static org.junit.Assert.assertEquals;
import org.junit.Test;
import java.util.*;

public class OrderingSystemTest {  
    @Test
    public void testOrderName() {
        OrderingSystem orderingSystem = new OrderingSystem();
        assertEquals(orderingSystem.getOrderName(0), "Special");
        assertEquals(orderingSystem.getOrderName(5), "Bread");
    }

    @Test
    public void testOrderPrice() {
        OrderingSystem orderingSystem = new OrderingSystem();
        assertEquals(orderingSystem.getPrice(1), 45, 0);
        assertEquals(orderingSystem.getPrice(4), 15, 0);
    }

    @Test
    public void testTotal() {
        OrderingSystem orderingSystem = new OrderingSystem();
        orderingSystem.order(0, 1); //40 * 1
        assertEquals(orderingSystem.total, 40, 0);
        orderingSystem.order(1, 2); //45 * 2
        assertEquals(orderingSystem.total, 130, 0);
    }

    @Test
    public void testChange1() {
        OrderingSystem orderingSystem = new OrderingSystem();
		orderingSystem.order(0, 1); //40 * 1
		orderingSystem.order(1, 2); //45 * 2
		assertEquals(orderingSystem.getChange(1000), 870, 0);
	}
	
	@Test
    public void testChange2() {
        OrderingSystem orderingSystem = new OrderingSystem();
		orderingSystem.order(5, 5); //7 * 5
		orderingSystem.order(1, 2); //45 * 2
		orderingSystem.order(2, 2); //50 * 2
		assertEquals(orderingSystem.getChange(1000), 775, 0);
    }
}