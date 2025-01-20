/**
 * An object to hold the name and image information of any card processed in the Card-Game project.
 */
public class Card {
    /**
     * The name of this Card.
     */
    private String name;
    /**
     * The directory of the image to be used for this Card.
     */
    private String image;

    /**
     * Constructs a Card object with the specified name and image.
     * @param name the name which will be set for the Card
     * @param image the image directory which will be set for the Card
     */
    public Card(String name, String image) {
        this.name = name;
        this.image = image;
    }

    /**
     * Returns the name of this Card.
     * @return the name of this Card
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the directory of the image of this Card.
     * @return the directory of the image of this Card
     */
    public String getImage() {
       return image;
    }
}
