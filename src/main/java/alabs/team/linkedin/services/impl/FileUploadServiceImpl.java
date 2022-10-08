package alabs.team.linkedin.services.impl;

import alabs.team.linkedin.model.User;
import alabs.team.linkedin.repository.UserRepository;
import alabs.team.linkedin.services.FileUploadService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
@RequiredArgsConstructor
public class FileUploadServiceImpl implements FileUploadService {

    @Value("${targetAvatarURL}")
    private String targetAvatarURL;

    private final UserRepository userRepository;

    public boolean uploadUserAvatar(MultipartFile file, User user) {
        try {
            String fileName = DigestUtils.sha1Hex(user.getId() + "_springSecurity");
            byte bytes[] = file.getBytes();
            Path path = Paths.get(targetAvatarURL + "/" + fileName + ".jpg");
            Files.write(path, bytes);

            user.setAvatarUrl(fileName);
            userRepository.save(user);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}