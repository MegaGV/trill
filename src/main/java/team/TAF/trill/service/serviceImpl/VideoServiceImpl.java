package team.TAF.trill.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import team.TAF.trill.dao.VideoMapper;
import team.TAF.trill.dto.Result;
import team.TAF.trill.pojo.Video;
import team.TAF.trill.service.VideoService;

import java.util.regex.Pattern;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private VideoMapper videoMapper;

    @Override
    public List<Video> getAll(Integer page, Integer limit) {
        if (limit == null) {
            limit = 3;
        }
        page = (page == null) ? 0 : (page - 1) * limit;
        return videoMapper.selectAll(page, limit);
    }

    @Override
    public List<Video> getByDesc(String desc) {
        return videoMapper.getByDesc(desc);
    }

    @Override
    public Result getByIdDesc(String id, String desc) {
        Result result = new Result();
        result.setData(videoMapper.getByIdDesc(id, desc));
        result.setTotal(videoMapper.countByIdDesc(id, desc));
        return result;
    }

    @Override
    @Transactional
    public Result deleteById(String id) {
        Result result = new Result();
        Video video = videoMapper.selectByPrimaryKey(id);
        if (video == null){
            result.setStatus(500);
            result.setMessage("请刷新界面后再试");
        }
        else{
            try{
                videoMapper.deleteByPrimaryKey(id);
                result.setStatus(100);
                result.setMessage("删除成功");
            } catch (Exception e){
                e.printStackTrace();
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
                result.setStatus(501);
                result.setMessage("系统繁忙，请稍后再试");
            }
        }
        return result;
    }

//    @Override
//    @Transactional
//    public void deleteById(String id) {
//        videoMapper.deleteByPrimaryKey(id);
//    }

    @Override
    public Result getResult(Integer page, Integer limit) {
        if (limit == null) {
            limit = 3;
        }
        page = (page == null) ? 0 : (page - 1) * limit;
        Integer count = count();
        Result result = new Result();
        result.setData(videoMapper.getResult(page, limit));
        result.setTotal(count);
        return result;
    }

    @Override
    public int count(){
        return videoMapper.count();
    }

    @Override
    @Transactional
    public Result update(String vid, String field, String value) {
        Video video = videoMapper.selectByPrimaryKey(vid);
        Result result = new Result();

        if (field.equals("likeCounts")){
            if (!Pattern.matches("^\\+?[0-9]\\d*$", value)){
                result.setStatus(400);
                result.setMessage("点赞数只能是数字");
                return result;
            }
        }

        if (video == null){
            result.setStatus(500);
            result.setMessage("请刷新界面后再试");
        }
        else{
            try {
                videoMapper.update(vid, field, value);
                result.setStatus(100);
                result.setMessage("更新成功");
            } catch (Exception e){
                e.printStackTrace();
                result.setStatus(501);
                result.setMessage("系统繁忙，请稍后再试");
            }
        }
        return result;
    }

    @Override
    public Video getVideoById(String id) {
        return videoMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public Result delete(String[] ids) {
        Result result = new Result();
        try {
            for (String id : ids) {
                videoMapper.deleteByPrimaryKey(id);
            }
            result.setStatus(100);
            result.setMessage("删除成功");
        } catch (Exception e){
            e.printStackTrace();
            result.setStatus(501);
            result.setMessage("系统繁忙，请稍后再试");
        }
        return result;
    }

    @Override
    @Transactional
    public Result updateAll(String id, String videoDesc, String videoPath, String likeCounts, String status) {
        Result result = new Result();
        Video video = videoMapper.selectByPrimaryKey(id);
        if (video == null){
            result.setStatus(500);
            result.setMessage("请刷新界面后再试");
        }
        else {
            try {
                video.setVideoDesc(videoDesc);
                video.setVideoPath(videoPath);
                video.setLikeCounts((long) Integer.parseInt(likeCounts));
                video.setStatus((status.equals("0")? 0 : 1));
                videoMapper.updateByPrimaryKey(video);
                result.setStatus(100);
                result.setMessage("更新成功");
            } catch (Exception e){
                e.printStackTrace();
                result.setStatus(501);
                result.setMessage("系统繁忙，请稍后再试");
            }
        }
        return result;
    }

    @Override
    public Result getByDate(String date) {
        Result result = new Result();
        if (date.isEmpty()){
            result.setData(videoMapper.getByDate(null, null));
            result.setTotal(count());
        }
        else {
            String[] dates = date.split("~");
            result.setData(videoMapper.getByDate(dates[0], dates[1]));
            result.setTotal(videoMapper.countByDate(dates[0], dates[1]));
        }

        return result;
    }

    @Override
    public List<String> getChoice(String value) {
        return videoMapper.getChoice(value);
    }

    @Override
    public List<String> getChoicePre() {
        return videoMapper.getChoicePre();
    }

}
