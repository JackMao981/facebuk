package facebuk;

import java.awt.Image;
import java.util.ArrayList;

public class Moment {
	private String momentName;
	private Image momentImage;
	private ArrayList momentParticipants;
	private ArrayList momentSmileValues;
	
	public Moment(String name, Image image, ArrayList participants, ArrayList smileValues){
		momentName = name;
		momentImage = image;
		momentParticipants = participants;
		momentSmileValues = smileValues;
	}
	
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else {
			return false;
		}
	}

}
