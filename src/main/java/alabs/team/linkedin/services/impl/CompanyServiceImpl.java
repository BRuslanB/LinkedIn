package alabs.team.linkedin.services.impl;

import alabs.team.linkedin.dto.CompanyDTO;
import alabs.team.linkedin.mapper.CompanyMapper;
import alabs.team.linkedin.model.Company;
import alabs.team.linkedin.repository.CompanyRepository;
import alabs.team.linkedin.services.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    private final CompanyMapper companyMapper;

    public Company addCompany(Company company){
        return companyRepository.save(company);
    }

    public Company saveCompany(Company company){
        return companyRepository.save(company);
    }

    public void deleteCompany(Company company){
        companyRepository.delete(company);
    }

    public Company getCompany(Long id){
        return companyRepository.findById(id).orElseThrow();
    }

    public CompanyDTO getCompanyDTO(Long id){
        return companyMapper.toDto(companyRepository.findById(id).orElseThrow());
    }

    public List<Company> getAllCompanies(){
        return companyRepository.findAllByOrderByIdAsc();
    }

    public List<CompanyDTO> getAllCompaniesDTO(){
        return companyMapper.toDtoList(companyRepository.findAllByOrderByIdAsc());
    }
}