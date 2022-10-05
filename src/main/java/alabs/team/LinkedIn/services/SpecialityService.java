package alabs.team.LinkedIn.services;

import alabs.team.LinkedIn.dto.SpecialityDTO;
import alabs.team.LinkedIn.model.Speciality;

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