package Hotel;


import java.util.Collections;
import java.util.Comparator;

import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;


/**
 * <h3>
 * <strong>Class that represents the client Score based on Total Purchases,
 * Monetization and Regularity indexes</strong>
 * </h3>
 *
 * @author Adão Araújo
 * @author Luis Oliveira
 * @author Rui Teixeira
 * @author Pedro Marques
 */
public class Score implements IScore {

    public Score(String type, int quartil, String value) {
        this.type = type;
        this.quartil = quartil;
        this.value = value;
    }

    public Score() {
    }

    // #region Variables

    private static final Logger log = Logger.getLogger(Score.class.getName());
    /**
     * Reference to the type of score
     */
    private String type;

    /**
     * Reference to the value of the score
     */
    private String value;

    /**
     * Reference to the value of the score
     */
    private int quartil;

    // #endregion

    // #region Gets

    /**
     * Returns the type of score
     * 
     * @return String with the type of score
     */
    @Override
    public String getType() {
        return type;
    }

    /**
     * Returns the value f the score
     * 
     * @return int with the value of the score
     */
    @Override
    public int getQuartil() {
        return quartil;
    }

    /**
     * Returns the value f the score
     * 
     * @return int with the value of the score
     */
    @Override
    public String getValue() {
        return value;
    }

    /**
     * Method to divide the list of clients into quartiles and assign a score to
     * each client based on the quartile they are in
     *
     * @param clientList List of clients
     */
    @Override
    public void getScore(String type, List<Client> clientList) {
        // Divide the list of clients into 4 quartiles
        int size = clientList.size();
        int q1 = size / 4;
        int q2 = size / 2;
        int q3 = (size * 3) / 4;

        // Assign a score to each client based on the quartile they are in
        for (int i = 0; i < size; i++) {
            Client client = clientList.get(i);
            if (i < q1) {
                assignScore(type, client, 1);
            } else if (i < q2) {
                assignScore(type, client, 2);
            } else if (i < q3) {
                assignScore(type, client, 3);
            } else {
                assignScore(type, client, 4);
            }
        }
    }

    /**
     * Method to get the purchase date of the last transaction of a client
     *
     * @param clientList List of clients
     * @return String with the purchase date of the last transaction
     */
    private String getLastPurchaseDate(Client client) {

        // Get the list of transactions for the client
        List<Transaction> transactions = client.getTransactions();
        if (client.getTransactions().isEmpty()) {
            return "O cliente nao tem transacoes";
        }

        client.sortTransactionsByPurchaseDate();

        // Get the last transaction in the sorted list
        Transaction lastTransaction = transactions.get(transactions.size() - 1);

        // Get the purchase date of the last transaction
        return lastTransaction.getPurchaseDate();
    }

    /**
     * Method to sort the list of clients by the purchase date of the last
     * transaction
     *
     * @param clientList List of clients
     * @return List of clients sorted by the purchase date of the last transaction
     *         and with a score assigned to each client based on the quartile they
     *         are in
     * @throws Exception
     */
    @Override
    public List<Client> getRegularity(List<Client> clientList) throws Exception {
        if (clientList.isEmpty()) {
            throw new Exception("A lista de clientes esta vazia");
        }
        try {
            // Sort the list of clients by the last purchase date
            clientList.sort(new Comparator<Client>() {
                @Override
                public int compare(Client c1, Client c2) {
                    // Extract the year, month, and day from the date strings
                    String date1 = getLastPurchaseDate(c1);
                    String year1 = date1.substring(6);
                    String month1 = date1.substring(3, 5);
                    String day1 = date1.substring(0, 2);

                    String date2 = getLastPurchaseDate(c2);
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

            getScore("Regularity", clientList);

        } catch (Exception ex) {
            throw new Exception(ex);
        }

        return clientList;
    }

    /**
     * Method to sort the list of clients by the number of transactions
     *
     * @param clientList List of clients
     * @return List of clients sorted by the number of transactions and with a score
     *         assigned to each client based on the quartile they are in
     * @throws Exception
     */
    @Override
    public void getTotalPurchases(List<Client> clientList) throws Exception {
        if (clientList.isEmpty()) {
            throw new Exception("A lista de clientes esta vazia");
        }
        try {
            // Sort the list of clients by the number of transactions they have made
            Collections.sort(clientList, new Comparator<Client>() {
                @Override
                public int compare(Client c1, Client c2) {
                    return c1.getTransactions().size() - c2.getTransactions().size();
                }
            });

            getScore("Total_Purchase", clientList);

        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    /**
     * Method to sort the list of clients by the total amount of money they have
     * spent
     *
     * @param clientList List of clients
     * @return List of clients sorted by the total amount of money they have spent
     *         and with a score assigned to each client based on the quartile they
     *         are in
     * @throws Exception
     */
    @Override
    public List<Client> getMonetization(List<Client> clientList) throws Exception {
        if (clientList.isEmpty()) {
            throw new Exception("A lista de clientes esta vazia");
        }
        try {
            // add the total revenue of each client
            for (Client client : clientList) {

                Double totalRevenue = 0.0;

                for (Transaction transaction : client.getTransactions()) {
                    if (client.getTransactions().isEmpty()) {
                        log.log(Level.INFO,"O cliente nao tem transacoes");
                    }
                    // Replace the comma with an empty string
                    String lodgingRevenueString = transaction.getLodgingRevenue();
                    String otherRevenueString = transaction.getOtherRevenue();

                    // Parse the modified string as a double
                    double lodgingRevenue = Double.parseDouble(lodgingRevenueString);
                    double otherRevenue = Double.parseDouble(otherRevenueString);

                    // Add the revenue to the total
                    totalRevenue += lodgingRevenue + otherRevenue;
                }
                client.setTotalRevenue(totalRevenue);
            }

            // Sort the list of clients by the total revenue they have generated
            Collections.sort(clientList, new Comparator<Client>() {
                @Override
                public int compare(Client c1, Client c2) {
                    return (int) (c1.getTotalRevenue() - c2.getTotalRevenue());
                }
            });

            getScore("Monetization", clientList);

        } catch (Exception e) {
            throw new Exception(e);
        }
        return clientList;
    }



    // #region Sets
    /**
     * Sets the string for the type of score
     * 
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Sets the value for the score value
     * 
     * @param value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Sets the value for the score value
     * 
     * @param quartil
     */
    public void setQuartil(int quartil) {
        this.quartil = quartil;
    }

    // #endregion

    /**
     * To String method
     * 
     * @return String with the score information
     */
    @Override
    public String toString() {
        return "Score [{"+ type + "= "+ value + "}]";
    }

    /**
     * Method to assign a score
     * 
     * @param type     Type of score
     * @param client   Client to assign the score
     * @param quartil  Quartile to assign the score
     */
    private void assignScore(String type, Client client, int quartil) {

        switch (type) {
            case "Regularity":
                client.setScores(type, quartil, getLastPurchaseDate(client));
                break;
            case "Total_Purchase":
                client.setScores(type, quartil, String.valueOf(client.getTransactions().size()));
                break;
            case "Monetization":
                client.setScores(type, quartil, String.valueOf(client.getTotalRevenue()));
                break;
            default:
        }
    }
}
