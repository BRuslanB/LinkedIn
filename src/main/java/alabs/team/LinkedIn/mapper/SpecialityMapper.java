package alabs.team.LinkedIn.mapper;

import alabs.team.LinkedIn.dto.SpecialityDTO;
import alabs.team.LinkedIn.model.Speciality;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SpecialityMapper {
    SpecialityDTO toDto(Speciality speciality);
    Speciality toEntity(SpecialityDTO specialityDTO);
    List<SpecialityDTO> toDtoList(List<Speciality> specialties);
}