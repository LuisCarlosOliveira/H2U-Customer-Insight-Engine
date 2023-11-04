package Hotel;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.jupiter.api.*;

import com.opencsv.exceptions.CsvValidationException;

/**
 * <h3>
 * <strong>Class that represents the tests for the ClientManagement functions</strong>
 * </h3>
 *
 * @author Adão Araújo
 * @author Luis Oliveira
 * @author Rui Teixeira
 * @author Pedro Marques
 */

public class ClientManagementTest {
    private transient ClientManagement clientManagement;
    private transient String input_csv_file = "resources/Dataset_nova_versao_min.csv";
    private transient String teste = "resources/teste.csv";
    private transient String noTransaction = "resources/noTransactions.csv";
    /**
     * @throws CsvValidationException
     * @throws IOException
     */
    @BeforeEach
    public void setUp() throws CsvValidationException, IOException {
        clientManagement = new ClientManagement();
        clientManagement.ImportDataFromCsvFile(input_csv_file);
        }


    /**
     * 
     * Test to check if import throws error when sending wrong file path
     * 
     */
    @Test
    @DisplayName("Test to check if import throws error when sending wrong file path")
    public void testImportClients(){
        Assertions.assertThrows(FileNotFoundException.class,()-> clientManagement.ImportDataFromCsvFile(""));
    }

    /**
     * 
     * Test to check if import does not throw error when sending correct file path
     * 
     */
    @Test
    @DisplayName("Test to check if import does not throw error when sending correct file path")
    public void testImportClients_2(){
        Assertions.assertDoesNotThrow(()->clientManagement.ImportDataFromCsvFile(input_csv_file));
    }

    /**
     * 
     * Test to check if import if import throw an error when have empty lines
     * 
     */
    @Test
    @DisplayName("Test to check if import throw an error when have empty lines")
    public void testImportClients3() throws CsvValidationException{
        Assertions.assertThrows(CsvValidationException.class, ()->clientManagement.ImportDataFromCsvFile(teste));
    }

    /**
     * 
     * Test to check if import throw an error when dont have transations
     * 
     */
    @Test
    @DisplayName("Test to check if import throw an error when dont have transations")
    public void testImportClients4() throws CsvValidationException{
        Assertions.assertThrows(CsvValidationException.class, ()->clientManagement.ImportDataFromCsvFile(noTransaction));
    }

    /**
     * 
     * Test to check if ExistsClient returns true when sending a clientDocIdHash that exists
     * 
     */
    @Test
    @DisplayName("Test to check if ExistsClient returns true when sending a clientDocIdHash that exists")
    public void testExistsClient_1(){
            Assertions.assertTrue(clientManagement.ExistsClient("0x71568459B729F7A7ABBED6C781A84CA4274D571003ACC7A4A791C3350D924137"), "Sucess");
    } 

    /**
     * 
     * Test to check if ExistsClient returns true when sending a clientDocIdHash that does not exist
     * 
     */
    @Test
    @DisplayName("Test to check if ExistsClient returns true when sending a clientDocIdHash that does not exist")
    public void testExistsClient_2(){
            Assertions.assertFalse(clientManagement.ExistsClient("a"), "That client hash doesnt exist");
    }

    /**
     * 
     * Test to check if ExistsClient returns false when sending a clientDocIdHash empty
     * 
     */
    @Test
    @DisplayName("Test to check if ExistsClient returns false when sending a clientDocIdHash empty")
    public void testExistsClient_3(){
            Assertions.assertFalse(clientManagement.ExistsClient(""),"Insert a client hash");
    }
    
    /**
     * 
     * Test to check if GetClientByDocIdHash returns a client when sending a clientDocIdHash that exists
     * 
     */
    @Test
    @DisplayName("Test to check if GetClientByDocIdHash returns a client when sending a clientDocIdHash that exists")
    public void testGetClientByDocIdHash_1(){
        Assertions.assertNotNull(clientManagement.GetClientByDocIdHash("0x71568459B729F7A7ABBED6C781A84CA4274D571003ACC7A4A791C3350D924137"), "Sucess");
    }

    /**
     * 
     * Test to check if GetClientByDocIdHash returns null when sending a clientDocIdHash that does not exist
     * 
     */
    @Test
    @DisplayName("Test to check if GetClientByDocIdHash returns null when sending a clientDocIdHash that does not exist")
    public void testGetClientByDocIdHash_2(){
        Assertions.assertNull(clientManagement.GetClientByDocIdHash("a"),"Insert a client hash");
    }

}