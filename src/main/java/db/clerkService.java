package db;

import models.clerk;
import models.doctor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class clerkService {
    public static void addClerk(clerk clerk) throws ClassNotFoundException {
        Statement stmt = null;
        Connection con = null;

        try {
            con = CS360DB.getConnection();
            stmt = con.createStatement();

            StringBuilder insQuery = new StringBuilder();

            insQuery.append("INSERT INTO ")
                    .append(" clerk (name)")
                    .append(" VALUES (")
                    .append("'").append(clerk.getName()).append("');");


            String generatedColumns[] = {"clerk_id"};
            PreparedStatement stmtIns = con.prepareStatement(insQuery.toString(), generatedColumns);
            stmtIns.executeUpdate();

            ResultSet rs = stmtIns.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                clerk.setId(id);
            }
            System.out.println("#DB: The clerk with name " + clerk.getName() + "  was successfully added in the database.");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CS360DB.closeDBConnection(stmt, con);
        }
    }

    public static List<clerk> getClerk(int id) throws ClassNotFoundException {
        Statement stmt = null;
        Connection con = null;
        ArrayList<clerk> clerks = new ArrayList<>();

        try {
            con = CS360DB.getConnection();
            stmt = con.createStatement();

            stmt.execute("SELECT * FROM doctor WHERE id = " + id + ";");

            ResultSet res = stmt.getResultSet();
            while (res.next()) {
                clerk clerk = new clerk(res.getString("name"));
                clerk.setId(res.getInt("id"));
                clerks.add(clerk);
            }
            System.out.println("#DB: The clerk for id " + id + "  was successfully recovered from the database.");

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CS360DB.closeDBConnection(stmt, con);
        }
        return clerks;
    }
}
