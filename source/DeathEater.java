public class DeathEater extends Monster implements Combatable {
	public DeathEater(Complex mana) {
		// mp: mana point
		super(mana);
	}

	@Override
	public double getCombatScore() {
		return 1.0;
	}
}
