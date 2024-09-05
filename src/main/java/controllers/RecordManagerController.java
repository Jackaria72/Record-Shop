package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.RecordManagerService;

@RestController
@RequestMapping("/api/v1/record")
public class RecordManagerController {

    @Autowired
    RecordManagerService recordManagerService;

}
