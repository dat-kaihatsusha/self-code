package com.example.demo.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "sinhvien")
@Data
@NoArgsConstructor
public class Sinhvien {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "mssv")
  private Integer mssv;

  @Column(name = "ho")
  private String ho;

  @Column(name = "ten")
  private String ten;

  @Column(name = "diemthi")
  private Integer diemthi;
}
