package Hotel;

import java.util.List;

/**
 * <h3>
 * <strong>Interface that represents represents the client Score based on Total Purchases, Monetization and Regularity indexes</strong>
 * </h3>
 *
 * @author Adão Araújo
 * @author Luis Oliveira
 * @author Rui Teixeira
 * @author Pedro Marques
 */
public interface IScore {

    //#region Gets

    /**
     * Returns the type os score
     * 
     * @return String with the type of score
     */
    String getType();

    /**
     * Returns the quartil
     * 
     * @return int with the value of the quartil
     */
    int getQuartil();
    
    /**
     * Returns the value of the score
     * 
     * @return String with the value of the score
     */
    String getValue();

    /**
     * Method to divide the list of clients into quartiles and assign a score to each client based on the quartile they are in
     *
     * @param clientList List of clients
     */
    void getScore(String type, List<Client> clientList);

    /**
     * Method to sort the list of clients by the purchase date of the last transaction
     *
     * @param clientList List of clients
     * @return List of clients sorted by the purchase date of the last transaction and with a score assigned to each client based on the quartile they are in
     * @throws Exception
     */
    List<Client> getRegularity(List<Client> clientList) throws Exception;
    
    /**
     * Method to get the purchase date of the last transaction of a client
     *
     * @param clientList List of clients
     * @return String with the purchase date of the last transaction
     * @throws Exception
     */ 
    // String getLastPurchaseDate(Client client);

    /**
     * Method to sort the list of clients by the number of transactions
     *
     * @param clientList List of clients
     * @return List of clients sorted by the number of transactions they and with a score assigned to each client based on the quartile they are in
     * @throws Exception
     */
    void getTotalPurchases(List<Client> clientList) throws Exception;

    /**
     * Method to sort the list of clients by the total amount of money they have spent
     *
     * @param clientList List of clients
     * @return List of clients sorted by the total amount of money they have spent and with a score assigned to each client based on the quartile they are in
     * @throws Exception
     */
    List<Client> getMonetization(List<Client> clientList) throws Exception;

    //#endregion
}
