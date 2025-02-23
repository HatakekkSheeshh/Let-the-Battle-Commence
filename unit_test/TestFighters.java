

public class TestFighters{
    private Testcase[] testcases;
    
    public TestFighters() {
        testcases = new Testcase[] {
            // Test cases for Knight
            new KnightTest("\u001B[34mTest Knight with regular HP\u001B[0m", 1),
            new KnightTest("\u001B[34mTest Knight with GROUND is square\u001B[0m", 2),
            new KnightTest("\u001B[34mTest Knight with WP = 1\u001B[0m", 3),
            new KnightTest("\u001B[34mTest Knight with HP over bound\u001B[0m", 4),
            
            // Test cases for Warrior
            new WarriorTest("\u001B[34mTest Warrior with regular HP\u001B[0m", 5),
            new WarriorTest("\u001B[34mTest Warrior with GROUND is prime\u001B[0m", 6),
            new WarriorTest("\u001B[34mTest Warrior with WP = 1\u001B[0m", 7),
            new WarriorTest("\u001B[34mTest Warrior with HP over bound\u001B[0m", 8),

            // Test cases for DeathEater
            new DeathEaterTest("\u001B[34mTest DeathEater with normal mana\u001B[0m", 9),
            new DeathEaterTest("\u001B[34mTest DeathEater with complex mana\u001B[0m", 10),
            
            // Test cases for Paladin
            new PaladinTest("\u001B[34mTest Paladin with HP is not Fibonacci\u001B[0m", 11),
            new PaladinTest("\u001B[34mTest Paladin with HP is small Fibonacci\u001B[0m", 12),
            new PaladinTest("\u001B[34mTest Paladin with HP is huge Fibonacci\u001B[0m", 13),
            new PaladinTest("\u001B[34mTest Paladin with HP is very huge Fibonacci\u001B[0m", 14)
        };
    }
    
    public void runAllTests() {
        for (Testcase test : testcases) {
            test.runTest();
            System.out.println(test);
        }
    }
}

class KnightTest extends Testcase {
    public KnightTest(String testName, int testId) {
        super(testName, testId);
    }
    
    @Override
    public void runTest() {
        switch(getTestId()) {
            case 1:
                testNormalHP();
                break;
            case 2:
                testSquareGround();
                break;
            case 3:
                testWPOne();
                break;
            case 4:
                testExceedingHP();
                break;
        }
    }
    
    private void testNormalHP() {
        Battle.GROUND = generateNonSquareNumber(1, MAX_V);
        Knight knight = new Knight(500, 4);
        double score = knight.getCombatScore();
        setTestResult(score, 50.0);
    }
    
    private void testSquareGround() {
        Battle.GROUND = generateSquareNumber(1, MAX_V); 
        Knight knight = new Knight(500, 4);
        double score = knight.getCombatScore();
        setTestResult(score, 999.0); 
    }
    
    private void testWPOne() {
        Battle.GROUND = random.nextInt(MAX_V) + 1;
        Knight knight = new Knight(500, 1);
        double score = knight.getCombatScore();
        if(Utility.isSquare(Battle.GROUND)){
            setTestResult(score, 999.0);
            return;
        }
        setTestResult(score, 500.0);
    }
    
    private void testExceedingHP() {
        Battle.GROUND = generateSquareNumber(1, MAX_V);
        Knight knight = new Knight(random.nextInt(1000) + 999, 4);
        double score = knight.getCombatScore();
        if(Utility.isSquare(Battle.GROUND)){
            setTestResult(score, 999.0);
            return;
        }
        setTestResult(score, 999.0);
    }
}

class WarriorTest extends Testcase {
    public WarriorTest(String testName, int testId) {
        super(testName, testId);
    }
    
    @Override
    public void runTest() {
        switch(getTestId()) {
            case 5:
                testNormalHP();
                break;
            case 6:
                testPrimeGround();
                break;
            case 7:
                testWPOne();
                break;
            case 8:
                testExceedingHP();
                break;
        }
    }
    
    private void testNormalHP() {
        Battle.GROUND = generateNonPrimeNumber(1, MAX_V);
        Warrior warrior = new Warrior(500, 4);
        double score = warrior.getCombatScore();
        if(Utility.isPrime(Battle.GROUND)){
            setTestResult(score, 999.0);
            return;
        }
        setTestResult(score, 50.0);
    }
    
    private void testPrimeGround() {
        Battle.GROUND = generatePrimeNumber(1, MAX_V);; 
        Warrior warrior = new Warrior(500, 4);
        double score = warrior.getCombatScore();
        setTestResult(score, 999.0); 
    }
    
    private void testWPOne() {
        Warrior warrior = new Warrior(500, 1);
        double score = warrior.getCombatScore();
        if(Utility.isPrime(Battle.GROUND)){
            setTestResult(score, 999.0);
            return;
        }
        setTestResult(score, 500.0);
    }
    
    private void testExceedingHP() {
        Battle.GROUND = generatePrimeNumber(1, MAX_V);
        Warrior warrior = new Warrior(random.nextInt(999) + 999, 4);
        double score = warrior.getCombatScore();
        setTestResult(score, 999.0);
    }
}

class DeathEaterTest extends Testcase {
    public DeathEaterTest(String testName, int testId) {
        super(testName, testId);
    }
    
    @Override
    public void runTest() {
        switch(getTestId()) {
            case 9:
                testNormalMana();
                break;
            case 10:
                testComplexMana();
                break;
        }
    }
    
    private void testNormalMana() {
        Battle.GROUND = random.nextInt(MAX_V) + 1;
        Complex mana = new Complex(3, 0);
        DeathEater deathEater = new DeathEater(mana);
        double score = deathEater.getCombatScore();
        setTestResult(score, 3.0);
    }
    
    private void testComplexMana() {
        Battle.GROUND = random.nextInt(MAX_V) + 1;
        Complex mana = new Complex(3, 4);
        DeathEater deathEater = new DeathEater(mana);
        double score = deathEater.getCombatScore();
        setTestResult(score, 5.0); // 3-4-5 tam giác vuông
    }
}

class PaladinTest extends Testcase {
    public PaladinTest(String testName, int testId) {
        super(testName, testId);
    }
    
    @Override
    public void runTest() {
        switch(getTestId()) {
            case 11:
                testNonFiboHP();
                break;
            case 12:
                testSmallFiboHP();
                break;
            case 13:
                testLargeFiboHP();
                break;
            case 14:
                testVeryLargeFiboHP();
                break;
        }
    }
    
    private void testNonFiboHP() {
        Battle.GROUND = random.nextInt(MAX_V) + 1;
        Paladin paladin = new Paladin(500, 4);
        double score = paladin.getCombatScore();
        setTestResult(score, 1500.0); // 3 * HP vì không phải số Fibonacci
    }
    
    private void testSmallFiboHP() {
        Battle.GROUND = random.nextInt(MAX_V) + 1;
        Paladin paladin = new Paladin(2, 4); // 2 là số Fibonacci thứ 3
        double score = paladin.getCombatScore();
        setTestResult(score, 1003.0); // 1000 + 3
    }
    
    private void testLargeFiboHP() {
        Battle.GROUND = random.nextInt(MAX_V) + 1;
        Paladin paladin = new Paladin(21, 4); // 21 là số Fibonacci thứ 8
        double score = paladin.getCombatScore();
        setTestResult(score, 1008.0); // 1000 + 8 vì là số Fibonacci thứ 8
    }

    private void testVeryLargeFiboHP() {
        Battle.GROUND = random.nextInt(MAX_V) + 1;
        Paladin paladin = new Paladin(832040, 4); 
        double score = paladin.getCombatScore();
        setTestResult(score, 1030);
    }
}