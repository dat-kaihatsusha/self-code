package com.example.demo.Service;

import com.fasterxml.jackson.annotation.JsonProperty;

public interface SvHocphiDto {

  @JsonProperty("name")
    // dùng để thay thế tên của field khi trả ra thay vì là "ten" thì sẽ là "name"
  String getTen();

  Integer getHocphi(); // bắt buộc phải có get đằng trước, thì spring sẽ tự cắt chuỗi đó sau get để lấy thành tên cột.
}
