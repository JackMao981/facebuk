public class Possession extends FacebukObject{

    private Person fOwner;
    private float fPrice;

    public Possession(String name, Image image, float price) {
        super(name, image);
        fPrice = price;
    }

    public void setOwner(Person owner) {
        fOwner = owner;
    }
}
