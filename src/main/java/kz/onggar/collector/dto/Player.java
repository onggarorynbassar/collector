package kz.onggar.collector.dto;

import java.util.UUID;

public class Player {
    private UUID id;
    private String steamId;
    private int simpleMmr;
    private int competitiveMmr;
    private int relativeMmr;

    public String getSteamId() {
        return steamId;
    }

    public void setSteamId(String steamId) {
        this.steamId = steamId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public int getSimpleMmr() {
        return simpleMmr;
    }

    public void setSimpleMmr(int simpleMmr) {
        this.simpleMmr = simpleMmr;
    }

    public int getCompetitiveMmr() {
        return competitiveMmr;
    }

    public void setCompetitiveMmr(int competitiveMmr) {
        this.competitiveMmr = competitiveMmr;
    }

    public int getRelativeMmr() {
        return relativeMmr;
    }

    public void setRelativeMmr(int relativeMmr) {
        this.relativeMmr = relativeMmr;
    }

}


