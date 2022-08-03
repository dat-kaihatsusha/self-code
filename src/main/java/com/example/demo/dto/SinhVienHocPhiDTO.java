package com.example.demo.dto;

public class SinhVienHocPhiDTO {
  private String ten;
  private Integer hocphi;

  public SinhVienHocPhiDTO() {
  }

  public SinhVienHocPhiDTO(String ten, Integer hocphi) {
    this.ten = ten;
    this.hocphi = hocphi;
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
