package com.jjh.mtvs.presentation.controller.community;

import com.jjh.mtvs.application.service.community.CommunityRoomService;
import com.jjh.mtvs.presentation.dto.common.ObjectDto;
import com.jjh.mtvs.presentation.dto.request.community.CommunityRequestDTO;
import com.jjh.mtvs.presentation.dto.response.community.CommunityResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/community")
@Tag(name = "Community", description = "커뮤니티 관련 API")
@RequiredArgsConstructor
public class CommunityRoomController {

    private final CommunityRoomService communityRoomService;


    @Operation(summary = "내가만든 커뮤맵 목록 조회", description = "사용가자가만든 커뮤니티 목록을 조회합니다.")
    @GetMapping("/my/{userId}")
    public ResponseEntity<Page<CommunityResponseDto>> getMyMaps(@PathVariable Long userId,@PageableDefault(size = 9) Pageable pageable){
        Page<CommunityResponseDto> communityResponseDtos = communityRoomService.getMyMaps(userId,pageable);
        return ResponseEntity.ok(communityResponseDtos);
    }

    @Operation(summary = "즐겨찾기 목록 조회", description = "사용자의 즐겨찾기 커뮤니티 목록을 조회합니다.")
    @GetMapping("/favorites/{userId}")
    public ResponseEntity<Page<CommunityResponseDto>> getFavorites(
            @PathVariable Long userId,
            @PageableDefault(size = 9) Pageable pageable) {
        return ResponseEntity.ok(communityRoomService.getFavorites(userId, pageable));
    }

    @Operation(summary = "최근 커뮤니티 조회", description = "최근 생성된 커뮤니티 목록을 조회합니다.")
    @GetMapping("/recent/{userId}")
    public ResponseEntity<Page<CommunityResponseDto>> getRecent(@PageableDefault(size = 3) Pageable pageable,@PathVariable Long userId) {
        return ResponseEntity.ok(communityRoomService.getRecent(pageable,userId));
    }

    @Operation(summary = "커뮤니티 생성", description = "새로운 커뮤니티를 생성합니다.")
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Boolean> createCommunityRoom(
            @ModelAttribute CommunityRequestDTO dto,
            @RequestPart("objectDtos") List<ObjectDto> objectDtos) {
        return ResponseEntity.ok(communityRoomService.createCommunityRoom(dto,objectDtos));
    }
    @Operation(summary = "커뮤니티 삭제", description = "커뮤니티를 삭제합니다.")
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteCommunityRoom(@PathVariable Long id){
        if(communityRoomService.deleteCommunityRoom(id)){
            return ResponseEntity.ok(true);
        }else{
            return ResponseEntity.ok(false);
        }
    }
}
