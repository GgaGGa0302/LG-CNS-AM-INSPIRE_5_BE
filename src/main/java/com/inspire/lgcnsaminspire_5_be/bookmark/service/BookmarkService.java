package com.inspire.lgcnsaminspire_5_be.bookmark.service;

import com.inspire.lgcnsaminspire_5_be.auth.repository.UserRepository;
import com.inspire.lgcnsaminspire_5_be.bookmark.domain.dto.BookmarkRequestDTO;
import com.inspire.lgcnsaminspire_5_be.bookmark.domain.dto.BookmarkResponseDTO;
import com.inspire.lgcnsaminspire_5_be.bookmark.domain.entity.BookmarkEntity;
import com.inspire.lgcnsaminspire_5_be.bookmark.repository.BookmarkRepository;
import com.inspire.lgcnsaminspire_5_be.festival.domain.entity.FestivalEntity;
import com.inspire.lgcnsaminspire_5_be.festival.repository.FestivalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookmarkService {

    private final BookmarkRepository bookmarkRepository;
    private final FestivalRepository festivalRepository;
    private final UserRepository userRepository;

    public void createBookmark(Long userId, BookmarkRequestDTO dto) {
        FestivalEntity festival = festivalRepository.findByContentId(dto.getContentId())
                .orElseGet(() -> festivalRepository.save(dto.toFestivalEntity()));

        if (bookmarkRepository.existsByUser_UserIdAndFestival_FestivalId(userId, festival.getFestivalId())) {
            throw new IllegalStateException("이미 찜한 축제입니다.");
        }

        BookmarkEntity bookmark = BookmarkEntity.builder()
                .user(userRepository.getReferenceById(userId))
                .festival(festival)
                .userMemo(null)
                .build();
        bookmarkRepository.save(bookmark);
    }

    public List<BookmarkResponseDTO> getBookmark(Long tempUserId) {
        return bookmarkRepository.findAllByUser_UserId(tempUserId)
                .stream()
                .map(BookmarkResponseDTO::fromEntity)
                .toList();
    }
}
