package com.hamid.redis.questionnaire;

public class QuestionnaireNotFoundException extends RuntimeException {

  public QuestionnaireNotFoundException() {
    super();
  }

  public QuestionnaireNotFoundException(Long id) {
    super(String.format("Questionnaire with id of %d not found", id));
  }
}
