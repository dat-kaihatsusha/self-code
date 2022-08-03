package com.example.demo.Controller;

import com.example.demo.Entity.Hocphik47;
import com.example.demo.Service.Impl.Hocphik47Service;
import com.example.demo.dto.Hocphik47DTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/hocphik47s")
public class Hocphik47Controller {
  @Autowired
  Hocphik47Service hocphik47Service;

  @PostMapping()
  public ResponseEntity<Hocphik47> postHocphik47(@RequestBody Hocphik47DTO request) {
    return ResponseEntity.ok(hocphik47Service.postHocphik47(request));
  }

  @GetMapping()
  public ResponseEntity<List<Hocphik47>> getAllHocphik47() {
    return ResponseEntity.ok(hocphik47Service.getAllHocphik47());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Hocphik47> findById(@PathVariable Integer id) {
    return ResponseEntity.ok(hocphik47Service.findById(id));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> delete(@PathVariable Integer id) {
    hocphik47Service.delete(id);
    return ResponseEntity.ok("Success");
  }

  @PutMapping("/{id}")
  public ResponseEntity<Hocphik47> update(@PathVariable Integer id, @RequestBody Hocphik47DTO request) {
    return ResponseEntity.ok(hocphik47Service.update(request, id));
  }
}
