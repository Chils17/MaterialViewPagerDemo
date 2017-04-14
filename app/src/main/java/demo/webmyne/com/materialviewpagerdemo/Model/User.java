package demo.webmyne.com.materialviewpagerdemo.Model;

/**
 * Created by vaibhavirana on 29-03-2017.
 */

public class User {
    private int image;
    private String name;
    private String descript;

    public User(int image, String name, String descript) {
        this.image = image;
        this.name = name;
        this.descript = descript;
    }

    public User() {

    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }
}
