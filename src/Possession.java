public class Possession extends FacebukObject{

    private Person fOwner;
    private float fPrice;

    /**
     * Creates an instance of a Possesion with the given name, image, and price.
     * @param name the name of the possesion.
     * @param image the picture associated with the possesion.
     * @param price the possesion's price.
     */
    public Possession(String name, Image image, float price) {
        super(name, image);
        fPrice = price;
    }

    /**
     * Sets a possession's owner to the given Person object.
     * @param owner the Person object that owns the possession.
     */
    public void setOwner(Person owner) {
        fOwner = owner;
    }
}
