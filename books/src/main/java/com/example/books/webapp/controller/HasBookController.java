package com.example.books.webapp.controller;

import com.example.books.model.HasBook;
import com.example.books.webapp.service.BookServiceService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class HasBookController {

    private final BookServiceService bookServiceService;

    public HasBookController(BookServiceService bookServiceService) {
        this.bookServiceService = bookServiceService;
    }

    @GetMapping("/services/{id}")
    public HasBook getServiceById(@PathVariable Long id) {
        return bookServiceService.getServiceById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "响应不存在"));
    }

    @PostMapping("/services")
    public ResponseEntity<HasBook> createService(@Valid @RequestBody HasBook request) {
        HasBook created = bookServiceService.createService(request);
        return ResponseEntity.created(URI.create("/api/services/" + created.getId())).body(created);
    }

    @PutMapping("/services/{id}")
    public HasBook updateService(@PathVariable Long id, @Valid @RequestBody HasBook request) {
        try {
            return bookServiceService.updateService(id, request);
        } catch (IllegalStateException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        } catch (IllegalArgumentException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }

    @DeleteMapping("/services/{id}")
    public ResponseEntity<Void> deleteService(@PathVariable Long id) {
        try {
            bookServiceService.deleteService(id);
            return ResponseEntity.noContent().build();
        } catch (IllegalStateException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getMessage());
        } catch (IllegalArgumentException ex) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ex.getMessage());
        }
    }

    @GetMapping("/services/user/{userId}")
    public List<HasBook> getServicesByUserId(@PathVariable Long userId) {
        return bookServiceService.getServicesByUserId(userId);
    }

    @PostMapping(value = "/upload/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Map<String, String> uploadImage(@RequestParam("file") MultipartFile file) {
        validateFile(file);
        return mockUpload(file, "image");
    }

    @PostMapping(value = "/upload/video", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Map<String, String> uploadVideo(@RequestParam("file") MultipartFile file) {
        validateFile(file);
        return mockUpload(file, "video");
    }

    private void validateFile(MultipartFile file) {
        if (file == null || file.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "文件不能为空");
        }
    }

    private Map<String, String> mockUpload(MultipartFile file, String type) {
        Map<String, String> response = new HashMap<>();
        String randomName = UUID.randomUUID() + "-" + StringUtils.cleanPath(file.getOriginalFilename());
        response.put("fileName", randomName);
        response.put("type", type);
        response.put("size", String.valueOf(file.getSize()));
        response.put("url", "/files/" + randomName);
        return response;
    }
}
