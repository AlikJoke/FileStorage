package ru.filestorage.project.rest.controllers;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.filestorage.project.context.configuration.ApplicationContextService;
import ru.filestorage.project.rest.resources.CommonResource;

@RestController
public class ResourceLoaderController extends ExceptionHandlerController {

	@Resource
	private ApplicationContextService service;

	@RequestMapping(value = "/load", method = RequestMethod.POST)
	public CommonResource doPost(@RequestParam("location") String location) throws IOException {
		// TODO
		return null;
	}

	@RequestMapping(value = "/load", method = RequestMethod.OPTIONS)
	public void doOptions(HttpServletRequest request, HttpServletResponse response) {
		super.doOptions(request, response);
	}
}
