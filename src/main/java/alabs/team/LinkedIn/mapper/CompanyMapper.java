package alabs.team.LinkedIn.mapper;

import alabs.team.LinkedIn.dto.CompanyDTO;
import alabs.team.LinkedIn.model.Company;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
    CompanyDTO toDto(Company company);
    Company toEntity(CompanyDTO companyDTO);
    List<CompanyDTO> toDtoList(List<Company> companies);
}