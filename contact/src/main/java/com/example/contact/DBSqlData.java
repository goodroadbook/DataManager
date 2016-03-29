package com.example.contact;

public class DBSqlData
{
    public static final String SQL_DB_CREATE_TABLE
            = "CREATE TABLE db_table_test " +
                "(reg_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT NOT NULL, " +
                "phone_number TEXT NOT NULL, " +
                "email TEXT NOT NULL)";

    public static final String SQL_DB_INSERT_DATA
            = "INSERT INTO db_table_test " +
                "(phone_number, name, email) " +
                "VALUES (?, ?, ?)";

    public static final String SQL_DB_SELECT_ALL
            = "SELECT * " + "FROM db_table_test ORDER BY reg_id DESC";

    public static final String SQL_DB_DELETE_DATA
            = "DELETE FROM db_table_test " + "WHERE phone_number=?";
}
