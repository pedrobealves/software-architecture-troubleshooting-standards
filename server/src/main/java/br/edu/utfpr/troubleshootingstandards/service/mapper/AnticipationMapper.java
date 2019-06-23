package br.edu.utfpr.troubleshootingstandards.service.mapper;

import br.edu.utfpr.troubleshootingstandards.dto.AnticipationDTO;
import br.edu.utfpr.troubleshootingstandards.dto.LessonDTO;
import br.edu.utfpr.troubleshootingstandards.dto.ProposalAnticipationDTO;
import br.edu.utfpr.troubleshootingstandards.entity.Anticipation;
import br.edu.utfpr.troubleshootingstandards.entity.Lesson;
import br.edu.utfpr.troubleshootingstandards.entity.ProposalAnticipation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper
public interface AnticipationMapper {


    ProposalAnticipationDTO toProposalAnticipationDTO(ProposalAnticipation proposalAnticipation);

    ProposalAnticipation toProposalAnticipation(ProposalAnticipationDTO proposalAnticipationDTO);

    List<ProposalAnticipationDTO> toProposalAnticipationDTO(List<ProposalAnticipation> proposalAnticipation);

    @Mapping(source = "modalitie", target = "modalitie")
    Anticipation toAticipation(AnticipationDTO anticipationDTO);

}
