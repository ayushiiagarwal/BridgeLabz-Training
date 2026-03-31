package manager;

import java.sql.*;
import connection.DBconnection;
import exception.ClinicException;
import model.Visit;

public class VisitManager {
    // UC - 4.1
    public void recordVisit(Visit visit) throws ClinicException, SQLException{
        String sql1 = """
                INSERT INTO visits
                (appointment_id, visit_date, diagnosis, notes)
                VALUES(?, ?, ?, ?)
                """;

        String sql2 = """
                UPDATE appointments
                SET status = 'COMPLETED'
                WHERE appointment_id = ?
                """;
        
        try(Connection connection = DBconnection.getConnection()){
            connection.setAutoCommit(false);

            try(PreparedStatement ps1 = connection.prepareStatement(sql1); 
                PreparedStatement ps2 = connection.prepareStatement(sql2)){

                ps1.setInt(1, visit.getAppointmentID());
                ps1.setDate(2, java.sql.Date.valueOf(visit.getVisitDate()));
                ps1.setString(3, visit.getDiagnosis());
                ps1.setString(4, visit.getNotes());
                
                ps1.executeUpdate();

                ps2.setInt(1, visit.getAppointmentID());
                ps2.executeUpdate();

                connection.commit();
            }
            catch(Exception e){
                connection.rollback();
                throw new ClinicException("Error recording the visit!");
            }
        }
    }
    
    // UC - 4.2
    public void viewPatientHistory(int pateintId) throws ClinicException, SQLException{
        String sql = """
                SELECT
                    v.visit_date,
                    d.name AS doctor_name,
                    v.diagnosis,
                    p.medicine_name,
                    p.dosage,
                    p.duration
                FROM visits v
                JOIN appointments a ON v.appointment_id = a.appointment_id
                JOIN doctors d ON a.doctor_id = d.doctor_id
                LEFT JOIN prescriptions p ON v.visit_id = p.visit_id
                WHERE a.patient_id = ?
                ORDER BY v.visit_date DESC
                """;
        
        try(Connection connection = DBconnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){

            ps.setInt(1, pateintId);
            ResultSet rs = ps.executeQuery();

            System.out.println("Date | Doctor | Diagnosis | Medicine | Dosage | Duration");
            System.out.println("--------------------------------------------------------");

            while (rs.next())
                System.out.println(
                    rs.getDate("visit_date") + " | " +
                    rs.getString("doctor_name") + " | " +
                    rs.getString("medicine_name") + " | " +
                    rs.getString("dosage") + " | " + 
                    rs.getString("duration"));
        }
        catch(Exception e){
            throw new ClinicException("Error fetching medical history!");
        }
    }

    // UC - 4.3
    public void addDescription(int visitId, String[][] medicines) throws ClinicException, SQLException{
        String sql = """
                INSERT INTO prescriptions
                (visit_id, medicine_name, dosage, duration)
                VALUES(?, ?, ?, ?)
                """;

        try(Connection connection = DBconnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){
            
            for(String[] med : medicines){
                ps.setInt(1, visitId);
                ps.setString(2, med[0]);
                ps.setString(3, med[1]);
                ps.setString(4, med[2]);
                ps.addBatch();
            }

            ps.executeBatch();
        }
        catch(Exception e){
            throw new ClinicException("Error adding prescriptions!");
        }
    }
}
