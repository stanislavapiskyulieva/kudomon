public class Map
{
  //an array of booleans indicating the occupancy of the position
  public boolean[][] occupied;
  //an array of types indicating whether the position is occupied by a trainer
  //or a kudomon
  public Type[][] positions;
  //an instance variable for a type
  private Type type;

  //a constructor for the map which creates a map of 100x100 positions and sets
  //all of those's occupancy to false
  public Map()
  {
    occupied = new boolean[100][100];
    positions = new Type[100][100];
    for(int i = 0; i < 100; i++)
      for(int j = 0; j < 100; j++)
        occupied[i][j] = false;
    for(int i = 0; i < 100; i++)
      for(int j = 0; j < 100; j++)
        positions[i][j] = Type.EMPTY;
  }


  //check whether a given position is occupied
  public boolean isOccupied(int i, int j)
  {
    return occupied[i][j];
  }

  //set the occupancy of a position
  public void setOccupancy(int i, int j, boolean isOccupied)
  {
    occupied[i][j] = isOccupied;
  }

  //placing the type of an object
  public void placeObjects(int i, int j, Type type)
  {
    switch(type)
    {
      case FIRE: positions[i][j] = Type.FIRE; break;
      case WATER: positions[i][j] = Type.WATER; break;
      case ELECTRIC: positions[i][j] = Type.ELECTRIC; break;
      case PSYCHIC: positions[i][j] = Type.PSYCHIC; break;
      case ROCK: positions[i][j] = Type.ROCK; break;
      case GRASS: positions[i][j] = Type.GRASS; break;
      case TRAINER: positions[i][j] = Type.TRAINER; break;
      default: break;
    }
  }

  //a methdo which should return the type of the kudomon based on a position
  //it does not work, I cannot place an object type into a kudomon type
  //nor can I directly call the method
  public Type returnType(int i, int j)
  {
    return positions[i][j];
  }
}
