
public class Grid
{
  private String[][] grid;

  public Grid()
  {
    grid = new String[6][6];
    this.fillGrid();
    
    while(playsToWin() > 32)
    {
    	this.fillGrid();
    }
  }

  public String[][] getGrid()
  {
    return this.grid;
  }

  public void setGrid(String[][] grid)
  {
    this.grid = grid;
  }

  public void fillGrid()
  {
    //fills the grid

    for(String[] r : this.grid)
    {
      for(int i = 0; i < r.length; i++)
      {
        r[i] = getVal();
      }
    }
  }

  public void showGrid()
  {
    //displays the grid
    int y = 0;
    for(String[] r : this.grid)
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
  
  public int playsToWin()
  {
	 int count = 0;
	 for(String[] r : this.grid)
	   {
	     for(String c : r)
	     {
	       if(c.equals("O"))
	       {
	    	   count++;
	       }
	     }
	   }
	 return count;
  }

  public String getVal()
  {
    //B = bomb 0 = safe
    int num = (int)(Math.random()*10) + 1;

    if(num == 1)
    {
      return "B";
    }
    else
    {
      return "O";
    }
  }
  
  public String getSpace(int x, int y)
  {
	  return grid[y - 1][x - 1];
  }
  public static void main(String args[])
  {
	  Grid g  = new Grid();
	  g.showGrid();
  }
}
