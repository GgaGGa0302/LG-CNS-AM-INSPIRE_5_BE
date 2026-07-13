package com.inspire.lgcnsaminspire_5_be.bookmark.repository;

import com.inspire.lgcnsaminspire_5_be.bookmark.domain.entity.BookmarkEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookmarkRepository extends JpaRepository<BookmarkEntity, Long> {
    boolean existsByUser_UserIdAndFestival_FestivalId(Long userId, Long festivalId);
    List<BookmarkEntity> findAllByUser_UserId(Long userId);
}
