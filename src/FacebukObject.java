public class FacebukObject {

    private String fName;
    private Image fImage;

    public FacebukObject(String name, Image image) {
        fName = name;
        fImage = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
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
