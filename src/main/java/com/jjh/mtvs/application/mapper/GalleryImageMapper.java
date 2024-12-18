package com.jjh.mtvs.application.mapper;

import com.jjh.mtvs.domain.model.myroom.entity.GalleryImage;
import com.jjh.mtvs.presentation.dto.request.myroom.GalleryImageRequestDTO;
import com.jjh.mtvs.presentation.dto.response.myroom.GalleryImageResponseDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GalleryImageMapper {
    GalleryImageResponseDto toGalleryImageResponseDto(GalleryImage galleryImage);
    List<GalleryImageResponseDto> toGalleryImageResponseDto(List<GalleryImage> galleryImages);
}
