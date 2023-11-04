package Hotel;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * <h3>
 * <strong>Class To Import CSV File </strong>
 * </h3>
 *
 * @author Adão Araújo
 * @author Luis Oliveira
 * @author Rui Teixeira
 * @author Pedro Marques
 */
public class ClientManagement {

    private transient List<Client> clientList = new ArrayList<>();
    /**
     * Method to import the CSV file and parse it to a list of clients
     *
     * @throws IOException
     * @throws CsvValidationException
     */
    public void ImportDataFromCsvFile(String input_csv_file)
            throws IOException, CsvValidationException {
        File file = new File(input_csv_file);
        if (!file.exists()) {
            throw new FileNotFoundException("File not found: " + input_csv_file);
        }
        try (CSVReader reader = new CSVReaderBuilder(new FileReader(input_csv_file))
                .withCSVParser(new CSVParserBuilder().withSeparator(';').build())
                .withSkipLines(1)
                .build()) {
            // read line by line
            String[] record = null;

            while ((record = reader.readNext()) != null) {
                if (record.length < Variables.MINIMUM_COLUMM_NUMBER) {
                    throw new CsvValidationException("Nao tem transações");
                }
                for (int i=Variables.MINIMUM_COLUMM_NUMBER; i < record.length; i++){
                    if(record[i].isBlank()){
                        throw new CsvValidationException("Linha vazia");
                    }
                }
        
                String DocIdHash = record[5];
                if (Double.parseDouble(record[7].replace(",", ".")) > 0) {

                    // Create new transaction
                    Transaction newTransaction = new Transaction();
                    newTransaction.setID(record[0]);
                    newTransaction.setAverageLeadTime(record[6]);
                    newTransaction.setLodgingRevenue(record[7].replace(",", "."));
                    newTransaction.setOtherRevenue(record[8].replace(",", "."));
                    newTransaction.setDaysSinceLastStay(record[14]);
                    newTransaction.setDaysSinceFirstStay(record[15]);
                    newTransaction.setDistributionChannel(record[16]);
                    newTransaction.setMarketSegment(record[17]);
                    newTransaction.setPurchaseDate(record[31]);
                    newTransaction.setPaymentMethod(Integer.parseInt(record[32]));

                    if (!ExistsClient(DocIdHash)) {
                        // Create new client
                        clientList.add(CreateNewClient(record, newTransaction));
                    } else {
                        // Find client
                        Client client = GetClientByDocIdHash(DocIdHash);
                        // Add transaction to the client
                        client.getTransactions().add(newTransaction);
                    }
                }
            }
        } catch (IOException e) {
            throw new IOException(e);
        }

    }

    /**
     * Method to check the imported list for repeated clients and add non repeated
     * clients to client list
     *
     * @param clientManagement List of all imported clients
     */
    boolean ExistsClient(String ClientDocIDHash) {
        // If the client is already in the list, it is not added again
        if (clientList
                .stream()
                .filter(o -> o.getDocIDHash().equals(ClientDocIDHash))
                .findFirst()
                .isPresent()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Method to return new client after creation based on the data received from
     * the CSV file
     * 
     * @param record         Data received from the csv file
     * @param newTransaction New transaction to be added to the client
     * @return Client filled with the necessary data
     */
    private Client CreateNewClient(String[] record, Transaction newTransaction) {
        Client newClient = new Client();
        newClient.setNationality(record[1]);
        newClient.setAge(record[2]);
        newClient.setDaysSinceCreation(record[3]);
        newClient.setNameHash(record[4]);
        newClient.setDocIDHash(record[5]);
        newClient.getScores().add(new Score("Regularity", 0, ""));
        newClient.getScores().add(new Score("Total_Purchase", 0, ""));
        newClient.getScores().add(new Score("Monetization", 0, ""));

        newClient.getTransactions().add(newTransaction);

        return newClient;
    }

    /**
     * Method to return client by DocIdHash
     * 
     * @param DocIdHash DocIdHash that identifies the client
     * @return Client present in the list of clients
     */
    public Client GetClientByDocIdHash(String DocIdHash) {
        return clientList.stream().filter(findClient -> findClient.getDocIDHash().equals(DocIdHash)).findAny()
                .orElse(null);
    }

    /**
     * Returns the list of clients
     *
     * @return List of clients
     */
    public List<Client> GetClientList() {
        return clientList;
    }
}
