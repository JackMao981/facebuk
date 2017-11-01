public class Pet extends Profile {

    private Person fOwner;

    /**
     * Creates an instance of a Pet, with the given name and image.
     * @param name the pet's name.
     * @param image the picture associated with the pet.
     */
    public Pet(String name, Image image) {
        super(name, image);
    }

    /**
     * Sets a pet's owner to the given Person object.
     * @param owner the Person object that owns the pet.
     */
    public void setOwner(Person owner) {
        fOwner = owner;
    }

}
