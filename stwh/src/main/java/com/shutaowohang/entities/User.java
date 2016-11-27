package com.shutaowohang.entities;

import cn.bmob.v3.BmobUser;

/**
 * Created by 78421 on 2016/11/23.
 */

public class User extends BmobUser {
  private Integer age;
  private Boolean gender;

  public User() {

  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Boolean getGender() {
    return gender;
  }

  public void setGender(Boolean gender) {
    this.gender = gender;
  }
}
