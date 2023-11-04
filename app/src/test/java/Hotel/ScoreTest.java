package Hotel;

import java.io.IOException;
import java.lang.Exception;

import org.junit.jupiter.api.*;

import com.opencsv.exceptions.CsvValidationException;

/**
 * <h3>
 * <strong>Class that represents the tests for the Score functions</strong>
 * </h3>
 *
 * @author Adão Araújo
 * @author Luis Oliveira
 * @author Rui Teixeira
 * @author Pedro Marques
 */
public class ScoreTest {
    private transient Score score;
    private transient ClientManagement clientManagement;
    private transient String input_csv_file = "resources/Dataset_nova_versao_min.csv";

    /**
     * @throws CsvValidationException
     * @throws IOException
     */
    @BeforeEach
    public void setUp() throws CsvValidationException, IOException {
        score = new Score();
        score.setType("Regularity");
        score.setQuartil(1);

        clientManagement = new ClientManagement();
    }
    
    /**
     * 
     * Test to check if get regularity does not throw error when sending populated list of clients
     * @throws IOException
     * @throws CsvValidationException
     * @throws Exception
     * 
     */
    @Test
    @DisplayName("Test to check if get regularity does not throw error when sending populated list of clients")
    public void testGetRegularity_1() throws CsvValidationException, IOException, Exception{
        clientManagement.ImportDataFromCsvFile(input_csv_file);
        Assertions.assertDoesNotThrow(() -> score.getRegularity(clientManagement.GetClientList()));
    }

    /**
     * 
     * Test to check if get regularity does not throw error when sending empty list of clients
     * @throws Exception
     * 
     */
    @Test
    @DisplayName("Test to check if get regularity does not throw error when sending empty list of clients")
    public void testGetRegularity_2() throws Exception{
        Assertions.assertThrows(Exception.class,() -> score.getRegularity(clientManagement.GetClientList()));
    }

    /**
     * 
     * Test to check if get regularity throws error when sending null list of clients
     * 
     */
    @Test
    @DisplayName("Test to check if get regularity throws error when sending null list of clients")
    public void testGetRegularity_3(){
        Assertions.assertThrows(NullPointerException.class, () -> score.getRegularity(null));
    }

    /**
     * 
     * Test to check if get total purchases does not throw error when sending populated list of clients
     * @throws IOException
     * @throws CsvValidationException
     * @throws Exception
     * 
     */
    @Test
    @DisplayName("Test to check if get total purchases does not throw error when sending populated list of clients")
    public void testGetTotalPurchases_1() throws CsvValidationException, IOException, Exception{
        clientManagement.ImportDataFromCsvFile(input_csv_file);
        Assertions.assertDoesNotThrow(() -> score.getTotalPurchases(clientManagement.GetClientList()));
    }

    /**
     * 
     * Test to check if get total purchases does not throw error when sending empty list of clients
     * @throws Exception
     * 
     */
    @Test
    @DisplayName("Test to check if get total purchases does not throw error when sending empty list of clients")
    public void testGetTotalPurchases_2() throws Exception{
        Assertions.assertThrows(Exception.class, () -> score.getTotalPurchases(clientManagement.GetClientList()));
    }

    /**
     * 
     * Test to check if get total purchases throws error when sending null list of clients
     * 
     */
    @Test
    @DisplayName("Test to check if get total purchases throws error when sending null list of clients")
    public void testGetTotalPurchases_3(){
        Assertions.assertThrows(NullPointerException.class, () -> score.getTotalPurchases(null));
    }

     /**
     * 
     * Test to check if get monetization does not throw error when sending populated list of clients
     * @throws IOException
     * @throws CsvValidationException
     * @throws Exception
     * 
     */
    @Test
    @DisplayName("Test to check if get monetization does not throw error when sending populated list of clients")
    public void testGetMonetization_1() throws CsvValidationException, IOException, Exception{
        clientManagement.ImportDataFromCsvFile(input_csv_file);
        Assertions.assertDoesNotThrow(() -> score.getMonetization(clientManagement.GetClientList()));
    }

    /**
     * 
     * Test to check if get monetization does not throw error when sending empty list of clients
     * @throws Exception
     * 
     */
    @Test
    @DisplayName("Test to check if get monetization does not throw error when sending empty list of clients")
    public void testGetMonetization_2() throws Exception{
        Assertions.assertThrows(Exception.class, () -> score.getMonetization(clientManagement.GetClientList()));
    }

    /**
     * 
     * Test to check if get monetization throws error when sending null list of clients
     * 
     */
    @Test
    @DisplayName("Test to check if get monetization throws error when sending null list of clients")
    public void testGetMonetization_3(){
        Assertions.assertThrows(NullPointerException.class, () -> score.getMonetization(null));
    }

    /**
     * Test toString method
     */
    @Test
    @DisplayName("Test Score toString method")
    public void testToString() {
        String expected = "Score [{"+ score.getType() + "= "+ score.getValue() + "}]";
    
        Assertions.assertEquals(expected, score.toString(), "Score toString should return the score information");
    }
}
