package com.task.shashank.repository;

import com.task.shashank.model.Subjects;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface SubjectRepository extends MongoRepository<Subjects, String> {
    Subjects findBySubjectname(Subjects subject);
}
