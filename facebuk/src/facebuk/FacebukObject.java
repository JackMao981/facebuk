package facebuk;

import java.awt.Image;

public class FacebukObject {
	private String name;
	private Image image;

	public FacebukObject(Image image, String name) {
		this.name = name;
		this.image = image;
	}

	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else {
			return false;
		}
	}
	
	public String getName(){
		return this.name;
	}
	
	public Image getImage(){
		return this.image;
	}
}
