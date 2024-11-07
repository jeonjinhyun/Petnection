package com.jjh.mtvs.app.presentation.dto.request.auth;

import com.jjh.mtvs.app.presentation.dto.request.user.PetCreateRequestDTO;
import com.jjh.mtvs.app.presentation.dto.request.user.UserCreateRequestDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "회원가입 사용자 DTO")
public class SignupRequestDTO {
    @Schema(description = "사용자 요청 정보")
    private UserCreateRequestDTO userCreateRequestDTO;

    @Schema(description = "반려동물 요청 정보")
    private PetCreateRequestDTO petCreateRequestDto;
}