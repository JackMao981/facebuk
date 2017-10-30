public class Pet extends Profile {

    private Person fOwner;

    public Pet(String name, Image image) {
        super(name, image);
    }

    public void setOwner(Person owner) {
        fOwner = owner;
    }

}
