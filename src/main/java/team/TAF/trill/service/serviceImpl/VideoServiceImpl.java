package team.TAF.trill.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import team.TAF.trill.dao.VideoMapper;
import team.TAF.trill.dto.Result;
import team.TAF.trill.pojo.Video;
import team.TAF.trill.service.VideoService;

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
    public List<Video> getByIdDesc(String id, String desc) {
        return videoMapper.getByIdDesc(id, desc);
    }

    @Override
    @Transactional
    public void deleteById(String id) {
        try{
            videoMapper.deleteByPrimaryKey(id);
        } catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
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
        List<Video> data = videoMapper.getResult(page, limit);
        Integer count = count();
        Result result = new Result();
        result.setData(data);
        result.setTotal(count);
        return result;
    }

    @Override
    public int count(){
        return videoMapper.count();
    }

    @Override
    @Transactional
    public Result updateStatus(String vid, Integer status) {
        Video video = videoMapper.selectByPrimaryKey(vid);
        Result result = new Result();
        if (video == null){
            result.setStatus(500);
            result.setMessage("请刷新界面后再试");
        }
        else{
            try {
                videoMapper.updateStatus(vid, status);
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



}
