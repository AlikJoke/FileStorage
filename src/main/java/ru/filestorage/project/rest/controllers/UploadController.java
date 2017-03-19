package ru.filestorage.project.rest.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController extends ExceptionHandlerController {

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public void doPost(@RequestParam Map<String, String> params, @RequestParam("file") MultipartFile file) {
		Map<String, String> paramsTemp = params;
		paramsTemp.entrySet().stream().map(entry -> entry.getValue()).forEach(System.out::println);
	}

	@RequestMapping(value = "/upload", method = RequestMethod.OPTIONS)
	public void doOptions(HttpServletRequest request, HttpServletResponse response) {
		super.doOptions(request, response);
	}
}
