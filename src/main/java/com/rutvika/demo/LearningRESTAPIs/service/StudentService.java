package com.rutvika.demo.LearningRESTAPIs.service;

import com.rutvika.demo.LearningRESTAPIs.dto.AddStudentRequestDto;
import com.rutvika.demo.LearningRESTAPIs.dto.StudentDto;

import java.util.List;
import java.util.Map;

public interface StudentService {

    List<StudentDto> getAllStudents();
    StudentDto getStudentById(Long id);
    StudentDto createNewStudent(AddStudentRequestDto addStudentRequestDto);
    void deleteStudentById(Long id);
    StudentDto updateStudent(Long id, AddStudentRequestDto addStudentRequestDto);
    StudentDto updatePartialStudentById(Long id, Map<String,Object> updates);
}
