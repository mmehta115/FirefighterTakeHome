package main.firefighters;

import main.api.CityNode;
import main.api.Firefighter;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class FirefighterImpl implements Firefighter {

  private CityNode cityNode;
  private int distanceTraveled;

  public FirefighterImpl(CityNode cityNode){
    this.cityNode = cityNode;
    this.distanceTraveled = 0;
  }

  @Override
  public void setLocation(CityNode cN){
    this.cityNode = cN;
  }

  @Override
  public CityNode getLocation() {
    return cityNode;
  }

  @Override
  public void setDistanceTraveled(int d){
    this.distanceTraveled = d;
  }

  @Override
  public int distanceTraveled() {
    return distanceTraveled;
  }
}
