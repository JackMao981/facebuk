public class Pet extends Profile {

    private Person fowner;

    public Pet(String name, Image image) {
        super(name, image);
    }

    public void setOwner(Person owner) {
        fowner = owner;
    }

}
