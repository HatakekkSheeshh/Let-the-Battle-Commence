public class Knight extends Fighter {
    public Knight(int baseHp, int wp) {
        super(baseHp,wp);
    }
    @Override
    public double getCombatScore() {
        return 1.0;
    }
}
// 2 * 2 * 