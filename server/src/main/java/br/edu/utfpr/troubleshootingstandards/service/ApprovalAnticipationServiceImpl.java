package br.edu.utfpr.troubleshootingstandards.service;

import br.edu.utfpr.troubleshootingstandards.dto.ApprovalAnticipationDTO;
import br.edu.utfpr.troubleshootingstandards.exception.ConsentsAnticipationException;
import br.edu.utfpr.troubleshootingstandards.repository.ApprovalAnticipationRepository;
import br.edu.utfpr.troubleshootingstandards.repository.LessonRepository;
import br.edu.utfpr.troubleshootingstandards.service.mapper.ApprovalAnticipationMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Component
public class ApprovalAnticipationServiceImpl implements ApprovalAnticipationService {

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private ApprovalAnticipationRepository approvalAnticipationRepository;

    @Autowired
    private ApprovalAnticipationMapper approvalAnticipationMapper;

    @Override
    // create new approvalAntecipation
    public void include(ApprovalAnticipationDTO approvalAnticipationDTO) throws ConsentsAnticipationException {

        int numberConsents = approvalAnticipationDTO.getConsents().getAttendance().size();

        double numberStudentsP = approvalAnticipationDTO.getProposalAnticipation().getLesson().getClassCourse().getStudents().size() * 0.75;

        if (numberConsents < numberStudentsP)
            throw new ConsentsAnticipationException("Não possui uma lista de anuência com no mínimo 75%");

        long idLesson = approvalAnticipationDTO.getProposalAnticipation().getLesson().getId();

        lessonRepository.findById(idLesson)
                .map(record -> {
                    record.getType().add(
                            approvalAnticipationDTO.getProposalAnticipation().getAnticipation().getModalitie()
                    );
                    return lessonRepository.save(record);
                });


        approvalAnticipationRepository
                .save(
                        approvalAnticipationMapper
                                .toApprovalAnticipation(approvalAnticipationDTO)
                );
    }

    @Override
    // get specific approvalAntecipation
    public Optional<ApprovalAnticipationDTO> getById(Long id) {
        return approvalAnticipationRepository
                .findById(id)
                .map(a -> approvalAnticipationMapper.toApprovalAnticipationDTO(a));
    }

    @Override
    // list of all approvalAntecipation
    public List<ApprovalAnticipationDTO> getAll() {
        return approvalAnticipationMapper.toApprovalAnticipationDTO(approvalAnticipationRepository.findAll());
    }

}
