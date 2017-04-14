import java.util.*;

public class Trainer
{
  //instance variables for name and position
  private String name;
  private Position position;
  private Kudomon kudomon;
  private Type type;

  //a trainer will have an array list of kudomons, his collection
  private List<Kudomon> kudomonCollection = new ArrayList<Kudomon>();

  //creating a map
  private Map map = new Map();

  //taking input from the command line
  Scanner input = new Scanner(System.in);

  //a constructor for the trainer which takes a String - his name
  public Trainer(String name, Type type)
  {
    switch(type){
    case TRAINER:
    this.name = name;break;
    }
  }

  public Type getType(Position position)
  {
    return type;
  }

  //randomly placing a Trainer on the map by using math.random; after I
  //calculate a random position I check if it is available and place it there
  //if it is, continue calculating if it is not
  public void placeTrainer()
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

  //a method for walking which takes an int indicating the distance and a String
  //indicating the direction
  public void walking(int distance, String direction)
  {
    switch(direction)
    {
      //in the case that the instruction is up, free the position in which the
      //trainer was, subtract its y axis by the distance given, if the resulting
      //new y axis is negative then make it 0(the curb of the map), set the new
      //position to occupied
      case "up":
      {
        map.setOccupancy((int) position.getX(), (int) position.getY(), false);
        int newY = (int) position.getY() - distance;
        if(newY < 0) newY = 0;
        position = new Position(position.getX(), newY);
        map.setOccupancy((int) position.getX(), (int) newY, true);
        break;
      }
      //in the case that the instruction is down, free the position in which the
      //trainer was, add to its y axis the distance given, if the resulting
      //new y axis is gretaer than 99 then make it 00(the curb of the map),
      //set the new position to occupied
      case "down":
      {
        map.setOccupancy((int) position.getX(), (int) position.getY(), false);
        int newY = (int) position.getY() + distance;
        if(newY > 99) newY = 99;
        position = new Position(position.getX(), newY);
        map.setOccupancy((int) position.getX(), (int) newY, true);
        break;
      }
      //in the case that the instruction is right, free the position in which
      //the trainer was, add to its x axis the distance given, if the resulting
      //new y axis is gretaer than 99 then make it 00(the curb of the map),
      //set the new position to occupied
      case "right":
      {
        map.setOccupancy((int) position.getX(), (int) position.getY(), false);
        int newX = (int) position.getX() + distance;
        if(newX > 99) newX = 99;
        position = new Position((int) newX, (int) position.getY());
        map.setOccupancy((int) newX, (int) position.getY(), true);
        break;
      }
      //in the case that the instruction is left, free the position in which the
      //trainer was, subtract its x axis by the distance given, if the resulting
      //new y axis is negative then make it 0(the curb of the map), set the new
      //position to occupied
      case "left":
      {
        map.setOccupancy((int) position.getX(), (int) position.getY(), false);
        int newX = (int) position.getX() - distance;
        if(newX < 0) newX = 0;
        position = new Position((int) newX, (int) position.getY());
        map.setOccupancy((int) newX, (int) position.getY(), true);
        break;
      }
    }
  }

  //a method for checking if kudumons are nearby in a radius of 10 positions
  //if you find that a position is occupied then present the player with the
  //choice of adding the kudomon to his collection
  public void checkNearby()
  {
    //calculate the square which we are checking
    int xRadiusFrom = (int) position.getX() - 10;
    if(xRadiusFrom < 0) xRadiusFrom = 0;

    int xRadiusTo = (int) position.getX() + 10;
    if(xRadiusTo > 99) xRadiusTo = 99;

    int yRadiusFrom = (int) position.getY() - 10;
    if(yRadiusFrom < 0) yRadiusFrom = 0;

    int yRadiusTo = (int) position.getY() + 10;
    if(yRadiusTo > 99) yRadiusTo = 99;

    //go through the positions and check if a position is occupied, do nothing
    //when you find your own position
    for(int i = xRadiusFrom; i < xRadiusTo; i++)
      for(int j = yRadiusFrom; j < yRadiusTo; j++)
        if(i == position.getX() && j == position.getY()) ;
        else
        {
          //if it is occupied then you know there is a kudomon There
          //you get the tyoe from the map, craate a new Kudomon with that type
          //and place it in your collection
          if(map.isOccupied(i, j))
          {
            Position kudomonPosition = new Position(i, j);
            Type type = map.returnType(i, j);
            Kudomon newKudomon = new Kudomon(type);
            System.out.println("There is a " + newKudomon.getName(kudomonPosition)
                               + " nearby.");
            System.out.println("Do you want to catch it?");
            String answer = input.nextLine();
            if(answer == "yes")
              {
                kudomonCollection.add(newKudomon);
                System.out.println("Congrats! It has been added to your collection!");
		            map.setOccupancy(i, j, false);
              }
          }
      }
  }
}
