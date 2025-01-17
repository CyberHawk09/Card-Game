public class Card {
    private String name;
    private String image;
    
    public Card(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }
    public String getImage() {
       return image;
    }
    public void setName(String name) {
        this.name = name;
    }
}
