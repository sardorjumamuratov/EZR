package com.sendi.v1.test.question;

import com.sendi.v1.domain.Flashcard;
import com.sendi.v1.test.AnswerWith;
import com.sendi.v1.test.QuestionAnswerUtil;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class WrittenQuestion extends Question {
    private String answer;

    public WrittenQuestion prepareQuestion(Flashcard flashcard, AnswerWith answerWith) {
        String actualQuestion = QuestionAnswerUtil.getQuestion(flashcard, answerWith);;
        String actualAnswer = QuestionAnswerUtil.getAnswer(flashcard, answerWith);

        WrittenQuestion writtenQuestion = WrittenQuestion.builder()
                .question(actualQuestion)
                .answer(actualAnswer)
                .flashcardId(flashcard.getId())
                .build();

        return writtenQuestion;
    }
}
