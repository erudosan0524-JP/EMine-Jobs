package com.github.jp.erudosan.emj.job.jobs.lamber;

import com.github.jp.erudosan.emj.job.Job;
import com.github.jp.erudosan.emj.job.JobGenre;

public class Lamber extends Job {

    @Override
    public String name() {
        return "lamber";
    }

    @Override
    public int id() {
        return 2;
    }

    @Override
    public JobGenre genre() {
        return JobGenre.LAMBER;
    }

    @Override
    public int rank() {
        return 1;
    }
}
