package test;
import main.Category;
import main.Product;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProductUnitTest {
    /*
    Create product, product and test asserts
     */
    @Test
    public void testAddProduct(){
        Category testCategory = new Category().setTitle("testCategoryTitle").setParentCategory(null).setCampaign(null);
        Product product = new Product().setTitle("productTitle").setCategory(testCategory).setPrice(100);

        String expectedTitle = product.getTitle();
        assertEquals(expectedTitle, "productTitle");

        float expectedPrice = product.getPrice();
        assertEquals(expectedPrice, 100, 0.1);
    }

    @Test
    public void testAddFailProduct(){
        Category testCategory = new Category().setTitle("testCategoryTitle").setParentCategory(null).setCampaign(null);
        Product product = new Product().setTitle("productTitle").setCategory(testCategory).setPrice(100);

        String expectedTitle = product.getTitle();
        assertNotEquals(expectedTitle, "productTitle2");

        float expectedPrice = product.getPrice();
        assertNotEquals(expectedPrice, 50, 0.1);
    }
}
