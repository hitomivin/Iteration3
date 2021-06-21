package sample;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;

public class Database {

    private Connection con;

    public Database() {
        String url = "jdbc:mysql://127.0.0.1:3306/?user=Hitomi";
        String password = "test";

        try {
            // connect Database
            this.con = DriverManager.getConnection(url, null, password);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private ResultSet executeSelect(String query) {

        try {
            Statement st = this.con.createStatement();
            ResultSet rs = st.executeQuery(query);

            return rs;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return null;
    }

    public ArrayList<Mutation> getStatistikMutationList(String postnr, String startDate, String slutDate) {
        String query;
        ArrayList<Mutation> mutations = new ArrayList<Mutation>();

        query = """
            Select Borger.Postnr, Test.Mutationsnavn, count(*) as Antal
            From coronanet.Test
            Inner join coronanet.Borger
               on Test.BorgerID = Borger.BorgerID 
            Where Borger.Postnr = '%s'
              and Test.Testtidspunkt between '%s 00:00:00' and '%s 23:59:59'
            Group by Borger.Postnr, Test.Mutationsnavn
            Order by Test.Mutationsnavn
        """;

        ResultSet rs = this.executeSelect(String.format(query, postnr, startDate, slutDate));

        try {
            if (rs != null) {
                while (rs.next()) {
                    mutations.add(new Mutation(rs.getString("Mutationsnavn"), rs.getInt("Antal")));
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return mutations;
    }

}
