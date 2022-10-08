package alabs.team.linkedin.mapper;

import alabs.team.linkedin.dto.SpecialityDTO;
import alabs.team.linkedin.model.Speciality;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SpecialityMapper {
    SpecialityDTO toDto(Speciality speciality);
    Speciality toEntity(SpecialityDTO specialityDTO);
    List<SpecialityDTO> toDtoList(List<Speciality> specialties);
}