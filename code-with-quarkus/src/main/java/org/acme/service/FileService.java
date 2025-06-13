package org.acme.service;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.resteasy.reactive.server.multipart.MultipartFormDataInput;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@ApplicationScoped
public class FileService {

    @ConfigProperty(name = "file.upload.directory", defaultValue = "uploads/")
    String uploadDirectory;

    public String saveFile(InputStream fileInputStream, String fileName) throws Exception {
        Path dirPath = Path.of(uploadDirectory);
        if (!Files.exists(dirPath)) {
            Files.createDirectories(dirPath);
        }

        Path filePath = dirPath.resolve(fileName);

        Files.copy(fileInputStream, filePath, StandardCopyOption.REPLACE_EXISTING);

        return filePath.toString();
    }

    public String getUploadDirectory() {
        return uploadDirectory;
    }
}
