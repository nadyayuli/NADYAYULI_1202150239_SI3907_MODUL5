package com.example.nadyayulipratama.studycase5;

/**
 * Created by nadya yuli pratama on 25/03/2018.
 */

public class informasi {
    String Name, Descripsi, Priority;


    public informasi(String Name, String Descripsi, String Priority){
        this.Name = Name;
        this.Descripsi = Descripsi;
        this.Priority = Priority;
    }

    public String getName() {
        return Name;
    }
    public void  setName(String Name){
        this.Name = Name;
    }

    public String getDeskripsi() {
        return Descripsi;


    }
    public void  setDescripsi (String Deskripsi){
        this.Descripsi = Deskripsi;

    }

    public String getPriority() {
        return Priority;
    }
    public void  setPriority(String Priority){
        this.Priority = Priority;
    }



}
