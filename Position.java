public class Position
{
  //instance variables for the x and y axis
  private double x;
  private double y;

  //a contructor for creating a position
  public Position(double x, double y)
  {
    this.x = x;
    this.y = y;
  }

  //an accessor method for getting the x axis
  public double getX()
  {
    return x;
  }

  //an accessor method for getting the y axis
  public double getY()
  {
    return y;
  }
}
