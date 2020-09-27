package test;

import main.Campaign;
import main.Category;
import org.junit.Test;

import static org.junit.Assert.*;

public class CategoryUnitTest {
    /*
    Create category and test asserts
     */
    @Test
    public void testAddCategory() {
        Category category = new Category().setTitle("testCategory").setParentCategory(null).setCampaign(null);

        String expectedTitle = category.getTitle();
        assertEquals(expectedTitle, "testCategory");

        Category parentCategory = category.getParentCategory();
        assertNull(parentCategory);

        Campaign campaign = category.getCampaign();
        assertNull(campaign);
    }

    @Test
    public void testAddFailCategory() {
        Category category = new Category().setTitle("testCategory").setParentCategory(null).setCampaign(null);

        String expectedTitle = category.getTitle();
        assertNotEquals(expectedTitle, "testCategory2");
    }
}
