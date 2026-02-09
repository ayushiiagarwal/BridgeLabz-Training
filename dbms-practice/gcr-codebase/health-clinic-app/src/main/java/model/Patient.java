package model;

import java.time.LocalDate;

public class Patient {
    private int patientId;
    private String name, email, contact, address, bloodGroup;
    private LocalDate dob;

    public Patient(){
    }

    public Patient(int patientId, String name, String email, String contact, 
                    String address, String bloodGroup, LocalDate dob){

        this.patientId = patientId;
        this.name = name;
        this.email = email;
        this.contact = contact;
        this.address = address;
        this.bloodGroup = bloodGroup;
        this.dob = dob;
    }

    public int getPatientId(){
        return patientId;
    }
    public void setPatientId(int patientId){
        this.patientId = patientId;
    }

    public String getPatientName(){
        return name;
    }
    public void setPatientName(String name){
        this.name = name;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public String getContact(){
        return contact;
    }
    public void setContact(String contact){
        this.contact = contact;
    }

    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address = address;
    }

    public String getBloodGroup(){
        return bloodGroup;
    }
    public void setBloodGroup(String bloodGroup){
        this.bloodGroup = bloodGroup;
    }

    public LocalDate getDOB(){
        return dob;
    }
    public void setDOB(LocalDate dob){
        this.dob = dob;
    }

}
