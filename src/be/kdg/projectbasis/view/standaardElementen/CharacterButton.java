package be.kdg.projectbasis.view.standaardElementen;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import javax.swing.*;

import static javax.swing.SwingConstants.CENTER;

public class CharacterButton extends Button {
    public CharacterButton(String s){
        super(s);
        //set font
        setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
        setFont(new Font("Arial Black", 14));
    }
}
