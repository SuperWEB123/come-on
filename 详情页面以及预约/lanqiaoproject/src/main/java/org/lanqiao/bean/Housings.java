package org.lanqiao.bean;

import java.util.List;

public class Housings {
    private List<Housing> housing;
    private List<String> photo;

    public List<Housing> getHousing() {
        return housing;
    }

    public void setHousing(List<Housing> housing) {
        this.housing = housing;
    }

    public List<String> getPhoto() {
        return photo;
    }

    public void setPhoto(List<String> photo) {
        this.photo = photo;
    }
}
