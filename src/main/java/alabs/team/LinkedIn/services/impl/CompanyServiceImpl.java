package alabs.team.LinkedIn.services.impl;

import alabs.team.LinkedIn.dto.CompanyDTO;
import alabs.team.LinkedIn.mapper.CompanyMapper;
import alabs.team.LinkedIn.model.Company;
import alabs.team.LinkedIn.repository.CompanyRepository;
import alabs.team.LinkedIn.services.CompanyService;
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