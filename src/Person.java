import java.util.ArrayList;

public class Person extends Profile {

    private ArrayList<Possession> fPossessions;
    private ArrayList<Pet> fPets;

    /**
     * Creates an instance of a Person, with the given name and image.
     * @param name the person's name.
     * @param image the picture associated with the person.
     */
    public Person(String name, Image image) {
        super(name, image);
    }

    /**
     * Sets the fPossesions arraylist of a person object to the provided arraylist.
     * @param possessions the arraylist to set a Person object's fPossesions to.
     */
    public void setPossessions(ArrayList possessions){
        fPossessions = possessions;
    }

    /**
     * Sets the fPets arraylist of a person object to the provided arraylist.
     * @param pets the arraylist to set a Person object's fPets to.
     */
    public void setPets(ArrayList pets){
        fPets = pets;
    }

}


