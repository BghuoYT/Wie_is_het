package be.kdg.projectbasis.view.standaardElementen;

import javafx.scene.control.Label;
import javafx.scene.text.Font;

public class StyleButton extends Label {
    public StyleButton(String s){
        super(s);
        this.setFont(new Font("Arial", 14));
    }
}
