package models;

import java.util.ArrayList;

public class patient {
    private int id;
    private String name;
    private String address;
    private String insurance;
    private int amka;
    private ArrayList<patient_archive> archives;

    public patient(String name,String address,String insurance, int amka){
        this.address=address;
        this.amka=amka;
        this.insurance=insurance;
        this.name=name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAmka(int amka) {
        this.amka = amka;
    }

    public void setInsurance(String insurance) {
        this.insurance = insurance;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getAmka() {
        return amka;
    }

    public String getAddress() {
        return address;
    }

    public String getInsurance() {
        return insurance;
    }

    public void setArchives(ArrayList<patient_archive> archives) {
        this.archives = archives;
    }

    public ArrayList<patient_archive> getArchives() {
        return archives;
    }
}
