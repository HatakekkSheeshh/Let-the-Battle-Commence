public class Paladin extends Knight {
	public Paladin(int baseHp, int wp) {
		super(baseHp,wp);				// call constructor of parent class
	}

	@Override
	public double getCombatScore() {
		return 1.0;
	}
}
