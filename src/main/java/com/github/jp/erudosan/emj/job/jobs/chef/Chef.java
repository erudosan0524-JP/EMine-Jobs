package com.github.jp.erudosan.emj.job.jobs.chef;

import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobGenre;

public class Chef extends Job {

    @Override
    public String name() {
        return "chef";
    }

    @Override
    public int id() {
        return 4;
    }

    @Override
    public JobGenre genre() {
        return JobGenre.CHEF;
    }

    @Override
    public int rank() {
        return 1;
    }
}
