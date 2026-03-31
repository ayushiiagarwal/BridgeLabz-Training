package model;

import java.time.LocalDate;

public class Visit {
    private int visitId, appointmentId;
    private LocalDate visitDate;
    private String diagnosis, prescription, notes;

    public Visit(){}

    public Visit(int visitId, int appointmentId, LocalDate visitDate, String diagnosis, String prescription, String notes){
        this.visitId = visitId;
        this.appointmentId = appointmentId;
        this.visitDate = visitDate;
        this.diagnosis = diagnosis;
        this.prescription = prescription;
        this.notes = notes;
    }

    public int getVisitId(){ return visitId; }
    public void setVisitId(int visitId){ this.visitId = visitId; }

    public int getAppointmentID(){ return appointmentId; }
    public void setAppointmentID(int appointmentId){ this.appointmentId = appointmentId; }

    public LocalDate getVisitDate(){ return visitDate; }
    public void setVisitDate(LocalDate visitDate){ this.visitDate = visitDate; }

    public String getDiagnosis(){ return diagnosis; }
    public void setDiagnosis(String diagnosis){ this.diagnosis = diagnosis; }

    public String getPrescription(){ return prescription; }
    public void setPrescription(String prescreption){ this.prescription = prescreption; }

    public String getNotes(){ return notes; }
    public void setNotes(String notes){ this.notes = notes; }
}
