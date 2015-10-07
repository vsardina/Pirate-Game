/**
 * @student.info
 *<BR> Name:          Ronni Sardina
 *<BR> Date:          11-19-2013
 *<BR> Period:        5
 *<BR> Assignment:    Extra Credit
 *<BR> Description:   Boat
 *<BR> Cite Sources:  none
 */
 
//import java.awt.Color;
//import gpdraw.*;
import java.util.Random;
import java.util.Scanner;
 
 public class PirateShip
 {
	//private DrawingTool Pencil;
	//private SketchPad Paper;
	private double windSpeed;
	private double weight;
	private double shipSpeed;
	private int cannons;				//
	private int cannonballs;			//
	private int gold;					//
	private int life;					//
	private int hp;						//
	private int level;					//
	private final int cannonballWeight = 10;
	private final int cannonWeight = 1000;
	private final int shipWeight = 10000;
	private final int cannonPrice = 2000;
	private final int cannonballPrice = 10;
	private String FlagColor;			//
	private String Location;			//
	private boolean win;
	//fighting enemy pirate variables
	private Random MyRandom = new Random();
	private String EnemyLocation = "SEA";
	private String EnemyFlagColor;
	private String Attack;
	private String Action;
	private int enemyShipLvl;
	private int enemyGold;
	private int enemyLife;
	private int enemyHP;
	private int enemyCannons;
	private int enemyCannonballs;
	private int damageToEnemy;
	private int hit;
	private int enemyHit;
	private int damageToMe;
		
		
	Scanner in = new Scanner(System.in);
	{
		//Paper = new SketchPad(500, 500);
		//Pencil = new DrawingTool(Paper);
	}
	public static void main(String[] args)
	{
		//DrawingTool Pencil;
		//Pencil = new DrawingTool(new SketchPad(500,500));
		
	}
	public PirateShip()
	{
		gold = 100;
		life = 50;
		level = 1;
		cannons = 1;
		cannonballs = 10;
		FlagColor = "Black";
	}
	public PirateShip(int coins, int lfe, int lvl, int cannon, int cannonball, String Color, String Lctn)
	{
		gold = coins;
		life = lfe;
		hp = life;
		level = lvl;
		cannons = cannon;
		cannonballs = cannonball;
		FlagColor = Color;
		Location = Lctn;
	}
	public PirateShip(PirateShip OtherPirateShip)//copy constructor)
	{
		//gold = 
		//try using the "this" 
	}
	public double shipSpeed()
	{
		weight = shipWeight + (cannons * cannonWeight) + (cannonballs * cannonballWeight);
		System.out.println("Input Wind Speed in Knots --> ");
		shipSpeed = in.nextDouble();
		//buoyancy = xxxxxxx
		//shipspeed = shipspeed -=buoyancy
		return shipSpeed;
	}
	
	public void attackShip()
	{
		if (Location.equals("SEA"))
		{
			enemyShipLvl = MyRandom.nextInt(3) + 1;
			
			if (enemyShipLvl == 1)
			{
				EnemyFlagColor = "yellow";
				enemyGold = MyRandom.nextInt(1001);
				enemyLife = MyRandom.nextInt(91) + 10;
				enemyHP = enemyLife;
				enemyCannons = MyRandom.nextInt(4);
				enemyCannonballs = MyRandom.nextInt(31);
			}
			else if (enemyShipLvl == 2)
			{
				EnemyFlagColor = "red";
				enemyGold = MyRandom.nextInt(4000) + 1001;
				enemyLife = MyRandom.nextInt(200)+ 101;
				enemyHP = enemyLife;
				enemyCannons = MyRandom.nextInt(4) + 4;
				enemyCannonballs = MyRandom.nextInt(40) + 31;
			}
			else	//if enemy ship lvl == 3
			{
				EnemyFlagColor = "blue";
				enemyGold = MyRandom.nextInt(10000) + 5001;
				enemyLife = MyRandom.nextInt(200)+ 301;
				enemyHP = enemyLife;
				enemyCannons = MyRandom.nextInt(5) + 8;
				enemyCannonballs = MyRandom.nextInt(50) + 71;
			}
			printEnemy();
			System.out.print("Attack? (yes or no) : ");
			Attack = in.next();
			if (Attack.equals("yes"))
			{
				attackWave();	//recursion
			}
			else
			{
				System.out.println("YOU ARE AT SEA");
				Location = "SEA";
			}
			
			
		}
		else
		{
			System.out.println("YOU ARE NOT AT SEA");
		}
		//find and attack random 0-500hp
		//win = get gold random amount between x and x, x% of defeated ships hp depending on ship level 1,2,3
		//chance of winning varies random between x and x for levels 1,2,3
		//level 1 = 10-100hp, 0-3 cannons, 0 - 1000 gold, holds 0-30 cannonballs
		//level 2 = 101-300hp, 4-7 cannons, 1001 - 5000 gold, holds 31-70 cannonballs
		//level 3 = 301-500hp, 8-12 cannons, 5001 - 15,000 gold, holds 71 - 120 cannonballs
	}
	private void attackWave()
	{
		
		String Answer;
		
		if (cannonballs >= cannons)
		{
			hit = MyRandom.nextInt(cannons + 1);
			damageToEnemy = hit * 10;
			enemyLife -= damageToEnemy;
			cannonballs -= cannons;
		}
		else if (cannonballs > 0)
		{
			hit = MyRandom.nextInt(cannonballs + 1);
			damageToEnemy = hit * 10;
			enemyLife -= damageToEnemy;
			cannonballs = 0;
		}
		else
		{
			System.out.println("YOU HAVE NO CANNONBALLS. GO BUY THEM AT THE PORT");
		}
		//enemy attack on you
		if (enemyCannonballs >= enemyCannons)
		{
			enemyHit = MyRandom.nextInt(enemyCannons + 1);
			damageToMe = enemyHit * 10;
			life -= damageToMe;
			enemyCannonballs -= enemyCannons;
		}
		else if (enemyCannonballs > 0)
		{
			hit = MyRandom.nextInt(enemyCannonballs + 1);
			damageToMe = enemyHit * 10;
			life -= damageToMe;
			enemyCannonballs = 0;
		}
		else //enemy has no ammo
		{
			enemyLife = 0;
		}
		
		//print results of attack
		System.out.println("Life : " + life + "/" + hp);
		System.out.println("Cannonballs left : " + cannonballs);
		System.out.println("Enemy Life : " + enemyLife + "/" + enemyHP);
		
		if (life >= .25 * hp && enemyLife >= .25 * enemyHP)
		{
			System.out.println("BOTH SHIPS ARE STILL SAILING. ATTACK AGAIN? (yes or no)");
			Answer = in.next();
			if (Answer.equals("yes"))
			{
				attackWave();
			}
			else
			{
				System.out.println("YOU ARE BACK AT PORT");
				Location = ("PORT");
			}
			
		}
		else if (life >= .25 * hp && enemyLife < .25 * enemyHP)
		{
			System.out.println("YOU SUCCESSFULLY LOOTED THE ENEMY SHIP, GAINED " + enemyGold + " GOLD, AND ARE BACK AT PORT");
			gold += enemyGold;
			hp += enemyHP * .07;
			Location = "PORT";
			printShipStatus();
		}
		else 
		{
			System.out.println("YOUR SHIP HAS BEEN BOARDED. HALF OF YOUR GOLD HAS BEEN PILLAGED. BACK TO PORT AND BETTER LUCK NEXT TIME.");
			gold -= .5 * gold;
			Location = "PORT";
			printShipStatus();
		}
	}
	public void goToPort()
	{
		Location = "PORT";
		System.out.println("YOU ARE AT PORT");
	}
	public void goToSea()
	{
		Location = "SEA";
		System.out.println("YOU ARE AT SEA");
	}
	private void rest()
	{
		System.out.println("YOU HAVE RESTED AND REPAIRED ALL DAMAGE TO YOUR SHIP.");
		life = hp;
	}
	
	public void buyCannons(int number)
	{
		if (Location.equals("PORT"))
		{
			if (number * cannonPrice < gold)
			{
				gold -= (number * cannonPrice);
				cannons += number;
				System.out.println("YOU HAVE BOUGHT " + number + " CANNONS");
			}
			else
			{
				System.out.println("YOU DO NOT HAVE ENOUGH GOLD. GO ATTACK SOME SHIPS.");
			}
		}
		else
		{
			System.out.println("YOU ARE NOT AT PORT");
		}
	}
	public void buyCannonballs(int number)
	{
		if (Location.equals("PORT"))
		{
			if (number * cannonballPrice < gold)
			{
				gold -= (number * cannonballPrice);
				cannonballs += number;
				System.out.println("YOU HAVE BOUGHT " + number + " CANNONBALLS");
			}
			else
			{
				System.out.println("YOU DO NOT HAVE ENOUGH GOLD. GO ATTACK SOME SHIPS.");
			}
		}
		else
		{
			System.out.println("YOU ARE NOT AT PORT");
		}
	}
	private void printEnemy()
	{
		System.out.println("Enemy Ship Lvl : " + enemyShipLvl);
		System.out.println("Enemy Location : " + EnemyLocation);
		System.out.println("Enemy Flag Color : " + EnemyFlagColor);
	}
	public void printShipStatus()
	{
		System.out.println("Location : " + Location);
		System.out.println("Flag Color : " + FlagColor);
		System.out.println("Life : " + life + "/" + hp);
		if (Location.equals("SEA"))
		{
			System.out.println("Ship Speed : " + shipSpeed);
			System.out.println("Total Ship Weight : " + weight);
		}
		System.out.println("# of Cannons : " + cannons);
		System.out.println("# of Cannonballs : " + cannonballs);
		System.out.println("Gold Pieces : " + gold);
		//fix level
		if (hp <= 100 || cannons <= 3)
		{
			level = 1;
		}
		else if (hp > 300 && cannons > 7)
		{
			level = 3;
		}
		else
		{
			level = 2;
		}
		System.out.println("Ship Level : " + level);
		
	}
	
	public void pirateLife()
	{
		
		System.out.println("=======================================");
		System.out.println("What Would You Like To Do? \ngotoport\ngotosea\nbuycannons\nbuycannonballs\nattackships\nshipstats\nrest\nend");
		System.out.println("=======================================");
		Action = in.next();
		
		if (Action.equals("gotoport"))
		{
			goToPort();
			pirateLife();
		}
		else if (Action.equals("gotosea"))
		{
			goToSea();
			pirateLife();
		}
		else if (Action.equals("buycannons"))
		{
			int number;
			System.out.println("Cannon Price : " + cannonPrice);
			System.out.println("Input # of Cannons : ");
			number = in.nextInt();
			buyCannons(number);
			pirateLife();
		}
		else if (Action.equals("buycannonballs"))
		{
			int number;
			System.out.println("Cannonball Price : " + cannonballPrice);
			System.out.println("Input # of Cannonballs : ");
			number = in.nextInt();
			buyCannonballs(number);
			pirateLife();
		}
		else if (Action.equals("attackships"))
		{
			attackShip();
			pirateLife();
		}
		else if (Action.equals("shipstats"))
		{
			printShipStatus();
			pirateLife();
		}
		else if (Action.equals("rest"))
		{
			rest();
			pirateLife();
		}
		else if (Action.equals("end"))
		{
			System.out.println("YOUR PIRATE LIFE HAS ENDED");
			printShipStatus();
			
		}
		else
		{
			System.out.println("PLEASE TYPE A VALID RESPONSE");
			pirateLife();
		}
		
	}
	public void printStart()
	{
		System.out.println("WELCOME TO THE PIRATE LIFE!");
		printShipStatus();
	}
	
	
	//default constructor: shipweight = 100, cannons = 1, cannonballs = 10, flagcolor = black
	//normal constructor
	//copy constructor
	//calculate speed and weight: 
		//weight = shipweight + cannonweight + cannonballsweight
		//shipspeed = wind(mph) 
		//Force = mass(kg) * velocity
		//acceleration = change in velocity / time
		//mass = density * volume
		
		//wind speed = speed of the boat
		//weight = subtracts from buovancy (the water level rises)
		//default buoyancy = 2ft water level
		//higher water level subtracts from speed
		
	//lower anchor
		//shipspeed = 0, regardless of wind
	
	//attack other ships 
		//int life
		//int gold
		//int level
		//cannot have anchor down
		//find and attack random 0-500hp
		//win = get gold random amount between x and x, x% of defeated ships hp depending on ship level 1,2,3
		//chance of winning varies random between x and x for levels 1,2,3
		//level 1 = 10-100hp, 0-3 cannons, 0 - 1000 gold, holds 0-12 cannonballs
		//level 2 = 101-300hp, 4-7 cannons, 1001 - 5000 gold, holds 13-28 cannonballs
		//level 3 = 301-500hp, 8-12 cannons, 5001 - 15,000 gold, holds 29 - 48 cannonballs
		//shooting cannon(round 1)
			//your attack cannons have random x-x % hitting target
			//each shot -= cannonball
			//successful shot = 10 points damage
			//print ship status
		//if you sustain 75% damage you lose, minus x% of winning ships gold amount of gold looted, minus x% of winning ships xp depending on ships level
		//other ships have same rates
		//raise white flag truce fight ends no more attacks
		//one helper method (input win ship, input loss ship)
	//ship status
		//life
		//gold
		//cannons
		//cannonballs
		//weight
		//speed or at anchor
	//go to port
	//buy cannons
	//repair ship
 }
 
 
 