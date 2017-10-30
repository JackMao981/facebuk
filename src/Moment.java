import java.util.ArrayList;

public class Moment extends FacebukObject {

    ArrayList<Profile> fParticipants;
    ArrayList<Float> fSmileValues;

    public Moment(String name, Image image, ArrayList participants, ArrayList smileValues) {
        super(name, image);
        fParticipants = participants;
        fSmileValues = smileValues;
    }

    public Float averageHappiness() {
        float avg = 0f;
        for (int i = 0; i < fSmileValues.size(); i++) {
            avg += fSmileValues.get(i);
        }
        avg = avg / fSmileValues.size();
        return avg;
    }

}
