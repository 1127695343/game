package entity;

import java.io.Serializable;

/**
 * 功能: 个人信息实体类
 */
public class User implements Serializable {
  public User(String name){
    this.name=name;
    winNum=0;
  }
  private String name;  // 姓名
  private int winNum;  // 战绩
}
