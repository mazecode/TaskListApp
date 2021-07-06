package com.mazecode.tasklist.controllers;

import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/login", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "Login Management Rest Controller", description = "REST API Login Controller to handle Login actions")
public class LoginController extends ApiController {
}
