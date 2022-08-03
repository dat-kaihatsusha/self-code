package com.example.demo.Service.Impl;

import com.example.demo.Entity.Hocphik47;
import com.example.demo.Repository.Hocphik47Repository;
import com.example.demo.dto.Hocphik47DTO;
import com.example.demo.handlerexception.CustomException;
import common.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Hocphik47Service {
  @Autowired
  Hocphik47Repository hocphik47Repository;

  public Hocphik47 postHocphik47(Hocphik47DTO request) {
    Hocphik47 hocphik47 = new Hocphik47();
    hocphik47.setTen(request.getTen());
    hocphik47.setHocphi(request.getHocphi());
    hocphik47Repository.save(hocphik47);
    return hocphik47;
  }

  public List<Hocphik47> getAllHocphik47(){
    return hocphik47Repository.findAll();
  }

  public Hocphik47 findById(Integer hocphik47_id) throws CustomException {
    Optional<Hocphik47> hpk47 = hocphik47Repository.findById(hocphik47_id);
    hpk47.orElseThrow(()->new CustomException("Khong tim duoc record hoc phi nay!", Constant.ERROR_TITLE3, 1001, HttpStatus.NOT_FOUND));
    return hpk47.get();
  }

  public void delete(Integer hocphik47_id) throws CustomException{
    Optional<Hocphik47> hocphik47 = hocphik47Repository.findById((hocphik47_id));
    hocphik47.orElseThrow(()->new CustomException("Khong tim duoc record hoc phi nay!", Constant.ERROR_TITLE3, 1001, HttpStatus.NOT_FOUND));
    hocphik47Repository.deleteById(hocphik47_id);
  }

  public Hocphik47 update(Hocphik47DTO request, Integer hocphik47_id) throws CustomException{
    Optional<Hocphik47> hocphik47 = hocphik47Repository.findById((hocphik47_id));
    hocphik47.orElseThrow(()->new CustomException("Khong tim duoc record hoc phi nay!", Constant.ERROR_TITLE3, 1001, HttpStatus.NOT_FOUND));

    Hocphik47 hpk47 = hocphik47.get();

    hpk47.setTen(request.getTen());
    hpk47.setHocphi(request.getHocphi());

    return hocphik47Repository.saveAndFlush(hpk47);
  }

}
