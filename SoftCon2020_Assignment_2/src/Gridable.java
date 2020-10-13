import boats.Ship;

/**
 * Simple interface for building a Grid for 2D Battleships.
 * @version 1.0
 */

public interface Gridable {

    /**
     * Method relying on a single call for building an empty grid.
     * @return void
     */

    void buildGrid();

    /**
     * Method relying on a single call for printing a populated grid.
     * @return void
     */

    void printGrid();

    /**
     * Method enabling ship object placement on a grid object.
     * @param ship Ship object to place
     * @param start String start represents first coordinate
     * @param end String end represents end coordinate
     * @return void
     */

    void Insert(Ship ship, String start, String end);

}
