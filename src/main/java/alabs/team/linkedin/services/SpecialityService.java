package alabs.team.linkedin.services;

import alabs.team.linkedin.dto.SpecialityDTO;
import alabs.team.linkedin.model.Speciality;

import java.util.List;

public interface SpecialityService {
    Speciality addSpeciality(Speciality speciality);
    Speciality saveSpeciality(Speciality speciality);
    void deleteSpeciality(Speciality speciality);
    Speciality getSpeciality(Long id);
    SpecialityDTO getSpecialityDTO(Long id);
    List<Speciality> getAllSpecialties();
    List<SpecialityDTO> getAllSpecialtiesDTO();
}