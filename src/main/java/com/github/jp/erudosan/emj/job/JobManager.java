package com.github.jp.erudosan.emj.job;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.event.PlayerChangeExpEvent;
import com.github.jp.erudosan.emj.event.PlayerLevelUpEvent;
import com.github.jp.erudosan.emj.job.jobs.chef.Chef;
import com.github.jp.erudosan.emj.job.jobs.fisher.*;
import com.github.jp.erudosan.emj.job.jobs.hunter.Hunter;
import com.github.jp.erudosan.emj.job.jobs.lamber.*;
import com.github.jp.erudosan.emj.job.jobs.miner.Gunner;
import com.github.jp.erudosan.emj.job.jobs.miner.MinePro;
import com.github.jp.erudosan.emj.job.jobs.miner.Miner;
import lombok.Getter;
import org.bukkit.entity.Player;

import java.util.*;

public class JobManager {

    protected Main plugin;

    @Getter
    private List<Job> jobs = new ArrayList<>();

    /*
    * HashMap<rank,jobs>
     */
    protected HashMap<Integer,List<Job>> MinerJobs = new HashMap<>();
    protected HashMap<Integer,List<Job>> LamberJobs = new HashMap<>();
    protected HashMap<Integer,List<Job>> FisherJobs = new HashMap<>();
    protected HashMap<Integer,List<Job>> ChefJobs = new HashMap<>();
    protected HashMap<Integer,List<Job>> HunterJobs = new HashMap<>();

    private List<Job> miners = new ArrayList<>();
    private List<Job> lambers = new ArrayList<>();
    private List<Job> fishers = new ArrayList<>();
    private List<Job> chefs = new ArrayList<>();
    private List<Job> hunters = new ArrayList<>();

    private Set<JobGenre> jobGenres = new HashSet<>();
    protected Iterator<JobGenre> jobGenreIterator;


    public JobManager(Main plugin) {
        this.plugin = plugin;
    }

    public void setup() {
        //Miner
        jobs.add(new Miner());
        jobs.add(new MinePro());
        jobs.add(new Gunner());

        //Lamber
        jobs.add(new Lamber());
        jobs.add(new LamberPro());
        jobs.add(new Farmer());
        jobs.add(new Crafter());
        jobs.add(new Ork());
        jobs.add(new Goblin());
        jobs.add(new FarmMaster());
        jobs.add(new LamberMaster());
        jobs.add(new MineCrafter());

        //Fisher
        jobs.add(new Fisher());
        jobs.add(new FishPro());
        jobs.add(new Enchanter());
        jobs.add(new Wizard());
        jobs.add(new Mage());

        //Chef
        jobs.add(new Chef());

        //Hunter
        jobs.add(new Hunter());



        //Setting Over rank2 Jobs
        for(int i=1; i <= 5; i++) {

            //ランクi職業一覧を取得
            for(String s : getJobsFromRank(i)) {

                if(Objects.isNull(s)) {
                    continue;
                }

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


        jobGenres.add(JobGenre.MINER);
        jobGenres.add(JobGenre.LAMBER);
        jobGenres.add(JobGenre.CHEF);
        jobGenres.add(JobGenre.FISHING);
        jobGenres.add(JobGenre.HUNTER);

        jobGenreIterator = jobGenres.iterator();

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

    protected List<String> getJobsFromRank(int rank) {
        return plugin.getSql().getJobsFromRank(rank);
    }
}
