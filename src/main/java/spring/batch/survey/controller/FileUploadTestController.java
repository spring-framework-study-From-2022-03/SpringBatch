package spring.batch.survey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FileUploadTestController {

    @GetMapping("/fileUpload")
    public String fileupload(){
        return "index";
    }

}
