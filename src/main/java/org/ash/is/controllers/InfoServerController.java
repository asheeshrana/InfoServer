package org.ash.is.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.springframework.web.servlet.ModelAndView;



@RestController
@RequestMapping("/is")
public class InfoServerController {
    
    @RequestMapping("/info/{info}")
    public ModelAndView getInfo(@PathVariable String info) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("info");
        return mv;
    }

    @RequestMapping("/info/getFilesNames")
    public ModelAndView getInfo() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("info");
        return mv;
    }
    
    @RequestMapping("/data/{info}")
    public String getData(@PathVariable String info) {
                System.out.println("Input = " + info);
        Resource resource = new ClassPathResource(info + ".json");
        String response = "Not found";
        if (resource.exists()) {
            try{
                JSONParser parser = new JSONParser();
                JSONObject jsonResource = (JSONObject)(parser.parse(new BufferedReader(new InputStreamReader(resource.getInputStream()))));
                response = jsonResource.toString();    
            } catch (Exception e) {
                //Ignore
            }
            
        }
        return response;

    }
}
