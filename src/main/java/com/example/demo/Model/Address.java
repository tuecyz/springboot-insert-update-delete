package com.example.demo.Model;
import javax.persistence.*;

@Entity
@Table(name = "Addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String etkinlikadi;
    private String baslangictarihi;
    private String bitistarihi;
    private Integer kota;
    private Integer katilimcisayisi;

    public Address(String etkinlikadi,String baslangictarihi,String bitistarihi,Integer kota, Integer katilimcisayisi) {
        this.etkinlikadi = etkinlikadi;
        this.baslangictarihi = baslangictarihi;
        this.bitistarihi = bitistarihi;
        this.kota=kota;
        this.katilimcisayisi=katilimcisayisi;
    }

    public String getEtkinlikadi() {
        return etkinlikadi;
    }

    public Integer getKatilimcisayisi() {
        return katilimcisayisi;
    }

    public void setKatilimcisayisi(Integer katilimcisayisi) {
        this.katilimcisayisi = katilimcisayisi;
    }

    public Integer getKota() {
        return kota;
    }

    public void setKota(Integer kota) {
        this.kota = kota;
    }

    public String getBitistarihi() {
        return bitistarihi;
    }

    public void setBitistarihi(String bitistarihi) {
        this.bitistarihi = bitistarihi;
    }

    public String getBaslangictarihi() {
        return baslangictarihi;
    }

    public void setBaslangictarihi(String baslangictarihi) {
        this.baslangictarihi = baslangictarihi;
    }

    public void setEtkinlikadi(String etkinlikadi) {
        this.etkinlikadi = etkinlikadi;
    }

    public Integer getId() {
        return id;
    }
    public Address() {
    }

}
