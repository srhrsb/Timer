package com.brh;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Timer;
import java.util.TimerTask;

public class Controller {
    @FXML
    private TextField timeTf;

    @FXML
    private TextField descriptionTf;

    //RadioButton------------------------
    @FXML
    private RadioButton radio1;

    @FXML
    private RadioButton radio2;

    @FXML
    private RadioButton radio3;

    private ToggleGroup radioButtons;

    private Timer timer;

    private TimerDAO dao;

    @FXML
    private void initialize(){
         timer = new Timer();

    }

    @FXML
    protected void startTimer() {
       int time = getCurrentTime();
       runTimer( time );

    }

    private void runTimer( int seconds ){

        TimerTask timerTask = new TimerTask(){
            @Override
            public void run() {
                Platform.runLater( ()-> { timerEnd(); } );
            }
        };

        timer.schedule(timerTask, seconds * 1000);
    }

    /**
     * Zeit ist abgelaufen
     */
    private void timerEnd(){
          int time = getCurrentTime();
          String description = descriptionTf.getText();
          String infoText = createInfoText( description, time );
          showInfoWindow( "Timer ist abgelaufen", infoText);

    }

    private int getCurrentTime(){

        String text = timeTf.getText();
        int time = 0;

        try {
            time =  Integer.parseInt( text );

            if(time<0){
                throw new NumberFormatException();
            }
        }
        catch( NumberFormatException e){
            System.err.println("Fehler: "+e.getMessage() );
        }

        return time;
    }

    private String createInfoText( String description, int time ){

        String text = "Zeit von "+description+" ist abgelaufen\n";
        text +="eingestellt waren "+time+" Sekunden";

        return text;
    }


    private void showInfoWindow(String titel, String message){
         Alert window = new Alert( Alert.AlertType.INFORMATION );
         window.setTitle( titel );
         window.setHeaderText(null);
         window.setContentText( message );

         window.showAndWait();
    }

















}