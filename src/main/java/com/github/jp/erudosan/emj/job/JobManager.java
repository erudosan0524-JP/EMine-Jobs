package com.github.jp.erudosan.emj.job;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.event.PlayerChangeExpEvent;
import com.github.jp.erudosan.emj.event.PlayerLevelUpEvent;
import com.github.jp.erudosan.emj.job.jobs.chef.Chef;
import com.github.jp.erudosan.emj.job.jobs.fisher.Fisher;
import com.github.jp.erudosan.emj.job.jobs.hunter.Hunter;
import com.github.jp.erudosan.emj.job.jobs.lamber.Lamber;
import com.github.jp.erudosan.emj.job.jobs.miner.MinePro;
import com.github.jp.erudosan.emj.job.jobs.miner.Miner;
import lombok.Getter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class JobManager {

    private Main plugin;

    @Getter
    private List<Job> jobs = new ArrayList<>();

    /*
    * HashMap<rank,jobs>
     */

    @Getter
    private HashMap<Integer,List<Job>> MinerJobs = new HashMap<>();
    @Getter
    private HashMap<Integer,List<Job>> LamberJobs = new HashMap<>();
    @Getter
    private HashMap<Integer,List<Job>> FisherJobs = new HashMap<>();
    @Getter
    private HashMap<Integer,List<Job>> ChefJobs = new HashMap<>();
    @Getter
    private HashMap<Integer,List<Job>> HunterJobs = new HashMap<>();


    public JobManager(Main plugin) {
        this.plugin = plugin;
    }

    public void setup() {
        //Miner
        jobs.add(new Miner());
        jobs.add(new MinePro());

        //Lamber
        jobs.add(new Lamber());

        //Fisher
        jobs.add(new Fisher());

        //Chef
        jobs.add(new Chef());

        //Hunter
        jobs.add(new Hunter());

        //Setting Over rank2 Jobs
        for(int i=1; i <= 5; i++) {
            List<Job> miners = new ArrayList<>();
            List<Job> lambers = new ArrayList<>();
            List<Job> fishers = new ArrayList<>();
            List<Job> chefs = new ArrayList<>();
            List<Job> hunters = new ArrayList<>();


            //ランクi職業一覧を取得
            for(String s : getJobsFromRank(i)) {
                Job job = getJobFromName(s);

                switch (job.genre()) {
                    case MINER:
                        miners.add(job);
                        break;
                    case LAMBER:
                        lambers.add(job);
                        break;
                    case FISHING:
                        fishers.add(job);
                        break;
                    case CHEF:
                        chefs.add(job);
                        break;
                    case HUNTER:
                        hunters.add(job);
                        break;
                }
            }

            MinerJobs.put(i,miners);
            LamberJobs.put(i,lambers);
            FisherJobs.put(i,fishers);
            ChefJobs.put(i,chefs);
            HunterJobs.put(i,hunters);

        }

        setJob(jobs);
    }

    public boolean jobExists(String job_name) {
        for(Job job : jobs) {
            if(job.name().equalsIgnoreCase(job_name)) {
                return true;
            }
        }
        return false;
    }

    public boolean playerJobExists(Player player) {
        return plugin.getSql().playerJobExists(player);
    }

    public Job getJobFromName(String name) {
        for (Job job : jobs) {
            if(job.name().equals(name)) {
                return job;
            }
        }

        return null;
    }


    private void setJob(List<Job> jobs) {
        jobs.stream().forEach(job -> plugin.getSql().setJob(job));
    }

    private List<String> getJobsFromRank(int rank) {
        return plugin.getSql().getJobsFromRank(rank);
    }

    public void setPlayerJob(Player player, Job job) {
        if(Objects.isNull(job)) {
            plugin.getSql().leavePlayerJob(player);
        } else {
            plugin.getSql().setPlayerJob(player,job);
        }

    }

    public Job getPlayerJob(Player player) {
        String job_name = plugin.getSql().getPlayerJob(player);
        Job job = getJobFromName(job_name);

        return job;
    }

    public void addExp(Player player, int exp) {
        if (plugin.getSql().getExp(player) > plugin.getMyconfig().getNeedExpLevelUp()) {
            this.levelUp(player);
            plugin.getSql().updateExp(player,0);
        }

        PlayerChangeExpEvent event = new PlayerChangeExpEvent(player);
        plugin.getServer().getPluginManager().callEvent(event);

        plugin.getSql().updateExp(player,plugin.getSql().getExp(player) + exp);
    }

    public void levelUp(Player player) {
        int level = plugin.getSql().getLevel(player) + 1;
        PlayerLevelUpEvent event = new PlayerLevelUpEvent(player,level);
        plugin.getServer().getPluginManager().callEvent(event);

        plugin.getSql().updateLevel(player,level);
    }

}
