package db;

import models.doctor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class doctorService {
    public static void addDoctor(doctor doctor) throws ClassNotFoundException {
        Statement stmt = null;
        Connection con = null;

        try {
            con = CS360DB.getConnection();
            stmt = con.createStatement();

            StringBuilder insQuery = new StringBuilder();

            insQuery.append("INSERT INTO ")
                    .append(" doctor (name, specialty)")
                    .append(" VALUES (")
                    .append("'").append(doctor.getName()).append("',")
                    .append("'").append(doctor.getSpecialty()).append("');");


            String generatedColumns[] = {"doctor_id"};
            PreparedStatement stmtIns = con.prepareStatement(insQuery.toString(), generatedColumns);
            stmtIns.executeUpdate();

            ResultSet rs = stmtIns.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                doctor.setId(id);
            }
            System.out.println("#DB: The doctor with specialty " + doctor.getSpecialty() + "  was successfully added in the database.");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CS360DB.closeDBConnection(stmt, con);
        }
    }

    public static List<doctor> getDoctor(int id) throws ClassNotFoundException {
        Statement stmt = null;
        Connection con = null;
        ArrayList<doctor> doctors = new ArrayList<>();

        try {
            con = CS360DB.getConnection();
            stmt = con.createStatement();

            stmt.execute("SELECT * FROM doctor WHERE id = " + id + ";");

            ResultSet res = stmt.getResultSet();
            while (res.next()) {
                doctor doctor = new doctor(res.getString("name"), res.getString("specialty"));
                doctor.setId(res.getInt("id"));
                doctors.add(doctor);
            }
            System.out.println("#DB: The doctor for id " + id + "  was successfully recovered from the database.");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CS360DB.closeDBConnection(stmt, con);
        }
        return doctors;
    }
}

