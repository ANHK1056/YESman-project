package com.kosa.projectdeveloper.service;

import com.kosa.projectdeveloper.domain.Interest;
import com.kosa.projectdeveloper.dto.AddInterestRequest;
import com.kosa.projectdeveloper.repository.InterestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class InterestService {
    private final InterestRepository interestRepository;

    public Interest save(AddInterestRequest request) {
        return interestRepository.save(request.toEntity());
    }

    // 모든 예매 조회
    public List<Interest> findAllInterests(){
        return interestRepository.findAll();
    }

    // 예매 취소
    public void deleteByInterestId(long interestId){
        interestRepository.deleteById(interestId);
    }
}
