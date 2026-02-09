package model;

import java.time.LocalDate;

public class Appointment {
    private int appointmentId, patientId, doctorId;
    private LocalDate appointmentDate;
    private String status;

    public Appointment(){}

    public Appointment(int appointmentId, int pateindId, int doctorId, LocalDate appointmentDate, String status){
        this.appointmentId = appointmentId;
        this.patientId = pateindId;
        this.doctorId = doctorId;
        this.appointmentDate = appointmentDate;
        this.status = status;
    }

    public int getAppointmentID(){ return appointmentId; }
    public void setAppointmentID(int appointmentId){ this.appointmentId = appointmentId; }

    public int getPatientId(){ return patientId; }
    public void setPatientId(int pateindId){ this.patientId = pateindId; }

    public int getDoctorId(){ return doctorId; }
    public void setDoctorID(int doctorId){ this.doctorId = doctorId; }

    public LocalDate getAppointmentDate(){ return appointmentDate; }
    public void setAppointmentDate(LocalDate appointmentDate){ this.appointmentDate = appointmentDate; }

    public String getStatus(){ return status; }
    public void setStatus(String status){ this.status = status; }
}
