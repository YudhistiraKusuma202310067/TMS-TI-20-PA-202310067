package com.ibik.academicservices.academicservices.program_study;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProgramStudyServices {

    @Autowired
    private ProgramStudyRepo programStudyRepo;

    public ProgramStudy save(ProgramStudy programStudy){
        return programStudyRepo.save(programStudy);
    }

    public ProgramStudy update(ProgramStudy programStudy) {
        ProgramStudy result = findOne(programStudy.getId());

        result.setName(programStudy.getName());
        result.setDescription(programStudy.getDescription());
        result.setCode(programStudy.getCode());
        result.setProgram_id(programStudy.getProgram_id());
        result.setFaculty_id(programStudy.getFaculty_id());
        result.setDepartment_id(programStudy.getDepartment_id());
        result.setIs_active(programStudy.isIs_active());

        return result;
    }

    public ProgramStudy findOne(int id){
        return programStudyRepo.findById(id).get();
    }    

    public Iterable<ProgramStudy> findAll(){
        return programStudyRepo.findAll();
    }

    public void removeOne(int id){
        programStudyRepo.deleteById(id);
    }
}
