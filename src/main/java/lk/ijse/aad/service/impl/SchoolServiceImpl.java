package lk.ijse.aad.service.impl;

import lk.ijse.aad.dto.SchoolDTO;
import lk.ijse.aad.entity.School;
import lk.ijse.aad.repository.SchoolRepository;
import lk.ijse.aad.service.SchoolService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class SchoolServiceImpl implements SchoolService {

    private final SchoolRepository schoolRepository;

    public SchoolServiceImpl(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @Override
    public SchoolDTO saveSchool(SchoolDTO schoolDTO) {
       log.info("Execute saveSchool method");

       try{
           School school = new School();

           if(schoolDTO.getName() == null){
               throw new RuntimeException("Name is null");
           }

           if(schoolDTO.getLocation() == null){
               throw new RuntimeException("Location is null");
           }

           school.setName(schoolDTO.getName());
           school.setLocation( schoolDTO.getLocation() );

           School savedSchool = schoolRepository.save( school );

           // Can use all args constructor instead setters
           SchoolDTO savedSchoolDTO = new SchoolDTO();
           savedSchoolDTO.setId(savedSchool.getId());
           savedSchoolDTO.setName(savedSchool.getName());
           savedSchoolDTO.setLocation(savedSchool.getLocation());
           return savedSchoolDTO;

       } catch (Exception e) {
           log.error("Error in saveSchool method" + e.getMessage());
           throw e;
       }
    }

    @Override
    public List<SchoolDTO> getSchools() {
        log.info("Execute getSchools method");
        try {
            List<School> schools = schoolRepository.findAll();
            List<SchoolDTO> schoolDTOS = new ArrayList<>();
            for (School school : schools) {
                SchoolDTO schoolDTO = new SchoolDTO();
                schoolDTO.setId(school.getId());
                schoolDTO.setName(school.getName());
                schoolDTO.setLocation(school.getLocation());
                schoolDTOS.add(schoolDTO);
            }
            return schoolDTOS;
        } catch (Exception e) {
            log.error("Error in getSchools method" + e.getMessage());
            throw e;
        }
    }

    @Override
    public SchoolDTO getSchoolById(Long id) {
        log.info("Execute getSchoolById method");

        try {
            Optional<School> OptionalSchool = schoolRepository.findById(id);
            if (!OptionalSchool.isPresent()) {
                log.error("School with id " + id + " not found");
                throw new RuntimeException("School with id " + id + " not found");
            }
            School school = OptionalSchool.get();
            SchoolDTO schoolDTO = new SchoolDTO();
            schoolDTO.setId(school.getId());
            schoolDTO.setName(school.getName());
            schoolDTO.setLocation(school.getLocation());
            return schoolDTO;
        } catch (Exception e) {
            log.error("Error in getSchoolById method" + e.getMessage());
            throw e;
        }
    }

    @Override
    public SchoolDTO updateSchool(SchoolDTO schoolDTO) {
        log.info("Execute updateSchool method");

        try {
            Optional<School> OptionalSchool = schoolRepository.findById(schoolDTO.getId());
            if (!OptionalSchool.isPresent()) {
                log.error("School with id " + schoolDTO.getId() + " not found");
                throw new RuntimeException("School with id " + schoolDTO.getId() + " not found");
            }

            School school = OptionalSchool.get();

            if(schoolDTO.getName() == null){
                throw new RuntimeException("Name is null");
            }

            if(schoolDTO.getLocation() == null){
                throw new RuntimeException("Location is null");
            }

            school.setName(schoolDTO.getName());
            school.setLocation(schoolDTO.getLocation());
            School savedSchool = schoolRepository.save(school);

            SchoolDTO savedSchoolDTO = new SchoolDTO();
            savedSchoolDTO.setId(savedSchool.getId());
            savedSchoolDTO.setName(savedSchool.getName());
            savedSchoolDTO.setLocation(savedSchool.getLocation());

            return savedSchoolDTO;

        } catch (Exception e) {
            log.error("Error in updateSchool method" + e.getMessage());
            throw e;
        }
    }
}
