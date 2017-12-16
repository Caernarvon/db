package run;

import items.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetData {
    public static List<Country> countries = new ArrayList<>();
    public static List<Country_nationalities> countryNationalities = new ArrayList<>();
    public static List<Emblem> emblems = new ArrayList<>();
    public static List<Locality> localities = new ArrayList<>();
    public static List<Locality_type> localityTypes = new ArrayList<>();
    public static List<Nationality> nationalities = new ArrayList<>();
    public static List<Region> regions = new ArrayList<>();

    public static void getData() throws SQLException {
        countries.clear();
        countryNationalities.clear();
        emblems.clear();
        localities.clear();
        localityTypes.clear();
        nationalities.clear();
        regions.clear();

        getCountriesFromDB();
        getCountryNationalitiesFromDB();
        getEmblemsFromDB();
        getLocalitiesFromDB();
        getLocalityTypesFromDB();
        getNationalitiesFromDB();
        getRegionsFromDB();
    }

    public static void getCountriesFromDB() throws SQLException {
        Statement stmt = Connect.connection.createStatement();
        String sql = "SELECT * FROM \"Country\"";
        ResultSet result = stmt.executeQuery(sql);
        while (result.next()) {
            Country country = new Country(result.getInt(1), result.getString(2),
                    result.getString(3), result.getInt(4));
            if (!countries.contains(country)) {
                countries.add(country);
            }
        }
    }

    public static void getCountryNationalitiesFromDB() throws SQLException {
        Statement stmt = Connect.connection.createStatement();
        String sql = "SELECT * FROM \"Country_nationalities\"";
        ResultSet result = stmt.executeQuery(sql);
        while (result.next()) {
            Country_nationalities countryNationality = new Country_nationalities(result.getInt(1), result.getInt(2));
            if (!countryNationalities.contains(countryNationality)) {
                countryNationalities.add(countryNationality);
            }
        }
    }

    public static void getEmblemsFromDB() throws SQLException {
        Statement stmt = Connect.connection.createStatement();
        String sql = "SELECT * FROM \"Emblem\"";
        ResultSet result = stmt.executeQuery(sql);
        while (result.next()) {
            Emblem emblem = new Emblem(result.getInt(1), result.getString(2));
            if (!emblems.contains(emblem)) {
                emblems.add(emblem);
            }
        }
    }

    public static void getLocalitiesFromDB() throws SQLException {
        Statement stmt = Connect.connection.createStatement();
        String sql = "SELECT * FROM \"Locality\"";
        ResultSet result = stmt.executeQuery(sql);
        while (result.next()) {
            Locality locality = new Locality(result.getInt(1), result.getString(2),
                    result.getInt(3), result.getBoolean(4), result.getBoolean(5),
                    result.getInt(6), result.getInt(7), result.getInt(8),
                    result.getInt(9));
            if (!localities.contains(locality)) {
                localities.add(locality);
            }
        }
    }

    public static void getLocalityTypesFromDB() throws SQLException {
        Statement stmt = Connect.connection.createStatement();
        String sql = "SELECT * FROM \"Locality_type\"";
        ResultSet result = stmt.executeQuery(sql);
        while (result.next()) {
            Locality_type localityType = new Locality_type(result.getInt(1), result.getString(2),
                    result.getString(3));
            if (!localityTypes.contains(localityType)) {
                localityTypes.add(localityType);
            }
        }
    }

    public static void getNationalitiesFromDB() throws SQLException {
        Statement stmt = Connect.connection.createStatement();
        String sql = "SELECT * FROM \"Nationality\"";
        ResultSet result = stmt.executeQuery(sql);
        while (result.next()) {
            Nationality nationality = new Nationality(result.getInt(1), result.getString(2),
                    result.getString(3));
            if (!nationalities.contains(nationality)) {
                nationalities.add(nationality);
            }
        }
    }

    public static void getRegionsFromDB() throws SQLException {
        Statement stmt = Connect.connection.createStatement();
        String sql = "SELECT * FROM \"Region\"";
        ResultSet result = stmt.executeQuery(sql);
        while (result.next()) {
            Region region = new Region(result.getInt(1), result.getString(2),
                    result.getInt(3), result.getInt(4), result.getString(5),
                    result.getInt(6));
            if (!regions.contains(region)) {
                regions.add(region);
            }
        }
    }
}
