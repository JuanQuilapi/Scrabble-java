package cl.uchile.dcc.scrabble.gui;
import cl.uchile.dcc.scrabble.gui.Controller.astController;

import java.awt.Color;
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
  private static final HBox[] text2 = {new HBox(),new HBox()};
  private static final HBox[] arbol3 = {new HBox(), new HBox(), new HBox(), new HBox()};
  private static Integer[] hijosBan2 = {0,0};
  private static Integer[] hijosBan3 = {0,0,0,0};
  private static Integer[] hijosBan4 = {0,0,0,0,0,0,0,0};
  private static final HBox[] text3 = {new HBox(), new HBox(), new HBox(), new HBox()};
  private static final HBox[] arbol4 = {
    new HBox(), new HBox(), new HBox(), new HBox(), new HBox(), new HBox(), new HBox(), new HBox()
  };
  private static final HBox[] text4 = {
      new HBox(), new HBox(), new HBox(), new HBox(), new HBox(), new HBox(), new HBox(), new HBox()
  };
  private static final HBox hb1 = new HBox();
  private static final HBox hb2 = new HBox();
  private static final HBox hb3 = new HBox();
  private static final HBox hb4 = new HBox();
  private static final HBox hb5 = new HBox();
  private static final HBox hb6 = new HBox();
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
  private static final Button b3 = new Button("Seleccione operacion");

  @Override
  public void start(@NotNull Stage stage) throws FileNotFoundException {
    stage.setTitle("Scratch Uchile");
    var root = new Group();
    int width = 1400;
    int height = 900;
    // arbol config
    arbol1.setLayoutX(300);
    arbol1.setLayoutY(10);
    text1.setLayoutX(475);
    text1.setLayoutY(35);

    arbol2[0].setLayoutX(200);
    arbol2[0].setLayoutY(140);
    arbol2[1].setLayoutX(600);
    arbol2[1].setLayoutY(140);

    text2[0].setLayoutX(274);
    text2[0].setLayoutY(160);
    text2[1].setLayoutX(674);
    text2[1].setLayoutY(160);
    for (int j = 0; j < 4; j++) {
      arbol3[j].setLayoutX(100 + ((j) * 200));
      arbol3[j].setLayoutY(210);
      text3[j].setLayoutX(175 + ((j) * 200));
      text3[j].setLayoutY(260);
    }

    for (int k = 0; k < 8; k++) {
      if(k%2==0){
        arbol4[k].setLayoutX(100+ ((k) * 100));
        text4[k].setLayoutX(115+ ((k) * 100));
      }
      else{
        arbol4[k].setLayoutX(120+ ((k) * 100));
        text4[k].setLayoutX(135+ ((k) * 100));
      }
      arbol4[k].setLayoutY(340);
      text4[k].setLayoutY(360);
    }


    // choiceBoxes config
    cb2.setItems(
        FXCollections.observableArrayList(
            "Agregar Constante", "Agregar Operacion Binaria", "Agregar Operacion Unitaria"));
    cb.setItems(
        FXCollections.observableArrayList(
            "Add", "Sub", "Mult", "Div", new Separator(), "And", "Or"));
    cb3.setItems(
        FXCollections.observableArrayList(
            "Neg", new Separator(), "ToBin", "ToBool", "ToFloat", "ToInt", "ToStr"));
    cb4.setItems(
        FXCollections.observableArrayList("Booleano", "Decimal", "Entero", "Binario", "String"));

    hb1.setVisible(false);
    hb2.setVisible(false);
    hb3.setVisible(false);
    hb4.setVisible(true);
    hb5.setVisible(false);
    hb6.setVisible(false);
    Scene scene = new Scene(root, width, height);

    var background = new ImageView(new Image(new FileInputStream(RESOURCE_PATH + "Fondo.png")));
    root.getChildren().add(background);
    root.getChildren().add(setupTextField());
    root.getChildren().add(setupCBox3());
    root.getChildren().add(setupCBox4());
    root.getChildren().add(setupCBox2());
    root.getChildren().add(setupCBox());
    root.getChildren().add(resetButton());
    root.getChildren().add(resultButton());
    root.getChildren().add(hb6);
    root.getChildren().add(arbol1);
    for (int i = 0; i < 2; i++) {
      root.getChildren().addAll(arbol2[i],text2[i]);

    }
    for (int j = 0; j < 4; j++) {
      root.getChildren().addAll(arbol3[j],text3[j]);
    }
    for (int k = 0; k < 8; k++) {
      root.getChildren().addAll(arbol4[k],text4[k]);
    }
    root.getChildren().addAll(text1);
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
    var button = new Button("Agregar Nodo");
    hb4.getChildren().addAll(cb2, button);
    hb4.setLayoutX(1100);
    hb4.setLayoutY(350);
    button.setOnAction(Scrabble::selecc);
    return hb4;
  }

  private static void selecc(ActionEvent event) {
    hb4.setVisible(false);
    var tipo = cb2.getValue().toString();
    try {
      if (tipo.equals("Agregar Operacion Binaria")) {
        hb1.setVisible(true);
      }
      if (tipo.equals("Agregar Constante")) {
        hb2.setVisible(true);
      }
      if (tipo.equals("Agregar Operacion Unitaria")) {
        hb5.setVisible(true);
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

  private @NotNull HBox setupCBox4() {
    hb5.getChildren().addAll(cb3, b3);
    hb5.setLayoutX(1150);
    hb5.setLayoutY(400);
    b3.setOnAction(Scrabble::creandoS);
    return hb5;
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
        text2[i].getChildren().clear();
      }
      for (int j = 0; j < 4; j++) {
        arbol3[j].getChildren().clear();
        text3[j].getChildren().clear();
      }

      for (int k = 0; k < 8; k++) {
        arbol4[k].getChildren().clear();
        text4[k].getChildren().clear();
      }
      cont = 0;
      cont2 = 0;
      cont3 = 0;
      cont4 = 0;
      hijosBan3 = new Integer[]{0, 0, 0, 0};
      hijosBan4 = new Integer[]{0, 0, 0, 0, 0, 0, 0, 0};
      hijosBan2 = new Integer[]{0,0};
      astController.reset();
      hb6.setVisible(false);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private @NotNull Button resultButton() {
    var button = new Button("Obtener resultado");
    button.setLayoutX(1150);
    button.setLayoutY(500);
    button.setOnAction(Scrabble::result);
    return button;
  }

  private static void result(ActionEvent event) {
    var resultado = astController.getResultado().toString() ;
      Label res = new Label("Resultado= " + resultado);
    try{
      hb6.setLayoutX(300);
      hb6.setLayoutY(700);
      if (astController.getResultado() != null) {
        hb6.getChildren().add(res);
      }else{
        Label error = new Label("Error, el arbol esta mal armado, o se ingreso mal un valor");
      }
      hb6.setVisible(true);
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
    hb4.setVisible(true);
    var tipo = cb.getValue().toString();
    var label = new Label(tipo);
    try {
      if (cont3 < 4 && cont2 >= 2 && cont >= 1) {
        var rama3 = creandoNodos("prueba2.png");
        while (hijosBan3[cont3] == 1 && cont3 < 3){
          cont3++;
          astController.AddOpScr("Null");
        }
        if (hijosBan3[cont3] == 0) {
          arbol3[cont3].getChildren().add(rama3);
          text3[cont3].getChildren().add(label);
          astController.AddOpScr(tipo);
        }else{astController.AddOpScr("Null");}
        cont3++;
      }
      if (cont2 < 2 && cont >= 1) {
        var rama2 = creandoNodos("doble1.png");
        arbol2[cont2].getChildren().add(rama2);
        text2[cont2].getChildren().add(label);
        astController.AddOpScr(tipo);
        if (hijosBan2[1] == 1) {
          cont2++;
          astController.AddOpScr("Null");
        }
      cont2++;
      }

      if (cont < 1) {
        var rama = creandoNodos("copa.png");
        arbol1.getChildren().add(rama);
        text1.getChildren().add(label);
        astController.AddOpScr(tipo);
        cont++;
      }
      hb1.setVisible(false);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }
  }

  private static void creandoC(ActionEvent event) {
    hb4.setVisible(true);
    var tipo = cb4.getValue().toString();
    var valor = textField.getCharacters().toString();
    var label = new Label(valor);
    try {
      if (cont4 < 8 && cont3 >= 4 && cont2 >= 2 && cont >= 1) {
        var rama4 = creandoNodos("constant.png");
        while (hijosBan4[cont4]==1 && cont4 < 7) {
          cont4++;
          astController.AddOpScr("Null");
        }
        if(hijosBan4[cont4] == 0){
          astController.AddConst(tipo,valor);
          arbol4[cont4].getChildren().add(rama4);
          text4[cont4].getChildren().add(label);
        }else{
          astController.AddOpScr("Null");
        }
        cont4++;
      }
      if (cont3 < 4 && cont2 >= 2 && cont >= 1) {
        var rama3 = creandoNodos("Const3.png");
        while (hijosBan3[cont3] == 1 && cont3 < 3){
          cont3++;
          astController.AddOpScr("Null");
        }
        if(hijosBan3[cont3] == 0){
          arbol3[cont3].getChildren().add(rama3);
          text3[cont3].getChildren().add(label);
          astController.AddConst(tipo,valor);
          hijosBan4[cont3*2] = 1;
          hijosBan4[cont3*2+1] = 1;
        }else{astController.AddOpScr("Null");}
        cont3++;
      }
      if (cont2 < 2 && cont >= 1) {

          var rama2 = creandoNodos("Const2.png");
          arbol2[cont2].getChildren().add(rama2);
          text2[cont2].getChildren().add(label);
          astController.AddConst(tipo, valor);
          hijosBan3[cont2 * 2] = 1;
          hijosBan3[cont2 * 2 + 1] = 1;
          hijosBan4[cont2 * 2] = 1;
          hijosBan4[cont2 * 2 + 1] = 1;
          hijosBan4[cont2 * 2 + 2] = 1;
          hijosBan4[cont2 * 2 + 3] = 1;
        if (hijosBan2[1] == 1) {
          cont2++;
          astController.AddOpScr("Null");
        }
        cont2++;
      }
      if (cont < 1) {
        var rama = creandoNodos("copaConst.png");
        arbol1.getChildren().add(rama);
        text1.getChildren().add(label);
        astController.AddConst(tipo,valor);
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
  private static void creandoS(ActionEvent event) {
    hb4.setVisible(true);
    var tipo = cb3.getValue().toString();
    var label = new Label(tipo);
    try{
      if (cont3 < 4 && cont2 >= 2 && cont >= 1) {
        var rama3 = creandoNodos("prueba22.png");
        while (hijosBan3[cont3] == 1 && cont3 < 3){
          cont3++;
          astController.AddOpScr("Null");
        }
        if(hijosBan3[cont3] == 0){
          arbol3[cont3].getChildren().add(rama3);
          text3[cont3].getChildren().add(label);
          astController.AddOpScr(tipo);
          hijosBan4[cont3*2+1] = 1;
        }else{astController.AddOpScr("Null");}
        cont3++;
      }
      if (cont2 < 2 && cont >= 1) {
        var rama2 = creandoNodos("doble11.png");

        if (hijosBan2[cont2] == 0) {
          arbol2[cont2].getChildren().add(rama2);
          text2[cont2].getChildren().add(label);
          astController.AddOpScr(tipo);
          hijosBan3[cont2 * 2 + 1] = 1;
          hijosBan4[cont2 * 2 + 2] = 1;
          hijosBan4[cont2 * 2 + 3] = 1;
          if (hijosBan2[1] == 1) {
            cont2++;
            astController.AddOpScr("Null");
          }
        }
        cont2++;
      }
      if (cont < 1) {
        var rama = creandoNodos("copaS.png");
        arbol1.getChildren().add(rama);
        text1.getChildren().add(label);
        astController.AddOpScr(tipo);
        cont++;
        hijosBan2[1] = 1;
        hijosBan3[2] = 1;
        hijosBan3[3] = 1;
        hijosBan4[4] = 1;
        hijosBan4[5] = 1;
        hijosBan4[6] = 1;
        hijosBan4[7] = 1;
      }
      hb5.setVisible(false);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
