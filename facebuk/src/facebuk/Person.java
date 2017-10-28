package facebuk;

import java.util.ArrayList;

public class Person {
	private String personName;
	private Image personImage;

	public Person(String person, Image image) {
		personName = person;
		personImage = image;
	}

	public void setFriends(ArrayList friends) {

	}

	public void setMoments() {

	}

	public ArrayList getFriends() {

		return null;
	}

	public void setPossessions() {

	}

	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else {
			return false;
		}
	}

}
