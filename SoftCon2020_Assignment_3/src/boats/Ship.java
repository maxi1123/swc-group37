package boats;

import java.util.ArrayList;

/**
 * Simple interface for building a Ship for 2D Battleships.
 * @version 1.0
 */

public interface Ship {

    /**
     * A simple getter method.
     * @return String fullname of the ship object.
     */

    String getName();

    /**
     * A simple getter method.
     * @return int size of the ship object.
     * Describes how many field a ship object occupies on a grid.
     */

    int getSize();

    /**
     * A simple getter method.
     * @return char type of the ship object.
     * type stands for the shortname of a ship object, which is used for representation on the printed grid.
     */

    char getType();

    void updateCoordlist(int c1_one, int c1_two);

    int getCoordlength();

    ArrayList<String> getCoordlist();

    void replaceCoordlist(ArrayList<String> coordlist);
}
