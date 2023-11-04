package Hotel;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

/**
 * Test class for the Client class
 */
public class ClientTest {

    private transient Client client;

    @BeforeEach
    public void setUp() {
        //Create Client
        client = new Client();
        client.setNationality("PRT");
        client.setAge("30");
        client.setDaysSinceCreation("20");
        client.setNameHash("123456789");
        client.setDocIDHash("987654321");
        client.getScores().add(new Score("Regularity", 1,"1"));
        client.getScores().add(new Score("Total_Purchase", 2,"2"));
        client.getScores().add(new Score("Monetization", 3,"3"));
        client.setTotalRevenue(1000.50);
        client.setMostInterestingTimeOfYear(3);
        client.setMostUsedPaymentMethod(2);
        client.setAvgTimeBetweenPurchases(15.5f);
        
    }


    /**
     * Test for the getNationality method
     */
    @Test
    @DisplayName("Test for the getNationality method")
    public void testGetNationality() {
        Assertions.assertEquals("PRT", client.getNationality(), "Nationality should be 'PRT'");
    }

    /**
     * Test for the getAge method
     */
    @Test
    @DisplayName("Test for the getAge method")
    public void testGetAge() {
        Assertions.assertEquals("30", client.getAge(), "Age should be '30'");
    }

    /**
     * Test for the getDaysSinceCreation method
     */
    @Test
    @DisplayName("Test for the getDaysSinceCreation method")
    public void testGetDaysSinceCreation() {
        Assertions.assertEquals("20", client.getDaysSinceCreation(), "Days since creation should be '20'");
    }

    /**
     * Test for the getNameHash method
     */
    @Test
    @DisplayName("Test for the getNameHash method")
    public void testGetNameHash() {
        Assertions.assertEquals("123456789", client.getNameHash(), "Name hash should be '123456789'");
    }

    /**
     * Test for the getDocIDHash method
     */
    @Test
    @DisplayName("Test for the getDocIDHash method")
    public void testGetDocIDHash() {
        Assertions.assertEquals("987654321", client.getDocIDHash(), "Doc ID hash should be '987654321'");
    }

    /**
     * Test for the getTransactions method
     */
    @Test
    @DisplayName("Test for the getTransactions method")
    public void testGetTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        client.setTransactions(transactions);
        Assertions.assertEquals(transactions, client.getTransactions(), "Transactions should be an empty list");
    }

    /**
     * Test for the getTotalRevenue method
     */
    @Test
    @DisplayName("Test for the getTotalRevenue method")
    public void testGetTotalRevenue() {
        Assertions.assertEquals(1000.50, client.getTotalRevenue(), "Total revenue should be 1000.50");
    }

    /**
     * Test for the getMostInterestingTimeOfYear method
     */
    @Test
    @DisplayName("Test for the getMostInterestingTimeOfYear method")
    public void testGetMostInterestingTimeOfYear() {
        Assertions.assertEquals(3, client.getMostInterestingTimeOfYear(), "Most interesting time of year should be 3");
    }

    /**
     * Test for the getMostUsedPaymentMethod method
     */
    @Test
    @DisplayName("Test for the getMostUsedPaymentMethod method")
    public void testGetMostUsedPaymentMethod() {
        Assertions.assertEquals(2, client.getMostUsedPaymentMethod(), "Most used payment method should be 2");
    }

    /**
     * Test for the getAvgTimeBetweenPurchases method
     */
    @Test
    @DisplayName("Test for the getAvgTimeBetweenPurchases method")
    public void testGetAvgTimeBetweenPurchases() {
        Assertions.assertEquals(15.5f, client.getAvgTimeBetweenPurchases(), 0.001, "Avg time between purchases should be 15.5");
    }
    
    /**
     * Test for the getScores method
     */
    @Test
    @DisplayName("Test for the getScores method")
    public void testGetScores() {
        Assertions.assertEquals(3, client.getScores().size(), "Scores should be 3");
    }

    /**
     * Test for the getSpecificScore type Regularity method
     */
    @Test
    @DisplayName("Test for the getSpecificScore method")
    public void testGetSpecificScore() {
        Assertions.assertEquals(1, client.getSpecificQuartil("Regularity"), "Score for Regularity should be 1");
    }

    /**
     * Test for the getSpecificScore type Total Purchase method
     */
    @Test
    @DisplayName("Test for the getSpecificScore_2 method")
    public void testGetSpecificScore_2() {
        Assertions.assertEquals(2, client.getSpecificQuartil("Total_Purchase"), "Score for Total_Purchase should be 2");
    }

    /**
     * Test for the getSpecificScore type Monetization method
     */
    @Test
    @DisplayName("Test for the getSpecificScore_3 method")
    public void testGetSpecificScore_3() {
        Assertions.assertEquals(3, client.getSpecificQuartil("Monetization"), "Score for Monetization should be 3");
    }

    /**
     * Test Client toString method
     */
    @Test
    @DisplayName("Test for the Client toString method")
    public void testToString() {
        String expected = "Client {" +
        "Nationality='" + client.getNationality() + '\'' +
        ", Age=" + client.getAge() +
        ", DaysSinceCreation=" + client.getDaysSinceCreation() +
        ", NameHash='" + client.getNameHash() + '\'' +
        ", DocIDHash='" + client.getDocIDHash() + '\'' +
        "}\n";
        
        assertEquals(expected, client.toString(), "Client toString should return a string with the client's information");
    }


    /**
     * Test the testGetSpecificValue method for Regularity
     */
    @Test
    @DisplayName("Test for the Client testGetSpecificValue method for Regularity")
    public void testGetSpecificValue() {
        assertEquals("1", client.getSpecificValue("Regularity"), "Client getSpecificValue should return a string with the client Regularity score");
    }
    
    /**
     * Test the testGetSpecificValue method for Total_Purchase
     */
    @Test
    @DisplayName("Test for the Client testGetSpecificValue method for Total_Purchase")
    public void testGetSpecificValue_2() {
        assertEquals("2", client.getSpecificValue("Total_Purchase"), "Client getSpecificValue should return a string with the client TotalPurchase score");
    }

    /**
     * Test the testGetSpecificValue method for Monetization
     */
    @Test
    @DisplayName("Test for the Client testGetSpecificValue method for Monetization")
    public void testGetSpecificValue_3() {
        assertEquals("3", client.getSpecificValue("Monetization"), "Client getSpecificValue should return a string with the client Monetization score");
    }
}
