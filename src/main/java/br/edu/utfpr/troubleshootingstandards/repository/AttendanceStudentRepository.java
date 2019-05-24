package br.edu.utfpr.troubleshootingstandards.repository;

import br.edu.utfpr.troubleshootingstandards.model.ApprovalAnticipation; // não acho que seja necessária a importação de ApprovalAnticipation neste arquivo
import br.edu.utfpr.troubleshootingstandards.model.AttendanceStudent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceStudentRepository extends JpaRepository<AttendanceStudent, Long> {}
