package main.api;

public interface Firefighter {

  /**
   * Sets the firefighter current location
   * @param cityNode representing the firefighter location
   */
  void setLocation(CityNode cityNode);

  /**
   * Get the firefighter's current location. Initially, the firefighter should be at the FireStation
   *
   * @return {@link CityNode} representing the firefighter's current location
   */
  CityNode getLocation();

  /**
   * Sets the distance traveled by the firefighter
   * @param distanceTraveled representing distance traveled
   */
  void setDistanceTraveled(int distanceTraveled);

  /**
   * Get the total distance traveled by this firefighter. Distances should be represented using TaxiCab
   * Geometry: https://en.wikipedia.org/wiki/Taxicab_geometry
   *
   * @return the total distance traveled by this firefighter
   */
  int distanceTraveled();
}
