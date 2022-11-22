package com.hamid.redis.questionnaire;

import static javax.persistence.GenerationType.AUTO;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Questionnaire implements Serializable {

  @Id
  @GeneratedValue(strategy = AUTO)
  private Long id;

  private String code;
  private String questionEn;
  private String questionFa;

  public Questionnaire() {}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getQuestionEn() {
    return questionEn;
  }

  public void setQuestionEn(String questionEn) {
    this.questionEn = questionEn;
  }

  public String getQuestionFa() {
    return questionFa;
  }

  public void setQuestionFa(String questionFa) {
    this.questionFa = questionFa;
  }
}
