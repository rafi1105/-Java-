public class CoinCombinations {
 public static int countCombinations(int[] coins, int target) {
 int[] dp = new int[target + 1];
 dp[0] = 1;
 for (int coin : coins) {
 for (int i = coin; i <= target; i++) {
 dp[i] += dp[i - coin];
 }
 }
 return dp[target];
 }
 public static void main(String[] args) {
 int[] coins = {1, 5, 10};
 int targetAmount = 50;
 int result = countCombinations(coins, targetAmount);
System.out.println("The number of combinations to make $" + targetAmount + " is: " + result);
 }
}