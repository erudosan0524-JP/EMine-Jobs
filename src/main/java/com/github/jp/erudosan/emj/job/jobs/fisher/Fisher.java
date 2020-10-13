package com.github.jp.erudosan.emj.job.jobs.fisher;

import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobGenre;

public class Fisher extends Job {

    @Override
    public String name() {
        return "fisher";
    }

    @Override
    public int id() {
        return 3;
    }

    @Override
    public JobGenre genre() {
        return JobGenre.FISHING;
    }

    @Override
    public int rank() {
        return 1;
    }
}
