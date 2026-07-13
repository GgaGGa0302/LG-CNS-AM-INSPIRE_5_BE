package com.inspire.lgcnsaminspire_5_be.bookmark.domain.dto;

import com.inspire.lgcnsaminspire_5_be.festival.domain.entity.FestivalEntity;
import lombok.*;

@Builder
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BookmarkRequestDTO {
    private String contentId;
    private String title;
    private String region;
    private String imageUrl;
    private String content;
    private String aiInfo;

    public FestivalEntity toFestivalEntity() {
        return FestivalEntity.builder()
                .contentId(this.contentId)
                .title(this.title)
                .region(this.region)
                .imageUrl(this.imageUrl)
                .content(this.content)
                .aiInfo(this.aiInfo)
                .build();
    }
}
