/**
 * An object to hold the name and image information of any card processed in the Card-Game project.
 */
public class Card {
    /**
     * The name of this Card.
     */
    private String name;

    /**
     * Constructs a Card object with the specified name and image.
     * @param name the name which will be set for the Card
     */
    public Card(String name) {
        this.name = name;
    }

    /**
     * Returns the name of this Card.
     * @return the name of this Card
     */
    public String getName() {
        return name;
    }
}
