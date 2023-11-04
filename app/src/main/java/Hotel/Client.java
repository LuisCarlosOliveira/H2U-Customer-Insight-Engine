package Hotel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

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

 @JsonPropertyOrder({"DocIDHash", "MostInterestingTimeOfYear", "MostUsedPaymentMethod", "AvgTimeBetweenPurchases", "scores"})
public class Client implements IClient {
    
    public Client() {
        setTransactions(new ArrayList<Transaction>());
        this.scores = new ArrayList<Score>();
    }

    // #region Variables

    /**
     * Reference to the Client Nationality
     */
    @JsonIgnore
    private String Nationality;

    /**
     * Reference to the client Age
     */
    @JsonIgnore
    private String Age;

    /**
     * Reference to the days since the client was created in the DB
     */
    @JsonIgnore
    private String DaysSinceCreation;

    /**
     * Reference to the client name hash
     */
    @JsonIgnore
    private String NameHash;

    /**
     * Reference to the client document id hash
     */
    private String DocIDHash;

    /**
     * Reference to the client most interesting time of the year
     */
    private int MostInterestingTimeOfYear;

    /**
     * Reference to the client most used payment method
     */
    private int MostUsedPaymentMethod;

    /**
     * Reference to the client average time between purchases
     */
    private float AvgTimeBetweenPurchases;

    /**
     * Reference to the client list of transactions
     */
    @JsonIgnore
    private List<Transaction> transactions;

    /**
     * Reference to the client list of scores
     */
    private List<Score> scores;

    /**
     * Reference to the total revenue (LodgingRevenue + OtherRevenue)
     */
    @JsonIgnore
    private Double TotalRevenue;

    // #endregion

    // #region Gets

    /**
     * Returns the client Nationality
     * 
     * @return String with the client Nationality
     */
    @Override
    @JsonIgnore
    public String getNationality() {
        return Nationality;
    }

    /**
     * Returns the client Age
     * 
     * @return String with the client Age
     */
    @Override
    @JsonIgnore
    public String getAge() {
        return Age;
    }

    /**
     * Returns the days since the client was created in the DB
     * 
     * @return String with the days since the client was created in the DB
     */
    @Override
    @JsonIgnore
    public String getDaysSinceCreation() {
        return DaysSinceCreation;
    }

    /**
     * Returns the client name hash
     * 
     * @return String with the client name hash
     */
    @Override
    @JsonIgnore
    public String getNameHash() {
        return NameHash;
    }

    /**
     * Returns the client document hash
     * 
     * @return String with the client document hash
     */
    @Override
    public String getDocIDHash() {
        return DocIDHash;
    }
    
    /**
     * Returns the client most interesting time of the year
     * 
     * @return Integer with the most interesting time of the year of the client
     */
    @Override
    public int getMostInterestingTimeOfYear() {
        return MostInterestingTimeOfYear;
    }

    /**
     * Returns the most used payment method
     * 
     * @return String with the most used payment method
     */
    @Override
    public int getMostUsedPaymentMethod() {
        return MostUsedPaymentMethod;
    }

    /**
     * Returns the average time between purchases
     * 
     * @return String with the most used payment method
     */
    @Override
    public float getAvgTimeBetweenPurchases() {
        return AvgTimeBetweenPurchases;
    }

    /**
     * Returns the client list of transactions
     * 
     * @return List of the client transactions
     */
    @Override
    @JsonIgnore
    public List<Transaction> getTransactions() {
        return transactions;
    }

    /**
     * Returns the client score
     * 
     * @return int with the client score
     */
    @Override
    public List<Score> getScores() {
        return scores;
    }

    /**
     * Returns the client specific score
     * 
     * @param type
     * @return int with the client score
     */
    public int getSpecificQuartil(String type) {
        int valor = 0;
        for (Score score : scores) {
            if (score.getType().equals(type)) {
                if (valor == 0) {
                    valor = score.getQuartil();
                }
            }
        }
        return valor;
    }

    /**
     * Returns the client specific score
     * 
     * @param type
     * @return String with the client score
     */
    public String getSpecificValue(String type) {
        String valor = "";
        for (Score score : scores) {
            if (score.getType().equals(type)) {
                    valor = score.getValue();
            }
        }
        return valor;
    }

     /**
     * Returns the total revenue
     *
     * @return Double with the total revenue
     */
    @Override
    @JsonIgnore
    public Double getTotalRevenue() {
        return TotalRevenue;
    }
    // #endregion

    // #region Sets

    /**
     * Sets the value for nationality
     * 
     * @param nationality
     */
    public void setNationality(String nationality) {
        Nationality = nationality;
    }

    /**
     * Sets the value for age
     * 
     * @param age
     */
    public void setAge(String age) {
        Age = age;
    }

    /**
     * Sets the value for the days since creation
     * 
     * @param daysSinceCreation
     */
    public void setDaysSinceCreation(String daysSinceCreation) {
        DaysSinceCreation = daysSinceCreation;
    }

    /**
     * Sets the value for the name hash
     * 
     * @param nameHash
     */
    public void setNameHash(String nameHash) {
        NameHash = nameHash;
    }

    /**
     * Sets the value for the Doc Id Hash
     * 
     * @param docIDHash
     */
    public void setDocIDHash(String docIDHash) {
        DocIDHash = docIDHash;
    }

    /**
     * Sets the value for the Most Interesting Time Of The Year
     * 
     * @param mostInterestingTimeOfYear
     */
    public void setMostInterestingTimeOfYear(int mostInterestingTimeOfYear) {
        MostInterestingTimeOfYear = mostInterestingTimeOfYear;
    }

    /**
     * Sets the value for the Most Used Payment method
     * 
     * @param mostUsedPaymentMethod
     */
    public void setMostUsedPaymentMethod(int mostUsedPaymentMethod) {
        MostUsedPaymentMethod = mostUsedPaymentMethod;
    }

    /**
     * Sets the value for the Average Time Between Purchases
     * 
     * @param avgTimeBetweenPurchases
     */
    public void setAvgTimeBetweenPurchases(float avgTimeBetweenPurchases) {
        AvgTimeBetweenPurchases = avgTimeBetweenPurchases;
    }

    /**
     * Sets the value for the transactions
     * 
     * @param transactions
     */
    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    /**
     * Sets the value for the score
     * 
     * @param type
     * @param value
     */
    public void setScores(String type, int quartil, String value) {
        for (Score score : scores) {
            if (score.getType().equals(type)) {
                score.setQuartil(quartil);
                score.setValue(value);
            }
        }
    }

    /**
     * Sets the value for the client totalRevenue
     * 
     * @param totalRevenue
     */
    public void setTotalRevenue(Double totalRevenue) {
        TotalRevenue = totalRevenue;
    }
    // #endregion

    /**
     * Method tto Sort the transactions by purchase date~
     */
    public void sortTransactionsByPurchaseDate(){
        // Sort the transactions by purchase date
        this.transactions.sort(new Comparator<Transaction>() {
            @Override
            public int compare(Transaction t1, Transaction t2) {
                // Extract the year, month, and day from the date strings
                String date1 = t1.getPurchaseDate();
                String year1 = date1.substring(6);
                String month1 = date1.substring(3, 5);
                String day1 = date1.substring(0, 2);
    
                String date2 = t2.getPurchaseDate();
                String year2 = date2.substring(6);
                String month2 = date2.substring(3, 5);
                String day2 = date2.substring(0, 2);
    
                // Compare the year, month, and day fields lexicographically
                int result = year1.compareTo(year2);
                if (result == 0) {
                    result = month1.compareTo(month2);
                    if (result == 0) {
                        result = day1.compareTo(day2);
                    }
                }
                return result;
            }
        });
    }

    /**
     * To String method
     * 
     * @return String with the client information
     */
    @Override
    public String toString() {
        return "Client {" +
                "Nationality='" + Nationality + '\'' +
                ", Age=" + Age +
                ", DaysSinceCreation=" + DaysSinceCreation +
                ", NameHash='" + NameHash + '\'' +
                ", DocIDHash='" + DocIDHash + '\'' +
                "}\n";
    }

}