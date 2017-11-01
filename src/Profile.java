import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Profile extends FacebukObject {

	private ArrayList<Profile> fFriends;
	private ArrayList<Moment> fMoments;

	/**
	 * Creates an instance of a Profile, with the given name and image.
	 * 
	 * @param name
	 *            the name of the profile.
	 * @param image
	 *            the picture associated with the profile.
	 */
	public Profile(String name, Image image) {
		super(name, image);
		fFriends = new ArrayList<Profile>();
		fMoments = new ArrayList<Moment>();
	}

	/**
	 * Sets a Profile object's fFriends arraylist to be equal to the given
	 * arraylist.
	 * 
	 * @param friends
	 *            the arraylist to set fFriends equal to.
	 */
	public void setFriends(ArrayList friends) {
		fFriends = friends;
	}

	/**
	 * Sets a Profile objects fMoments arraylist to be equal to the given
	 * arraylist.
	 * 
	 * @param moments
	 *            the arraylist to set fMoments equal to.
	 */
	public void setMoments(ArrayList moments) {
		fMoments = moments;
	}

	/**
	 * Gets a Profile object's fMoments.
	 * 
	 * @return fMoments, the arraylist of moments associated with a profile.
	 */
	public ArrayList<Moment> getMoments() {
		return fMoments;
	}

	/**
	 * Gets a Profile object's fFriends.
	 * 
	 * @return fFriends, the arraylist of friends associated with a profile.
	 */
	public ArrayList<Profile> getFriends() {
		return fFriends;
	}

	/**
	 * Loops through the moments a Profile object shares with other Profile
	 * objects, a calculates the average happiness value they have with each
	 * friend in their friend list. The method then returns the friend with whom
	 * they are happiest.
	 * 
	 * @return The Profile object with which the object has the highest average
	 *         happiness.
	 */
	public Profile getFriendWithWhomIAmHappiest() {
		Profile bestFriend = null;
		if (!fFriends.isEmpty()) {
			bestFriend = fFriends.get(0);
			float highestAverage = -1f;
			float counterZero = 0f;
			for (int j = 0; j < fMoments.size(); j++) {
				if (fMoments.get(j).fParticipants.contains(bestFriend)) {
					highestAverage += fMoments.get(j).fSmileValues
							.get(fMoments.get(j).fParticipants.indexOf(bestFriend));
				}
				counterZero++;
			}

			highestAverage = highestAverage / counterZero;

			for (int i = 0; i < fFriends.size(); i++) {
				Profile aFriend = fFriends.get(i);
				float counter = 0f;
				float averageHappiness = 0f;
				for (int j = 0; j < fMoments.size(); j++) {
					if (fMoments.get(j).fParticipants.contains(aFriend)) {
						averageHappiness += fMoments.get(j).fSmileValues
								.get(fMoments.get(j).fParticipants.indexOf(aFriend));
					}
					counter++;
				}

				averageHappiness = averageHappiness / counter;

				if (averageHappiness > highestAverage) {
					highestAverage = averageHappiness;
					bestFriend = fFriends.get(i);
				}
			}
		}
		return bestFriend;
	}

	/**
	 * Loops through a profile's moments, and returns the one with the highest
	 * average happiness between all participants.
	 * 
	 * @return The happiest moment stored in the profile.
	 */
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

	/**
	 * Finds the maximum clique of friends that a given person/pet belongs to.
	 * 
	 * @return an arraylist of profiles that forms a clique.
	 */
	public ArrayList<Profile> findMaximumCliqueOfFriends() {

		ArrayList<ArrayList<Profile>> array = new ArrayList<ArrayList<Profile>>();
		
		int n = fFriends.size();
		// inspired by http://www.geeksforgeeks.org/finding-all-subsets-of-a-given-set-in-java/
		for (int i = 0; i < (1 << n); i++) {
			array.add(new ArrayList<Profile>());
			for (int j = 0; j < n; j++)

				if ((i & (1 << j)) > 0) {
                    array.get(i).add(fFriends.get(j));
				}
		}
		for (int i = array.size() - 1; i >= 0; i--) {
			if (!isClique(array.get(i))) {
				array.remove(i);
			}
		}

		ArrayList<Profile> answer = new ArrayList<Profile>();
		for (int i = 0; i < array.size(); i++) {
			if (array.get(i).size() > answer.size()) {
				answer = array.get(i);
			}
		}

		return answer;
	}

	/**
	 * Determines if the given list of profiles form a clique (where all
	 * profiles are friends with each other), by sorting and comparing the given
	 * arraylist.
	 * 
	 * @param set
	 *            a list of people who may form a click.
	 * @return true if the given arraylist is a clique, false if it is not.
	 */
	public boolean isClique(ArrayList<Profile> set) {
		for (int i = 0; i < set.size(); i++) {
			if (fFriends.contains(set.get(i))) {
				for (int j = 0; j < set.size(); j++) {
					if (fFriends.get(j).getFriends().contains(set.get(i))) {
						// do nothing
					} else {
						return false;
					}
				}
			} else {
				return false;
			}
		}
		return true;

	}
}
