package bzh.amzerin.openD6.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileService {

    private final Path uploadDir = Paths.get("uploads/");

    public String save(MultipartFile file) throws IOException {
        if (file.isEmpty()) return null;

        Files.createDirectories(uploadDir);

        String fileName = file.getOriginalFilename();
        Path target = uploadDir.resolve(fileName);
        Files.write(target, file.getBytes());

        return "/uploads/" + fileName;
    }
}