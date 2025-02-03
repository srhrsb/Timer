package com.brh;


import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

/*
DAO dient dazu die erstellten Daten in ein speicherbares Objekt umzuwandeln
zum Zwecke der Speicherung und Wiederherstellung
DAO arbeitet mit der Modelklasse Timer zusammen
 */
public class TimerDAO {

    private final String FILE_PATH = "log.csv";
    private final String SEPARATOR = ",";

    private ArrayList<Timer> timerList;

    public TimerDAO() {
        timerList = loadLog();
    }


    private void saveLog() {

        //ToDo: Speichern der Daten

        //Fehlerbehandlung
        FileWriter writer = null;
        try{
            String path = getClass().getResource(FILE_PATH).getPath();
            writer = new FileWriter( path );

            for( var timer : timerList){
                if(timer != null){ //Objekt gültig?
                    String line = timer.getTime()+SEPARATOR+
                                   timer.getTimeStamp()+SEPARATOR+
                                   timer.getDescription();

                    writer.write( line );
                }
            }
        }catch( IOException e){
            System.err.println( "Exception: "+ e.getMessage() );
        }
        finally{
            if(writer != null){ // gibt es ein Writer-Objek?
                   try{
                      writer.close();
                   }
                   catch( IOException e){
                       System.err.println("Exception:"+ e.getMessage());
                   }
            }
        }







        //ToDo: Text in Datei schreiben

    }

    private ArrayList<Timer> loadLog() {

        ArrayList<Timer> list = new ArrayList<>();

        //ToDo: Reader erzeugen

        FileReader reader = null;
        try{
            String path = getClass().getResource(FILE_PATH).getPath();
            reader = new FileReader( path );

            BufferedReader buffer = new BufferedReader( reader );
            String line ;

            while( ( line = buffer.readLine() ) != null){ //sind noch ungelesene Zeilen da?

                String[] lineData = line.split(SEPARATOR);

                      int time = Integer.parseInt(lineData[0]);
                      LocalDateTime timestamp = LocalDateTime.parse( lineData[1]);
                      String description = lineData[2];

                      Timer timer = new Timer(time, timestamp,description);
                      timerList.add(timer);


            }




        }catch( IOException e){
            System.err.println( "Exception: "+ e.getMessage() );
        }
        finally{
            if(reader != null){ // gibt es ein Writer-Objek?
                try{
                    reader.close();
                }
                catch( IOException e){
                    System.err.println("Exception:"+ e.getMessage());
                }
            }
        }



        //ToDo: Pfad bekommen

        //ToDo: Buffer erzeugen

        //ToDo: Daten einlesen, solange nicht alle Zeilen gelesen wurden

        //ToDo: Gelesene Daten in Objekte umwandeln und der List hinzufügen









        return list;
    }


    public boolean addTimer(String description, int time) {
        Timer currentTimer = new Timer(time, description);
        return timerList.add(currentTimer);
    }

    public ArrayList<Timer> getLog() {
        return timerList;
    }
}
