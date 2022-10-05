package alabs.team.LinkedIn.rest;

import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin
@RequiredArgsConstructor
public class UploadController {
    @Value("${uploadAvatarURL}")
    private String fileUploadAvatarURL;

    @GetMapping(value = "/avatars/{url}", produces = MediaType.IMAGE_JPEG_VALUE)
    public @ResponseBody byte[] avatar(@PathVariable(name = "url", required = false) String url) throws IOException{
        String picURL = fileUploadAvatarURL + "default_avatar.jpg";
        if (!url.isEmpty()) {
            picURL = fileUploadAvatarURL +  url + ".jpg";
        }
        InputStream in;
        try{
            ClassPathResource classPathResource = new ClassPathResource(picURL);
            in = classPathResource.getInputStream();
        }catch(Exception e){
            picURL = fileUploadAvatarURL + "default_avatar.jpg";
            ClassPathResource classPathResource = new ClassPathResource(picURL);
            in = classPathResource.getInputStream();
        }
        return IOUtils.toByteArray(in);
    }
}