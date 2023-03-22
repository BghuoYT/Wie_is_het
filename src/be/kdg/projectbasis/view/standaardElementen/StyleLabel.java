package be.kdg.projectbasis.view.standaardElementen;

import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class StyleLabel extends Label {
    public StyleLabel(String s){
        super(s);
        this.setFont(new Font("Arial Black", 24));

    }
}
