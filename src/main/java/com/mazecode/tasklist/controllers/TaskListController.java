package com.mazecode.tasklist.controllers;

import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * https://codeburst.io/spring-boot-rest-microservices-best-practices-2a6e50797115
 */

@RequestMapping(path = "/api/v1/tasks", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "Task Rest Controller", description = "REST API Task Controller to Task Entity")
@Log4j
public class TaskListController {
}
