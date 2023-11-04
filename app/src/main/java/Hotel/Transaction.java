package Hotel;

/**
 * <h3>
 * <strong>Class that represents the structure of the Transaction data</strong>
 * </h3>
 *
 * @author Adão Araújo
 * @author Luis Oliveira
 * @author Rui Teixeira
 * @author Pedro Marques
 */
public class Transaction implements ITransaction {

    // #region Variables

    /**
     * Reference to the transaction ID
     */
    private String ID;

    /**
     * Reference to the client average lead time
     */
    private String AverageLeadTime;

    /**
     * Reference to the client lodging revenue
     */
    private String LodgingRevenue;

    /**
     * Reference to the client other revenue (Complementary services...)
     */
    private String OtherRevenue;

    /**
     * Reference to the days since last booking
     */
    private String DaysSinceLastStay;

    /**
     * Reference to the days since first booking
     */
    private String DaysSinceFirstStay;

    /**
     * Reference to the channel used to book the stay (Via agency, direct, etc)
     */
    private String DistributionChannel;

    /**
     * Reference to the type of client (company, individual, etc)
     */
    private String MarketSegment;

    /**
     * String reference to the date of purchase (dd/mm/yyyy)
     */
    private String PurchaseDate;

    /**
     * String reference to the payment method
     */
    private int PaymentMethod;

    // #endregion

    // #region Gets

    /**
     * Returns the transaction ID
     *
     * @return String with the transaction ID
     */
    @Override
    public String getID() {
        return ID;
    }

    /**
     * Returns the client average lead time
     *
     * @return String with the client average lead time
     */
    @Override
    public String getAverageLeadTime() {
        return AverageLeadTime;
    }

    /**
     * Returns the client lodging revenue
     *
     * @return String with the client lodging revenue
     */
    @Override
    public String getLodgingRevenue() {
        return LodgingRevenue;
    }

    /**
     * Returns the client other revenue (Complementary services...)
     *
     * @return String with the client other revenue (Complementary services...)
     */
    @Override
    public String getOtherRevenue() {
        return OtherRevenue;
    }

    /**
     * Returns the days since last stay
     * 
     * @return String with the days since last stay
     */
    @Override
    public String getDaysSinceLastStay() {
        return DaysSinceLastStay;
    }

    /**
     * Returns the days since first stay
     *
     * @return String with the days since first stay
     */
    @Override
    public String getDaysSinceFirstStay() {
        return DaysSinceFirstStay;
    }

    /**
     * Returns the channel used to book the stay (Via agency, direct, etc)
     *
     * @return String with the channel used to book the stay (Via agency, direct,
     *         etc)
     */
    @Override
    public String getDistributionChannel() {
        return DistributionChannel;
    }

    /**
     * Returns the type of client (company, individual, etc)
     *
     * @return String with the type of client (company, individual, etc)
     */
    @Override
    public String getMarketSegment() {
        return MarketSegment;
    }

    /**
     * Returns the date of purchase
     *
     * @return String with the date of purchase
     */
    @Override
    public String getPurchaseDate() {
        return PurchaseDate;
    }

    /**
     * Returns the Payment Method
     *
     * @return String with the Payment Method
     */
    @Override
    public int getPaymentMethod() {
        return PaymentMethod;
    }

    // #endregion

    // #region Sets

    /**
     * Sets the transaction ID
     *
     * @param iD String with the transaction ID
     */
    public void setID(String iD) {
        ID = iD;
    }

    /**
     * Sets the client average lead time
     *
     * @param averageLeadTime String with the client average lead time
     */
    public void setAverageLeadTime(String averageLeadTime) {
        AverageLeadTime = averageLeadTime;
    }
    
    /**
     * Sets the client lodging revenue
     *
     * @param lodgingRevenue String with the client lodging revenue
     */
    public void setLodgingRevenue(String lodgingRevenue) {
        LodgingRevenue = lodgingRevenue;
    }

    /**
     * Sets the client other revenue
     *
     * @param otherRevenue String with the client other revenue
     */
    public void setOtherRevenue(String otherRevenue) {
        OtherRevenue = otherRevenue;
    }

    /**
     * Sets the days since last stay
     *
     * @param daysSinceLastStay String with the days since last stay
     */
    public void setDaysSinceLastStay(String daysSinceLastStay) {
        DaysSinceLastStay = daysSinceLastStay;
    }

    /**
     * Sets the days since first stay
     *
     * @param daysSinceFirstStay String with the days since first stay
     */
    public void setDaysSinceFirstStay(String daysSinceFirstStay) {
        DaysSinceFirstStay = daysSinceFirstStay;
    }

    /**
     * Sets the channel used to book the stay 
     *
     * @param distributionChannel String with the channel used to book the stay
     */
    public void setDistributionChannel(String distributionChannel) {
        DistributionChannel = distributionChannel;
    }

    /**
     * Sets the type of client
     *
     * @param marketSegment String with the type of client
     */
    public void setMarketSegment(String marketSegment) {
        MarketSegment = marketSegment;
    }

    /**
     * Sets the date of purchase
     *
     * @param purchaseDate String with the date of purchase
     */
    public void setPurchaseDate(String purchaseDate) {
        PurchaseDate = purchaseDate;
    }

    /**
     * Sets the Payment Method
     *
     * @param paymentMethod String with the Payment Method
     */
    public void setPaymentMethod(int paymentMethod) {
        PaymentMethod = paymentMethod;
    }

    // #endregion
    
    /**
     * To String method
     *
     * @return String with the Transaction data
     */
    @Override
    public String toString() {
        return ("Transaction {" +
                " ID=" +
                ID +
                ", AverageLeadTime=" +
                AverageLeadTime +
                ", LodgingRevenue=" +
                LodgingRevenue +
                ", OtherRevenue=" +
                OtherRevenue +
                ", DaysSinceLastStay=" +
                DaysSinceLastStay +
                ", DaysSinceFirstStay=" +
                DaysSinceFirstStay +
                ", DistributionChannel='" +
                DistributionChannel +
                '\'' +
                ", MarketSegment='" +
                MarketSegment +
                '\'' +
                ", PurchaseDate='" +
                PurchaseDate +
                '\'' +
                ", PaymentMethod=" +
                PaymentMethod +
                "}\n");
    }

}
