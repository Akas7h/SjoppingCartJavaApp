package test;

import main.Campaign;
import main.Category;
import main.Order;
import main.Product;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderUnitTest {
    /*
    Create category, product, order and checkout test asserts
     */
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

    @Test
    public void testDiscountOrder() {
        Campaign campaign = new Campaign().setDiscount(20);
        Category testCategory = new Category().setTitle("testCategoryTitle").setParentCategory(null).setCampaign(campaign);
        Product product = new Product().setTitle("productTitle").setCategory(testCategory).setPrice(100);

        Order order = Order.newBuilder().address("Istanbul/Sisli").username("kaanozbudak").addToCart(product, 5).checkout();

        float expectedFinalAmount = order.finalAmount;
        // (100 * 5) > minimum cart discount which 400, so set discount %20 and add delivery cost
        // (100 * 5) * 80/100 + 5 * 10
        assertEquals(450, expectedFinalAmount, 0.1);
    }

    @Test
    public void testFailDiscountOrder() {
        Campaign campaign = new Campaign().setDiscount(20);
        Category testCategory = new Category().setTitle("testCategoryTitle").setParentCategory(null).setCampaign(campaign);
        Product product = new Product().setTitle("productTitle").setCategory(testCategory).setPrice(100);

        Order order = Order.newBuilder().address("Istanbul/Sisli").username("kaanozbudak").addToCart(product, 5).checkout();

        float expectedFinalAmount = order.finalAmount;
        // (100 * 5) > minimum cart discount which 400, so set discount %20 and add delivery cost
        // (100 * 5) * 80/100 + 5 * 10
        assertNotEquals(550, expectedFinalAmount, 0.1);
    }
}
