package models;

import java.util.ArrayList;

public class patient_archive {
    private int id;
    private String in_date;
    private String out_data;
    private int amka;
    private int exams_id;
    private int disease_id;
    private String disease_name;
    private String exam_name;
    private ArrayList<String> drug;
    private String symptoms;

    public patient_archive(String in_date,String out_data,int amka,int exams_id,int disease_id){
        this.amka=amka;
        this.disease_id=disease_id;
        this.exams_id=exams_id;
        this.in_date=in_date;
        this.out_data=out_data;
    }

    public void setAmka(int amka) {
        this.amka = amka;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDisease_id(int disease_id) {
        this.disease_id = disease_id;
    }

    public void setExams_id(int exams_id) {
        this.exams_id = exams_id;
    }

    public void setIn_date(String in_date) {
        this.in_date = in_date;
    }

    public void setOut_data(String out_data) {
        this.out_data = out_data;
    }

    public void setDisease_name(String disease_name) {
        this.disease_name = disease_name;
    }

    public void setExam_name(String exam_name) {
        this.exam_name = exam_name;
    }

    public int getAmka() {
        return amka;
    }

    public int getId() {
        return id;
    }

    public int getDisease_id() {
        return disease_id;
    }

    public int getExams_id() {
        return exams_id;
    }

    public String getIn_date() {
        return in_date;
    }

    public String getOut_data() {
        return out_data;
    }

    public String getDisease_name() {
        return disease_name;
    }

    public String getExam_name() {
        return exam_name;
    }

    public void setDrug(ArrayList<String> drug) {
        this.drug = drug;
    }

    public ArrayList<String> getDrug() {
        return drug;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getSymptoms() {
        return symptoms;
    }
}
