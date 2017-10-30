import java.util.ArrayList;

public class Profile extends FacebukObject {

    private ArrayList<Profile> fFriends;
    private ArrayList<Moment> fMoments;

    public Profile(String name, Image image) {
        super(name, image);
    }

    public void setFriends(ArrayList friends) {
        //does this add to the existing arraylist or replace it?
        fFriends = friends;
    }

    public void setMoments(ArrayList moments) {
        //same question as above
        fMoments = moments;
    }

    public ArrayList getFriends() {
        return fFriends;
    }

    public Profile getFriendWithWhomIAmHappiest() {
        return null;
    }

    public Moment getOverallHappiestMoment() {
        Moment happiestMoment = null;
        float avgHappiestMoment = 0f;
        for (int i = 0; i < fMoments.size(); i++) {
            if (fMoments.get(i).averageHappiness() > avgHappiestMoment) {
                avgHappiestMoment = fMoments.get(i).averageHappiness();
                happiestMoment = fMoments.get(i);
            }
        }
        return happiestMoment;
    }




}
