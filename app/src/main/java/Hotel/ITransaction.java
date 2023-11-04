package Hotel;

/**
 * <h3>
 * <strong>Interface that represents the methods of the Transaction data</strong>
 * </h3>
 *
 * @author Adão Araújo
 * @author Luis Oliveira
 * @author Rui Teixeira
 * @author Pedro Marques
 */
public interface ITransaction {

    //#region Gets

    /**
     * Returns the transaction ID
     * 
     * @return String with the transaction ID
     */
    String getID();

    /**
     * Returns the average lead time
     * 
     * @return String with the client average lead time
     */
    String getAverageLeadTime();

    /**
     * Returns the lodging revenue
     * 
     * @return String with the client lodging revenue
     */
    String getLodgingRevenue();

    /**
     * Returns other revenue (Complementary services...)
     * 
     * @return String with the client other revenue (Complementary services...)
     */
    String getOtherRevenue();

    /**
     * Returns the days since last stay
     * @return String with the days since last stay
     */
    String getDaysSinceLastStay();

    /**
     * Returns the days since first stay
     * 
     * @return String with the days since first stay
     */
    String getDaysSinceFirstStay();

    /**
     * Returns the channel used to book the stay (Via agency, direct, etc)
     * 
     * @return String with the channel used to book the stay (Via agency, direct, etc)
     */
    String getDistributionChannel();

    /**
     * Returns the type of client (company, individual, etc)
     * 
     * @return String with the type of client (company, individual, etc)
     */
    String getMarketSegment();

    /**
     * Returns the date of purchase
     * 
     * @return String with the date of purchase
     */
    String getPurchaseDate();

    /**
     * Returns the Payment Method
     * 
     * @return int with the Payment Method
     */
    int getPaymentMethod();

    //#endregion
    
}