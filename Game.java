public class Game
{
  public static void main(String[] args)
  {
    Map map = new Map();
    Type type1 = Type.GRASS;
    Type type2 = Type.FIRE;
    Type type3 = Type.ELECTRIC;
    Type type4 = Type.WATER;
    Type type5 = Type.ROCK;
    Type type6 = Type.PSYCHIC;
    Type type7 = Type.TRAINER;

    Kudomon sourbulb =  new Kudomon(type1);
    Kudomon mancharred =  new Kudomon(type2);
    Kudomon chikapu = new Kudomon(type3);
    Kudomon wolipag = new Kudomon(type4);
    Kudomon noix = new Kudomon(type5);
    Kudomon wowzee = new Kudomon(type6);
    System.out.println("" + sourbulb);
    sourbulb.placeKudomon();
    mancharred.placeKudomon();
    chikapu.placeKudomon();
    wolipag.placeKudomon();
    noix.placeKudomon();
    wowzee.placeKudomon();

    Trainer tash = new Trainer("tash", type7);
    tash.placeTrainer();
    tash.checkNearby();

  }
}
