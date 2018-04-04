package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class Controller {
    public Button btnLogin;
    public Label lblError;
    public PasswordField txtPassword;
    public TextField txtLogin;
    public Button btnGenerate;
    public Label lblNum1;
    public Label lblNum2;
    public Label lblNum3;
    public Label lblNum4;
    public Label lblNum5;
    private int[] arr;
    private ActionEvent actionEvent;



    public void clickLogin(ActionEvent actionEvent) throws Exception{
        this.actionEvent = actionEvent;
        lblError.setText("");
        String login = txtLogin.getText().trim();
        String password = txtPassword.getText().trim();
        System.out.println(login+" "+password);
        if(login.length()<1 || password.length()<2){
            lblError.setText("Incorrect login or password!");
        }else {
            Stage stage = (Stage) btnLogin.getScene().getWindow();

            Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
            Stage newStage = new Stage();
            newStage.setTitle("TIPOS admin portal");
            newStage.setScene(new Scene(root, 600, 300));
            newStage.show();
            stage.close();
        }
    }

    public void generateNumbers(ActionEvent actionEvent) throws Exception{
        this.actionEvent = actionEvent;
        arr = new int[5];
        Random random=new Random();
        arr[0]=random.nextInt(35)+1;
        int i,j=1,k;
        boolean match;
        do{
            arr[j]=random.nextInt(35)+1;
            match=false;
            for(k=0;k<j;k++){
                if(arr[j]==arr[k]){
                    match=true;
                }
            }
            if(match==false){
                j++;
            }
        }while(j!=5);

        for(i=0;i<4;i++)
            for(j=0;j<4;j++)
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }


                lblNum1.setText(Integer.toString(arr[0]));
        lblNum2.setText(Integer.toString(arr[1]));
        lblNum3.setText(Integer.toString(arr[2]));
        lblNum4.setText(Integer.toString(arr[3]));
        lblNum5.setText(Integer.toString(arr[4]));




    }

}