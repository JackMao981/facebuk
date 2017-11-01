public class FacebukObject {

    private String fName;
    private Image fImage;

    /**
     *  Creates an instance of an FacebukObject, with the provided name and image.
     * @param name the name of the FacebukObject.
     * @param image the image associated with the FacebukObject.
     */
    public FacebukObject(String name, Image image) {
        fName = name;
        fImage = image;
    }

    /**
     * This function takes in an object, and returns true if it matches the name of the
     * FacebukObject it is called on.
     * @param o
     * @return True if the objects have the same name, false if they do not.
     */
    public boolean equals(Object o) {
    	FacebukObject f = (FacebukObject) o;
        if (this.fName.equals(f.getName())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Gets the name of aFacebukObject.
     * @return A FacebukObject's name.
     */
    public String getName(){
        return fName;
    }

    /**
     * Gets the image of a FacebukObject.
     * @return A FacebukObject's image.
     */
    public Image getImage(){
        return fImage;
    }


}
