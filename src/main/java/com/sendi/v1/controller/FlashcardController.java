package com.sendi.v1.controller;

import com.sendi.v1.service.dto.FlashcardDTO;
import com.sendi.v1.security.permission.FlashcardCreatePermission;
import com.sendi.v1.security.permission.FlashcardDeletePermission;
import com.sendi.v1.security.permission.FlashcardReadPermission;
import com.sendi.v1.security.permission.FlashcardUpdatePermission;
import com.sendi.v1.service.FlashcardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/flashcards")
@RequiredArgsConstructor
public class FlashcardController {
    private final FlashcardService flashcardService;

    @FlashcardReadPermission
    @GetMapping("{deckId}/all")
    public ResponseEntity<List<FlashcardDTO>> getAllFlashcards(@PathVariable Long deckId) {
        return ResponseEntity.ok(flashcardService.getFlashcardsByDeckId(deckId));
    }

    @FlashcardReadPermission
    @GetMapping(value = "{deckId}/all", params = {"page", "size"})
    public ResponseEntity<List<FlashcardDTO>> getAllFlashcards(@RequestParam int page,
                                                               @RequestParam int size,
                                                               @PathVariable Long deckId) {
        PageRequest pageRequest = PageRequest.of(page, size);

        return ResponseEntity.ok(flashcardService.getFlashcardsByDeckId(deckId, pageRequest));
    }

    @FlashcardCreatePermission
    @PostMapping("{deckId}")
    public ResponseEntity<FlashcardDTO> createFlashcard(@PathVariable Long deckId, @RequestBody FlashcardDTO flashcardDTO) {
        return ResponseEntity.ok(flashcardService.createOrUpdate(deckId, flashcardDTO));
    }

    @FlashcardUpdatePermission
    @PutMapping("{deckId}")
    public ResponseEntity<FlashcardDTO> updateFlashcard(@PathVariable Long deckId, @RequestBody FlashcardDTO flashcardDTO) {
        return ResponseEntity.ok(flashcardService.createOrUpdate(deckId, flashcardDTO));
    }

    @FlashcardDeletePermission
    @DeleteMapping("{flashcardId}")
    public ResponseEntity<String> deleteFlashcard(@PathVariable Long flashcardId) {
        flashcardService.deleteById(flashcardId);

        return ResponseEntity.ok("Deleted successfully");
    }

    @FlashcardReadPermission
    @GetMapping("{flashcardId}")
    public ResponseEntity<FlashcardDTO> getFlashcard(@PathVariable Long flashcardId) {
        return ResponseEntity.ok(flashcardService.getOneById(flashcardId));
    }
}
