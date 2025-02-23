public class Warrior extends Fighter {
    public Warrior(int baseHp, int wp) {
        super(baseHp,wp);
    }

    @Override
    public double getCombatScore() {
        return 1.0;
    }
}
