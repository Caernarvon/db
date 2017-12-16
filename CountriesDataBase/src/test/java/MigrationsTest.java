import items.*;
import liquibase.exception.LiquibaseException;
import org.junit.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import run.Connect;
import run.GetData;
import run.Main;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

import static junit.framework.Assert.assertEquals;

public class MigrationsTest {

    @BeforeAll
    public static void onlyOnce() throws SQLException, ClassNotFoundException {
        Connect.connect();
    }

    @AfterAll
    public static void afterTest() throws SQLException, ClassNotFoundException {
        Connect.connection.close();
    }

    @Test
    public void createTablesTest() throws SQLException, LiquibaseException, ClassNotFoundException {
        Connect.connect();
        Main.createTables();
        DatabaseMetaData md = Connect.connection.getMetaData();
        ResultSet rs = md.getTables("", "", "%", null);
        while (rs.next())
            System.out.println(rs.getString(3));
        rs.close();
    }

    @Test
    public void setDataTest1() throws SQLException, LiquibaseException, ClassNotFoundException {
        Connect.connect();
        Main.createTables();
        Main.fillTables();
        GetData.getData();
        Country country = new Country(1, "UA", "Ukraine", 1);
        assertEquals(true, country.equals(GetData.countries.get(0)));
    }

    @Test
    public void setDataTest2() throws SQLException, LiquibaseException, ClassNotFoundException {
        Connect.connect();
        Main.createTables();
        Main.fillTables();
        GetData.getData();
        Country_nationalities countryNationality = new Country_nationalities(1, 1);
        assertEquals(true, countryNationality.equals(GetData.countryNationalities.get(0)));
    }

    @Test
    public void setDataTest3() throws SQLException, LiquibaseException, ClassNotFoundException {
        Connect.connect();
        Main.createTables();
        Main.fillTables();;
        GetData.getData();
        Emblem emblem = new Emblem(1, "Ukrainian nat. emblem");
        assertEquals(true, emblem.equals(GetData.emblems.get(0)));
    }

    @Test
    public void setDataTest4() throws SQLException, LiquibaseException, ClassNotFoundException {
        Connect.connect();
        Main.createTables();
        Main.fillTables();
        GetData.getData();
        Locality locality = new Locality(1,	"Kyiv",	4000000,
                true,	true,	1,	1,	6,	1);
        assertEquals(true, locality.equals(GetData.localities.get(0)));
    }

    @Test
    public void setDataTest5() throws SQLException, LiquibaseException, ClassNotFoundException {
        Connect.connect();
        Main.createTables();
        Main.fillTables();
        GetData.getData();
        Locality_type localityType = new Locality_type(1	, "I",
                "There will be first type description.");
        assertEquals(true, localityType.equals(GetData.localityTypes.get(0)));
    }

    @Test
    public void setDataTest6() throws SQLException, LiquibaseException, ClassNotFoundException {
        Connect.connect();
        Main.createTables();
        Main.fillTables();
        GetData.getData();
        Nationality nationality = new Nationality(1,	"Ukrainians",	"white");
        assertEquals(true, nationality.equals(GetData.nationalities.get(0)));
    }

    @Test
    public void setDataTest7() throws SQLException, LiquibaseException, ClassNotFoundException {
        Connect.connect();
        Main.createTables();
        Main.fillTables();
        GetData.getData();
        Region region = new Region(1,	"Kyiv  region",	1839,	1700000,
                "50°27′00″N 30°31′24″E",	21);
        assertEquals(true, region.equals(GetData.regions.get(0)));
    }

    @Test
    public void setRowTest() throws SQLException, LiquibaseException, ClassNotFoundException {
        Connect.connect();
        Main.createTables();
        Main.fillTables();
        Main.insertInTable();
        GetData.getData();
        Emblem emblem = new Emblem(36,	"Test emblem");
        assertEquals(true, emblem.equals(GetData.emblems.get(35)));
    }

    @Test
    public void updateRowTest() throws SQLException, LiquibaseException, ClassNotFoundException {
        Connect.connect();
        Main.createTables();
        Main.fillTables();
        Main.updateRow();
        GetData.getData();
        Emblem emblem = new Emblem(36, "executedMigration test");
        assertEquals(true, emblem.equals(GetData.emblems.get(35)));
    }

    @Test
    public void selectTest() throws SQLException, LiquibaseException, ClassNotFoundException {
        Connect.connect();
        Main.createTables();
        Main.fillTables();
        Main.selectFromTables();
        GetData.getData();
    }

    @Test
    public void deleteRowTest() throws SQLException, LiquibaseException, ClassNotFoundException {
        Connect.connect();
        Main.createTables();
        Main.fillTables();
        Main.deleteCertainRows();
        GetData.getData();
        boolean bool = true;
        if(GetData.emblems.size() > 35) {
            bool = false;
        }
        assertEquals(true, bool);
    }

}
