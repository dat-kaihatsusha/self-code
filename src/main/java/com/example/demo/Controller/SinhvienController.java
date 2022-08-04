package com.example.demo.Controller;

import com.example.demo.Entity.Sinhvien;
import com.example.demo.Service.Impl.SinhvienService;
import com.example.demo.Service.SvHocphiDto;
import com.example.demo.dto.SinhVienHocPhiDTO;
import com.example.demo.dto.SinhvienDTO;
import com.example.demo.dto.SinhvienHpCaoNhatDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/sinhviens")
public class SinhvienController {

  @Autowired
  SinhvienService sinhvienService;

  @PostMapping()
  public ResponseEntity<Sinhvien> postSinhvien(@RequestBody SinhvienDTO request) {
    return ResponseEntity.ok(sinhvienService.postSinhvien(request));
  }

  @GetMapping()
  public ResponseEntity<List<Sinhvien>> getSinhviens() {
    return ResponseEntity.ok(sinhvienService.getAllSinhviens());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Sinhvien> getSinhvienById(@PathVariable Integer id) {
    return ResponseEntity.ok(sinhvienService.findById(id));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteSinhVienById(@PathVariable Integer id) {
    sinhvienService.delete(id);
    return ResponseEntity.ok("success");
  }

  @PutMapping("/{id}")
  public ResponseEntity<Sinhvien> updateSinhvien(@RequestBody SinhvienDTO request, @PathVariable Integer id) {
    return ResponseEntity.ok(sinhvienService.update(request, id));
  }

  // 1. Đây là trường hợp dùng HQL để lấy SinhVienHocPhi
  @GetMapping("/getsinhvienhocphi")
  public ResponseEntity<List<SinhVienHocPhiDTO>> getSinhVienHocPhi() {
    return ResponseEntity.ok(sinhvienService.getSinhVienHocPhi());
  }

  // 2. Đây là trường hợp dùng tuple để hứng data
  @GetMapping("/getsinhvienhocphi2")
  public ResponseEntity<List<SinhVienHocPhiDTO>> getSinhVienHocPhi2() {
    return ResponseEntity.ok(sinhvienService.getSinhVienHocPhi2());
  }

  // 3. Đây là trường hợp dùng cái cụ thể hơn tuple để hứng data
  @GetMapping("/getsinhvienhocphi3")
  public ResponseEntity<List<SvHocphiDto>> getSinhVienHocPhi3() {
    return ResponseEntity.ok(sinhvienService.getSinhVienHocPhi3());
  }

  @GetMapping("/GetSinhvienHpCaoNhat")
  public ResponseEntity<List<SinhvienHpCaoNhatDTO>> GetSinhvienHpCaoNhat() {
    return ResponseEntity.ok(sinhvienService.GetSinhvienHpCaoNhat());
  }

}
