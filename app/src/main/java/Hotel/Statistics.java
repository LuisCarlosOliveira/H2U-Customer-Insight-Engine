package Hotel;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Statistics implements IStatistics {

  // #region Variables

  private static final Logger log = Logger.getLogger(Statistics.class.getName());
  /**
   * Reference to the Most Interesting Time Of The Year
   */
  private int MostInterestingTimeOfYear;

  /**
   * Reference to the most Used Aquisition Service
   */
  private String MostUsedAquisitionService;

  /**
   * Reference to the Average Time Between Purchases
   */
  private float AvgTimeBetweenPurchases;

  /**
   * Reference to the Minimum Time Between Purchases
   */
  private int MinTimeBetweenPurchases;

  /**
   * Reference to the Maximum Time Between Purchases
   */
  private int MaxTimeBetweenPurchases;

  /**
   * Reference to the Most Used Payment Method
   */
  private int MostUsedPaymentMethod;

  /**
   * Reference to the Average Total Purchases Value
   */
  private float AvgTotalPurchasesValue;

  /**
   * Reference to the Minimum Purchases Value
   */
  private float MinPurchasesValue;

  /**
   * Reference to the Maximum Purchases Value
   */
  private float MaxPurchasesValue;

  /**
   * Reference to the Average Worst Score
   */
  private String AvgWorstScore;

  /**
   * Reference to the Average Best Score
   */
  private String AvgBestScore;

  /**
   * Reference to the Average Best Score
   */
  private String BestScoreMonetization;

  /**
   * Reference to the Average Best Score
   */
  private String BestScoreTotalPurchases;

  /**
   * Reference to the Average Best Score
   */
  private String BestScoreRegularity;

  /**
   * Reference to the Average Best Score
   */
  private String WorstScoreMonetization;

  /**
   * Reference to the Average Best Score
   */
  private String WorstScoreTotalPurchases;

  /**
   * Reference to the Average Best Score
   */
  private String WorstScoreRegularity;

  // #endregion

  // #region Gets

  /**
   * Method to get the Most Interesting Time of the Year
   * 
   * @return String with the Most Interesting Time of the Year
   */
  @Override
  public int getMostInterestingTimeOfYear() {
    return MostInterestingTimeOfYear;
  }

  /**
   * Method to get the Most Used Aquisition Service
   * 
   * @return String with the Most Used Aquisition Service
   */
  @Override
  public String getMostUsedAquisitionService() {
    return MostUsedAquisitionService;
  }

  /**
   * Method to get the Average Time Between Purchases
   * 
   * @return Float value with the Average Time Between Purchases
   */
  @Override
  public float getAvgTimeBetweenPurchases() {
    return AvgTimeBetweenPurchases;
  }

  /**
   * Method to get the Minimum Time Between Purchases
   * 
   * @return Integer with the Minimum Time Between Purchases
   */
  @Override
  public int getMinTimeBetweenPurchases() {
    return MinTimeBetweenPurchases;
  }

  /**
   * Method to get the Maximum Time Between Purchases
   * 
   * @return Integer with the Maximum Time Between Purchases
   */
  @Override
  public int getMaxTimeBetweenPurchases() {
    return MaxTimeBetweenPurchases;
  }

  /**
   * Method to get the Most Used Payment Method
   * 
   * @return int the Most Used Payment Method
   */
  @Override
  public int getMostUsedPaymentMethod() {
    return MostUsedPaymentMethod;
  }

  /**
   * Method to get the Average Total Purchases Value
   * 
   * @return Float of the Average Total Purchases Value
   */
  @Override
  public float getAvgTotalPurchasesValue() {
    return AvgTotalPurchasesValue;
  }

  /**
   * Method to get the Minimum Purchases Value
   * 
   * @return Float of the Minimum Purchases Value
   */
  @Override
  public float getMinPurchasesValue() {
    return MinPurchasesValue;
  }

  /**
   * Method to get the Maximum Purchases Value
   * 
   * @return Float of the Maximum Purchases Value
   */
  @Override
  public float getMaxPurchasesValue() {
    return MaxPurchasesValue;
  }

  /**
   * Method to get the Average Worst Score
   * 
   * @return String of the Average Worst Score
   */
  @Override
  public String getAvgWorstScore() {
    return AvgWorstScore;
  }

  /**
   * Method to get the Average Best Score
   * 
   * @return String of the Average Best Score
   */
  @Override
  public String getAvgBestScore() {
    return AvgBestScore;
  }

  /**
   * Method to get the Best Score Monetization
   * 
   * @return String of the Best Score Monetization
   * 
   */
  @Override
  public String getBestScoreMonetization() {
    return BestScoreMonetization;
  }

  /**
   * Method to get the Best Score Total Purchases
   * 
   * @return String of the Best Score Total Purchases
   * 
   */
  @Override
  public String getBestScoreTotalPurchases() {
    return BestScoreTotalPurchases;
  }

  /**
   * Method to get the Best Score Regularity
   * 
   * @return String of the Best Score Regularity
   * 
   */
  @Override
  public String getBestScoreRegularity() {
    return BestScoreRegularity;
  }
  
  /**
   * Method to get the Worst Score Monetization
   * 
   * @return String of the Worst Score Monetization
   * 
   */
  @Override
  public String getWorstScoreMonetization() {
    return WorstScoreMonetization;
  }

  /**
   * Method to get the Worst Score Total Purchases
   * 
   * @return String of the Worst Score Total Purchases
   * 
   */
  @Override
  public String getWorstScoreTotalPurchases() {
    return WorstScoreTotalPurchases;
  }

  /**
   * Method to get the Worst Score Regularity
   * 
   * @return String of the Worst Score Regularity
   * 
   */	
  @Override
  public String getWorstScoreRegularity() {
    return WorstScoreRegularity;
  }

  // #endregion

  // #region Sets

  /**
   * Method to set the Most Interesting Time of the Year
   * 
   * @param mostInterestingTimeOfYear
   */
  public void setMostInterestingTimeOfYear(int mostInterestingTimeOfYear) {
    MostInterestingTimeOfYear = mostInterestingTimeOfYear;
  }

  /**
   * Method to set the Most Used Aquisition Service
   * 
   * @param mostUsedAquisitionService
   */
  public void setMostUsedAquisitionService(String mostUsedAquisitionService) {
    MostUsedAquisitionService = mostUsedAquisitionService;
  }

  /**
   * Method to set the Average Time Between Purchases
   * 
   * @param avgTimeBetweenPurchases
   */
  public void setAvgTimeBetweenPurchases(float avgTimeBetweenPurchases) {
    AvgTimeBetweenPurchases = avgTimeBetweenPurchases;
  }

  /**
   * Method to set the Minimum Time Between Purchases
   * 
   * @param minTimeBetweenPurchases
   */
  public void setMinTimeBetweenPurchases(int minTimeBetweenPurchases) {
    MinTimeBetweenPurchases = minTimeBetweenPurchases;
  }

  /**
   * Method to set the Maximum Time Between Purchases
   * 
   * @param maxTimeBetweenPurchases
   */
  public void setMaxTimeBetweenPurchases(int maxTimeBetweenPurchases) {
    MaxTimeBetweenPurchases = maxTimeBetweenPurchases;
  }

  /**
   * Method to set the Most Used Payment Method
   * 
   * @param mostUsedPaymentMethod
   */
  public void setMostUsedPaymentMethod(int mostUsedPaymentMethod) {
    MostUsedPaymentMethod = mostUsedPaymentMethod;
  }

  /**
   * Method to set the Average Total Purchases Value
   * 
   * @param avgTotalPurchasesValue
   */
  public void setAvgTotalPurchasesValue(float avgTotalPurchasesValue) {
    AvgTotalPurchasesValue = avgTotalPurchasesValue;
  }

  /**
   * Method to set the Minimum Purchases Value
   * 
   * @param minPurchasesValue
   */
  public void setMinPurchasesValue(float minPurchasesValue) {
    MinPurchasesValue = minPurchasesValue;
  }

  /**
   * Method to set the Maximum Purchases Value
   * 
   * @param maxPurchasesValue
   */
  public void setMaxPurchasesValue(float maxPurchasesValue) {
    MaxPurchasesValue = maxPurchasesValue;
  }

  /**
   * Method to set the Average Worst Score
   * 
   * @param avgWorstScore
   */
  public void setAvgWorstScore(String avgWorstScore) {
    AvgWorstScore = avgWorstScore;
  }

  /**
   * Method to set the Average Best Score
   * 
   * @param avgBestScore
   */
  public void setAvgBestScore(String avgBestScore) {
    AvgBestScore = avgBestScore;
  }

  /**
   * Method to set the Average Best Score Monetization
   * 
   * @param bestScoreMonetization
   */
  public void setBestScoreMonetization(String bestScoreMonetization) {
    BestScoreMonetization = bestScoreMonetization;
  }

  /**
   * Method to set the Best Score Total Purchases
   * 
   * @param bestScoreTotalPurchases
   */
  public void setBestScoreTotalPurchases(String bestScoreTotalPurchases) {
    BestScoreTotalPurchases = bestScoreTotalPurchases;
  } 

  /**
   * Method to set the Best Score Regularity
   * 
   * @param bestScoreRegularity
   */
  public void setBestScoreRegularity(String bestScoreRegularity) {
    BestScoreRegularity = bestScoreRegularity;
  }

  /**
   * Method to set the Worst Score Monetization
   * 
   * @param worstScoreMonetization
   */
  public void setWorstScoreMonetization(String worstScoreMonetization) {
    WorstScoreMonetization = worstScoreMonetization;
  }

  /**
   * Method to set the Worst Score Total Purchases
   * 
   * @param worstScoreTotalPurchases
   */
  public void setWorstScoreTotalPurchases(String worstScoreTotalPurchases) {
    WorstScoreTotalPurchases = worstScoreTotalPurchases;
  }

  /**
   * Method to set the Worst Score Regularity
   * 
   * @param worstScoreRegularity
   */
  public void setWorstScoreRegularity(String worstScoreRegularity) {
    WorstScoreRegularity = worstScoreRegularity;
  }

  // #endregion
  /**
   * Method to calculate the Most Interesting Time Of The Year for each client and
   * the general statistics
   *
   * @param clients the populated list of clients
   * @throws ParseException in case the date isn't on the specified format:
   *                        dd/MM/yyyy
   */
  public void calculateMostInterestingTimeOfYear(List<Client> clients)
      throws ParseException, Exception {
    if (clients.isEmpty()) {
      throw new Exception(Variables.LISTA_VAZIA);
    }

    int[] generalValuePerMonth = new int[4];
    int indexGeneralMaxValuePerMonth = 0;

    for (Client client : clients) {
      int[] valuePerMonth = new int[4];
      for (Transaction transaction : client.getTransactions()) {
        Date date = new SimpleDateFormat("dd/MM/yyyy", Locale.US)
            .parse(transaction.getPurchaseDate());

        switch (new SimpleDateFormat("MM", Locale.US).format(date)) {
          case "01":
          case "02":
          case "03":
            valuePerMonth[0]++;
            generalValuePerMonth[0]++;
            break;
          case "04":
          case "05":
          case "06":
            valuePerMonth[1]++;
            generalValuePerMonth[1]++;
            break;
          case "07":
          case "08":
          case "09":
            valuePerMonth[2]++;
            generalValuePerMonth[2]++;
            break;
          case "10":
          case "11":
          case "12":
            valuePerMonth[3]++;
            generalValuePerMonth[3]++;
            break;
            default:
            log.info("Mes invalido, o input deve ser entre 1 e 12");
            break;
        }

        int indexMaxValuePerMonth = 0;
        for (int i = 0; i < valuePerMonth.length; i++) {
          if (valuePerMonth[i] > valuePerMonth[indexMaxValuePerMonth]) {
            indexMaxValuePerMonth = i;
          }
        }

        client.setMostInterestingTimeOfYear(indexGeneralMaxValuePerMonth + 1);
      }

      for (int i = 0; i < generalValuePerMonth.length; i++) {
        if (generalValuePerMonth[i] > generalValuePerMonth[indexGeneralMaxValuePerMonth]) {
          indexGeneralMaxValuePerMonth = i;
        }
      }
    }

    this.MostInterestingTimeOfYear = indexGeneralMaxValuePerMonth + 1;
  }

  /**
   * Method to calculate the Most Used Payment Method for each client and the
   * general statistics
   *
   * @param clients the populated list of clients
   */
  public void calculateMostUsedPaymentMethod(List<Client> clients)
      throws Exception {
    if (clients.isEmpty()) {
      throw new Exception(Variables.LISTA_VAZIA);
    }

    int[] generalPaymentMethodUsage = new int[4];
    int indexMaxValueGeneralPaymenthMethodUsage = 0;

    for (Client client : clients) {
      int[] paymentMethodUsage = new int[4];
      int indexMaxValuePaymenthMethodUsage = 0;

      for (Transaction transaction : client.getTransactions()) {
        paymentMethodUsage[transaction.getPaymentMethod() - 1]++;
        generalPaymentMethodUsage[transaction.getPaymentMethod() - 1]++;
      }

      for (int i = 0; i < paymentMethodUsage.length; i++) {
        if (paymentMethodUsage[i] > paymentMethodUsage[indexMaxValuePaymenthMethodUsage]) {
          indexMaxValuePaymenthMethodUsage = i;
        }
      }

      client.setMostUsedPaymentMethod(indexMaxValuePaymenthMethodUsage + 1);
    }

    for (int i = 0; i < generalPaymentMethodUsage.length; i++) {
      if (generalPaymentMethodUsage[i] > generalPaymentMethodUsage[indexMaxValueGeneralPaymenthMethodUsage]) {
        indexMaxValueGeneralPaymenthMethodUsage = i;
      }
    }

    this.MostUsedPaymentMethod = indexMaxValueGeneralPaymenthMethodUsage + 1;
  }

  /**
   * Method to calculate the Average Time Between Purchases for each client and
   * the general statistics
   *
   * @param clients the populated list of clients
   * @throws ParseException in case the date isn't on the specified format:
   *                        dd/MM/yyyy
   */
  public void calculateAvgTimeBetweenPurchases(List<Client> clients)
      throws ParseException, Exception {
    if (clients.isEmpty()) {
      throw new Exception(Variables.LISTA_VAZIA);
    }

    int generalTotalDays = 0;
    int amountOfTransactionsCompares = 0;
    int minTime = 99999;
    int maxTime = 0;

    for (Client client : clients) {
      if (client.getTransactions().size() > Variables.MINIMUM_TRANSACTION_COUNT) {
        client.sortTransactionsByPurchaseDate();

        int totalDays = 0;
        for (int i = 0; i < client.getTransactions().size() - 1; i++) {
          SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.UK);
          Date dateBefore = sdf.parse(
              client.getTransactions().get(i).getPurchaseDate());
          Date dateAfter = sdf.parse(
              client.getTransactions().get(i + 1).getPurchaseDate());

          long timeDiff = dateAfter.getTime() - dateBefore.getTime();
          long daysDiff = TimeUnit.DAYS.convert(
              timeDiff,
              TimeUnit.MILLISECONDS);
          totalDays += daysDiff;
          generalTotalDays += totalDays;

          minTime = minTime > totalDays ? totalDays : minTime;
          maxTime = maxTime < totalDays ? totalDays : maxTime;
        }

        amountOfTransactionsCompares += client.getTransactions().size() - 1;
        client.setAvgTimeBetweenPurchases(
            totalDays / (client.getTransactions().size() - 1));
      } else {
        amountOfTransactionsCompares = 1;
        client.setAvgTimeBetweenPurchases(0);
      }
    }

    this.MinTimeBetweenPurchases = minTime == 99999 ? -1 : minTime;
    this.MaxTimeBetweenPurchases = maxTime == 0 ? -1 : maxTime;
    this.AvgTimeBetweenPurchases = generalTotalDays / amountOfTransactionsCompares;
  }

  /**
   * Method to calculate the Most Used Aquisition Service for the general
   * statistics
   *
   * @param clients the populated list of clients
   */
  public void calculateMostUsedAquisitionService(List<Client> clients)
      throws Exception {
    if (clients.isEmpty()) {
      throw new Exception(Variables.LISTA_VAZIA);
    }

    int[] generalDistributionChannelsValue = new int[3];
    int indexGeneralDistributionChannelsValue = 0;

    for (Client client : clients) {
      for (Transaction transaction : client.getTransactions()) {
        switch (transaction.getDistributionChannel()) {
          case "Direct":
            generalDistributionChannelsValue[0]++;
            break;
          case "Travel Agent/Operator":
            generalDistributionChannelsValue[1]++;
            break;
          case "Corporate":
            generalDistributionChannelsValue[2]++;
            break;
          default:
            log.info("Canal de distribuição desconhecido");
            break;
        }
      }
    }

    for (int i = 0; i < generalDistributionChannelsValue.length; i++) {
      if (generalDistributionChannelsValue[i] > generalDistributionChannelsValue[indexGeneralDistributionChannelsValue]) {
        indexGeneralDistributionChannelsValue = i;
      }
    }

    switch (indexGeneralDistributionChannelsValue) {
      case 0:
        this.MostUsedAquisitionService = "Direct";
        break;
      case 1:
        this.MostUsedAquisitionService = "Travel Agent/Operator";
        break;
      case 2:
        this.MostUsedAquisitionService = "Corporate";
        break;
      default:
        log.info("Canal de distribuição desconhecido");
        break;
    }
  }

  /**
   * Method to calculate the Average Total Purchases And Minimum/Maximum Values
   * for the general statistics
   *
   * @param clients
   * @throws Exception
   */
  public void calculateAvgTotalPurchasesAndMinMaxValues(List<Client> clients)
      throws Exception {
    if (clients.isEmpty()) {
      throw new Exception(Variables.LISTA_VAZIA);
    }

    Score score = new Score();
    score.getMonetization(clients);
    float totalPurchasesValue = 0;
    int amountOfPurchases = 0;

    for (Client client : clients) {
      float purchasesValue = 0;

      for (Transaction transaction : client.getTransactions()) {
        purchasesValue += Float.parseFloat(transaction.getLodgingRevenue());
        purchasesValue += Float.parseFloat(transaction.getOtherRevenue());
        amountOfPurchases++;
      }

      if (clients.indexOf(client) == 0) {
        this.MinPurchasesValue = purchasesValue;
      } else if (clients.indexOf(client) == clients.size() - 1) {
        this.MaxPurchasesValue = purchasesValue;
      }

      totalPurchasesValue = purchasesValue;
    }

    this.AvgTotalPurchasesValue = totalPurchasesValue / amountOfPurchases;
  }

  /**
   * Method to calculate the Best and Worst Average Score for the general
   * statistics
   *
   * @param clients the populated list of clients
   * @throws Exception
   */
  public void calculateBestandWorstAvgScore(List<Client> clients)
      throws Exception {
    if (clients.isEmpty()) {
      throw new Exception(Variables.LISTA_VAZIA);
    }

    double bestScore = 0;
    double worstScore = 5;
    String hashBest = "";
    String hashWorst = "";
    for (Client client : clients) {
      double tmpScore = 0;
      int n = 0;
      for (Score score : client.getScores()) {
        tmpScore += score.getQuartil();
        n++;
      }
      tmpScore = tmpScore / n;

      if (tmpScore > bestScore) {
        bestScore = tmpScore;
        hashBest = client.getDocIDHash();
      }

      if (tmpScore < worstScore) {
        worstScore = tmpScore;
        hashWorst = client.getDocIDHash();
      }
    }

    this.AvgBestScore = hashBest;
    this.AvgWorstScore = hashWorst;
  }

  /**
   * Method to calculate the Best Score Monetization for the general statistics
   *
   * @param clients the populated list of clients
   * @throws Exception
   *
   */    
  public void calculateBestScoreMonetization(List<Client> clients)
      throws Exception {
    if (clients.isEmpty()) {
      throw new Exception(Variables.LISTA_VAZIA);
    }
    int money = 0;
    double value = 0;
    String hash = "";
    for (Client client : clients) {
      if (client.getSpecificQuartil(Variables.MONETIZATION) >= money) {
        if (Double.parseDouble(client.getSpecificValue(Variables.MONETIZATION)) > value) {
        value = Double.parseDouble(client.getSpecificValue(Variables.MONETIZATION));
        money = client.getSpecificQuartil(Variables.MONETIZATION);
        hash = client.getDocIDHash();
        }
      }
    }
    this.BestScoreMonetization = hash;
  }

  /**
   * Method to calculate the Best Score Total Purchases for the general
   * statistics
   *
   * @param clients the populated list of clients
   * @throws Exception
   *
   */
  public void calculateBestScoreTotalPurchases(List<Client> clients)
      throws Exception {
    if (clients.isEmpty()) {
      throw new Exception(Variables.LISTA_VAZIA);
    }
    int money = 0;
    int value = 0;
    String hash = "";
    for (Client client : clients) {
      if (client.getSpecificQuartil(Variables.TOTAL_PURCHASE) >= money) {
        if (Integer.parseInt(client.getSpecificValue(Variables.TOTAL_PURCHASE)) > value) {
        value = Integer.parseInt(client.getSpecificValue(Variables.TOTAL_PURCHASE));
        money = client.getSpecificQuartil(Variables.TOTAL_PURCHASE);
        hash = client.getDocIDHash();
        }
      }
    }
    this.BestScoreTotalPurchases = hash;
  }

  /**
   * Method to calculate the Best Score Regularity for the general statistics
   *
   * @param clients the populated list of clients
   * @throws Exception
   *
   */
  public void calculateBestScoreRegularity(List<Client> clients)
      throws Exception {
    if (clients.isEmpty()) {
      throw new Exception(Variables.LISTA_VAZIA);
    }
    int money = 0;
    float value = Integer.MAX_VALUE;
    String hash = "";
    for (Client client : clients) {
      if (client.getSpecificQuartil(Variables.REGULARITY) > money) {
        if (client.getAvgTimeBetweenPurchases() < value) {
        value = client.getAvgTimeBetweenPurchases();
        money = client.getSpecificQuartil(Variables.REGULARITY);
        hash = client.getDocIDHash();
        }
      }
    }
    this.BestScoreRegularity = hash;
  }

  /**
   * Method to calculate the Worst Score Monetization for the general statistics
   *
   * @param clients the populated list of clients
   * @throws Exception
   *
   */
  public void calculateWorstScoreMonetization(List<Client> clients)
      throws Exception {
    if (clients.isEmpty()) {
      throw new Exception(Variables.LISTA_VAZIA);
    }
    int money = 5;
    double value = Integer.MAX_VALUE;
    String hash = "";
    for (Client client : clients) {
      if (client.getSpecificQuartil(Variables.MONETIZATION) <= money) {
        if (Double.parseDouble(client.getSpecificValue(Variables.MONETIZATION)) < value) {
        value = Double.parseDouble(client.getSpecificValue(Variables.MONETIZATION));
        money = client.getSpecificQuartil(Variables.MONETIZATION);
        hash = client.getDocIDHash();
        }
      }
    }
    this.WorstScoreMonetization = hash;
  }

  /**
   * Method to calculate the Best Score Total Purchases for the general
   * statistics
   *
   * @param clients the populated list of clients
   * @throws Exception
   *
   */
  public void calculateWorstScoreTotalPurchases(List<Client> clients)
      throws Exception {
    if (clients.isEmpty()) {
      throw new Exception(Variables.LISTA_VAZIA);
    }
    int money = 5;
    int value = Integer.MAX_VALUE;
    String hash = "";
    for (Client client : clients) {
      if (client.getSpecificQuartil(Variables.TOTAL_PURCHASE) <= money) {
        if (Integer.parseInt(client.getSpecificValue(Variables.TOTAL_PURCHASE)) < value) {
        value = Integer.parseInt(client.getSpecificValue(Variables.TOTAL_PURCHASE));
        money = client.getSpecificQuartil(Variables.TOTAL_PURCHASE);
        hash = client.getDocIDHash();
        }
      }
    }
    this.WorstScoreTotalPurchases = hash;
  }

  /**
   * Method to calculate the Worst Score Regularity for the general statistics
   *
   * @param clients the populated list of clients
   * @throws Exception
   *
   */
  public void calculateWorstScoreRegularity(List<Client> clients)
      throws Exception {
    if (clients.isEmpty()) {
      throw new Exception(Variables.LISTA_VAZIA);
    }
    int money = 5;
    float value = Integer.MAX_VALUE;
    String hash = "";
    for (Client client : clients) {
      if (client.getSpecificQuartil(Variables.REGULARITY) < money) {
        if (client.getAvgTimeBetweenPurchases() < value) {
          value = client.getAvgTimeBetweenPurchases();
          money = client.getSpecificQuartil(Variables.REGULARITY);
          hash = client.getDocIDHash();
        }
      }
    }
    this.WorstScoreRegularity = hash;
  }

  /**
   * Method to export the clients statistics and general statistics to a JSON file
   *
   * @param clients the populated list of clients
   * @param statistics statistics class
   * @throws Exception
   *
   */
  public void exportClientsToJson(List<Client> clients, Statistics statistics) throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    mapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);
    ObjectNode root = mapper.createObjectNode();
    ArrayNode clientsList = mapper.valueToTree(clients);
    root.set("ClientsStatistics", clientsList);
    root.set("GeneralStatistics", mapper.valueToTree(statistics));
    try (FileWriter writer = new FileWriter("clients.json")) {
      mapper.writeValue(writer, root);
    } catch (IOException e) {
      throw new Exception(e);
    }
  }

  /**
   * To String method
   * 
   * @return String with the statistics information
   */
  @Override
  public String toString() {
    return ("Statistics [MostInterestingTimeOfYear=" +
        MostInterestingTimeOfYear +
        ", MostUsedAquisitionService=" +
        MostUsedAquisitionService +
        ", AvgTimeBetweenPurchases=" +
        AvgTimeBetweenPurchases +
        ", MinTimeBetweenPurchases=" +
        MinTimeBetweenPurchases +
        ", MaxTimeBetweenPurchases=" +
        MaxTimeBetweenPurchases +
        ", MostUsedPaymentMethod=" +
        MostUsedPaymentMethod +
        ", AvgTotalPurchasesValue=" +
        AvgTotalPurchasesValue +
        ", MinPurchasesValue=" +
        MinPurchasesValue +
        ", MaxPurchasesValue=" +
        MaxPurchasesValue +
        "]");
  }
}
