package com.hamid.redis.questionnaire;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionnaireController {

  private final Logger LOGGER = LogManager.getLogger(QuestionnaireController.class);

  private final QuestionnaireService questionnaireService;

  public QuestionnaireController(QuestionnaireService questionnaireService) {
    this.questionnaireService = questionnaireService;
  }

  @PostMapping("/questionnaire")
  public ResponseEntity<QuestionnaireDTO> createQuestionnaire(@RequestBody QuestionnaireDTO questionnaireDTO) {
    LOGGER.info("Request to create a questionnaire");
    questionnaireDTO = questionnaireService.saveQuestionnaire(questionnaireDTO);
    return ResponseEntity.ok(questionnaireDTO);
  }

  @PatchMapping("/questionnaire/{questionnaireId}")
  public ResponseEntity<QuestionnaireDTO> updateQuestionnaire(
      @PathVariable Long questionnaireId, @RequestBody QuestionnaireDTO questionnaireDTO) {
    LOGGER.info("Request to update a questionnaire");
    questionnaireDTO = questionnaireService.updateQuestionnaire(questionnaireId, questionnaireDTO);
    return ResponseEntity.ok(questionnaireDTO);
  }

  @GetMapping("/questionnaire/{questionnaireId}")
  public ResponseEntity<QuestionnaireDTO> getQuestionnaire(@PathVariable Long questionnaireId) {
    QuestionnaireDTO questionnaireDTO = questionnaireService.getQuestionnaireById(questionnaireId);
    return ResponseEntity.ok(questionnaireDTO);
  }

  @DeleteMapping("/questionnaire/{questionnaireId}")
  public ResponseEntity<Long> deleteQuestionnaire(@PathVariable Long questionnaireId) {
    questionnaireService.deleteQuestionnaireById(questionnaireId);
    return ResponseEntity.ok(questionnaireId);
  }

  @GetMapping("/questionnaire")
  public ResponseEntity<List<QuestionnaireDTO>> getQuestionnaires() {
    LOGGER.info("Request to get all questionnaires");
    List<QuestionnaireDTO> allQuestionnaires = questionnaireService.getAllQuestionnaires();
    return ResponseEntity.ok(allQuestionnaires);
  }
}
