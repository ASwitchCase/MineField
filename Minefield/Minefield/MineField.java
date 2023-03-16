
import java.util.Scanner;
public class MineField 
{
	public void play()
	{
		boolean playing = true;
		int rounds = 0;
		String[][] field = loadField();
		Grid g = new Grid();
		showField(field);
		
		while(playing)
		{	
			Scanner s = new Scanner(System.in);
			int x;
			int y;
			
			System.out.println("\nChoose a coordinate\nX = hidden O = Safe B = bomb\n");
			System.out.println("Enter x: ");
			x = s.nextInt();
			
			System.out.println("Enter y: ");
			y = s.nextInt();
			
			field[y-1][x-1] = g.getSpace(x, y);
			showField(field);
			
			rounds ++;
			if(g.getSpace(x, y).equals("B"))
			{
				System.out.println("\nyou blew up!\n");
				playing = false;
			}
			else if(g.playsToWin() == rounds)
			{
				System.out.println("you win!");
				playing = false;
			}
			
		}
		g.showGrid();
	}
	
	public String[][] loadField()
	{
		String[][] field = new String[6][6];
		
		for(String[] r : field)
	    {
	      for(int i = 0; i < r.length; i++)
	      {
	        r[i] = "X";
	      }
	    }
		return field;
	}
	
	public void showField(String[][] field)
	{
		int y = 0;
	    for(String[] r : field)
	    {
	      for(String c : r)
	      {
	        System.out.print(" " + c);
	      }
	      y +=1;
	      System.out.println("  | " + y);
	    }
	    System.out.println(" ____________");
	    System.out.println(" 1 2 3 4 5 6");
	}
	
	public static void main(String args[])
	{
		System.out.println("* Welcome to MineField! Choose all the points \non the gird and avoid the Bombs! *\n");
		MineField game = new MineField();
		game.play();
	}
}
