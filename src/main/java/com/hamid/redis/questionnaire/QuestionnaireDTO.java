package com.hamid.redis.questionnaire;

public class QuestionnaireDTO {
  private Long id;
  private String code;
  private String questionEn;
  private String questionFa;

  public QuestionnaireDTO() {}

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
