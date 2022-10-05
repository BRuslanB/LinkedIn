package alabs.team.LinkedIn.services;

import alabs.team.LinkedIn.dto.CompanyDTO;
import alabs.team.LinkedIn.model.Company;

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