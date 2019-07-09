package br.edu.utfpr.troubleshootingstandards.service.mapper;

import br.edu.utfpr.troubleshootingstandards.dto.AnticipationDTO;
import br.edu.utfpr.troubleshootingstandards.dto.ProposalAnticipationDTO;
import br.edu.utfpr.troubleshootingstandards.model.Anticipation;
import br.edu.utfpr.troubleshootingstandards.model.ProposalAnticipation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface AnticipationMapper {
    ProposalAnticipationDTO toProposalAnticipationDTO(ProposalAnticipation proposalAnticipation);
    ProposalAnticipation toProposalAnticipation(ProposalAnticipationDTO proposalAnticipationDTO);
    List<ProposalAnticipationDTO> toProposalAnticipationDTO(List<ProposalAnticipation> proposalAnticipation);
    @Mapping(source = "modalitie", target = "modalitie")
    Anticipation toAticipation(AnticipationDTO anticipationDTO);
}
