import java.util.ArrayList;

public class Profile extends FacebukObject {

    private ArrayList<Profile> ffriends;
    private ArrayList<Moment> fmoments;

    public Profile(String name, Image image) {
        super(name, image);
    }

    public void setFriends(ArrayList friends) {
        //does this add to the existing arraylist or replace it?
        ffriends = friends;
    }

    public void setMoments(ArrayList moments) {
        //same question as above
        fmoments = moments;
    }

    public ArrayList getFriends() {
        return ffriends;
    }

}
