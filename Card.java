public class Card {
    private String position;
    private String name;
    private String image;
    public Card(String position, String name, String image) {
        this.position = position;
        this.name = name;
        this.image = image;
    }

    public String getPosition() {
        return position;
    }
    public String getName() {
        return name;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public void setName(String name) {
        this.name = name;
    }
}
