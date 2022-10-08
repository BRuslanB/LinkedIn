package alabs.team.linkedin.api;

import alabs.team.linkedin.model.Company;
import alabs.team.linkedin.model.Speciality;
import alabs.team.linkedin.model.User;
import alabs.team.linkedin.services.impl.CompanyServiceImpl;
import alabs.team.linkedin.services.impl.SpecialityServiceImpl;
import alabs.team.linkedin.services.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final UserServiceImpl userService;
    private final CompanyServiceImpl companyService;
    private final SpecialityServiceImpl specialityService;

    @GetMapping("/")
    public String indexPage(Model model) {
        return "index";
    }

    @PreAuthorize("hasAnyRole('ROLE_HR_MANAGER')")
    @GetMapping("/candidates")
    public String candidatesPage(Model model) {
        List<Company> allCompanies = companyService.getAllCompanies();
        model.addAttribute("allCompanies", allCompanies);
        List<Speciality> allSpecialties = specialityService.getAllSpecialties();
        model.addAttribute("allSpecialties", allSpecialties);
        return "candidates";
    }

    @PreAuthorize("hasAnyRole('ROLE_HR_MANAGER')")
    @GetMapping("/findcandidates/{company_id}/{operand}/{speciality_id}")
    public String findCandidates(@PathVariable(name = "company_id") String company_id,
                                 @PathVariable(name = "operand") String operand,
                                 @PathVariable(name = "speciality_id") String speciality_id,
                                 Model model) {
        Long companyId, specialityId;
        try {
            companyId = Long.parseLong(company_id);
        } catch (NumberFormatException e) {
            companyId = null;
        }
        try {
            specialityId = Long.parseLong(speciality_id);
        } catch (NumberFormatException e) {
            specialityId = null;
        }
        List<User> allCandidates = userService.findByAllUsers(companyId, specialityId, operand);
        model.addAttribute("allCandidates", allCandidates);
        List<Company> allCompanies = companyService.getAllCompanies();
        model.addAttribute("allCompanies", allCompanies);
        List<Speciality> allSpecialties = specialityService.getAllSpecialties();
        model.addAttribute("allSpecialties", allSpecialties);
        return "candidates";
    }

    @PreAuthorize("hasAnyRole('ROLE_HR_MANAGER')")
    @GetMapping("/findcandidates")
    public String findCandidates(Model model) {
        List<User> allCandidates = userService.getAllUsers();
        model.addAttribute("allCandidates", allCandidates);
        List<Company> allCompanies = companyService.getAllCompanies();
        model.addAttribute("allCompanies", allCompanies);
        List<Speciality> allSpecialties = specialityService.getAllSpecialties();
        model.addAttribute("allSpecialties", allSpecialties);
        return "candidates";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/companies")
    public String companiesPage(Model model) {
        List<Company> allCompanies = companyService.getAllCompanies();
        model.addAttribute("allCompanies", allCompanies);
        return "companies";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping("/addcompany")
    public String addCompany(@RequestParam(name = "company_name") String companyName) {
        Company company = new Company();
        company.setName(companyName);
        companyService.addCompany(company);
        return "redirect:/companies";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping("/editcompany")
    public String saveCompany(@RequestParam(name = "company_id") Long companyId,
                              @RequestParam(name = "company_name") String companyName) {
        Company company = companyService.getCompany(companyId);
        if (company != null) {
            company.setName(companyName);
            companyService.saveCompany(company);
        }
        return "redirect:/companies";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping("/deletecompany")
    public String deleteCompany(@RequestParam(name = "company_id") Long companyId) {
        Company company = companyService.getCompany(companyId);
        if (company != null)
            companyService.deleteCompany(company);
        return "redirect:/companies";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @GetMapping("/specialties")
    public String specialtiesPage(Model model) {
        List<Speciality> allSpecialties = specialityService.getAllSpecialties();
        model.addAttribute("allSpecialties", allSpecialties);
        return "specialties";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping("/addspeciality")
    public String addSpeciality(@RequestParam(name = "speciality_name") String specialityName) {
        Speciality speciality = new Speciality();
        speciality.setName(specialityName);
        specialityService.addSpeciality(speciality);
        return "redirect:/specialties";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping("/editspeciality")
    public String saveSpeciality(@RequestParam(name = "speciality_id") Long specialityId,
                                 @RequestParam(name = "speciality_name") String specialityName) {
        Speciality speciality = specialityService.getSpeciality(specialityId);
        if (speciality != null) {
            speciality.setName(specialityName);
            specialityService.saveSpeciality(speciality);
        }
        return "redirect:/specialties";
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping("/deletespeciality")
    public String deleteSpeciality(@RequestParam(name = "speciality_id") Long specialityId) {
        Speciality speciality = specialityService.getSpeciality(specialityId);
        if (speciality != null)
            specialityService.deleteSpeciality(speciality);
        return "redirect:/specialties";
    }
}