package Hotel;

/**
 * <h3>
 * <strong>Interface that represents the structure of the Statistics data</strong>
 * </h3>
 *
 * @author Adão Araújo
 * @author Luis Oliveira
 * @author Rui Teixeira
 * @author Pedro Marques
 */
public interface IStatistics {

//#region Gets

  /**
   * Method to get the Most Interesting Time of the Year
   */
  int getMostInterestingTimeOfYear();

  /**
   * Method to get the Most Used Aquisition Service
   */
  String getMostUsedAquisitionService();

  /**
   * Method to get the Average Time Between Purchases
   * @return Float value with the Average Time Between Purchases
   */
  float getAvgTimeBetweenPurchases();

  /**
   * Method to get the Minimum Time Between Purchases
   * @return Integer with the Minimum Time Between Purchases
   */
  int getMinTimeBetweenPurchases();

  /**
   * Method to get the Maximum Time Between Purchases
   * @return Integer with the Maximum Time Between Purchases
   */
  int getMaxTimeBetweenPurchases();

  /**
   * Method to get the Most Used Payment Method
   * @return String of the Most Used Payment Method
   */
  int getMostUsedPaymentMethod();
  
  /**
   * Method to get the Average Total Purchases Value
   * @return Float of the Average Total Purchases Value
   */
  float getAvgTotalPurchasesValue();

  /**
   * Method to get the Minimum Purchases Value
   * @return Float of the Minimum Purchases Value
   */
  float getMinPurchasesValue();

  /**
   * Method to get the Maximum Purchases Value
   * @return Float of the Maximum Purchases Value
   */
  float getMaxPurchasesValue();

  /**
   * Method to get the Average Worst Score
   * @return Float of the Average Worst Score
   */
  String getAvgWorstScore();

  /**
   * Method to get the Average Best Score
   * @return Float of the Average Best Score
   */
  String getAvgBestScore();

  /**
   * Method to get the Best Score Monetization
   * @return String of the Best Score Monetization
   */
  String getBestScoreMonetization();

  /**
   * Method to get the Best Score Total Purchases
   * @return String of the Best Score Total Purchases
   */
  String getBestScoreTotalPurchases();

  /**
   * Method to get the Best Score Regularity
   * @return String of the Best Score Regularity
   */
  String getBestScoreRegularity();

  /**
   * Method to get the Worst Score Monetization
   * @return String of the Worst Score Monetization
   */
  String getWorstScoreMonetization();

  /**
   * Method to get the Worst Score Total Purchases
   * @return String of the Worst Score Total Purchases
   */
  String getWorstScoreTotalPurchases();

  /**
   * Method to get the Worst Score Regularity
   * @return String of the Worst Score Regularity
   */
  String getWorstScoreRegularity();
//#endregion
}
