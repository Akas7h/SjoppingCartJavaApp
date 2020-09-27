package test;

import main.Category;
import main.Order;
import main.Product;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderUnitTest {
    @Test
    public void testCreateOrder() {
        Category testCategory = new Category().setTitle("testCategoryTitle").setParentCategory(null).setCampaign(null);
        Product product = new Product().setTitle("productTitle").setCategory(testCategory).setPrice(100);

        Order order = Order.newBuilder().address("Istanbul/Sisli").username("kaanozbudak").addToCart(product, 2).checkout();

        String expectedUsername = order.username;
        assertEquals(expectedUsername, "kaanozbudak");

        float expectedFinalAmount = order.finalAmount;
        // (100 * 2) + (10 * 2)
        assertEquals(220, expectedFinalAmount, 0.1);
    }

    @Test
    public void testFailCreateOrder() {
        Category testCategory = new Category().setTitle("testCategoryTitle").setParentCategory(null).setCampaign(null);
        Product product = new Product().setTitle("productTitle").setCategory(testCategory).setPrice(100);

        Order order = Order.newBuilder().address("Istanbul/Sisli").username("kaanozbudak").addToCart(product, 2).checkout();

        String expectedAddress = order.address;
        assertNotEquals(expectedAddress, "Istanbul/Bahcelievler");

        float expectedFinalAmount = order.finalAmount;
        // (100 * 2) + (10 * 2)
        assertNotEquals(100, expectedFinalAmount, 0.1);
    }
}
