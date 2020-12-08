package com.github.jp.erudosan.emj.job;

public enum JobGenre {
    MINER("MINER"),
    LUMBER("LUMBER"),
    FISHING("FISHING"),
    CHEF("CHEF"),
    HUNTER("HUNTER");

    private String genre;

    private JobGenre(String genre){
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }
}
