package br.com.nord.repository;

import br.com.nord.model.Panel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PanelRepository extends JpaRepository<Panel, Long>{
}
