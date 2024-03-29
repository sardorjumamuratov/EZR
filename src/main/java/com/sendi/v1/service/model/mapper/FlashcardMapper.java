package com.sendi.v1.service.model.mapper;

import com.sendi.v1.domain.Flashcard;
import com.sendi.v1.service.model.FlashcardDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.io.*;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface FlashcardMapper {
    FlashcardMapper INSTANCE = Mappers.getMapper(FlashcardMapper.class);

    FlashcardDTO toDTO(Flashcard flashcard);
    Flashcard toEntity(FlashcardDTO flashcardDTO) throws IOException;

    Set<FlashcardDTO> toDTOs(Set<Flashcard> flashcards);

    Set<Flashcard> toEntities(Set<FlashcardDTO> flashcardDTOS);
}

