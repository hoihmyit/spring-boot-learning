package com.spl.hm.config.mapper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Champion {
    private String champion;
    private String fullName;
    private String avatar;
    private List<Skin> skins;
    private List<String> classes;
    private List<String> positions;
    private String resource;
    private String rangeType;
    private String adaptiveType;
    private Ability abilities;

    public String getChampion() {
        return champion;
    }

    public void setChampion(String champion) {
        this.champion = champion;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List<Skin> getSkins() {
        return skins;
    }

    public void setSkins(List<Skin> skins) {
        this.skins = skins;
    }

    public List<String> getClasses() {
        return classes;
    }

    public void setClasses(List<String> classes) {
        this.classes = classes;
    }

    public List<String> getPositions() {
        return positions;
    }

    public void setPositions(List<String> positions) {
        this.positions = positions;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getRangeType() {
        return rangeType;
    }

    public void setRangeType(String rangeType) {
        this.rangeType = rangeType;
    }

    public String getAdaptiveType() {
        return adaptiveType;
    }

    public void setAdaptiveType(String adaptiveType) {
        this.adaptiveType = adaptiveType;
    }

    public Ability getAbilities() {
        return abilities;
    }

    public void setAbilities(Ability abilities) {
        this.abilities = abilities;
    }

    @Override
    public String toString() {
        return "Champion{" +
                "champion='" + champion + '\'' +
                ", fullName='" + fullName + '\'' +
                ", avatar='" + avatar + '\'' +
                ", skins=" + skins +
                ", classes=" + classes +
                ", positions=" + positions +
                ", resource='" + resource + '\'' +
                ", rangeType='" + rangeType + '\'' +
                ", adaptiveType='" + adaptiveType + '\'' +
                ", abilities=" + abilities +
                '}';
    }
}
