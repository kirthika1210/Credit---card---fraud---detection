import java.util.Scanner;

public class FraudDetectionML {

    // Simple Logistic Regression based prediction
    public static double predictFraud(double amount, int transactions, int failedAttempts) {

        // Weights (sample values)
        double w1 = 0.00005;
        double w2 = 0.5;
        double w3 = 1.0;
        double bias = -4.0;

        // Linear equation
        double z = (w1 * amount) + (w2 * transactions) + (w3 * failedAttempts) + bias;

        // Sigmoid Function
        double probability = 1 / (1 + Math.exp(-z));

        return probability;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== Credit Card Fraud Detection Using ML =====");

        System.out.print("Enter Card Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Transaction Amount: ");
        double amount = sc.nextDouble();

        System.out.print("Enter Number of Transactions Today: ");
        int transactions = sc.nextInt();

        System.out.print("Enter Failed Login Attempts: ");
        int failedAttempts = sc.nextInt();

        // ML Prediction
        double fraudProbability = predictFraud(amount, transactions, failedAttempts);

        System.out.println("\nFraud Probability: " + (fraudProbability * 100) + "%");

        // Classification
        if (fraudProbability > 0.5) {
            System.out.println("Result: Fraudulent Transaction Detected");
        } else {
            System.out.println("Result: Legitimate Transaction");
        }

        System.out.println("Card Holder: " + name);

        sc.close();
    }
}