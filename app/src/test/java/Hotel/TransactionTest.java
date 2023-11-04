package Hotel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TransactionTest {

private transient Transaction transaction;

@BeforeEach
public void setUp() {
    transaction = new Transaction();
    transaction.setID("1");
    transaction.setAverageLeadTime("5");
    transaction.setLodgingRevenue("100");
    transaction.setOtherRevenue("50");
    transaction.setDaysSinceLastStay("2");
    transaction.setDaysSinceFirstStay("TravelAgent");
    transaction.setDistributionChannel("Other");
    transaction.setMarketSegment("1");
    transaction.setPurchaseDate("2015-07-01");
    transaction.setPaymentMethod(Integer.parseInt("1"));


}

/**
 * Test for the getID method
 */
@Test
@DisplayName("Test for the getID method")
public void testGetID() {
    Assertions.assertEquals("1", transaction.getID(), "The ID should be '1'");
}

/**
 * Test for the getAverageLeadTime method
 */
@Test
@DisplayName("Test for the getAverageLeadTime method")
public void test() {
   
    transaction.setAverageLeadTime("5");
    Assertions.assertEquals("5", transaction.getAverageLeadTime(), "The average lead time should be '5'");
}

/**
 * Test for the getLodgingRevenue method
 */
@Test
@DisplayName("Test for the getLodgingRevenue method")
public void testGetLodgingRevenue() {
    transaction.setLodgingRevenue("100");
    Assertions.assertEquals("100", transaction.getLodgingRevenue(), "The lodging revenue should be '100'");
}

/**
 * Test for the getOtherRevenue method
 */
@Test
@DisplayName("Test for the getOtherRevenue method")
public void testGetOtherRevenue() {
    transaction.setOtherRevenue("50");
    Assertions.assertEquals("50", transaction.getOtherRevenue(), "The other revenue should be '50'");
}

/**
 * Test for the getDaysSinceLastStay method
 */
@Test
@DisplayName("Test for the getDaysSinceLastStay method")
public void testGetDaysSinceLastStay() {
    transaction.setDaysSinceLastStay("5");
    Assertions.assertEquals("5", transaction.getDaysSinceLastStay(), "The number of days since the last stay should be '5'");
}

/**
 * Test for the getDaysSinceFirstStay method
 */
@Test
@DisplayName("Test for the getDaysSinceFirstStay method")
public void testGetDaysSinceFirstStay() {
    transaction.setDaysSinceFirstStay("5");
    Assertions.assertEquals("5", transaction.getDaysSinceFirstStay(), "The number of days since the first stay should be '5'");
}

/**
 * Test for the getDistributionChannel method
 */
@Test
@DisplayName("Test for the getDistributionChannel method")
public void testGetDistributionChannel() {
    transaction.setDistributionChannel("Travel Agent/Operator");
    Assertions.assertEquals("Travel Agent/Operator", transaction.getDistributionChannel(), "The distribution channel should be 'Travel Agent/Operator'");
}

/**
 * Test for the getMarketSegment method
 */
@Test
@DisplayName("Test for the getMarketSegment method")
public void testGetMarketSegment() {
    transaction.setMarketSegment("Other");
    Assertions.assertEquals("Other", transaction.getMarketSegment(), "The market segment should be 'Other'");
}

/**
 * Test for the getPurchaseDate method
 */
@Test
@DisplayName("Test for the getPurchaseDate method")
public void testGetPurchaseDate() {
    transaction.setPurchaseDate("01/01/2022");
    Assertions.assertEquals("01/01/2022", transaction.getPurchaseDate(), "The purchase date should be '01/01/2022'");
}

/**
 * Test for the getPaymentMethod method
 */
@Test
@DisplayName("Test for the getPaymentMethod method")
public void testGetPaymentMethod() {
    transaction.setPaymentMethod(1);
    Assertions.assertEquals(1, transaction.getPaymentMethod(), "The payment method should be 1");
}

/**
 * Test for the toString method
 */
    @Test
    @DisplayName("Test for the Transaction toString method")
    public void testToString() {
        String expectedString = "Transaction {" +
        " ID=" +
        transaction.getID() +
        ", AverageLeadTime=" +
        transaction.getAverageLeadTime() +
        ", LodgingRevenue=" +
        transaction.getLodgingRevenue() +
        ", OtherRevenue=" +
        transaction.getOtherRevenue() +
        ", DaysSinceLastStay=" +
        transaction.getDaysSinceLastStay() +
        ", DaysSinceFirstStay=" +
        transaction.getDaysSinceFirstStay() +
        ", DistributionChannel='" +
        transaction.getDistributionChannel() +
        '\'' +
        ", MarketSegment='" +
        transaction.getMarketSegment() +
        '\'' +
        ", PurchaseDate='" +
        transaction.getPurchaseDate() +
        '\'' +
        ", PaymentMethod=" +
        transaction.getPaymentMethod() +
        "}\n";

        Assertions.assertEquals(expectedString, transaction.toString(), "The Transaction toString method should return a string with all the values of the transaction");
    }
}
