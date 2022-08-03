package com.example.demo.Entity;

import javax.persistence.*;

@Entity
@Table(name = "hocphik47")
public class Hocphik47 {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "hocphik47_id")
  Integer hocphik47Id;

  @Column(name = "ten")
  String ten;

  @Column(name = "hocphi")
  Integer hocphi;

  public Hocphik47() {
  }

  public Hocphik47(Integer hocphik47Id, String ten, Integer hocphi) {
    this.hocphik47Id = hocphik47Id;
    this.ten = ten;
    this.hocphi = hocphi;
  }

  public Integer getHocphik47Id() {
    return hocphik47Id;
  }

  public void setHocphik47Id(Integer hocphik47Id) {
    this.hocphik47Id = hocphik47Id;
  }

  public String getTen() {
    return ten;
  }

  public void setTen(String ten) {
    this.ten = ten;
  }

  public Integer getHocphi() {
    return hocphi;
  }

  public void setHocphi(Integer hocphi) {
    this.hocphi = hocphi;
  }
}
