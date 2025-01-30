package com.brh;


import java.util.ArrayList;

/*
DAO dient dazu die erstellten Daten in ein speicherbares Objekt umzuwandeln
zum Zwecke der Speicherung und Wiederherstellung
DAO arbeitet mit der Modelklasse Timer zusammen
 */
public class TimerDAO {

   private ArrayList<Timer> timerList;

   public TimerDAO(){
       timerList = loadLog();
   }


   private void saveLog(){

       //ToDo: Speichern der Daten

       //ToDo: Fehlerbehandlung
       //ToDo: Liste mit einzelnen Timerobjekten durchlaufen
       //ToDo: Daten in der List von Objektform in Textform bringen
       //ToDo: Text in Datei schreiben

   }

    private ArrayList<Timer> loadLog(){

       ArrayList<Timer> list  = new ArrayList<>();

       //ToDo: Laden aus der CSV Datei und list zuweisen





       return list;
    }




   public boolean addTimer( String description, int time ){
       Timer currentTimer = new Timer( time, description );
       return timerList.add( currentTimer );
   }





}
