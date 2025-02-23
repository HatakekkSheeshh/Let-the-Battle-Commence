import java.util.Random;

public class TeamMaker {
    // Trả về mảng Team 1
	public static Combatable[] makeTeam1() {
		Combatable[] knights = new Combatable[3];
		for (int i = 0; i < knights.length; i++) {
			knights[i] = makeRandomTeam1Member();
		}
		return knights;
	}

    // Trả về mảng Team 2
	public static Combatable[] makeTeam2() {
		Combatable[] warriors = new Combatable[3];
		for (int i = 0; i < warriors.length; i++) {
			warriors[i] = makeRandomTeam2Member();
		}
		return warriors;
	}

	private static Combatable makeRandomTeam1Member() {
		Random rand = new Random();
		int baseHP = rand.nextInt(999) + 1;
		int wp = 3;
		return (wp % 2 == 0) ? new Knight(baseHP, wp) : new Paladin(500, 1);
	}

	private static Combatable makeRandomTeam2Member() {
		Random rand = new Random();
		int baseHP = rand.nextInt(999) + 1;
		int wp = 4;
		return (Battle.GROUND % 2 == 0) ? new Warrior(baseHP, wp) : new DeathEater(new Complex(300, 200));
	}
}
// rand.nextInt(999 - 99) + 1;
// rand.nextInt(2);