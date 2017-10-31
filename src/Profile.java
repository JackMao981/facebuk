import java.util.ArrayList;
import java.util.Arrays;

public class Profile extends FacebukObject {

	private ArrayList<Profile> fFriends;
	private ArrayList<Moment> fMoments;

	public Profile(String name, Image image) {
		super(name, image);
		fFriends = null;
		fMoments = null;
	}

	public void setFriends(ArrayList friends) {
		// does this add to the existing arraylist or replace it?
		fFriends = friends;
	}

	public void setMoments(ArrayList moments) {
		// same question as above
		fMoments = moments;
	}

	public ArrayList<Moment> getMoments() {
		return fMoments;
	}

	public ArrayList<Profile> getFriends() {
		return fFriends;
	}
//!!!!!!!!!!!!!!!!!!!! THIS IS WRONG !!!!!!!!!!!!!!!!!!!
	public Profile getFriendWithWhomIAmHappiest() {
		Profile bestFriend = null;

		// Looks to see if fFriends is not null
		if (fFriends != null) {

			// sets BFF to be first element
			bestFriend = fFriends.get(0);
			float oldAverage = 0f;

			// sets oldAverage to be that of the first element
			for (int i = 0; i < bestFriend.getMoments().size(); i++) {
				oldAverage += (float) bestFriend.getMoments().get(i).averageHappiness()
						/ bestFriend.getMoments().size();
			}

			// looks for the happiest friend
			for (int i = 0; i < fFriends.size(); i++) {
				Profile friend = fFriends.get(i);

				float newAverage = 0f;

				// looks through the moments to find the newAverage
				for (int j = 0; j < friend.getMoments().size(); j++) {
					newAverage += (float) friend.getMoments().get(j).averageHappiness() / friend.getMoments().size();
				}

				// checks if newAverage is bigger than oldAverage
				if (newAverage > oldAverage) {
					oldAverage = newAverage;
					bestFriend = friend;
				}
			}
		}
		return bestFriend;
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

	public ArrayList<Profile> findMaximumCliqueOfFriends() {
		if (this.isClique(fFriends)) {
			return fFriends;
		} else {
			return recursiveHelper(new ArrayList<ArrayList<Profile>>(Arrays.asList(fFriends)));
		}
	}

	public boolean isClique(ArrayList set) {
		return true;
	}

	private ArrayList<Profile> recursiveHelper(ArrayList<ArrayList<Profile>> set) {
		ArrayList aggregate = new ArrayList<ArrayList<Profile>>();

		for (int i = 0; i < set.size(); i++) {
			for (int j = 0; j < set.get(i).size(); j++) {
				if (this.isClique((ArrayList) set.get(i).subList(j, set.get(i).size()))) {
					return (ArrayList) set.get(i).subList(j, set.get(i).size());
				} else {
					aggregate.add(set.get(i).subList(j, set.get(i).size()));
				}
			}
		}

		recursiveHelper(aggregate);
		// should never reach this
		return aggregate;
	}

}
