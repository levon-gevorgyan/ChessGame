package ui.window.main;

import javafx.beans.NamedArg;
import javafx.scene.image.Image;

/**
 * Created by Levon on 1/26/2016, 11:48 PM
 */
public class MyImage extends Image {
    private String url;
    public MyImage(@NamedArg("url") String url) {
        super(url);
        this.url=url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String toString(){
        return this.url;

    }
}
