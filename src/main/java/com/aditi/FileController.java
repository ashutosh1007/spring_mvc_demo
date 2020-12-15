package com.aditi;

import java.io.IOException;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.aditi.model.UploadFile;
import com.aditi.service.FileService;


@RestController
@RequestMapping("/file")
@CrossOrigin
public class FileController {

	@Autowired
	private FileService fileService;

	/*
	 * @Autowired private IdentiyService identityService;
	 */

	@RequestMapping(value = "/doUpload/{id}", method = RequestMethod.POST)
	public String handleFileUpload(HttpServletRequest request,
								   @RequestParam("FILE_DATA") CommonsMultipartFile[] fileUpload,@PathVariable int id) throws Exception {

		if (fileUpload != null && fileUpload.length > 0) {
			for (CommonsMultipartFile aFile : fileUpload){

				System.out.println("Saving file: " + aFile.getOriginalFilename());
				UploadFile uploadFile = new UploadFile();
				uploadFile.setFile_name(aFile.getOriginalFilename());
				uploadFile.setFile_data(aFile.getBytes());
				uploadFile.setLoan_id(id);
				fileService.save(uploadFile);
			}
		}

		return "Success";
	}

}