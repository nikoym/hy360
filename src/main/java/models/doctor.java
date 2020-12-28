package models;

public class doctor {
    private int id;
    private String name;
    private String Specialty;

    public doctor(String name,String specialty){
        this.name=name;
        this.Specialty=specialty;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSpecialty(String specialty) {
        Specialty = specialty;
    }

    public String getSpecialty() {
        return Specialty;
    }
}
