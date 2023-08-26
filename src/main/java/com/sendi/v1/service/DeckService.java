package com.sendi.v1.service;

import com.sendi.v1.service.model.DeckDTO;
import com.sendi.v1.security.domain.User;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DeckService {
    DeckDTO getOneById(Long id);

    DeckDTO getOneByIdWithoutFlashcards(Long id);

//    List<DeckDTO> getDecksByUser(User user);
//
//    List<DeckDTO> getDecksByUser(User user, Pageable pageable);
//
//    List<DeckDTO> getDecksByUser(User user, int page, int size);

    List<DeckDTO> getDecksByUserId(Long userId);

    List<DeckDTO> getDecksByUserId(Long userId, int page, int size);

    List<DeckDTO> getDecksInfoByUserId(Long userId);

    List<DeckDTO> getDecksInfoByUserId(Long userId, int page, int size);

    DeckDTO createOrUpdate(Long userId, DeckDTO deckDTO);

    void deleteById(Long deckId);

    boolean existsById(Long deckId);
}
