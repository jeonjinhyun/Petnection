package com.jjh.mtvs.app.presentation.controller;

import com.jjh.mtvs.app.application.facade.MainPageFacadeService;
import com.jjh.mtvs.app.presentation.dto.response.MainPageDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/main")
@Tag(name = "Main Page", description = "메인 페이지 관련 API")
@RequiredArgsConstructor
public class MainPageController {
    private final MainPageFacadeService mainPageFacadeService;

    @Operation(summary = "메인 페이지 조회", description = "사용자의 메인 페이지 정보를 조회합니다.")
    @GetMapping("/{userId}")
    public ResponseEntity<MainPageDto> getMainPage(
            @Parameter(description = "사용자 ID", required = true)
            @PathVariable Long userId) {
        return ResponseEntity.ok(mainPageFacadeService.getMainPage(userId));
    }
}
