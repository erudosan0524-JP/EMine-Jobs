package com.github.jp.erudosan.emj.job;

public enum JobGenre {
    MINER("MINER"),
    LAMBER("LAMBER"),
    FISHING("FISHING"),
    CHEF("CHEF"),
    HUNTER("HUNTER"),
    NONE("NONE");

    private String genre;

    private JobGenre(String genre){
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }
}
