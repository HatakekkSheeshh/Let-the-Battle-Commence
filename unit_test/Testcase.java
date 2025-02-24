import java.util.Random;

public abstract class Testcase {
    private String testName;
    private int testId;
    private boolean isPassed;
    private double actualOutput;
    private double expectedOutput;

    public Testcase(String testName, int testId) {
        this.testName = testName;
        this.testId = testId;
        this.isPassed = false;
    }

    public abstract void runTest();

    protected void setIsPassed(boolean isPassed) {
        this.isPassed = isPassed;
    }

    protected void setTestResult(double actual, double expected) {
        this.actualOutput = actual;
        this.expectedOutput = expected;
        this.isPassed = Math.abs(actual - expected) < 0.001;
    }
    protected int getTestId() {
        return testId;
    }

    protected static Random random = new Random();
    protected int MAX_V = 999;

    protected static int generateNonSquareNumber(int min, int max) {
        int number;
        do {
            number = random.nextInt(max - min + 1) + min;
        } while (Utility.isSquare(number));
        return number;
    }

    protected static int generateNonPrimeNumber(int min, int max) {
        int number;
        do {
            number = random.nextInt(max - min + 1) + min;
        } while (Utility.isPrime(number));
        return number;
    }

    protected static int generateSquareNumber(int min, int max) {
        int number;
        do {
            number = random.nextInt(max - min + 1) + min;
        } while (!Utility.isSquare(number));
        return number;
    }

    protected static int generatePrimeNumber(int min, int max) {
        int number;
        do {
            number = random.nextInt(max - min + 1) + min;
        } while (!Utility.isPrime(number));
        return number;
    }

    @Override
    public String toString() {
        if(isPassed){
            return String.format("\u001B[32mTest case %d - %s: \u001B[32mPASSED\n" +  
                                "Expected: %.3f\n" + 
                                "Actual:   %.3f\n" + 
                                "GROUND:   %s\n\u001B[0m" + "\u001B[35m\n====================================================================\n\u001B[0m", 
                                testId, testName, this.expectedOutput, this.actualOutput, Battle.GROUND);
        }
        else {
            return String.format("\u001B[31mTest case %d - %s: \u001B[31mFAILED\n" +
                               "Expected: %.3f\n" +
                               "Actual  : %.3f\n" + 
                               "GROUND  : %s\n\u001B[0m" + "\u001B[35m\n====================================================================\n\u001B[0m", 
                               testId, testName, this.expectedOutput, this.actualOutput, Battle.GROUND);
        }
    }
}
