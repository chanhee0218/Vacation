package com.chanhee.vacation;

public class SaveData {
    private String movieNm;
    private String ranking;

    public String getMovieNm() {
        return movieNm;
    }

    public void setMovieNm(String movieNm) {
        this.movieNm = movieNm;
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    public SaveData(String movieNm, String ranking) {
        this.movieNm = movieNm;
        this.ranking = ranking;
    }
}
