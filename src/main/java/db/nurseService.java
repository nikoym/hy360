package db;

import models.nurse;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class nurseService {
    public static void addNurse(nurse nurse) throws ClassNotFoundException {
        Statement stmt = null;
        Connection con = null;

        try {
            con = CS360DB.getConnection();
            stmt = con.createStatement();

            StringBuilder insQuery = new StringBuilder();

            insQuery.append("INSERT INTO ")
                    .append(" nurse (name)")
                    .append(" VALUES (")
                    .append("'").append(nurse.getName()).append("');");


            String generatedColumns[] = {"nurse_id"};
            PreparedStatement stmtIns = con.prepareStatement(insQuery.toString(), generatedColumns);
            stmtIns.executeUpdate();

            ResultSet rs = stmtIns.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                nurse.setId(id);
            }
            System.out.println("#DB: The nurse with name " + nurse.getName() + "  was successfully added in the database.");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CS360DB.closeDBConnection(stmt, con);
        }
    }

    public static List<nurse> getNurse(int id) throws ClassNotFoundException {
        Statement stmt = null;
        Connection con = null;
        ArrayList<nurse> nurses = new ArrayList<>();

        try {
            con = CS360DB.getConnection();
            stmt = con.createStatement();

            stmt.execute("SELECT * FROM doctor WHERE id = " + id + ";");

            ResultSet res = stmt.getResultSet();
            while (res.next()) {
                nurse nurse = new nurse(res.getString("name"));
                nurse.setId(res.getInt("id"));
                nurses.add(nurse);
            }
            System.out.println("#DB: The nurse for id " + id + "  was successfully recovered from the database.");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CS360DB.closeDBConnection(stmt, con);
        }
        return nurses;
    }
}
