package org.ash.is.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;

import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.springframework.web.servlet.ModelAndView;


@RestController
@RequestMapping("/is")
public class InfoServerController {

    private static final String DATA_DIR = "/projects/InfoServer/files";

    @RequestMapping("/info")
    public ModelAndView getInfo() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("info");

        return mv;
    }
    
    

    @RequestMapping("/data/{info}")
    public String getData(@PathVariable String info) {
        String response = "Not found";
        try {
            JSONParser parser = new JSONParser();
            JSONObject jsonResource = (JSONObject)(parser.parse(new BufferedReader(new FileReader(new File(DATA_DIR + File.separator + info + ".json")))));
            response = jsonResource.toString();
        } catch (Exception e) {
                //Ignore
        }
        return response;
    }


    @RequestMapping("/getFileList")
    public String getFileList() {

        File file = new File(DATA_DIR);
        JSONArray fileList = new JSONArray();
        
        for (String fileName : file.list()) {
            fileList.add(fileName);
        }
        return fileList.toString();
    }
}
