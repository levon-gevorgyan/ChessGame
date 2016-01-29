package gui.test.t_28;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by Levon on 28.01.2016.
 */
public class Person {


    private StringProperty firstName=new SimpleStringProperty(this,"firstName","");

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public String getFirstName() {
        return firstName.get();
    }



    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }
}
