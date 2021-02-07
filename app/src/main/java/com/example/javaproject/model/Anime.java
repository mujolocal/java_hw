package com.example.javaproject.model;

import androidx.annotation.NonNull;

public class Anime {
//"mal_id":10087,
//         "url":"https://myanimelist.net/anime/10087/Fate_Zero",
//         "image_url":"https://cdn.myanimelist.net/images/anime/2/73249.jpg?s=0ddd3d84549e11eda144df33626f97ae",
//         "title":"Fate/Zero",
//         "airing":false,
//         "synopsis":"With the promise of granting any wish, the omnipotent Holy Grail triggered three wars in the past, each too cruel and fierce to leave a victor. In spite of that, the wealthy Einzbern family is confide...",
//         "type":"TV",
//         "episodes":13,
//         "score":8.35,
//         "start_date":"2011-10-02T00:00:00+00:00",
//         "end_date":"2011-12-25T00:00:00+00:00",
//         "members":1070346,
//         "rated":"R"

    private String url;
    private String image_url;
    private String title;
    private boolean airing;
    private String synopsis;
    private String type;
    private String episodes;
    private float score;
    private String start_date;
    private String end_date;
    private int members;
    private String rated;

    public Anime(String url, String image_url, String title, boolean airing, String synopsis, String type, String episodes, float score, String start_date, String end_date, int members, String rated) {
        this.url = url;
        this.image_url = image_url;
        this.title = title;
        this.airing = airing;
        this.synopsis = synopsis;
        this.type = type;
        this.episodes = episodes;
        this.score = score;
        this.start_date = start_date;
        this.end_date = end_date;
        this.members = members;
        this.rated = rated;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isAiring() {
        return airing;
    }

    public void setAiring(boolean airing) {
        this.airing = airing;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEpisodes() {
        return episodes;
    }

    public void setEpisodes(String episodes) {
        this.episodes = episodes;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public int getMembers() {
        return members;
    }

    public void setMembers(int members) {
        this.members = members;
    }

    public String getRated() {
        return rated;
    }

    public void setRated(String rated) {
        this.rated = rated;
    }

    @NonNull
    @Override
    public String toString() {
        return getTitle();
    }
}
