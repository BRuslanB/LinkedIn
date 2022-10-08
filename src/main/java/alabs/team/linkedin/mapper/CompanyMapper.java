package alabs.team.linkedin.mapper;

import alabs.team.linkedin.dto.CompanyDTO;
import alabs.team.linkedin.model.Company;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
    CompanyDTO toDto(Company company);
    Company toEntity(CompanyDTO companyDTO);
    List<CompanyDTO> toDtoList(List<Company> companies);
}