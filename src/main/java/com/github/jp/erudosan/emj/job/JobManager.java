package com.github.jp.erudosan.emj.job;

import com.github.jp.erudosan.emj.Main;
import com.github.jp.erudosan.emj.job.jobs.chef.Chef;
import com.github.jp.erudosan.emj.job.jobs.fisher.*;
import com.github.jp.erudosan.emj.job.jobs.hunter.Hunter;
import com.github.jp.erudosan.emj.job.jobs.lamber.*;
import com.github.jp.erudosan.emj.job.jobs.miner.*;
import lombok.Getter;

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



    private Set<JobGenre> jobGenres = new HashSet<>();
    protected Iterator<JobGenre> jobGenreIterator;


    public JobManager(Main plugin) {
        this.plugin = plugin;
    }

    public void setup() {
        //Miner
        jobs.add(new Miner(plugin));
        jobs.add(new MinePro(plugin));
        jobs.add(new Gunner(plugin));
        jobs.add(new CanonShooter(plugin));
        jobs.add(new GunMaster(plugin));
        jobs.add(new MineMaster(plugin));

        //Lamber
        jobs.add(new Lumber(plugin));
        jobs.add(new LumberPro(plugin));
        jobs.add(new Farmer(plugin));
        jobs.add(new Crafter(plugin));
        jobs.add(new Ork(plugin));
        jobs.add(new Goblin(plugin));
        jobs.add(new FarmMaster(plugin));
        jobs.add(new LumberMaster(plugin));
        jobs.add(new MineCrafter(plugin));

        //Fisher
        jobs.add(new Fisher(plugin));
        jobs.add(new FishPro(plugin));
        jobs.add(new Enchanter(plugin));
        jobs.add(new Wizard(plugin));
        jobs.add(new Mage(plugin));
        jobs.add(new DemonAvenger(plugin));
        jobs.add(new ArkMage(plugin));
        jobs.add(new Alchemist(plugin));
        jobs.add(new FishMaster(plugin));

        //Chef
        jobs.add(new Chef(plugin));

        //Hunter
        jobs.add(new Hunter(plugin));



        //Setting Over rank2 Jobs
        for(int i=1; i <= 5; i++) {
            List<Job> miners = new ArrayList<>();
            List<Job> lambers = new ArrayList<>();
            List<Job> fishers = new ArrayList<>();
            List<Job> chefs = new ArrayList<>();
            List<Job> hunters = new ArrayList<>();

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
                    case LUMBER:
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

                MinerJobs.put(i,miners);
                LamberJobs.put(i,lambers);
                FisherJobs.put(i,fishers);
                ChefJobs.put(i,chefs);
                HunterJobs.put(i,hunters);
            }
        }


        jobGenres.add(JobGenre.MINER);
        jobGenres.add(JobGenre.LUMBER);
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
