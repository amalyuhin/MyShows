package com.amalyuhin.myshows.api.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by amalyuhin on 08.12.2014.
 */
public class Episode {
    @SerializedName("episodeId")
    private Integer id;

    @SerializedName("title")
    private String title;

    @SerializedName("showId")
    private Integer showId;

    @SerializedName("seasonNumber")
    private Integer seasonNumber;

    @SerializedName("episodeNumber")
    private Integer episodeNumber;

    @SerializedName("airDate")
    private String airDate;

    private Show show;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getShowId() {
        return showId;
    }

    public void setShowId(Integer showId) {
        this.showId = showId;
    }

    public Integer getSeasonNumber() {
        return seasonNumber;
    }

    public void setSeasonNumber(Integer seasonNumber) {
        this.seasonNumber = seasonNumber;
    }

    public Integer getEpisodeNumber() {
        return episodeNumber;
    }

    public void setEpisodeNumber(Integer episodeNumber) {
        this.episodeNumber = episodeNumber;
    }

    public String getAirDate() {
        return airDate;
    }

    public void setAirDate(String airDate) {
        this.airDate = airDate;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }
}
