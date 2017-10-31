import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

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

	public Profile getFriendWithWhomIAmHappiest() {
		Profile bestFriend = null;
		if (fFriends != null) {
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

		final ArrayList<Profile> sortedFriends = fFriends;
		sortedFriends.sort(new Comparator<Profile>() {
			@Override
			public int compare(Profile p1, Profile p2) {
				return p1.getName().compareTo(p2.getName());
			}
		});

		for (int i = 0; i < sortedFriends.size(); i++) {
			//make sure this is actually final
			final ArrayList<Profile> friendsOfFriend = sortedFriends.get(i).getFriends();

			if (sortedFriends.equals(friendsOfFriend.set(friendsOfFriend.indexOf(friendsOfFriend.get(i)), this))) {
				return true;
			} else {
				return false;
			}

		}
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
		// should never reach this aka this is probs iffy code
		return aggregate;
	}

}
