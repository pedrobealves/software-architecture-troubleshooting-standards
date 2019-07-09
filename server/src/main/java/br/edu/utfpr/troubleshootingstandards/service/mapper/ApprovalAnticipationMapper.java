package br.edu.utfpr.troubleshootingstandards.service.mapper;

import br.edu.utfpr.troubleshootingstandards.dto.ApprovalAnticipationDTO;
import br.edu.utfpr.troubleshootingstandards.model.ApprovalAnticipation;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface ApprovalAnticipationMapper {
    ApprovalAnticipation toApprovalAnticipation(ApprovalAnticipationDTO approvalAnticipationDTO);
    ApprovalAnticipationDTO toApprovalAnticipationDTO(ApprovalAnticipation approvalAnticipation);
    List<ApprovalAnticipationDTO> toApprovalAnticipationDTO(List<ApprovalAnticipation> approvalAnticipationDTO);
}
