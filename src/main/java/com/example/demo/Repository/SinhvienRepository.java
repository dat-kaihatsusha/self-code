package com.example.demo.Repository;

import com.example.demo.Entity.Sinhvien;
import com.example.demo.Service.SvHocphiDto;
import com.example.demo.dto.SinhVienHocPhiDTO;
import com.example.demo.dto.SinhvienHpCaoNhatDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.Tuple;
import java.util.List;

@Repository
public interface SinhvienRepository extends JpaRepository<Sinhvien, Integer> {
  List<Sinhvien> findByTen(String ten);
  List<Sinhvien> findByHoAndTen(String ho , String ten);

  // 1. Đây là trường hợp dùng HQL để lấy SinhVienHocPhi
  @Query(value = " select new com.example.demo.dto.SinhVienHocPhiDTO(s.ten, hp.hocphi) from " +
      " Sinhvien s inner join Hocphik47 hp " +
      " on s.ten = hp.ten ")
  List<SinhVienHocPhiDTO> getSinhVienHocPhi();

  // 2. Đây là trường hợp dùng tuple để hứng data
  @Query(value = " select sinhvien.ten, hocphik47.hocphi from " +
      " sinhvien inner join hocphik47 " +
      " on sinhvien.ten = hocphik47.ten ", nativeQuery = true)
  List<Tuple> getSinhVienHocPhi2();

  // 3. Đây là trường hợp dùng cái cụ thể hơn tuple để hứng data
  @Query(value = " select sinhvien.ten, hocphik47.hocphi from " +
      " sinhvien inner join hocphik47 " +
      " on sinhvien.ten = hocphik47.ten ", nativeQuery = true)
  List<SvHocphiDto> getSinhVienHocPhi3();

  // 4. Đây là trường hợp sử dụng store procedure
  @Query(value = "call GetSinhvienHpCaoNhatThapNhat()", nativeQuery = true)
  List<SinhvienHpCaoNhatDTO> GetSinhvienHpCaoNhat();

  //5. Đây là trường hợp sử dụng store function trong mysql
  @Query(value = "select hocPhiTrungBinh()", nativeQuery = true)
  Float hocPhiTrungBinh();

}