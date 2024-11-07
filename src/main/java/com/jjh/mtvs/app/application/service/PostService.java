package com.jjh.mtvs.app.application.service;

import com.jjh.mtvs.app.presentation.dto.request.community.PostRequestDTO;
import com.jjh.mtvs.app.presentation.dto.response.PostResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostService {
    Boolean createPost(PostRequestDTO dto);
    Page<PostResponseDto> getPostsByCommunityRoomId(Long communityRoomId, Pageable pageable);
    Boolean deletePost(Long id);
}
