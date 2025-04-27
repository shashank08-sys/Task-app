package com.task.shashank.service;


import com.task.shashank.model.Subjects;
import com.task.shashank.model.Users;
import com.task.shashank.repository.SubjectRepository;
import com.task.shashank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    @Autowired
    private SubjectRepository subjectRepository;
        @Autowired
        private UserRepository userRepository;

        public List<Users> getAllUsers(){
            return userRepository.findAll();
        }

    public void addUser(Users user) {
        List<Subjects> subList = user.getSubjects();
        List<Subjects> savedSubjects = new ArrayList<>();
        List<Subjects> finalSubjectsList = new ArrayList<>();

        String userId = user.getId();
        Optional<Users> existingUserOptional = userRepository.findById(userId);

        if (existingUserOptional.isPresent()) {
            Users existingUser = existingUserOptional.get();
            List<Subjects> existingSubjects = existingUser.getSubjects();
            if (existingSubjects != null) {
                finalSubjectsList.addAll(existingSubjects); // Add existing subjects
            }
        }

        if (subList != null) {
            for (Subjects sub : subList) {
                Subjects newSubject = new Subjects();
                newSubject.setId(sub.getId()); // Consider if you want to let MongoDB generate IDs
                newSubject.setChaptername(sub.getChaptername());
                newSubject.setSubjectname(sub.getSubjectname());

                Subjects savedSubject = subjectRepository.save(newSubject);
                savedSubjects.add(savedSubject);
                finalSubjectsList.add(savedSubject); // Add the newly saved subject
            }
        }

        user.setSubjects(finalSubjectsList);
        userRepository.save(user);
    }

}
