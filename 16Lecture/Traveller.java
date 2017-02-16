public interface Traveller
{
    //Can include attributes if you want
    enum RouteType{WATER, AIR, RAIL, ROAD}

    //What behaviors do we need?
    RouteType getRouteType(); //Returns type of route being used

}
