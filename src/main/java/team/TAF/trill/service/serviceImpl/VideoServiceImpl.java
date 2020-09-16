package team.TAF.trill.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.TAF.trill.dao.VideoMapper;
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
}
