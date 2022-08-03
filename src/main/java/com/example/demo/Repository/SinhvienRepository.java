package com.example.demo.Repository;

import com.example.demo.Entity.Sinhvien;
import com.example.demo.dto.SinhVienHocPhiDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SinhvienRepository extends JpaRepository<Sinhvien, Integer> {
  List<Sinhvien> findByTen(String ten);
  List<Sinhvien> findByHoAndTen(String ho , String ten);

  @Query(value = " select new com.example.demo.dto.SinhVienHocPhiDTO(s.ten, hp.hocphi) from " +
      " Sinhvien s inner join Hocphik47 hp" +
      " on s.ten = hp.ten ")
  List<SinhVienHocPhiDTO> getSinhVienHocPhi();
}