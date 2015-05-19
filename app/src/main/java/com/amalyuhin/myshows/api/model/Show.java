package com.amalyuhin.myshows.api.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by amalyuhin on 08.12.2014.
 */
public class Show {

    @SerializedName("showId")
    private Integer id;

    @SerializedName("title")
    private String title;

    @SerializedName("ruTitle")
    private String ruTitle;

    @SerializedName("runtime")
    private Integer runtime;

    @SerializedName("showStatus")
    private String status;

    @SerializedName("watchStatus")
    private String watchStatus;

    @SerializedName("watchedEpisodes")
    private int watchedEpisodes;

    @SerializedName("totalEpisodes")
    private int totalEpisodes;

    @SerializedName("rating")
    private Double rating;

    @SerializedName("image")
    private String imageUrl;

    private List<Episode> episodes;

    public Show() {
        this.episodes = new ArrayList<Episode>();
    }

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

    public String getRuTitle() {
        return ruTitle;
    }

    public void setRuTitle(String ruTitle) {
        this.ruTitle = ruTitle;
    }

    public String getTitleString() {
        return !this.ruTitle.isEmpty() ? this.ruTitle : this.title;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public void setRuntime(Integer runtime) {
        this.runtime = runtime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getWatchStatus() {
        return watchStatus;
    }

    public void setWatchStatus(String watchStatus) {
        this.watchStatus = watchStatus;
    }

    public int getWatchedEpisodes() {
        return watchedEpisodes;
    }

    public void setWatchedEpisodes(int watchedEpisodes) {
        this.watchedEpisodes = watchedEpisodes;
    }

    public int getTotalEpisodes() {
        return totalEpisodes;
    }

    public void setTotalEpisodes(int totalEpisodes) {
        this.totalEpisodes = totalEpisodes;
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
    }

    public void addEpisode(Episode episode) {
        this.episodes.add(episode);
    }

    public void removeEpisode(Episode episode) {
        this.episodes.remove(episode);
    }
}
