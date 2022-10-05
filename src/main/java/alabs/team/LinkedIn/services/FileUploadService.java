package alabs.team.LinkedIn.services;

import alabs.team.LinkedIn.model.User;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
    boolean uploadUserAvatar(MultipartFile file, User user);
}