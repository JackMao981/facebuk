import java.util.ArrayList;

public class Person extends Profile {

    private ArrayList<Possession> fPossessions;
    private ArrayList<Pet> fPets;

    public Person(String name, Image image) {
        super(name, image);
    }

    public void setPossessions(ArrayList possessions){
        //once again, does it add to the existing ArrayList or replace it?
        fPossessions = possessions;
    }

    public void setPets(ArrayList pets){
        //once again, does it add to the existing ArrayList or replace it?
        fPets = pets;
    }

}


