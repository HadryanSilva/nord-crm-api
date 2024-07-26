package br.com.nord.api.repository;

import br.com.nord.api.model.Panel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PanelRepository extends JpaRepository<Panel, Long> {

    Page<Panel> findAll(Pageable pageable);

}
