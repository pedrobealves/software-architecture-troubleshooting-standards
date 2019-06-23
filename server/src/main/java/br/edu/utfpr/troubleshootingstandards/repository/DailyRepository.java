package br.edu.utfpr.troubleshootingstandards.repository;

import br.edu.utfpr.troubleshootingstandards.entity.Daily;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyRepository extends JpaRepository<Daily, Long> {}
