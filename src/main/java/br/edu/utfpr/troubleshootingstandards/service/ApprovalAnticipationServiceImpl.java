package br.edu.utfpr.troubleshootingstandards.service;

import br.edu.utfpr.troubleshootingstandards.dto.ApprovalAnticipationDTO;
import br.edu.utfpr.troubleshootingstandards.exception.ConsentsAnticipationException;
import br.edu.utfpr.troubleshootingstandards.model.Lesson;
import br.edu.utfpr.troubleshootingstandards.model.Modalities;
import br.edu.utfpr.troubleshootingstandards.model.ProposalAnticipation;
import br.edu.utfpr.troubleshootingstandards.repository.ApprovalAnticipationRepository;
import br.edu.utfpr.troubleshootingstandards.repository.LessonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ApprovalAnticipationServiceImpl implements ApprovalAnticipationService {

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private ApprovalAnticipationRepository approvalAnticipationRepository;

    @Override
    public void approval(ApprovalAnticipationDTO approvalAnticipationDTO) throws ConsentsAnticipationException {

        int numberConsents = approvalAnticipationDTO.getProposalAnticipationDTO().getConsents().getAttendance().size();

        double numberStudentsP = approvalAnticipationDTO.getProposalAnticipationDTO().getLesson().getClassCourse().getStudents().size() * 0.75;

        if (numberConsents < numberStudentsP)
            throw new ConsentsAnticipationException("Não possui uma lista de anuência com no mínimo 75%");


        long idLesson = approvalAnticipationDTO.getProposalAnticipationDTO().getLesson().getId();

        lessonRepository.findById(idLesson)
                .map(record -> {
                    record.getType().add(
                            approvalAnticipationDTO.getProposalAnticipationDTO().getAnticipation().isInPerson() ?
                                    Modalities.PRESENCIAL.name() :
                                    Modalities.NÃO_PRESENCIAL.name()
                    );
                    return lessonRepository.save(record);
                });

        approvalAnticipationRepository.findById(approvalAnticipationDTO.getId())
                .map(record -> {
                    record.setApproved(true);
                    return approvalAnticipationRepository.save(record);
                });
    }


}
