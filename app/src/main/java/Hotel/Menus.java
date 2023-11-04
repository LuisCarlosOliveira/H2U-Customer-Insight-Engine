package Hotel;

import com.opencsv.exceptions.CsvValidationException;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Level;


/**
 * <h3>
 * <strong>Class Menu</strong>
 * </h3>
 *
 * @author Adão Araújo
 * @author Luis Oliveira
 * @author Rui Teixeira
 * @author Pedro Marques
 */
public class Menus {

  public static void main(String[] args)
      throws IOException, CsvValidationException, Exception {
    // String input_csv_file = "app/resources/teste.csv";
    // String input_csv_file = "app/resources/Dataset_nova_versao.csv";
    // String input_csv_file = "app/resources/Dataset_nova_versao_min.csv";
     String input_csv_file = "app/resources/testStatistics.csv";
    ClientManagement clientManagement = new ClientManagement();
    Score score = new Score();
    Statistics statistics = new Statistics();

    Logger logger = Logger.getLogger(Menus.class.getName());

    try {
      clientManagement.ImportDataFromCsvFile(input_csv_file);
    } catch (CsvValidationException e) {
      logger.log(Level.SEVERE, "an exception was thrown",e);
    } catch (IOException e) {
      logger.log(Level.SEVERE, "an exception was thrown",e);
    }

    score.getTotalPurchases(clientManagement.GetClientList());
    score.getRegularity(clientManagement.GetClientList());
    score.getMonetization(clientManagement.GetClientList());
    statistics.calculateMostInterestingTimeOfYear(clientManagement.GetClientList());
    statistics.calculateAvgTimeBetweenPurchases(clientManagement.GetClientList());
    statistics.calculateAvgTotalPurchasesAndMinMaxValues(clientManagement.GetClientList());
    statistics.calculateMostUsedAquisitionService(clientManagement.GetClientList());
    statistics.calculateMostUsedPaymentMethod(clientManagement.GetClientList());
    statistics.calculateBestandWorstAvgScore(clientManagement.GetClientList());
    statistics.calculateBestScoreMonetization(clientManagement.GetClientList());
    statistics.calculateBestScoreTotalPurchases(clientManagement.GetClientList());
    statistics.calculateBestScoreRegularity(clientManagement.GetClientList());
    statistics.calculateWorstScoreMonetization(clientManagement.GetClientList());
    statistics.calculateWorstScoreTotalPurchases(clientManagement.GetClientList());
    statistics.calculateWorstScoreRegularity(clientManagement.GetClientList());

    statistics.exportClientsToJson(clientManagement.GetClientList(), statistics);
  }
}
