package team.TAF.trill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import team.TAF.trill.pojo.Video;
import team.TAF.trill.service.VideoService;

import java.util.List;

@Controller
@RequestMapping("/videos")
public class VideoController {
    @Autowired
    private VideoService videoService;

    @RequestMapping("/getAll")
    @ResponseBody
    public List<Video> getAll(Integer page, Integer limit){
        return videoService.getAll(page, limit);
    }

    @RequestMapping("/getByDesc")
    @ResponseBody
    public List<Video> getByDesc(String desc){
        return videoService.getByDesc(desc);
    }

}
