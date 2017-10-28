package facebuk;

import java.util.ArrayList;

public class Pet {
	private String petName;
	private Image petImage;

	public Pet(String name, Image image) {
		petName = name;
		petImage = image;
	}
	public void setFriends() {

	}

	public void setMoments() {

	}
	
	public ArrayList getFriends(){
		
		return null;
	}
	
	public void setOwner(){
		
	}
	
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else {
			return false;
		}
	}

}
