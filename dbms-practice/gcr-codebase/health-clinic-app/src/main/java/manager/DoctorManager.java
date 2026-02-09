package manager;

import java.sql.*;
import java.util.*;
import connection.DBconnection;
import exception.ClinicException;
import model.Doctor;

public class DoctorManager {
    // UC - 2.1
    public int addDoctor(Doctor doctor) throws ClinicException, SQLException{
        String sql = """
                INSERT INTO doctors(name, speciality_id, contact, fee)
                VALUES(?, ?, ?, ?)
                """;
        
        try(Connection connection = DBconnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){

            ps.setString(1, doctor.getDoctorName());
            ps.setInt(2, doctor.getSpecialityId());
            ps.setString(3, doctor.getDoctorContact());
            ps.setDouble(4, doctor.getFee());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            return rs.getInt(1);
        }
    }

    // UC - 2.2
    public void updateDoctorSpeciality(int doctorId, String newSpeciality) throws ClinicException, SQLException{
        String sql = "UPDATE doctors SET specialization=? WHERE doctor_id=?";

        try(Connection connection = DBconnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){

            ps.setString(1, newSpeciality);
            ps.setInt(2, doctorId);

            int rows = ps.executeUpdate();
            if(rows == 0)
                throw new ClinicException("Doctor Not Found!");
        }
        catch(Exception e){
            throw new ClinicException("Error Updating doctor speciality!");
        }
    }

    // UC - 2.3 - view doctor by speciality
    public List<Doctor> viewDoctor(String speciality) throws ClinicException, SQLException{
        String sql = """
                SELECT d.doctor_id, d.doctor_name, d.specialization, d.contact, d.fee, s.speciality_name, a.appointment_date
                FROM doctors d
                JOIN specialities s ON d.speciality_id = speciality_id
                WHERE s.speciality_name = ?
                ORDER BY d.doctor_name
                """;

        List<Doctor> doctors = new ArrayList<>();

        try(Connection connection = DBconnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){

            ps.setString(1, speciality);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                doctors.add(new Doctor(
                    rs.getInt("doctor_id"),
                    rs.getString("doctor_name"),
                    rs.getString("specialization"),
                    rs.getString("contact"),
                    rs.getDouble("fee"),
                    rs.getInt("speciality_id")
                ));
            }

            return doctors;
        }
        catch(Exception e){
            throw new ClinicException("No doctors with such speciality!");
        }
    }

    // UC - 2.4
    public void deactivateDoctor(int doctorId) throws ClinicException, SQLException{
        String sql = """
            UPDATE doctors
            SET is_active=FALSE
            WHERE doctor_id=?
            AND doctor_id NOT IN (
                SELECT doctor_id FROM appointments
                WHERE appointment_date > CURRENT_DATE
            )
            """;

        try(Connection connection = DBconnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql)){

            ps.setInt(1, doctorId);

            if(ps.executeUpdate() == 0)
                throw new ClinicException("Doctor cannot be deactivated!");
        }
    }
}
