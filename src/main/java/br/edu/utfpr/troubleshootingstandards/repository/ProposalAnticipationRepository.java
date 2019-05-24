package br.edu.utfpr.troubleshootingstandards.repository;

import br.edu.utfpr.troubleshootingstandards.model.Anticipation; // não acho necessária a importação de Anticipation neste arquivo
import br.edu.utfpr.troubleshootingstandards.model.ProposalAnticipation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProposalAnticipationRepository extends JpaRepository<ProposalAnticipation, Long> {}
