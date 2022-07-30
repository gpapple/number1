package cn.itcast.domain;

import java.io.Serializable;
import java.security.SecureRandom;
import java.util.Date;

public class Goods implements Serializable {

    private Integer gid;
    private String gname;
    private String image;
    private String introduction;
    private Double price;
    private String gdate;
    private Type type;

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getGdate() {
        return gdate;
    }

    public void setGdate(String gdate) {
        this.gdate = gdate;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "gid=" + gid +
                ", gname='" + gname + '\'' +
                ", image='" + image + '\'' +
                ", introduction='" + introduction + '\'' +
                ", price=" + price +
                ", gdate='" + gdate + '\'' +
                ", type=" + type +
                '}';
    }
}
