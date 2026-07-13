package com.inspire.lgcnsaminspire_5_be.bookmark.controller;

import com.inspire.lgcnsaminspire_5_be.bookmark.domain.dto.BookmarkRequestDTO;
import com.inspire.lgcnsaminspire_5_be.bookmark.domain.dto.BookmarkResponseDTO;
import com.inspire.lgcnsaminspire_5_be.bookmark.service.BookmarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BookmarkController {

    private final BookmarkService bookmarkService;

    @PostMapping("/bookmark")
    public ResponseEntity<?> createBookmark(@RequestBody BookmarkRequestDTO request) {
        System.out.println(">>>> debug bookmark Controller createBookmark");
        System.out.println(">>>> debug params : " + request);

        // 임시 데이터
        Long tempUserId = 2L;
        bookmarkService.createBookmark(tempUserId ,request);

        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    @GetMapping("/bookmark")
    public ResponseEntity<?> getBookmark() {
        System.out.println(">>>> debug bookmark Controller getBookmark");

        // 임시 데이터
        Long tempUserId = 2L;
        List<BookmarkResponseDTO> response = bookmarkService.getBookmark(tempUserId);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
