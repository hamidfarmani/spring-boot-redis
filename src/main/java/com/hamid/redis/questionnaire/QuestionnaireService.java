package com.hamid.redis.questionnaire;

import static com.hamid.redis.utils.Mapper.mapInstance;
import static com.hamid.redis.utils.Mapper.mapList;

import java.util.List;
import javax.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class QuestionnaireService {

  private final Logger LOGGER = LogManager.getLogger(QuestionnaireService.class);

  private final QuestionnaireRepository questionnaireRepository;

  public QuestionnaireService(QuestionnaireRepository questionnaireRepository) {
    this.questionnaireRepository = questionnaireRepository;
  }

  public QuestionnaireDTO saveQuestionnaire(QuestionnaireDTO questionnaireDTO) {
    LOGGER.info("Saving a questionnaire with code of {}", questionnaireDTO.getCode());

    Questionnaire questionnaire = new Questionnaire();
    questionnaire.setCode(questionnaireDTO.getCode());
    questionnaire.setQuestionEn(questionnaireDTO.getQuestionEn());
    questionnaire.setQuestionFa(questionnaireDTO.getQuestionFa());
    questionnaire = questionnaireRepository.save(questionnaire);
    return mapInstance(questionnaire, QuestionnaireDTO.class);
  }

  public QuestionnaireDTO updateQuestionnaire(
      Long questionnaireId, QuestionnaireDTO questionnaireDTO) {
    LOGGER.info("Updating a questionnaire with id of {}", questionnaireId);

    Questionnaire questionnaire =
        questionnaireRepository
            .findById(questionnaireId)
            .orElseThrow(() -> new QuestionnaireNotFoundException(questionnaireId));

    questionnaire.setCode(questionnaireDTO.getCode());
    questionnaire.setQuestionEn(questionnaireDTO.getQuestionEn());
    questionnaire.setQuestionFa(questionnaireDTO.getQuestionFa());
    questionnaire = questionnaireRepository.save(questionnaire);
    return mapInstance(questionnaire, QuestionnaireDTO.class);
  }

  public Questionnaire getQuestionnaireByCode(String code) {
    LOGGER.info("Getting a questionnaire by code {}", code);
    return questionnaireRepository.findQuestionnaireByCode(code).orElseThrow();
  }

  public QuestionnaireDTO getQuestionnaireById(Long id) {
    LOGGER.info("Getting a questionnaire with id of {}", id);
    Questionnaire questionnaire =
        questionnaireRepository
            .findById(id)
            .orElseThrow(() -> new QuestionnaireNotFoundException(id));
    return mapInstance(questionnaire, QuestionnaireDTO.class);
  }

  public List<QuestionnaireDTO> getAllQuestionnaires() {
    LOGGER.info("Getting all questionnaires from the database");
    List<Questionnaire> questionnaires = questionnaireRepository.findAll();
    return mapList(questionnaires, QuestionnaireDTO.class);
  }
}
