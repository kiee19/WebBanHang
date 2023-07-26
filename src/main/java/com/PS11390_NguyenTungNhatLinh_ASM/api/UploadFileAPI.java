package com.PS11390_NguyenTungNhatLinh_ASM.api;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.PS11390_NguyenTungNhatLinh_ASM.dto.UploadFileResponse;
import com.PS11390_NguyenTungNhatLinh_ASM.service.impl.FileStorageService;

@RestController
@CrossOrigin
public class UploadFileAPI {
	
	@Autowired
	private FileStorageService fileStorageService;

	@PostMapping(value = "/api/uploadfile", consumes = {"multipart/form-data"})
	public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
		String fileContentType = file.getContentType();
		if (fileContentType.contains("image/")) {
			String fileName = fileStorageService.storeFile(file);

			String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
					.path("/archive/downloadFile/").path(fileName).toUriString();

			UploadFileResponse fileResponse = new UploadFileResponse(fileName, fileDownloadUri, file.getContentType(),
					file.getSize());
			return ResponseEntity.ok(fileResponse);
		}
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/archive/downloadFile/{fileName:.+}")
	public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
		// Load file as Resource
		Resource resource = fileStorageService.loadFileAsResource(fileName);

		// Try to determine file's content type
		String contentType = null;
		try {
			contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
		} catch (IOException ex) {
			// logger.info("Could not determine file type.");
		}

		// Fallback to the default content type if type could not be determined
		if (contentType == null) {
			contentType = "application/octet-stream";
		}

		return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
				.body(resource);
	}
}