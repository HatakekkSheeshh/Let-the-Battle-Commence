// Source code is decompiled from a .class file using FernFlower decompiler.
// import java.util.Arrays;

/* public class Main {
   public Main() {
   }

   public static void main(String[] var0) {
      System.out.println("Battle Begin.");
      Battle.moveRandomGround();
      Combatable[] var1 = TeamMaker.makeTeam1();
      Combatable[] var2 = TeamMaker.makeTeam2();
      System.out.println("Team 1 is " + Arrays.toString(var1));
      System.out.println("Team 2 is " + Arrays.toString(var2));
      Battle var3 = new Battle(var1, var2);
      var3.combat();
      System.out.println("Battle End.");
   }
}
 */

public class Main {
   public static void main(String[] args) {
       TestFighters testFighters = new TestFighters();
       testFighters.runAllTests();
   }
}