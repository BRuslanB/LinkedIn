package alabs.team.linkedin.services;

import alabs.team.linkedin.model.User;
import org.springframework.web.multipart.MultipartFile;

public interface FileUploadService {
    boolean uploadUserAvatar(MultipartFile file, User user);
}