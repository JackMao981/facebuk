public class FacebukObject {

    private String fname;
    private Image fimage;

    public FacebukObject(String name, Image image) {
        fname = name;
        fimage = image;
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
        return fname;
    }

    public Image getImage(){
        return fimage;
    }


}
