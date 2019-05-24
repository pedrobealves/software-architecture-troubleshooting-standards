package br.edu.utfpr.troubleshootingstandards.repository;

import br.edu.utfpr.troubleshootingstandards.model.Daily;
import br.edu.utfpr.troubleshootingstandards.model.ProposalAnticipation; // não acho necessária a importação de ProposalAnticipation neste arquivo
import org.springframework.data.jpa.repository.JpaRepository;

public interface DailyRepository extends JpaRepository<Daily, Long> {}
