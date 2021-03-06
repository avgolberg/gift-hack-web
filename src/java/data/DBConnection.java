package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    private static Connection con;
    
    public static Connection GetConnection() throws ClassNotFoundException, SQLException {
        if(con == null){
            Class.forName("com.mysql.cj.jdbc.Driver");
            String connectionString = "jdbc:mysql://localhost:3306/gift_hack" // Размещение БД
            + "?useUnicode=true&characterEncoding=UTF-8" // Кодировка канала (подключения)
+ "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC" // При проблемах согласования времени
+ "&autoReconnect=true&allowPublicKeyRetrieval=true&useSSL=false" ; // При проблемах с сервером

           con = DriverManager.getConnection( connectionString, "user1911", "pass1911" ) ;
                   
           Statement cmd = con.createStatement();
            cmd.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS Users (id int primary key auto_increment, "
                            + "username VARCHAR(32), name VARCHAR(64), surname VARCHAR(64), email VARCHAR(64), birthday VARCHAR(32), password VARCHAR(64)"
                            + ")"
                    + "Engine=InnoDB DEFAULT CHARSET=utf8"
            );
            cmd.executeUpdate(
                     "CREATE TABLE IF NOT EXISTS Lists (id VARCHAR(8) PRIMARY KEY, "
                             + "name VARCHAR(50), authorId INT)"
                     + "Engine=InnoDB DEFAULT CHARSET=utf8"
            );
            cmd.executeUpdate(
                     "CREATE TABLE IF NOT EXISTS Gifts (id int primary key auto_increment, "
                             + "name VARCHAR(50), quantity INT, link VARCHAR(256), ranking INT,"
                             + "comment VARCHAR(256), listId VARCHAR(8))"
                     + "Engine=InnoDB DEFAULT CHARSET=utf8"
            );
            cmd.executeUpdate(
                     "CREATE TABLE IF NOT EXISTS ReservedGifts (giftId int primary key, "
                             + "userId int)"
                     + "Engine=InnoDB DEFAULT CHARSET=utf8"
            );
        }
        return con;
    }
}
