package com.gahra.ahmed.gahra.model;

/**
 * Created by ahmed on 1/18/2017.
 */
public class BusniessModel {

    private String name;
    private String start;
    private String end;
//    private String imagePath;
//    private String imageLogo;
      private int imagePath;
     private int imageLogo;
    int flagFav;
    int flagFeatured;

    public BusniessModel() {
    }

    public BusniessModel(String name, String start, String end, int imagePath, int imageLogo) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.imagePath = imagePath;
        this.imageLogo = imageLogo;
    }

    public BusniessModel(String name, String start, String end, int imagePath, int imageLogo, int flagFav, int flagFeatured) {
        this.name = name;
        this.start = start;
        this.end = end;
        this.imagePath = imagePath;
        this.imageLogo = imageLogo;
        this.flagFav = flagFav;
        this.flagFeatured = flagFeatured;
    }

    public int getFlagFav() {
        return flagFav;
    }

    public void setFlagFav(int flagFav) {
        this.flagFav = flagFav;
    }

    public int getFlagFeatured() {
        return flagFeatured;
    }

    public void setFlagFeatured(int flagFeatured) {
        this.flagFeatured = flagFeatured;
    }

    public int getImagePath() {
        return imagePath;
    }

    public void setImagePath(int imagePath) {
        this.imagePath = imagePath;
    }

    public int getImageLogo() {
        return imageLogo;
    }

    public void setImageLogo(int imageLogo) {
        this.imageLogo = imageLogo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }


}
