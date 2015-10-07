/**
 * @student.info
 *<BR> Name:          Ronni Sardina
 *<BR> Date:          11-19-2013
 *<BR> Period:        5
 *<BR> Assignment:    Extra Credit
 *<BR> Description:   Boat
 *<BR> Cite Sources:  none
 */
		//level 1 = 10-100hp, 0-3 cannons, 0 - 1000 gold, holds cannonballs
		//level 2 = 101-300hp, 4-7 cannons, 1001 - 5000 gold, holds cannonballs
		//level 3 = 301-500hp, 8-12 cannons, 5001 - 15,000 gold, holds cannonballs
		
		//PirateShip(int coins, int lfe, int lvl, int cannon, int cannonball, String Color, String Lctn)
 public class PirateShipTester
 {
	public static void main(String[] args)
	{
	PirateShip BlackPearl = new PirateShip (5000, 275, 2, 5, 500, "Blue", "SEA");
	BlackPearl.printStart();
	BlackPearl.pirateLife();
	}
 }