public class FacebukObject {

    private String fName;
    private Image fImage;

    public FacebukObject(String name, Image image) {
        fName = name;
        fImage = image;
    }

    public boolean equals(Object o) {
    	FacebukObject f = (FacebukObject) o;
        if (this.fName.equals(f.getName())) {
            return true;
        } else {
            return false;
        }
    }

    public String getName(){
        return fName;
    }

    public Image getImage(){
        return fImage;
    }


}
