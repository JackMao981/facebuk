import java.util.ArrayList;

public class Moment extends FacebukObject {

    ArrayList<Profile> fparticipants;
    ArrayList fsmileValues;

    public Moment(String name, Image image, ArrayList participants, ArrayList smileValues) {
        super(name, image);
        fparticipants = participants;
        fsmileValues = smileValues;
    }


}
