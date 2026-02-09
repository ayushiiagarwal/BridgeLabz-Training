package model;

public class Speciality {
    private int speciality_id;
    private String specialityName, description;

    public Speciality(){}

    public Speciality(int speciality_id, String specialityName, String description){
        this.speciality_id = speciality_id;
        this.specialityName = specialityName;
        this.description = description;
    }

    public int getSpecialityId() { return speciality_id; }
    public void setSpecialityId(int speciality_id){ this.speciality_id = speciality_id; }

    public String getSpecialityName() { return specialityName; }
    public void setSpecialityName(String specialityName){ this.specialityName = specialityName; }

    public String getDescription() { return description; }
    public void setDescription(String description){ this.description = description; }
}
