package com.jjh.mtvs.app.application.serviceimpl;

import com.jjh.mtvs.app.application.facade.JoinFacadeService;
import com.jjh.mtvs.app.application.mapper.PetMapper;
import com.jjh.mtvs.app.application.mapper.UserMapper;
import com.jjh.mtvs.common.util.file.FileUploadService;
import com.jjh.mtvs.app.domain.model.user.entity.Pet;
import com.jjh.mtvs.app.domain.model.user.entity.User;
import com.jjh.mtvs.app.domain.repository.UserRepository;
import com.jjh.mtvs.app.presentation.dto.request.auth.SignupRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class JoinFacadeServiceImpl implements JoinFacadeService {

    private final UserMapper userMapper;
    private final PetMapper petMapper;
    private final UserRepository userRepository;
    private final FileUploadService fileUploadService;

    @Override
    @Transactional
    public Boolean join(SignupRequestDTO signupRequestDTO) {
        try {
            // 1. User 저장
            User user = userMapper.toUser(signupRequestDTO.getUserCreateRequestDTO());
            user.setImgUrl(fileUploadService.uploadFile(signupRequestDTO.getUserCreateRequestDTO().getImgFile()));
            user = userRepository.save(user);

            // 2. Pet 생성 및 연결 
            Pet pet = petMapper.toPet(signupRequestDTO.getPetCreateRequestDto());
            user.setPet(pet);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}