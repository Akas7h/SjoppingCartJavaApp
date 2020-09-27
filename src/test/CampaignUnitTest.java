package test;

import main.Campaign;
import org.junit.Test;
import static org.junit.Assert.*;

public class CampaignUnitTest {
    @Test
    public void testAddCampaign(){
        Campaign campaign = new Campaign().setDiscount(15);

        float discount = campaign.getDiscount();

        assertEquals(15, discount, 0.001);
    }

    @Test
    public void testAddFailCampaign(){
        Campaign campaign = new Campaign().setDiscount(15);

        float discount = campaign.getDiscount();

        assertNotEquals(30, discount);
    }
}
