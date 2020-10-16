package com.github.jp.erudosan.emj.job.jobs.hunter;

import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobGenre;

public class Hunter extends Job {

    @Override
    public String name() {
        return "hunter";
    }

    @Override
    public int id() {
        return 5;
    }

    @Override
    public JobGenre genre() {
        return JobGenre.HUNTER;
    }

    @Override
    public int rank() {
        return 1;
    }
}
