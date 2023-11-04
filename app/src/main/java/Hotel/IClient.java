package Hotel;

import java.util.List;

/**
 * <h3>
 * <strong>Class that represents the structure of the Client data</strong>
 * </h3>
 *
 * @author Adão Araújo
 * @author Luis Oliveira
 * @author Rui Teixeira
 * @author Pedro Marques
 */
public interface IClient {

    //#region Gets

    /**
     * Returns the client Nationality
     * 
     * @return String with the client Nationality
     */
    String getNationality();

    /**
     * Returns the client Age
     * 
     * @return String with the client Age   
     */
    String getAge();
    

    /**
     * Returns the days since the client was created in the DB
     * 
     * @return String with the days since the client was created in the DB
     */
    String getDaysSinceCreation();

    /**
     * Returns the client name hash
     * 
     * @return String with the client name hash
     */
    String getNameHash();

    /**
     * Returns the client document id hash
     * 
     * @return String with the client document id hash
     */
    String getDocIDHash();

    /**
     *  Return the list of client transactions
     * 
     * @return List of client transactions
     */
    List<Transaction> getTransactions();

    /**
     * Returns the client score
     * 
     * @return int with the client score
     */
    List<Score> getScores();

     /**
     * Returns the total revenue
     *
     * @return Double with the total revenue
     */
    Double getTotalRevenue();

    /**
     * Returns the Most Interesting Time of Year
     *
     * @return int with the Most Interesting Time of Year
     */
    int getMostInterestingTimeOfYear();

    /**
     * Returns the Most Used Payment Method
     *
     * @return int with the Most Used Payment Method
     */
    int getMostUsedPaymentMethod();

    /**
     * Returns the Average Time Between Purchases
     *
     * @return float with the Average Time Between Purchases
     */
    float getAvgTimeBetweenPurchases();

    //#endregion
}
