import java.sql.*;

/**
 * Created by vahurpuik on 26/12/15.
 */
public class Andmebaas {
    Connection yhendus;
    private int postkaart_id;

    public Andmebaas() {
        looYhendus();
        //kysiPostkaardiID();
        sulgeYhendus();

    }

    public void looYhendus() {
        try {
            Class.forName("org.sqlite.JDBC");
            yhendus = DriverManager.getConnection("jdbc:sqlite:postcarding.db");
        } catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
        }
        System.out.println("Yhendus olemas!");
    }

    public void sulgeYhendus() {
        try {
            yhendus.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Yhendus suletud");
    }

    public int kysiPostkaardiID() {
        try {
            looYhendus();
            Statement steitment = yhendus.createStatement();
            String sqlp2ring = "select * from [Main table Digar IDs] where [View count] = '' limit 1;";
            ResultSet vastus = steitment.executeQuery(sqlp2ring);

            postkaart_id = vastus.getInt("DIGARID");

            vastus.close();
            steitment.close();
            sulgeYhendus(); //Kõik tuleb kinni panna, tundub

            System.out.println(postkaart_id);
            return postkaart_id;

        } catch (Exception e) { //catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public int getPostkaart_id() {
        return postkaart_id;
    }

    public void logiVaatamine() {
        try {
            looYhendus();
            Statement steitment = yhendus.createStatement();
            String sqlk2sk = "UPDATE [Main table Digar IDs] SET [View count] = [View count] + 1 WHERE DIGARID = '" + postkaart_id + "';";
            steitment.executeUpdate(sqlk2sk);
            steitment.close();
            sulgeYhendus();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void m2rgiTekstiga() {
        try {
            looYhendus();
            Statement steitment = yhendus.createStatement();
            String sqlk2sk = "UPDATE [Main table Digar IDs] SET [Has text votes] = [Has text votes] + 1 WHERE DIGARID = '" + postkaart_id + "';";
            steitment.executeUpdate(sqlk2sk);
            steitment.close();
            sulgeYhendus();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }




}
