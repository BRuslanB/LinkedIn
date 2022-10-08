package alabs.team.linkedin.services;

import alabs.team.linkedin.dto.CompanyDTO;
import alabs.team.linkedin.model.Company;

import java.util.List;

public interface CompanyService {
    Company addCompany(Company company);
    Company saveCompany(Company company);
    void deleteCompany(Company company);
    Company getCompany(Long id);
    CompanyDTO getCompanyDTO(Long id);
    List<Company> getAllCompanies();
    List<CompanyDTO> getAllCompaniesDTO();
}