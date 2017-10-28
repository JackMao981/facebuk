package facebuk;


public class Possession {
	private String possessionName;
	private Image possessionImage;
	private float possessionPrice;
	
	public Possession(String name, Image image, float price){
		possessionName = name;
		possessionImage = image;
		possessionPrice = price;
	}
	
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		} else {
			return false;
		}
	}

	
}
