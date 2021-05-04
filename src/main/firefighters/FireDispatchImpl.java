package main.firefighters;

import java.util.List;
import java.util.ArrayList;

import main.api.City;
import main.api.CityNode;
import main.api.FireDispatch;
import main.api.Firefighter;
import main.api.exceptions.NoFireFoundException;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class FireDispatchImpl implements FireDispatch {

  private City city;
  private List<Firefighter> firefighters;

  public FireDispatchImpl(City c) {
    city = c;
    firefighters = new ArrayList<Firefighter>(); // Creates an arraylist of firefighters
  }

  @Override
  public void setFirefighters(int numFirefighters) {

    //Initializes firefighters arraylist with default location FireStation
    for (int i = 0; i < numFirefighters; i++){
      firefighters.add(new FirefighterImpl(this.city.getFireStation().getLocation()));
    }
  }

  @Override
  public List<Firefighter> getFirefighters() {
    return firefighters;
  }

  @Override
  public void dispatchFirefighers(CityNode... burningBuildings) {

    if (firefighters.size() != 0) {

      for (CityNode cityNode : burningBuildings) {

        int distance = Integer.MAX_VALUE;
        Firefighter fighter = null;

        //Find the closest firefighter
        for (Firefighter f : firefighters) {
          // Calculate distance using taxicab geometry
          int d = Math.abs(f.getLocation().getX() - cityNode.getX()) + Math.abs(f.getLocation().getY() - cityNode.getY());

          if (distance > d) {
            distance = d;
            fighter = f;
          }
        }

        //Set distance traveled and location for firefighter
        fighter.setDistanceTraveled(fighter.distanceTraveled() + distance);
        fighter.setLocation(cityNode);

        // Extinguish fire
        try {
          this.city.getBuilding(cityNode).extinguishFire();
        } catch (NoFireFoundException e) {
          System.out.println("No fire found at location " + cityNode.getX() + "," + cityNode.getY());
        }

      }
    }
  }
}
