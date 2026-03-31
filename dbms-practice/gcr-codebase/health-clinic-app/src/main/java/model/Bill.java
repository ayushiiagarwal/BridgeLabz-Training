package model;

import java.time.LocalDate;

public class Bill {
    private int billId, visitId, pateindId, doctorId;
    private double totalBill;
    private String paymentStatus;
    private LocalDate billDate;

    public Bill(){}

    public Bill(int billId, int visitId, int pateindId, int doctorId, double totalBill, 
                String paymentStatus, LocalDate billDate){
            this.billId = billId;
            this.visitId = visitId;
            this.pateindId = pateindId;
            this.doctorId = doctorId;
            this.totalBill = totalBill;
            this.paymentStatus = paymentStatus;
            this.billDate = billDate;
    }

    public int getBillId(){ return billId; }

    public int getVisitId() { return visitId; }

    public int getPatientId() { return pateindId; }
    
    public int getDoctorId() { return doctorId; }
    
    public double getTotalBill() { return totalBill; }
    
    public String getPaymentStatus() { return paymentStatus; }
    
    public LocalDate getBillDate() { return billDate; }
    public void setBillId(int billId){ this.billId = billId; }
}
