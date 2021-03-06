package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
    @FXML TextField tfTexto;
    @FXML Label lbCumple;
    @FXML ListView listCasos;
    @FXML
    protected void initialize(){
        listCasos.getItems().addAll("Ejercicio 1 (Empieza con _; no sigue p; tiene 3 o más letras o números; termina en q o w)","Ejercicio 2 (Empieza con +; tiene una o más letras)","Validar contraseña (Mínimo 1 mayús, 1 minús, 1 número, 1 caracter especial en cualquier orden)","Palabra que no comience con B","Validar grupo (ISC-númeroA|B)","Validar palabra con _ en medio");
    }
    public void procesar(ActionEvent event){
        String texto=tfTexto.getText();
        String expresion="";
        switch(listCasos.getSelectionModel().getSelectedIndex()){
            case 0://Ejercicio 1
                expresion="^[_][^p]([a-zA-Z0-9]{3,})[q|w]$";
                break;
            case 1://Ejercicio 2
                expresion="^[+]([a-zA-Z]+)";
                break;
            case 2://Validar password
                expresion="^(?=.*[a-z]+)(?=.*[A-Z]+)(?=.*[0-9]+)(?=.*[^\\w]+).*$";
                break;
            case 3://Palabra que no comience con B
                expresion="[^B].*";
                break;
            case 4://Validar grupo (ISC-1B)
                expresion="^(ISC)-([1-9])[A|B]$";
                break;
            case 5://Validar casa_perro
                expresion="([A-Za-z],{1,})[_]([A-Za-z]{1,})";
                break;
        }
        Pattern patron= Pattern.compile(expresion);
        Matcher matcher=patron.matcher(texto);
        if(matcher.matches()){
            lbCumple.setText("Sí cumple");
        }
        else{
            lbCumple.setText("No cumple");
        }
    }
}
