package team.TAF.trill.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import team.TAF.trill.dto.Result;
import team.TAF.trill.dto.VideoLike;
import team.TAF.trill.pojo.Video;
import team.TAF.trill.service.VideoService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/videos")
public class VideoController {
    @Autowired
    private VideoService videoService;

    @RequestMapping("/getResult")
    @ResponseBody
    public Result getResult(Integer page, Integer limit){
        return videoService.getResult(page, limit);
    }

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

    @RequestMapping("/getByIdDesc")
    @ResponseBody
    public Result getByIdDesc(String id, String desc){
        //SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern:"");
        return videoService.getByIdDesc(id, desc);
    }

    @RequestMapping("deleteById")
    @ResponseBody
    public Result deleteById(String vid){
        return videoService.deleteById(vid);
    }

//    @RequestMapping("deleteById")
//    @ResponseBody
//    public void deleteById(String id){
//        try {
//            videoService.deleteById(id);
//        } catch (Exception e){
//            e.printStackTrace();
//        }
//
//    }

    @RequestMapping("update")
    @ResponseBody
    public Result update(String vid, String field, String value){
        return videoService.update(vid, field, value);
    }

    @RequestMapping("getVideoById")
    @ResponseBody
    public Video getVideoById(String id){
        return videoService.getVideoById(id);
    }

    @RequestMapping("delete")
    @ResponseBody
    public Result delete(String[] ids){
        return videoService.delete(ids);
    }

    @RequestMapping("updateAll")
    @ResponseBody
    public Result updateAll(String id, String videoDesc, String videoPath, String likeCounts, String status){
        return videoService.updateAll(id, videoDesc, videoPath, likeCounts, status);
    }

    @RequestMapping("getByDate")
    @ResponseBody
    public Result getByDate(String date){
        return videoService.getByDate(date);
    }

    @RequestMapping("getChoice")
    @ResponseBody
    public List<String> getChoice(String value){
        return videoService.getChoice(value);
    }

    @RequestMapping("getChoicePre")
    @ResponseBody
    public List<String> getChoicePre(){
        return videoService.getChoicePre();
    }

    @RequestMapping("viewPath")
    public String viewPath(){
        return "videoInfo";
    }

    @RequestMapping("editPath")
    public String editPath(){
        return "videoEdit";
    }

    @RequestMapping("addPath")
    public String addPath(){
        return "videoSubmit";
    }

    @RequestMapping("upload")
    @ResponseBody
    public Result upload(MultipartFile file, HttpServletRequest request){
        return videoService.upload(file, request);
    }

    @RequestMapping("videoSubmit")
    @ResponseBody
    public Result videoSubmit(String videoDesc, String videoPath, HttpServletRequest request){
        return videoService.videoSubmit(videoDesc, videoPath, request);
    }

    @RequestMapping("getVideoLike")
    @ResponseBody
    public List<VideoLike> getVideoLike(){
        return videoService.getVideoLike();
    }


}
