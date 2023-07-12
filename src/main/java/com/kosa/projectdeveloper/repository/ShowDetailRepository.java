package com.kosa.projectdeveloper.repository;

import com.kosa.projectdeveloper.domain.ShowDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ShowDetailRepository extends JpaRepository<ShowDetail, String> {

//    Optional<ShowDetail> findByShowId(String show_id);

    public List<ShowDetail> findByShowActorContaining(String actorName);
    public List<ShowDetail> findByShowNameContaining(String showName);
}
