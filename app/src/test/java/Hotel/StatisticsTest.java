package Hotel;

import static org.junit.jupiter.api.Assertions.assertEquals;


import java.io.IOException;
import java.lang.Exception;
import java.text.ParseException;


import org.junit.jupiter.api.*;

import com.opencsv.exceptions.CsvValidationException;

/**
 * <h3>
 * <strong>Class that represents the tests for the Statistic functions</strong>
 * </h3>
 *
 * @author Adão Araújo
 * @author Luis Oliveira
 * @author Rui Teixeira
 * @author Pedro Marques
 */
public class StatisticsTest {
    
    private transient Statistics statistics;
    private transient Score score;
    private transient ClientManagement clientManagement;
    private transient String input_test = "resources/testStatistics.csv";
    private transient String hashTest = "0x0659443C9197CB0C2B728362C9837E67A72B3BA7D579842A41FD8977049A2679";
    private transient String errorMessage = "Statistics getAvgWorstScore must return 0x0659443C9197CB0C2B728362C9837E67A72B3BA7D579842A41FD8977049A2679";

    /**
     * @throws CsvValidationException
     * @throws IOException
     */
    @BeforeEach
    public void setUp() throws CsvValidationException, IOException, Exception {
        statistics = new Statistics();
        score = new Score();
        clientManagement = new ClientManagement();
    }
    
    /**
     * 
     * Test to check if calculateMostInterestingTimeOfYear does not throw error when sending populated list of clients
     * @throws IOException
     * @throws CsvValidationException
     * 
     */
    @Test
    @DisplayName("Test to check if calculateMostInterestingTimeOfYear does not throw error when sending populated list of clients")
    public void testCalculateMostInterestingTimeOfYear_1() throws CsvValidationException, IOException{
        clientManagement.ImportDataFromCsvFile(input_test);
        Assertions.assertDoesNotThrow(() -> statistics.calculateMostInterestingTimeOfYear(clientManagement.GetClientList()));
    }

    /**
     * 
     * Test to check if calculateMostInterestingTimeOfYear throws error when sending empty list of clients
     * @throws Exception
     * 
     */
    @Test
    @DisplayName("Test to check if calculateMostInterestingTimeOfYear throws error when sending empty list of clients")
    public void testCalculateMostInterestingTimeOfYear_2() throws Exception {
        Assertions.assertThrows(Exception.class,() -> statistics.calculateMostInterestingTimeOfYear(clientManagement.GetClientList()));
    }
    
    /**
     * 
     * Test to check if calculateMostInterestingTimeOfYear throws error when sending null list of clients
     * 
     */
    @Test
    @DisplayName("Test to check if calculateMostInterestingTimeOfYear throws error when sending null list of clients")
    public void testCalculateMostInterestingTimeOfYear_3() {
        Assertions.assertThrows(NullPointerException.class,() -> statistics.calculateMostInterestingTimeOfYear(null));
    }

    /**
     * 
     * Test to check if GetMostInterestingTimeOfYear returns expected value
     * @throws Exception
     * 
     */
    @Test
    @DisplayName("Test to check if GetMostInterestingTimeOfYear returns expected value")
    public void testGetMostInterestingTimeOfYear() throws Exception{
        clientManagement.ImportDataFromCsvFile(input_test);
        statistics.calculateMostInterestingTimeOfYear(clientManagement.GetClientList());
        assertEquals(3, statistics.getMostInterestingTimeOfYear(), "Statistics getMostInterestingTimeOfYear must return 3");

    }

    /**
     * 
     * Test to check if calculateMostUsedPaymentMethod does not throw error when sending populated list of clients
     * @throws IOException
     * @throws CsvValidationException
     * 
     */
    @Test
    @DisplayName("Test to check if calculateMostUsedPaymentMethod does not throw error when sending populated list of clients")
    public void testCalculateMostUsedPaymentMethod_1() throws CsvValidationException, IOException{
        clientManagement.ImportDataFromCsvFile(input_test);
        Assertions.assertDoesNotThrow(() -> statistics.calculateMostUsedPaymentMethod(clientManagement.GetClientList()));
    }

    /**
     * 
     * Test to check if calculateMostUsedPaymentMethod throws error when sending empty list of clients
     * @throws Exception
     * 
     */
    @Test
    @DisplayName("Test to check if calculateMostUsedPaymentMethod throws error when sending empty list of clients")
    public void testCalculateMostUsedPaymentMethod_2() throws Exception {
        Assertions.assertThrows(Exception.class, () -> statistics.calculateMostUsedPaymentMethod(clientManagement.GetClientList()));
    }

    /**
     * 
     * Test to check if calculateMostUsedPaymentMethod throws error when sending null list of clients
     * 
     */
    @Test
    @DisplayName("Test to check if calculateMostUsedPaymentMethod throws error when sending null list of clients")
    public void testCalculateMostUsedPaymentMethod_3() {
        Assertions.assertThrows(NullPointerException.class,() -> statistics.calculateMostUsedPaymentMethod(null));
    }

    /**
     * 
     * Test to check if GetMostUsedPaymentMethod returns expected value
     * @throws Exception
     * 
     */
    @Test
    @DisplayName("Test to check if GetMostUsedPaymentMethod returns expected value")
    public void testGetMostUsedPaymentMethod() throws Exception{
        clientManagement.ImportDataFromCsvFile(input_test);
        statistics.calculateMostUsedPaymentMethod(clientManagement.GetClientList());
        assertEquals(2, statistics.getMostUsedPaymentMethod(), "Statistics getMostUsedPaymentMethod must return 2");
    }

    /**
     * 
     * Test to check if calculateAvgTimeBetweenPurchases does not throw error when sending populated list of clients
     * @throws IOException
     * @throws CsvValidationException
     * 
     */
    @Test
    @DisplayName("Test to check if calculateAvgTimeBetweenPurchases does not throw error when sending populated list of clients")
    public void testCalculateAvgTimeBetweenPurchases_1() throws CsvValidationException, IOException{
        clientManagement.ImportDataFromCsvFile(input_test);
        Assertions.assertDoesNotThrow(() -> statistics.calculateAvgTimeBetweenPurchases(clientManagement.GetClientList()));
    }

    /**
     * 
     * Test to check if calculateAvgTimeBetweenPurchases throws error when sending empty list of clients
     * @throws Exception
     * 
     */
    @Test
    @DisplayName("Test to check if calculateAvgTimeBetweenPurchases throws error when sending empty list of clients")
    public void testCalculateAvgTimeBetweenPurchases_2() throws Exception {
        Assertions.assertThrows(Exception.class, () -> statistics.calculateAvgTimeBetweenPurchases(clientManagement.GetClientList()));
    }

    /**
     * 
     * Test to check if calculateAvgTimeBetweenPurchases throws error when sending null list of clients
     * 
     */
    @Test
    @DisplayName("Test to check if calculateAvgTimeBetweenPurchases throws error when sending null list of clients")
    public void testCalculateAvgTimeBetweenPurchases_3() {
        Assertions.assertThrows(NullPointerException.class,() -> statistics.calculateAvgTimeBetweenPurchases(null));
    }

    /**
     * 
     * Test to check if GetAvgTimeBetweenPurchases returns expected value
     * @throws Exception
     * 
     */
    @Test
    @DisplayName("Test to check if GetAvgTimeBetweenPurchases returns expected value")
    public void testGetAvgTimeBetweenPurchases() throws Exception{
        clientManagement.ImportDataFromCsvFile(input_test);
        statistics.calculateAvgTimeBetweenPurchases(clientManagement.GetClientList());
        assertEquals(0, statistics.getAvgTimeBetweenPurchases(), "Statistics getAvgTimeBetweenPurchases must return 0");
    }

    /**
     * 
     * Test to check if GetMinTimeBetweenPurchases returns expected value
     * @throws Exception
     * 
     */
    @Test
    @DisplayName("Test to check if GetMinTimeBetweenPurchases returns expected value")
    public void testGetMinTimeBetweenPurchases() throws Exception{
        clientManagement.ImportDataFromCsvFile(input_test);
        statistics.calculateAvgTimeBetweenPurchases(clientManagement.GetClientList());
        assertEquals(-1, statistics.getMinTimeBetweenPurchases(), "Statistics GetMinTimeBetweenPurchases must return -1");
    }

    /**
     * 
     * Test to check if GetMaxTimeBetweenPurchases returns expected value
     * @throws Exception
     * 
     */
    @Test
    @DisplayName("Test to check if GetMaxTimeBetweenPurchases returns expected value")
    public void testGetMaxTimeBetweenPurchases() throws Exception{
        clientManagement.ImportDataFromCsvFile(input_test);
        statistics.calculateAvgTimeBetweenPurchases(clientManagement.GetClientList());
        assertEquals(-1, statistics.getMaxTimeBetweenPurchases(), "Statistics GetMaxTimeBetweenPurchases must return -1");
    }

    /**
     * 
     * Test to check if calculateMostUsedAquisitionService does not throw error when sending populated list of clients
     * @throws IOException
     * @throws CsvValidationException
     * 
     * 
     */
    @Test
    @DisplayName("Test to check if calculateMostUsedAquisitionService does not throw error when sending populated list of clients")
    public void testMostUsedAquisitionService_1() throws CsvValidationException, IOException{
        clientManagement.ImportDataFromCsvFile(input_test);
        Assertions.assertDoesNotThrow(() -> statistics.calculateMostUsedAquisitionService(clientManagement.GetClientList()));
    }

    /**
     * 
     * Test to check if calculateMostUsedAquisitionService throws error when sending empty list of clients
     * @throws Exception
     * 
     */
    @Test
    @DisplayName("Test to check if calculateMostUsedAquisitionService throws error when sending empty list of clients")
    public void testMostUsedAquisitionService_2() throws Exception{
        Assertions.assertThrows(Exception.class, () -> statistics.calculateMostUsedAquisitionService(clientManagement.GetClientList()));
    }

    /**
     * 
     * Test to check if calculateMostUsedAquisitionService throws error when sending null list of clients
     * 
     */
    @Test
    @DisplayName("Test to check if calculateMostUsedAquisitionService throws error when sending null list of clients")
    public void testGetMostUsedAquisitionService_3(){
        Assertions.assertThrows(NullPointerException.class, () -> statistics.calculateMostUsedAquisitionService(null));
    }

    /**
     * 
     * Test to check if GetMostUsedAquisitionService returns expected value
     * @throws Exception
     * 
     */
    @Test
    @DisplayName("Test to check if GetMostUsedAquisitionService returns expected value")
    public void testGetMostUsedAquisitionService() throws Exception{
        clientManagement.ImportDataFromCsvFile(input_test);
        statistics.calculateMostUsedAquisitionService(clientManagement.GetClientList());
        assertEquals("Travel Agent/Operator", statistics.getMostUsedAquisitionService(), "Statistics getMostUsedAquisitionService must return Travel Agent/Operator");
    }

    /**
     * 
     * Test to check if calculateAvgTotalPurchasesAndMinMaxValues does not throw error when sending populated list of clients
     * @throws IOException
     * @throws CsvValidationException
     * 
     */
    @Test
    @DisplayName("Test to check if calculateAvgTotalPurchasesAndMinMaxValues does not throw error when sending populated list of clients")
    public void testCalculateAvgTotalPurchasesAndMinMaxValues_1() throws CsvValidationException, IOException{
        clientManagement.ImportDataFromCsvFile(input_test);
        Assertions.assertDoesNotThrow(() -> statistics.calculateAvgTotalPurchasesAndMinMaxValues(clientManagement.GetClientList()));
    }

    /**
     * 
     * Test to check if calculateAvgTotalPurchasesAndMinMaxValues throws error when sending empty list of clients
     * @throws Exception
     * 
     */
    @Test
    @DisplayName("Test to check if calculateAvgTotalPurchasesAndMinMaxValues throws error when sending empty list of clients")
    public void testCalculateAvgTotalPurchasesAndMinMaxValues_2() throws Exception {
        Assertions.assertThrows(Exception.class,() -> statistics.calculateAvgTotalPurchasesAndMinMaxValues(clientManagement.GetClientList()));
    }

    /**
     * 
     * Test to check if calculateAvgTotalPurchasesAndMinMaxValues throws error when sending null list of clients
     * 
     */
    @Test
    @DisplayName("Test to check if calculateAvgTotalPurchasesAndMinMaxValues throws error when sending null list of clients")
    public void testCalculateAvgTotalPurchasesAndMinMaxValues_3() {
        Assertions.assertThrows(NullPointerException.class,() -> statistics.calculateAvgTotalPurchasesAndMinMaxValues(null));
    }

    /**
     * 
     * Test to check if getAvgTotalPurchasesValue returns expected value
     * @throws Exception
     * @throws ParseException
     * 
     */
    @Test
    @DisplayName("Test to check if getAvgTotalPurchasesValue returns expected value")
    public void testGetAvgTotalPurchases() throws Exception{
        clientManagement.ImportDataFromCsvFile(input_test);
        statistics.calculateAvgTotalPurchasesAndMinMaxValues(clientManagement.GetClientList());
        assertEquals(456.8, statistics.getAvgTotalPurchasesValue(), 0.001, "Statistics getAvgTotalPurchasesValue must return 456.8");
    }

    /**
     * 
     * Test to check if getMaxPurchasesValue returns expected value
     * @throws Exception
     * 
     */
    @Test
    @DisplayName("Test to check if getMaxPurchasesValue returns expected value")
    public void getMaxPurchasesValue() throws Exception{
        clientManagement.ImportDataFromCsvFile(input_test);
        statistics.calculateAvgTotalPurchasesAndMinMaxValues(clientManagement.GetClientList());
        assertEquals(4568.0, statistics.getMaxPurchasesValue(), "Statistics getMaxPurchasesValue must return 4568.0");
    }

    /**
     * 
     * Test to check if getMinPurchasesValue returns expected value
     * @throws Exception
     * 
     */
    @Test
    @DisplayName("Test to check if getMinPurchasesValue returns expected value")
    public void getMinPurchasesValue() throws Exception{
        clientManagement.ImportDataFromCsvFile(input_test);
        statistics.calculateAvgTotalPurchasesAndMinMaxValues(clientManagement.GetClientList());
        assertEquals(243.0, statistics.getMinPurchasesValue(), "Statistics getMinPurchasesValue must return 243.0");
    }

    /**
     * 
     * Test to check if calculateBestandWorstAvgScore does not throw error when sending populated list of clients
     * @throws IOException
     * @throws CsvValidationException
     * @throws Exception
     * 
     */
    @Test
    @DisplayName("Test to check if calculateBestandWorstAvgScore does not throw error when sending populated list of clients")
    public void testCalculateBestandWorstAvgScore_1() throws CsvValidationException, IOException, Exception{
        clientManagement.ImportDataFromCsvFile(input_test);
        score.getTotalPurchases(clientManagement.GetClientList());
        score.getRegularity(clientManagement.GetClientList());
        score.getMonetization(clientManagement.GetClientList());
        Assertions.assertDoesNotThrow(() -> statistics.calculateBestandWorstAvgScore(clientManagement.GetClientList()));
    }

    /**
     * 
     * Test to check if calculateBestandWorstAvgScore throws error when sending empty list of clients
     * 
     */
    @Test	
    @DisplayName("Test to check if calculateBestandWorstAvgScore throws error when sending empty list of clients")
    public void testCalculateBestandWorstAvgScore_2() {
        Assertions.assertThrows(Exception.class,() -> statistics.calculateBestandWorstAvgScore(clientManagement.GetClientList()));
    }

    /**
     * 
     * Test to check if calculateBestandWorstAvgScore throws error when sending null list of clients
     * @throws Exception
     * 
     */
    @Test
    @DisplayName("Test to check if calculateBestandWorstAvgScore throws error when sending null list of clients")
    public void testCalculateBestandWorstAvgScore_3() throws Exception{
        Assertions.assertThrows(NullPointerException.class,() -> statistics.calculateBestandWorstAvgScore(null));
    }

    /**
     * 
     * Test to check if getBestAvgScore returns expected value
     * @throws Exception
     * 
     */
    @Test
    @DisplayName("Test to check if getAvgBestScore returns expected value")
    public void testGetBestAvgScore() throws Exception{
        clientManagement.ImportDataFromCsvFile(input_test);
        score.getTotalPurchases(clientManagement.GetClientList());
        score.getRegularity(clientManagement.GetClientList());
        score.getMonetization(clientManagement.GetClientList());
        statistics.calculateBestandWorstAvgScore(clientManagement.GetClientList());
        assertEquals("0x4FEADA25B090169D22CCE3A5ADFF956882316CACEFB29917D30874FEFA11D700", statistics.getAvgBestScore(), "Statistics getAvgBestScore must return 0x4FEADA25B090169D22CCE3A5ADFF956882316CACEFB29917D30874FEFA11D700");
    }

    /**
     * 
     * Test to check if getWorstAvgScore returns expected value
     * @throws Exception
     * 
     */
    @Test
    @DisplayName("Test to check if getAvgWorstScore returns expected value")
    public void testGetWorstAvgScore() throws Exception{
        clientManagement.ImportDataFromCsvFile(input_test);
        score.getTotalPurchases(clientManagement.GetClientList());
        score.getRegularity(clientManagement.GetClientList());
        score.getMonetization(clientManagement.GetClientList());
        statistics.calculateBestandWorstAvgScore(clientManagement.GetClientList());
        assertEquals("0x5FA1E0098A31497057C5A6B9FE9D49FD6DD47CCE7C268E6548699E78E587AAEA", statistics.getAvgWorstScore(), "Statistics getAvgWorstScore must return 0x5FA1E0098A31497057C5A6B9FE9D49FD6DD47CCE7C268E6548699E78E587AAEA");
    }

    /**
     * 
     * Test to check if calculateBestScoreMonetization does not throw error when sending populated list of clients
     * @throws IOException
     * @throws CsvValidationException
     * @throws Exception
     * 
     */
    @Test
    @DisplayName("Test to check if calculateBestScoreMonetization does not throw error when sending populated list of clients")
    public void calculateBestScoreMonetization_0() throws CsvValidationException, IOException, Exception{
        clientManagement.ImportDataFromCsvFile(input_test);
        score.getTotalPurchases(clientManagement.GetClientList());
        score.getRegularity(clientManagement.GetClientList());
        score.getMonetization(clientManagement.GetClientList());
        Assertions.assertDoesNotThrow(() -> statistics.calculateBestScoreMonetization(clientManagement.GetClientList()));
    }

    /**
     * 
     * Test to check if calculateBestScoreMonetization throws error when sending empty list of clients
     * @throws Exception
     * 
     */
    @Test
    @DisplayName("Test to check if calculateBestScoreMonetization throws error when sending empty list of clients")
    public void calculateBestScoreMonetization_1() throws Exception {
        Assertions.assertThrows(Exception.class,() -> statistics.calculateBestScoreMonetization(clientManagement.GetClientList()));
    }
    
    /**
     * 
     * Test to check if calculateBestScoreMonetization throws error when sending null list of clients
     * 
     */
    @Test
    @DisplayName("Test to check if calculateBestScoreMonetization throws error when sending null list of clients")
    public void calculateBestScoreMonetization_2() {
        Assertions.assertThrows(NullPointerException.class,() -> statistics.calculateBestScoreMonetization(null));
    }

    /**
     * 
     * Test to check if getBestScoreMonetization returns expected value
     * @throws Exception
     * 
     */
    @Test
    @DisplayName("Test to check if getBestScoreMonetization returns expected value")
    public void testgetBestScoreMonetization() throws Exception {
        clientManagement.ImportDataFromCsvFile(input_test);
        score.getTotalPurchases(clientManagement.GetClientList());
        score.getRegularity(clientManagement.GetClientList());
        score.getMonetization(clientManagement.GetClientList());
        statistics.calculateBestScoreMonetization(clientManagement.GetClientList());
        assertEquals("0x197C35F3140B7BE139E34CCEA38427282735E34F40E5C2A7C1A085BBEC2A9E93", statistics.getBestScoreMonetization(), "Statistics getAvgWorstScore must return 0x197C35F3140B7BE139E34CCEA38427282735E34F40E5C2A7C1A085BBEC2A9E93");
    }

    /**
     * 
     * Test to check if calculateBestScoreTotalPurchases does not throw error when sending populated list of clients
     * @throws IOException
     * @throws CsvValidationException
     * @throws Exception
     * 
     */
    @Test
    @DisplayName("Test to check if calculateBestScoreTotalPurchases does not throw error when sending populated list of clients")
    public void calculateBestScoreTotalPurchases_0() throws CsvValidationException, IOException, Exception{
        clientManagement.ImportDataFromCsvFile(input_test);
        score.getTotalPurchases(clientManagement.GetClientList());
        score.getRegularity(clientManagement.GetClientList());
        score.getMonetization(clientManagement.GetClientList());
        Assertions.assertDoesNotThrow(() -> statistics.calculateBestScoreTotalPurchases(clientManagement.GetClientList()));
    }

    /**
     * 
     * Test to check if calculateBestScoreTotalPurchases throws error when sending empty list of clients
     * @throws Exception
     * 
     */
    @Test
    @DisplayName("Test to check if calculateBestScoreTotalPurchases throws error when sending empty list of clients")
    public void calculateBestScoreTotalPurchases_2() throws Exception {
        Assertions.assertThrows(Exception.class,() -> statistics.calculateBestScoreTotalPurchases(clientManagement.GetClientList()));
    }
    
    /**
     * 
     * Test to check if calculateBestScoreTotalPurchases throws error when sending null list of clients
     * 
     */
    @Test
    @DisplayName("Test to check if calculateBestScoreTotalPurchases throws error when sending null list of clients")
    public void calculateBestScoreTotalPurchases_3() {
        Assertions.assertThrows(NullPointerException.class,() -> statistics.calculateBestScoreTotalPurchases(null));
    }

    /**
     * 
     * Test to check if getBestScoreTotalPurchases returns expected value
     * @throws Exception
     * 
     */
    @Test
    @DisplayName("Test to check if getBestScoreTotalPurchases returns expected value")
    public void testgetBestScoreTotalPurchases() throws Exception{
        clientManagement.ImportDataFromCsvFile(input_test);
        score.getTotalPurchases(clientManagement.GetClientList());
        score.getRegularity(clientManagement.GetClientList());
        score.getMonetization(clientManagement.GetClientList());
        statistics.calculateBestScoreTotalPurchases(clientManagement.GetClientList());
        assertEquals(hashTest, statistics.getBestScoreTotalPurchases(), errorMessage);
    }

    /**
     * 
     * Test to check if calculateBestScoreRegularity does not throw error when sending populated list of clients
     * @throws IOException
     * @throws CsvValidationException
     * @throws Exception
     * 
     */
    @Test
    @DisplayName("Test to check if calculateBestScoreRegularity does not throw error when sending populated list of clients")
    public void calculateBestScoreRegularity_1() throws CsvValidationException, IOException, Exception{
        clientManagement.ImportDataFromCsvFile(input_test);
        score.getTotalPurchases(clientManagement.GetClientList());
        score.getRegularity(clientManagement.GetClientList());
        score.getMonetization(clientManagement.GetClientList());
        Assertions.assertDoesNotThrow(() -> statistics.calculateBestScoreRegularity(clientManagement.GetClientList()));
    }

    /**
     * 
     * Test to check if calculateBestScoreRegularity throws error when sending empty list of clients
     * @throws Exception
     * 
     */
    @Test
    @DisplayName("Test to check if calculateBestScoreRegularity throws error when sending empty list of clients")
    public void calculateBestScoreRegularity_2() throws Exception {
        Assertions.assertThrows(Exception.class,() -> statistics.calculateBestScoreRegularity(clientManagement.GetClientList()));
    }
    
    /**
     * 
     * Test to check if calculateBestScoreRegularity throws error when sending null list of clients
     * 
     */
    @Test
    @DisplayName("Test to check if calculateBestScoreRegularity throws error when sending null list of clients")
    public void calculateBestScoreRegularity_3() {
        Assertions.assertThrows(NullPointerException.class,() -> statistics.calculateBestScoreRegularity(null));
    }

    /**
     * 
     * Test to check if getBestScoreRegularity returns expected value
     * @throws Exception
     * 
     */
    @Test
    @DisplayName("Test to check if getBestScoreRegularity returns expected value")
    public void testgetBestScoreRegularity() throws Exception{
        clientManagement.ImportDataFromCsvFile(input_test);
        score.getTotalPurchases(clientManagement.GetClientList());
        score.getRegularity(clientManagement.GetClientList());
        score.getMonetization(clientManagement.GetClientList());
       statistics.calculateBestScoreRegularity(clientManagement.GetClientList());
        assertEquals(hashTest, statistics.getBestScoreRegularity(), errorMessage);
    }

    /**
     * 
     * Test to check if calculateWorstScoreMonetization does not throw error when sending populated list of clients
     * @throws IOException
     * @throws CsvValidationException
     * @throws Exception
     * 
     */
    @Test
    @DisplayName("Test to check if calculateWorstScoreMonetization does not throw error when sending populated list of clients")
    public void calculateWorstScoreMonetization_1() throws CsvValidationException, IOException, Exception{
        clientManagement.ImportDataFromCsvFile(input_test);
        score.getTotalPurchases(clientManagement.GetClientList());
        score.getRegularity(clientManagement.GetClientList());
        score.getMonetization(clientManagement.GetClientList());
        Assertions.assertDoesNotThrow(() -> statistics.calculateWorstScoreMonetization(clientManagement.GetClientList()));
    }

    /**
     * 
     * Test to check if calculateWorstScoreMonetization throws error when sending empty list of clients
     * @throws Exception
     * 
     */
    @Test
    @DisplayName("Test to check if calculateWorstScoreMonetization throws error when sending empty list of clients")
    public void calculateWorstScoreMonetization_2() throws Exception {
        Assertions.assertThrows(Exception.class,() -> statistics.calculateWorstScoreMonetization(clientManagement.GetClientList()));
    }
    
    /**
     * 
     * Test to check if calculateWorstScoreMonetization throws error when sending null list of clients
     * 
     */
    @Test
    @DisplayName("Test to check if calculateWorstScoreMonetization throws error when sending null list of clients")
    public void calculateWorstScoreMonetization_3() {
        Assertions.assertThrows(NullPointerException.class,() -> statistics.calculateWorstScoreMonetization(null));
    }

    /**
     * 
     * Test to check if getWorstScoreMonetization returns expected value
     * @throws Exception
     * 
     */
    @Test
    @DisplayName("Test to check if getWorstScoreMonetization returns expected value")
    public void testgetWorstScoreMonetization() throws Exception{
        clientManagement.ImportDataFromCsvFile(input_test);
        score.getTotalPurchases(clientManagement.GetClientList());
        score.getRegularity(clientManagement.GetClientList());
        score.getMonetization(clientManagement.GetClientList());
        statistics.calculateWorstScoreMonetization(clientManagement.GetClientList());
        assertEquals(hashTest, statistics.getWorstScoreMonetization(), errorMessage);
    }

    /**
     * 
     * Test to check if calculateWorstScoreTotalPurchases does not throw error when sending populated list of clients
     * @throws IOException
     * @throws CsvValidationException
     * @throws Exception
     * 
     */
    @Test
    @DisplayName("Test to check if calculateWorstScoreTotalPurchases does not throw error when sending populated list of clients")
    public void calculateWorstScoreTotalPurchases_1() throws CsvValidationException, IOException, Exception{
        clientManagement.ImportDataFromCsvFile(input_test);
        score.getTotalPurchases(clientManagement.GetClientList());
        score.getRegularity(clientManagement.GetClientList());
        score.getMonetization(clientManagement.GetClientList());
        Assertions.assertDoesNotThrow(() -> statistics.calculateWorstScoreTotalPurchases(clientManagement.GetClientList()));
    }

    /**
     * 
     * Test to check if calculateWorstScoreTotalPurchases throws error when sending empty list of clients
     * @throws Exception
     * 
     */
    @Test
    @DisplayName("Test to check if calculateWorstScoreTotalPurchases throws error when sending empty list of clients")
    public void calculateWorstScoreTotalPurchases_2() throws Exception {
        Assertions.assertThrows(Exception.class,() -> statistics.calculateWorstScoreTotalPurchases(clientManagement.GetClientList()));
    }
    
    /**
     * 
     * Test to check if calculateWorstScoreTotalPurchases throws error when sending null list of clients
     * 
     */
    @Test
    @DisplayName("Test to check if calculateWorstScoreTotalPurchases throws error when sending null list of clients")
    public void calculateWorstScoreTotalPurchases_3() {
        Assertions.assertThrows(NullPointerException.class,() -> statistics.calculateWorstScoreTotalPurchases(null));
    }

    /**
     * 
     * Test to check if getWorstScoreTotalPurchases returns expected value
     * @throws Exception
     * 
     */
    @Test
    @DisplayName("Test to check if getWorstScoreTotalPurchases returns expected value")
    public void testgetWorstScoreTotalPurchases() throws Exception{
      clientManagement.ImportDataFromCsvFile(input_test);
      score.getTotalPurchases(clientManagement.GetClientList());
      score.getRegularity(clientManagement.GetClientList());
      score.getMonetization(clientManagement.GetClientList());
      statistics.calculateWorstScoreTotalPurchases(clientManagement.GetClientList());
      assertEquals(hashTest, statistics.getWorstScoreTotalPurchases(), "Statistics getWorstScoreTotalPurchases must return 0x0659443C9197CB0C2B728362C9837E67A72B3BA7D579842A41FD8977049A2679");
    }

     /**
     * 
     * Test to check if calculateWorstScoreRegularity does not throw error when sending populated list of clients
     * @throws IOException
     * @throws CsvValidationException
     * @throws Exception
     * 
     */
    @Test
    @DisplayName("Test to check if calculateWorstScoreRegularity does not throw error when sending populated list of clients")
    public void calculateWorstScoreRegularity_1() throws CsvValidationException, IOException, Exception{
        clientManagement.ImportDataFromCsvFile(input_test);
        score.getTotalPurchases(clientManagement.GetClientList());
        score.getRegularity(clientManagement.GetClientList());
        score.getMonetization(clientManagement.GetClientList());
        Assertions.assertDoesNotThrow(() -> statistics.calculateWorstScoreRegularity(clientManagement.GetClientList()));
    }

    /**
     * 
     * Test to check if calculateWorstScoreRegularity throws error when sending empty list of clients
     * @throws Exception
     * 
     */
    @Test
    @DisplayName("Test to check if calculateWorstScoreRegularity throws error when sending empty list of clients")
    public void calculateWorstScoreRegularity_2() throws Exception {
        Assertions.assertThrows(Exception.class,() -> statistics.calculateWorstScoreRegularity(clientManagement.GetClientList()));
    }
    
    /**
     * 
     * Test to check if calculateWorstScoreRegularity throws error when sending null list of clients
     * 
     */
    @Test
    @DisplayName("Test to check if calculateWorstScoreRegularity throws error when sending null list of clients")
    public void calculateWorstScoreRegularity_3() {
        Assertions.assertThrows(NullPointerException.class,() -> statistics.calculateWorstScoreRegularity(null));
    }

    /**
     * 
     * Test to check if getWorstScoreRegularity returns expected value
     * @throws Exception
     * 
     */
    @Test
    @DisplayName("Test to check if getWorstScoreRegularity returns expected value")
    public void testgetWorstScoreRegularity() throws Exception{
        clientManagement.ImportDataFromCsvFile(input_test);
        score.getTotalPurchases(clientManagement.GetClientList());
        score.getRegularity(clientManagement.GetClientList());
        score.getMonetization(clientManagement.GetClientList());
        statistics.calculateWorstScoreRegularity(clientManagement.GetClientList());
        assertEquals(hashTest, statistics.getWorstScoreRegularity(), errorMessage);
    }
}
