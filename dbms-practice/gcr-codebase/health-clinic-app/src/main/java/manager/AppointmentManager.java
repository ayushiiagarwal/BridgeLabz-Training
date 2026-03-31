package manager;

import java.sql.*;
import java.sql.Date;
import connection.DBconnection;
import model.Appointment;
import exception.ClinicException;

public class AppointmentManager {
    // UC - 3.1
    public void bookAppointment(Appointment a) throws ClinicException, SQLException{
        String checkSql = """
                SELECT COUNT(*) FROM appointments
                WHERE doctor_id=? AND appointment_date=? AND status='SCHEDULED'
                """;

        String insertSql = """
                INSERT INTO appointments(patient_id, doctor_id, appointment_date, status)
                VALUES(?, ?, ?, 'SCHEDULED')
                """;

        try(Connection connection = DBconnection.getConnection();
            PreparedStatement checkPs = connection.prepareStatement(checkSql)){

            checkPs.setInt(1, a.getDoctorId());
            checkPs.setDate(2, Date.valueOf(a.getAppointmentDate()));
             ResultSet rs = checkPs.executeQuery();
             rs.next();

             if(rs.getInt(1) > 0)
                throw new ClinicException("Doctor not Available!");
            
             try(PreparedStatement insertPs = connection.prepareStatement(insertSql)){
                insertPs.setInt(1, a.getPatientId());
                insertPs.setInt(2, a.getDoctorId());
                insertPs.setDate(3, Date.valueOf(a.getAppointmentDate()));
                insertPs.executeUpdate();
             }
        }
    }

    // UC - 3.3
    public void cancelAppointment(int appointmentId) throws ClinicException, SQLException{
        try(Connection connection = DBconnection.getConnection()){
            connection.setAutoCommit(false);

            PreparedStatement ps1 = connection.prepareStatement("UPDATE appointments SET status='CANCELED' WHERE appointment_id=?");
            ps1.setInt(1, appointmentId);
            ps1.executeUpdate();

            PreparedStatement ps2 = connection.prepareStatement("INSERT INTO appointment_audit VALUES (?, 'CANCELED', CURRENT_TIMESTAMP)");
            ps2.setInt(1, appointmentId);
            ps2.executeUpdate();

            connection.commit();
        }
    }

    // UC - 3.4
    public void rescheduleAppointment(int doctorId, int appointmentId, java.sql.Date newDate) throws ClinicException, SQLException{
        String sql1 = """
                COUNT(*) FROm appointments
                WHERE doctor_id=? AND appointment_date=?
                AND status = 'SCHEDULED'
                """;

        String sql2 = """
                UPDATE appointments
                SET doctor_id=?, appointment_date=?
                WHERE appointment_id=?
                """;

        try(Connection connection = DBconnection.getConnection()){
            connection.setAutoCommit(false);

            try(PreparedStatement ps1 = connection.prepareStatement(sql1)){
                ps1.setInt(1, doctorId);
                ps1.setDate(2, newDate);

                ResultSet rs = ps1.executeQuery();
                rs.next();

                if(rs.getInt(1) > 0)
                    throw new ClinicException("Appointment date is already booked!");

                try(PreparedStatement ps2 = connection.prepareStatement(sql2)){
                    ps2.setInt(1, doctorId);
                    ps2.setDate(2, newDate);
                    ps2.setInt(3, appointmentId);

                    ps2.executeQuery();
                }

                connection.commit();
            }
            catch(Exception e){
                throw new ClinicException("Error rescheduling appointment!");
            }
        }
    }

    // UC - 3.5
    public void viewSchedule(java.sql.Date date) throws ClinicException, SQLException{
        String sql = """
                SELECT
                    a.appointment_id,
                    p.name AS patient_name
                    d.name AS doctor_name,
                    a.status
                FROM appointments a
                JOIN patients p ON a.patient_id = p.patient_id
                JOIN doctors d ON a.doctor_id  = d.doctor_id
                WHERE a.appointment_date = ?
                ORDER BY d.name
                """;

        try(Connection connection = DBconnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){
                ps.setDate(1, date);

                ResultSet rs = ps.executeQuery();

                System.out.println("ID | Patient | Doctor | Status");
                System.out.println("------------------------------");

                while(rs.next())
                    System.out.println(rs.getInt("appointment_id") + " | " +
                                        rs.getString("patient_name") + " | " +
                                        rs.getString("doctor_name") + " | " +
                                        rs.getString("status"));
        }
        catch(Exception e){
            throw new ClinicException("Error viewing appointment schedule!");
        }
    }
}
