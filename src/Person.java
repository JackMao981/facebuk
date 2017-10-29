import java.util.ArrayList;

public class Person extends Profile {

    private ArrayList<Possession> fpossessions;
    private ArrayList<Pet> fpets;

    public Person(String name, Image image) {
        super(name, image);
    }

    public void setPossessions(ArrayList possessions){
        //once again, does it add to the existing ArrayList or replace it?
        fpossessions = possessions;
    }

    public void setPets(ArrayList pets){
        //once again, does it add to the existing ArrayList or replace it?
        fpets = pets;
    }

}


