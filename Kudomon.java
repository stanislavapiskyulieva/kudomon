import java.lang.Math.*;

public class Kudomon
{
  //instance variables for name, type and position
  private Type type;
  private String name;
  private Position position;

  //creating a map
  private Map map = new Map();

  //a constructor for a Kudomon which takes a type and depending on it, gives
  //the kudomon a name
  public Kudomon(Type type)
  {
    switch(type)
    {
      case WATER:
      this.type = Type.WATER;
      name = "Wolipag"; break;
      case FIRE:
      this.type = Type.FIRE;
      name = "Mancharred"; break;
      case ELECTRIC:
      this.type = Type.ELECTRIC;
      name = "Chikapu"; break;
      case PSYCHIC:
      this.type = Type.PSYCHIC;
      name = "Wowzee"; break;
      case ROCK:
      this.type = Type.ROCK;
      name = "Noix"; break;
      case GRASS:
      this.type = Type.GRASS;
      name = "Sourbulb"; break;
    }
  }

  //an accessor method which returns the type of the kudomon taking its
  //position(as in the trainer class when i find a position is occupied I only
  //have the positiion from which i can take information for the Kudomon,
  //however that does not work properly)
  public Type getType(Position position)
  {
    return type;
  }


  //same as with type but for name
  public String getName(Position position)
  {
    return name;
  }

  //an accessor method for the position
  public Position getPosition()
  {
    return position;
  }

  //randomly placing a Kudomon on the map by using math.random; after I
  //calculate a random position I check if it is available and place it there
  //if it is, continue calculating if it is not
  public void placeKudomon()
  {
    double x = Math.random() * 100;
    double y = Math.random() * 100;
    while(map.isOccupied((int) x, (int) y))
    {
      x = Math.random() * 100;
      y = Math.random() * 100;
    }
    position = new Position(x, y);
    map.setOccupancy((int) x, (int) y, true);
    map.placeObjects((int) x, (int) y, getType(position));
  }

  //a toString method for the kudomon
  public String toString()
  {
    return "This is " + name + " of type " + type;
  }
}
