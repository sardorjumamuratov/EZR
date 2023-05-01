package com.sendi.v1.service;

import com.sendi.v1.service.dto.FlashcardDTO;

import java.util.List;

public interface LearnService {
    List<FlashcardDTO> beginLearningSession(Long deckId);
    void finishLearningSession(Long deckId, List<Long> flashcardIds);
}

