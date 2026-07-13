package com.inspire.lgcnsaminspire_5_be.bookmark.controller;

import com.inspire.lgcnsaminspire_5_be.bookmark.domain.dto.BookmarkRequestDTO;
import com.inspire.lgcnsaminspire_5_be.bookmark.domain.dto.BookmarkResponseDTO;
import com.inspire.lgcnsaminspire_5_be.bookmark.domain.dto.BookmarkUpdateRequestDTO;
import com.inspire.lgcnsaminspire_5_be.bookmark.service.BookmarkService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BookmarkController {

    private final BookmarkService bookmarkService;

    @PostMapping("/bookmark")
    public ResponseEntity<?> createBookmark(@Valid @RequestBody BookmarkRequestDTO request) {
        System.out.println(">>>> debug bookmark Controller createBookmark");
        System.out.println(">>>> debug params : " + request);

        Long tempUserId = 2L;
        bookmarkService.createBookmark(tempUserId, request);

        return buildResponse(HttpStatus.CREATED, "관심 축제로 등록되었습니다.");
    }

    @GetMapping("/bookmark")
    public ResponseEntity<?> getBookmark() {
        System.out.println(">>>> debug bookmark Controller getBookmark");

        Long tempUserId = 2L;
        List<BookmarkResponseDTO> response = bookmarkService.getBookmark(tempUserId);

        Map<String, Object> body = new HashMap<>();
        body.put("status", "success");
        body.put("data", response);
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    @PutMapping("/bookmark/{bookmarkId}")
    public ResponseEntity<?> putBookmark(
            @PathVariable Long bookmarkId,
            @Valid @RequestBody BookmarkUpdateRequestDTO request) {
        System.out.println(">>>> debug bookmark Controller putBookmark");
        System.out.println(">>>> debug bookmark Controller putBookmark params" + bookmarkId);
        System.out.println(">>>> debug bookmark Controller putBookmark body" + request);

        Long tempUserId = 2L;
        bookmarkService.putBookmark(tempUserId, bookmarkId, request);

        return buildResponse(HttpStatus.OK, "메모가 수정되었습니다.");
    }

    @DeleteMapping("/bookmark/{bookmarkId}")
    public ResponseEntity<?> deleteBookmark(@PathVariable Long bookmarkId) {
        System.out.println(">>>> debug bookmark Controller deleteBookmark");
        System.out.println(">>>> debug bookmark Controller deleteBookmark params" + bookmarkId);

        Long tempUserId = 2L;
        bookmarkService.deleteBookmark(tempUserId, bookmarkId);

        return buildResponse(HttpStatus.OK, "찜 목록에서 삭제되었습니다.");
    }

    private ResponseEntity<?> buildResponse(HttpStatus status, String message) {
        Map<String, Object> body = new HashMap<>();
        body.put("status", "success");
        body.put("message", message);
        return ResponseEntity.status(status).body(body);
    }
}
