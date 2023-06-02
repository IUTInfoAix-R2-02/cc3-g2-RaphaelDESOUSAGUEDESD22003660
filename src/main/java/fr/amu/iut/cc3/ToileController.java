package fr.amu.iut.cc3;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


public class ToileController implements Initializable {

    private static int rayonCercleExterieur = 200;
    private static int angleEnDegre = 60;
    private static int angleDepart = 90;
    private static int noteMaximale = 20;

    @FXML
    Button traceButton;

    @FXML
    TextField Compt1;
    @FXML
    TextField Compt2;
    @FXML
    TextField Compt3;
    @FXML
    TextField Compt4;
    @FXML
    TextField Compt5;
    @FXML
    TextField Compt6;
    @FXML
    Button videButton;
    @FXML
    Pane scene;
    @FXML
    Label error1;

    @FXML
    Label error2;

    private List<Circle> pointsList;
    private List<Line> linesList;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        pointsList = new ArrayList<>();
        linesList = new ArrayList<>();
    }
    int getXRadarChart(double value, int axe ){
        return (int) (rayonCercleExterieur + Math.cos(Math.toRadians(angleDepart - (axe-1)  * angleEnDegre)) * rayonCercleExterieur
                *  (value / noteMaximale));
    }

    int getYRadarChart(double value, int axe ){
        return (int) (rayonCercleExterieur - Math.sin(Math.toRadians(angleDepart - (axe-1)  * angleEnDegre)) * rayonCercleExterieur
                *  (value / noteMaximale));
    }

    @FXML
    private void traceClicked() {
        traceButton.addEventHandler(MouseEvent.MOUSE_CLICKED, actionEvent -> {
            String comp1 = Compt1.getText();
            int saisie = Integer.parseInt(Compt1.getText());
            Dessiner(saisie, 25);
            Circle point1 = Dessiner(saisie, 1);
            pointsList.add(point1);

            String comp2 = Compt2.getText();
            int saisie2 = Integer.parseInt(Compt2.getText());
            Dessiner(saisie2, 200);
            Circle point2 = Dessiner(saisie2, 2);
            pointsList.add(point2);

            String comp3 = Compt3.getText();
            int saisie3 = Integer.parseInt(Compt3.getText());
            Dessiner(saisie3, 225);
            Circle point3 = Dessiner(saisie3, 3);
            pointsList.add(point3);

            String comp4 = Compt4.getText();
            int saisie4 = Integer.parseInt(Compt4.getText());
            Dessiner(saisie4, 250);
            Circle point4 = Dessiner(saisie4, 4);
            pointsList.add(point4);

            String comp5 = Compt5.getText();
            int saisie5 = Integer.parseInt(Compt5.getText());
            Dessiner(saisie5,125 );
            Circle point5 = Dessiner(saisie5, 5);
            pointsList.add(point5);

            String comp6 = Compt6.getText();
            int saisie6 = Integer.parseInt(Compt6.getText());
            Dessiner(saisie6, 150);
            Circle point6 = Dessiner(saisie6, 6);
            pointsList.add(point6);

            Compt1.clear();
            Compt2.clear();
            Compt3.clear();
            Compt4.clear();
            Compt5.clear();
            Compt6.clear();

        });
    }


    @FXML
    private void videClicked(){
        Compt1.clear();
        Compt2.clear();
        Compt3.clear();
        Compt4.clear();
        Compt5.clear();
        Compt6.clear();

        scene.getChildren().removeAll(pointsList);
        scene.getChildren().removeAll(linesList);
        pointsList.clear();
        linesList.clear();

    }

    private Circle Dessiner(double value, int axis) {
        error1.setVisible(true);
        error2.setVisible(true);
        double x = getXRadarChart(value, axis);
        double y = getYRadarChart(value, axis);

        Circle circle = new Circle(x, y, 5);
        circle.setCenterX(x);
        circle.setCenterY(y);
        circle.setRadius(8);

        scene.getChildren().add(circle);
        return circle;
    }



    }

