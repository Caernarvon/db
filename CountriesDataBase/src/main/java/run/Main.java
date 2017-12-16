package run;

import liquibase.Contexts;
import liquibase.LabelExpression;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.LiquibaseException;
import liquibase.resource.FileSystemResourceAccessor;

import java.io.File;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws LiquibaseException, SQLException, ClassNotFoundException {
        Connect.connect();

        create_tables();
        fill_tables();
        insert_inTable();
        update_row();
        select_fromTables();
        rename_column();
        delete_certainRows();
        delete_rows();
        delete_tables();
    }

    public static void create_tables() throws LiquibaseException {
        Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(Connect.connection));
        File change_create_tables = new File(ClassLoader.getSystemResource("liquibase/1.0-create-tables.xml").getFile());
        Liquibase create_tables = new liquibase.Liquibase(change_create_tables.toString(), new FileSystemResourceAccessor(), database);
        create_tables.update(new Contexts(), new LabelExpression());
    }

    public static void delete_tables() throws LiquibaseException {
        Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(Connect.connection));
        File change_delete_tables = new File(ClassLoader.getSystemResource("liquibase/2.0-delete-tables.xml").getFile());
        Liquibase delete_tables = new liquibase.Liquibase(change_delete_tables.toString(), new FileSystemResourceAccessor(), database);
        delete_tables.update(new Contexts(), new LabelExpression());
    }

    public static void delete_rows() throws LiquibaseException {
        Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(Connect.connection));
        File change_delete_rows = new File(ClassLoader.getSystemResource("liquibase/3.0-delete-rows.xml").getFile());
        Liquibase delete_rows = new liquibase.Liquibase(change_delete_rows.toString(), new FileSystemResourceAccessor(), database);
        delete_rows.update(new Contexts(), new LabelExpression());
    }

    public static void delete_certainRows() throws LiquibaseException {
        Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(Connect.connection));
        File change_delete_certainRows = new File(ClassLoader.getSystemResource("liquibase/3.1-delete-certainRows.xml").getFile());
        Liquibase delete_certainRows = new liquibase.Liquibase(change_delete_certainRows.toString(), new FileSystemResourceAccessor(), database);
        delete_certainRows.update(new Contexts(), new LabelExpression());
    }

    public static void fill_tables() throws LiquibaseException {
        Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(Connect.connection));
        File change_fill_tables = new File(ClassLoader.getSystemResource("liquibase/4.0-fill-tables.xml").getFile());
        Liquibase fill_tables = new liquibase.Liquibase(change_fill_tables.toString(), new FileSystemResourceAccessor(), database);
        fill_tables.update(new Contexts(), new LabelExpression());
    }

    public static void insert_inTable() throws LiquibaseException {
        Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(Connect.connection));
        File change_insert_inTable = new File(ClassLoader.getSystemResource("liquibase/4.1-insert-inTable.xml").getFile());
        Liquibase insert_inTable = new liquibase.Liquibase(change_insert_inTable.toString(), new FileSystemResourceAccessor(), database);
        insert_inTable.update(new Contexts(), new LabelExpression());
    }

    public static void update_row() throws LiquibaseException {
        Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(Connect.connection));
        File change_update_table = new File(ClassLoader.getSystemResource("liquibase/5.0-update-row.xml").getFile());
        Liquibase update_table = new liquibase.Liquibase(change_update_table.toString(), new FileSystemResourceAccessor(), database);
        update_table.update(new Contexts(), new LabelExpression());
    }

    public static void rename_column() throws LiquibaseException {
        Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(Connect.connection));
        File change_rename_column = new File(ClassLoader.getSystemResource("liquibase/5.1-rename-column.xml").getFile());
        Liquibase rename_column = new liquibase.Liquibase(change_rename_column.toString(), new FileSystemResourceAccessor(), database);
        rename_column.update(new Contexts(), new LabelExpression());
    }

    public static void select_fromTables() throws LiquibaseException {
        Database database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(Connect.connection));
        File change_select_fromTables = new File(ClassLoader.getSystemResource("liquibase/6.0-select-fromTables.xml").getFile());
        Liquibase select_fromTables = new liquibase.Liquibase(change_select_fromTables.toString(), new FileSystemResourceAccessor(), database);
        select_fromTables.update(new Contexts(), new LabelExpression());
    }
}
