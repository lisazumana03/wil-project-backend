package za.co.lzinc.heriplay.service.quiz.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import za.co.lzinc.heriplay.domain.quiz.Subject;
import za.co.lzinc.heriplay.repository.quiz.SubjectRepository;
import za.co.lzinc.heriplay.service.quiz.ISubjectService;

@Service
public class SubjectService implements ISubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public Subject create(Subject subject) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = (auth != null) ? auth.getName() : "system";

        Subject subjectToSave = new Subject.Builder()
                .setSubjectName(subject.getSubjectName())
                .setSubjectCode(subject.getSubjectCode())
                .setDescription(subject.getDescription())
                .setQuizzes(subject.getQuizzes())
                .build();

        return subjectRepository.save(subjectToSave);
    }

    @Override
    public List<Subject> readAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject readById(Integer subjectId) {
        Optional<Subject> subject = subjectRepository.findById(subjectId);
        return subject.orElse(null);
    }

    @Override
    public Subject update(Subject subject) {
        return subjectRepository.save(subject);
    }

    public Subject update(Integer subjectId, Subject subject) {
        Optional<Subject> existingSubject = subjectRepository.findById(subjectId);
        if (existingSubject.isPresent()) {
            Subject subjectToUpdate = existingSubject.get();
            // Update fields from the request
            if (subject.getSubjectName() != null) {
                subjectToUpdate = new Subject.Builder()
                        .setSubjectId(subjectToUpdate.getSubjectId())
                        .setSubjectName(subject.getSubjectName())
                        .setSubjectCode(subject.getSubjectCode())
                        .setDescription(subject.getDescription())
                        .setQuizzes(subjectToUpdate.getQuizzes())
                        .build();
            }
            return subjectRepository.save(subjectToUpdate);
        }
        return null;
    }

    @Override
    public void delete(Integer subjectId) {
        subjectRepository.deleteById(subjectId);
    }
}
