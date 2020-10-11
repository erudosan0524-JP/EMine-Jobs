package com.github.jp.erudosan.emj.utils.db;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {

    private final String host,username,password,database;
    private final int port;

    @Getter
    @Setter
    private Connection connection;

    public DBManager(String host, String username, String password, String database, int port) {
        this.host = host;
        this.username = username;
        this.password = password;
        this.database = database;
        this.port = port;

        setup();
    }

    public void setup() {
        try {
            synchronized (this) {
                if(getConnection() != null && !getConnection().isClosed()) {
                    return;
                }

                Class.forName("com.mysql.jdbc.Driver");
                setConnection(DriverManager.getConnection("jdbc:mysql://" + this.host + ":" + this.port + "/" + this.database
                        , this.username, this.password));

                //Message
                Bukkit.getLogger().info("Setting up MySQL");
            }
        } catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
