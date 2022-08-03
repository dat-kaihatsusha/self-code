package com.example.demo.Service.Impl;

import com.example.demo.Entity.Sinhvien;
import com.example.demo.Repository.SinhvienRepository;
import com.example.demo.dto.SinhVienHocPhiDTO;
import com.example.demo.dto.SinhvienDTO;
import com.example.demo.handlerexception.CustomException;
import common.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

@Service
public class SinhvienService {

  @Autowired
  SinhvienRepository sinhvienRepository;

  public Sinhvien postSinhvien(SinhvienDTO request) throws CustomException {
    List<Sinhvien> sinhviens = sinhvienRepository.findByHoAndTen(request.getHo(), request.getTen());
    if (!CollectionUtils.isEmpty(sinhviens)) {
      throw new CustomException("sinhvien da ton tai", "duplicate", 1001, HttpStatus.CONFLICT);
    }
    Sinhvien sinhvien = new Sinhvien();
    sinhvien.setHo(request.getHo());
    sinhvien.setTen(request.getTen());
    sinhvien.setDiemthi(request.getDiemthi());

    sinhvienRepository.save(sinhvien);
    return sinhvien;
  }

  public List<Sinhvien> getAllSinhviens() {
    return sinhvienRepository.findAll();
  }

  public Sinhvien findById(Integer sinhvienId) throws CustomException {
    Optional<Sinhvien> sv = sinhvienRepository.findById(sinhvienId);
    sv.orElseThrow(() -> new CustomException("sinh vien khong tim thay", Constant.ERROR_TITLE2, 1001, HttpStatus.NOT_FOUND));
    return sv.get();
  }

  public void delete(Integer sinhvienId) {
    Optional<Sinhvien> sv = sinhvienRepository.findById(sinhvienId);
    sv.orElseThrow(() -> new CustomException("sinh vien not found", Constant.ERROR_TITLE2, 1001, HttpStatus.NOT_FOUND));
    sinhvienRepository.deleteById(sinhvienId);
  }

  public Sinhvien update(SinhvienDTO request, Integer sinhvienId) throws CustomException{
    Optional<Sinhvien> sv = sinhvienRepository.findById(sinhvienId);
    sv.orElseThrow(()->new CustomException("sinh vien not found", Constant.ERROR_TITLE2, 1001, HttpStatus.NOT_FOUND));

    Sinhvien sinhvien = sv.get();
    sinhvien.setHo(request.getHo());
    sinhvien.setTen(request.getTen());
    sinhvien.setDiemthi(request.getDiemthi());

    return sinhvienRepository.saveAndFlush(sinhvien);
  }

  public List<SinhVienHocPhiDTO> getSinhVienHocPhi(){
    return sinhvienRepository.getSinhVienHocPhi();
  }
}
