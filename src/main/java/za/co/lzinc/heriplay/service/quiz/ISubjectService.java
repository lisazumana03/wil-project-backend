package za.co.lzinc.heriplay.service.quiz;

import za.co.lzinc.heriplay.domain.quiz.Subject;
import za.co.lzinc.heriplay.service.IService;

public interface ISubjectService extends IService<Subject, Integer> {
    void delete(Integer subjectId);
}
