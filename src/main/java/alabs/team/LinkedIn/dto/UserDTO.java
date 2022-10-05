package alabs.team.LinkedIn.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private Long id;
    private String email;
    private String fullName;
    private CompanyDTO company;
    private SpecialityDTO speciality;
}