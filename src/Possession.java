public class Possession extends FacebukObject{

    private Person fowner;
    private float fprice;

    public Possession(String name, Image image, float price) {
        super(name, image);
        fprice = price;
    }

    public void setOwner(Person owner) {
        fowner = owner;
    }
}
