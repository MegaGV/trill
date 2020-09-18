package team.TAF.trill.service;

import team.TAF.trill.dto.Result;
import team.TAF.trill.pojo.Video;

import java.util.List;

public interface VideoService {

    List<Video> getAll(Integer page, Integer limit);

    List<Video> getByDesc(String desc);

    List<Video> getByIdDesc(String id, String desc);

    void deleteById(String id);

    Result getResult(Integer page, Integer limit);

    int count();

    Result updateStatus(String vid, Integer status);
}
