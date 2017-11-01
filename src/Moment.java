import java.util.ArrayList;

public class Moment extends FacebukObject {

    ArrayList<Profile> fParticipants;
    ArrayList<Float> fSmileValues;

    /**
     *  Creates an instance of a Moment.
     * @param name the name of the moment.
     * @param image the picture associated with the moment.
     * @param participants an arraylist of Profile objects that participated in the moment.
     * @param smileValues an arraylist of floats that represents the happiness of the participants in the moment.
     */
    public Moment(String name, Image image, ArrayList participants, ArrayList smileValues) {
        super(name, image);
        fParticipants = participants;
        fSmileValues = smileValues;
    }

    /**
     * Loops through fSmileValues, sums up all of the smile values within the list,
     * and then divides by the size of the list to produce the average happiness.
     * @return The average happiness of fSmileValues.
     */
    public Float averageHappiness() {
        float avg = 0f;
        for (int i = 0; i < fSmileValues.size(); i++) {
            avg += fSmileValues.get(i);
        }
        avg = avg / fSmileValues.size();
        return avg;
    }

}
