package ru.filestorage.project.rest.controllers;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController extends ExceptionHandlerController {

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public void doPost(@RequestParam Map<String, String> name,
			@RequestParam("file") MultipartFile file) {
		
	}
}
