package com.github.jp.erudosan.emj.utils.db;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.job.Job;
import lombok.NonNull;
import org.bukkit.entity.Player;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLGetterSetter {

    private Main plugin;

    private final String player_table = "players";
    private final String player_jobs_table = "player_jobs";
    private final String jobs_table = "jobs";

    public SQLGetterSetter(Main plugin) {
        this.plugin = plugin;
    }

    public boolean playerExists(@NonNull Player player) {
        try {
            DBManager db = plugin.getDbManager();
            PreparedStatement statement = db.getConnection()
                    .prepareStatement("SELECT * FROM " + player_table + " WHERE uuid=?");
            statement.setString(1,player.getUniqueId().toString());

            ResultSet results = statement.executeQuery();

            if(results.next()) {
                return true;
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        return false;
    }

    public boolean playerJobExists(@NonNull Player player) {
        try {
            DBManager db = plugin.getDbManager();
            PreparedStatement statement = db.getConnection()
                    .prepareStatement("SELECT * FROM " + player_jobs_table + " WHERE uuid=?");
            statement.setString(1,player.getUniqueId().toString());

            ResultSet results = statement.executeQuery();

            if(results.next()) {
                return true;
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        return false;
    }

    public boolean jobExists(@NonNull Job job) {
        try {
            DBManager db = plugin.getDbManager();
            PreparedStatement statement = db.getConnection()
                    .prepareStatement("SELECT * FROM " + jobs_table + " WHERE job=?");
            statement.setString(1,job.name());

            ResultSet results = statement.executeQuery();

            if(results.next()) {
                return true;
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        return false;
    }

    public void setPlayer(Player player, Date date) {
        try {
            DBManager db = plugin.getDbManager();
            PreparedStatement statement = db.getConnection()
                    .prepareStatement("SELECT * FROM " + player_table + " WHERE uuid=?");
            statement.setString(1, player.getUniqueId().toString());
            ResultSet results = statement.executeQuery();
            results.next();

            if (!playerExists(player)) {
                PreparedStatement insert = db.getConnection()
                        .prepareStatement("INSERT INTO " + player_table + " (uuid,player_name,last_login) VALUE (?,?,?)");
                insert.setString(1,player.getUniqueId().toString());
                insert.setString(2,player.getName());
                insert.setDate(3,date);

                insert.executeUpdate();

            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public void updatePlayer(Player player, Date date) {
        try {
            DBManager db = plugin.getDbManager();
            PreparedStatement statement = db.getConnection()
                    .prepareStatement("UPDATE " + player_table + " SET last_login=? WHERE uuid=?");
            statement.setDate(1,date);
            statement.setString(2,player.getUniqueId().toString());
            statement.executeUpdate();

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public Date getDate(Player player) {
        try {
            DBManager db = plugin.getDbManager();
            PreparedStatement statement = db.getConnection()
                    .prepareStatement("SELECT * FROM " + player_table + " WHERE uuid=?");
            statement.setString(1,player.getUniqueId().toString());

            ResultSet results = statement.executeQuery();
            results.next();

            return results.getDate("last_login");


        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        return null;
    }

    public void setPlayerJob(Player player, Job job) {
        try {
            DBManager db = plugin.getDbManager();
            PreparedStatement statement = db.getConnection()
                    .prepareStatement("SELECT * FROM " + player_jobs_table + " WHERE uuid=?");
            statement.setString(1, player.getUniqueId().toString());
            ResultSet results = statement.executeQuery();
            results.next();

            if (!playerJobExists(player)) {
                PreparedStatement insert = db.getConnection()
                        .prepareStatement("INSERT INTO " + player_jobs_table + " (uuid,job,exp,level) VALUE (?,?,?,?)");
                insert.setString(1,player.getUniqueId().toString());
                insert.setString(2,job.name());
                insert.setInt(3,0);
                insert.setInt(4,1);

                insert.executeUpdate();

            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
    public void leavePlayerJob(Player player) {
        try {
            DBManager db = plugin.getDbManager();
            PreparedStatement statement = db.getConnection()
                    .prepareStatement("DELETE FROM " + player_jobs_table + " WHERE uuid=?");
            statement.setString(1,player.getUniqueId().toString());
            statement.executeUpdate();

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }



    public boolean isSetPlayerJob(Player player) {
        try {
            DBManager db = plugin.getDbManager();
            PreparedStatement statement = db.getConnection()
                    .prepareStatement("SELECT job FROM " + player_jobs_table + " WHERE uuid=?");
            statement.setString(1,player.getUniqueId().toString());

            ResultSet results = statement.executeQuery();

            if(results.next()) {
                return true;
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        return false;
    }

    public void updatePlayerJob(Player player, Job job) {
        try {
            DBManager db = plugin.getDbManager();
            PreparedStatement statement = db.getConnection()
                    .prepareStatement("UPDATE " + player_jobs_table + " SET job=?, exp=?, level=? WHERE uuid=?");
            statement.setString(1,job.name());
            statement.setInt(2,0);
            statement.setInt(3,1);
            statement.setString(4,player.getUniqueId().toString());
            statement.executeUpdate();

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public void updateExp(Player player, int exp) {
        try {
            DBManager db = plugin.getDbManager();
            PreparedStatement statement = db.getConnection()
                    .prepareStatement("UPDATE " + player_jobs_table + " SET exp=? WHERE uuid=?");
            statement.setInt(1,exp);
            statement.setString(2,player.getUniqueId().toString());
            statement.executeUpdate();

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public void updateLevel(Player player, int level) {
        try {
            DBManager db = plugin.getDbManager();
            PreparedStatement statement = db.getConnection()
                    .prepareStatement("UPDATE " + player_jobs_table + " SET level=? WHERE uuid=?");
            statement.setInt(1,level);
            statement.setString(2,player.getUniqueId().toString());
            statement.executeUpdate();

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public String getPlayerJob(Player player) {
        try {
            DBManager db = plugin.getDbManager();
            PreparedStatement statement = db.getConnection()
                    .prepareStatement("SELECT * FROM " + player_jobs_table + " WHERE uuid=?");
            statement.setString(1,player.getUniqueId().toString());

            ResultSet results = statement.executeQuery();
            results.next();

            return results.getString("job");

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        return "";
    }

    public int getExp(Player player) {
        try {
            DBManager db = plugin.getDbManager();
            PreparedStatement statement = db.getConnection()
                    .prepareStatement("SELECT * FROM " + player_jobs_table + " WHERE uuid=?");
            statement.setString(1,player.getUniqueId().toString());

            ResultSet results = statement.executeQuery();
            results.next();

            return results.getInt("exp");

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        return 0;
    }

    public int getLevel(Player player) {
        try {
            DBManager db = plugin.getDbManager();
            PreparedStatement statement = db.getConnection()
                    .prepareStatement("SELECT * FROM " + player_jobs_table + " WHERE uuid=?");
            statement.setString(1,player.getUniqueId().toString());

            ResultSet results = statement.executeQuery();
            results.next();

            return results.getInt("level");

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        return 0;
    }

    public void setJob(Job job) {
        try {
            DBManager db = plugin.getDbManager();
            PreparedStatement statement = db.getConnection()
                    .prepareStatement("SELECT * FROM " + jobs_table + " WHERE job=?");
            statement.setString(1, job.name());
            ResultSet results = statement.executeQuery();
            results.next();

            if (!jobExists(job)) {
                PreparedStatement insert = db.getConnection()
                        .prepareStatement("INSERT INTO " + jobs_table + " (job,genre,_rank) VALUE (?,?,?)");
                insert.setString(1,job.name());
                insert.setString(2,job.genre().getGenre());
                insert.setInt(3,job.rank());

                insert.executeUpdate();

            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    public List<String> getJobsFromRank(int rank) {
        try {
            DBManager db = plugin.getDbManager();
            PreparedStatement statement = db.getConnection()
                    .prepareStatement("SELECT * FROM " + jobs_table + " WHERE _rank=?");
            statement.setInt(1,rank);

            ResultSet results = statement.executeQuery();

            List<String> list = new ArrayList<>();

            while(results.next()) {
                list.add(results.getString("job"));
            }

            return list;

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        return null;
    }



}
