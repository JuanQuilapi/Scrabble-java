package cl.uchile.dcc.scrabble.gui;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * Main entry point for the application.
 *
 * <p><Complete here with the details of the implemented application>
 *
 * @author Ignacio Slater Muñoz.
 * @author <Juan Ignacio Quilapi Jordan>
 */
public class Scrabble extends Application {

  private static final String RESOURCE_PATH = "src/main/resources/";
  private static final HBox arbol1 = new HBox();
  private static final HBox text1 = new HBox();
  private static final HBox[] arbol2 = {new HBox(), new HBox()};
  private static final HBox text2 = new HBox();
  private static final HBox[] arbol3 = {new HBox(), new HBox(), new HBox(), new HBox()};
  private static final ArrayList<Integer> hijosBan3 = new ArrayList<>();
  private static final ArrayList<Integer> hijosBan4 = new ArrayList<>();
  private static final HBox text3 = new HBox();
  private static final HBox[] arbol4 = {
    new HBox(), new HBox(), new HBox(), new HBox(), new HBox(), new HBox(), new HBox(), new HBox()
  };
  private static final HBox text4 = new HBox();
  private static final HBox hb1 = new HBox();
  private static final HBox hb2 = new HBox();
  private static final HBox hb3 = new HBox();
  private static int cont = 0;
  private static int cont2 = 0;
  private static int cont3 = 0;
  private static int cont4 = 0;
  private static final ChoiceBox<Object> cb = new ChoiceBox<>();
  private static final ChoiceBox<Object> cb2 = new ChoiceBox<>();
  private static final ChoiceBox<Object> cb3 = new ChoiceBox<>();
  private static final ChoiceBox<Object> cb4 = new ChoiceBox<>();
  private static final TextField textField = new TextField();

  private static final Button b1 = new Button("Seleccione operacion");
  private static final Button b2 = new Button("Seleccione Tipo");

  @Override
  public void start(@NotNull Stage stage) throws FileNotFoundException {
    stage.setTitle("Scratch Uchile");
    var root = new Group();
    int width = 1400;
    int height = 900;
    // arbol config
    arbol1.setLayoutX(300);
    arbol1.setLayoutY(10);
    text1.setLayoutX(300);
    text1.setLayoutY(10);

    arbol2[0].setLayoutX(200);
    arbol2[0].setLayoutY(140);
    arbol2[1].setLayoutX(600);
    arbol2[1].setLayoutY(140);

    text2.setLayoutX(350);
    text2.setLayoutY(150);
    for (int j = 0; j < 4; j++) {
      arbol3[j].setLayoutX(100 + ((j) * 200));
      arbol3[j].setLayoutY(210);
    }
    text3.setLayoutX(100);
    text3.setLayoutY(200);
    for (int k = 0; k < 8; k++) {
      arbol4[k].setLayoutX(90);
      arbol4[k].setLayoutY(320);
    }
    text4.setLayoutX(115);
    text4.setLayoutY(340);
    // choiceBoxes config
    cb2.setItems(
        FXCollections.observableArrayList(
            "Agregar Constante", "Agregar Operacion Binaria", "Agregar operacion Unitaria"));
    cb.setItems(
        FXCollections.observableArrayList(
            "Add", "Sub", "Mult", "Div", new Separator(), "And", "Or", new Separator(), "Const"));
    cb3.setItems(
        FXCollections.observableArrayList(
            "Neg", new Separator(), "ToBin", "ToBool", "ToFlt", "ToInt", "ToStr"));
    cb4.setItems(
        FXCollections.observableArrayList("Booleano", "Decimal", "Entero", "Binario", "String"));

    hb1.setVisible(false);
    hb2.setVisible(false);
    hb3.setVisible(false);
    Scene scene = new Scene(root, width, height);

    var background = new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "Fondo.png")));
    root.getChildren().add(background);
    root.getChildren().add(setupTextField());
    root.getChildren().add(setupCBox3());
    root.getChildren().add(setupCBox2());
    root.getChildren().add(setupCBox());
    root.getChildren().add(resetButton());
    root.getChildren().add(arbol1);
    for (int i = 0; i < 2; i++) {
      root.getChildren().add(arbol2[i]);
    }
    for (int j = 0; j < 4; j++) {
      root.getChildren().add(arbol3[j]);
    }
    for (int k = 0; k < 8; k++) {
      root.getChildren().add(arbol4[k]);
    }
    root.getChildren().addAll(text1, text2, text3, text4);
    stage.setScene(scene);
    stage.show();
  }

  private @NotNull HBox setupTextField() {
    var button = new Button("Agregue Constante");
    hb3.getChildren().addAll(textField, button);
    hb3.setSpacing(10);
    hb3.setLayoutX(1100);
    hb3.setLayoutY(400);
    button.setOnAction(Scrabble::creandoC);
    return hb3;
  }

  private @NotNull HBox setupCBox2() {
    HBox hb = new HBox();
    var button = new Button("Agregar Nodo");
    hb.getChildren().addAll(cb2, button);
    hb.setLayoutX(1100);
    hb.setLayoutY(350);
    button.setOnAction(Scrabble::selecc);
    return hb;
  }

  private static void selecc(ActionEvent event) {
    var tipo = cb2.getValue().toString();
    try {
      if (tipo.equals("Agregar Operacion Binaria")) {
        hb1.setVisible(true);
      }
      if (tipo.equals("Agregar Constante")) {
        hb2.setVisible(true);
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private @NotNull HBox setupCBox() {
    hb1.getChildren().addAll(cb, b1);
    hb1.setLayoutX(1150);
    hb1.setLayoutY(400);
    b1.setOnAction(Scrabble::creandoA);
    return hb1;
  }

  private @NotNull HBox setupCBox3() {
    hb2.getChildren().addAll(cb4, b2);
    hb2.setLayoutX(1150);
    hb2.setLayoutY(400);
    b2.setOnAction(Scrabble::field);
    return hb2;
  }

  private static void field(ActionEvent event) {
    hb2.setVisible(false);
    try {
      hb3.setVisible(true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private @NotNull Button resetButton() {
    var button = new Button("Reiniciar arbol");
    button.setLayoutX(1150);
    button.setLayoutY(700);
    button.setOnAction(Scrabble::reset);
    return button;
  }

  private static void reset(ActionEvent event) {
    try {
      arbol1.getChildren().clear();
      text1.getChildren().clear();
      for (int i = 0; i < 2; i++) {
        arbol2[i].getChildren().clear();
      }
      text2.getChildren().clear();
      for (int j = 0; j < 4; j++) {
        arbol3[j].getChildren().clear();
      }
      text3.getChildren().clear();
      for (int k = 0; k < 8; k++) {
        arbol4[k].getChildren().clear();
      }
      text4.getChildren().clear();
      cont = 0;
      cont2 = 0;
      cont3 = 4;
      cont4 = 0;
      hijosBan3.clear();
      hijosBan4.clear();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static HBox creandoNodos(String s) throws FileNotFoundException {
    var arbol1 = new ImageView(new Image(new FileInputStream(RESOURCE_PATH + s)));
    HBox hb = new HBox();
    hb.getChildren().add(arbol1);
    return hb;
  }

  private static void creandoA(ActionEvent event) {
    var tipo = cb.getValue().toString();
    var label = new Label(tipo);
    try {
      if (cont3 < 4 && cont2 >= 2 && cont >= 1) {
        var rama3 = creandoNodos("prueba2.png");
        while (hijosBan3.toString().contains(String.valueOf(cont3)) && cont3 < 3) {
          cont3++;
        }
        arbol3[cont3].getChildren().add(rama3);
        cont3++;
      }
      if (cont2 < 2 && cont >= 1) {
        var rama2 = creandoNodos("doble1.png");
        arbol2[cont2].getChildren().add(rama2);
        text2.getChildren().add(label);
        text2.setSpacing(200);
        cont2++;
      }
      if (cont < 1) {
        var rama = creandoNodos("copa.png");
        arbol1.getChildren().add(rama);
        text1.getChildren().add(label);
        cont++;
      }
      hb1.setVisible(false);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  private static void creandoC(ActionEvent event) {
    var tipo = textField.getCharacters().toString();
    var label = new Label(tipo);
    try {
      if (cont4 < 8 && cont3 >= 4 && cont2 >= 2 && cont >= 1) {
        var rama4 = creandoNodos("constant.png");
        while (hijosBan4.toString().contains(String.valueOf(cont4)) && cont4 < 7) {
          cont4++;
        }
        arbol4[cont4].getChildren().add(rama4);
        text4.getChildren().add(label);
        cont4++;
      }
      if (cont3 < 4 && cont2 >= 2 && cont >= 1) {
        var rama3 = creandoNodos("Const3.png");
        while (hijosBan3.toString().contains(String.valueOf(cont3)) && cont3 < 3) {
          cont3++;
        }
        arbol3[cont3].getChildren().add(rama3);
        hijosBan4.add(cont3 * 2);
        hijosBan4.add(cont3 * 2 + 1);
        cont3++;
      }
      if (cont2 < 2 && cont >= 1) {
        var rama2 = creandoNodos("Const2.png");
        arbol2[cont2].getChildren().add(rama2);
        text2.getChildren().add(label);
        text2.setSpacing(200);
        if (cont2 == 0) {
          hijosBan3.add(0);
          hijosBan3.add(1);
        } else {
          hijosBan3.add(2);
          hijosBan3.add(3);
        }
        cont2++;
      }
      if (cont < 1) {
        var rama = creandoNodos("copaConst.png");
        arbol1.getChildren().add(rama);
        text1.getChildren().add(label);
        cont++;
        cont2 = 2;
        cont3 = 4;
        cont4 = 8;
      }
      hb3.setVisible(false);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }
}
