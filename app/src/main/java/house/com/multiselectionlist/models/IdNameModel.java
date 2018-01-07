package house.com.multiselectionlist.models;

/**
 * Created by welcome on 1/7/2018.
 */

public class IdNameModel {
    int id;
    String name;
    boolean isChecked;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
