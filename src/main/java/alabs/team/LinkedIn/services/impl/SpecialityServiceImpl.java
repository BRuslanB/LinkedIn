package alabs.team.LinkedIn.services.impl;

import alabs.team.LinkedIn.dto.SpecialityDTO;
import alabs.team.LinkedIn.mapper.SpecialityMapper;
import alabs.team.LinkedIn.model.Speciality;
import alabs.team.LinkedIn.repository.SpecialityRepository;
import alabs.team.LinkedIn.services.SpecialityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpecialityServiceImpl implements SpecialityService {
    private final SpecialityRepository specialityRepository;
    private final SpecialityMapper specialityMapper;

    public Speciality addSpeciality(Speciality speciality){
        return specialityRepository.save(speciality);
    }

    public Speciality saveSpeciality(Speciality speciality){
        return specialityRepository.save(speciality);
    }

    public void deleteSpeciality(Speciality speciality){
        specialityRepository.delete(speciality);
    }

    public Speciality getSpeciality(Long id){
        return specialityRepository.findById(id).orElseThrow();
    }

    public SpecialityDTO getSpecialityDTO(Long id){
        return specialityMapper.toDto(specialityRepository.findById(id).orElseThrow());
    }

    public List<Speciality> getAllSpecialties(){
        return specialityRepository.findAllByOrderByIdAsc();
    }

    public List<SpecialityDTO> getAllSpecialtiesDTO(){
        return specialityMapper.toDtoList(specialityRepository.findAllByOrderByIdAsc());
    }
}