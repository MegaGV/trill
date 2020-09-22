package team.TAF.trill.service;

import team.TAF.trill.dto.Result;
import team.TAF.trill.pojo.Video;

import java.util.List;

public interface VideoService {

    List<Video> getAll(Integer page, Integer limit);

    List<Video> getByDesc(String desc);

    Result getByIdDesc(String id, String desc);

    Result deleteById(String id);

    Result getResult(Integer page, Integer limit);

    int count();

    Result update(String vid, String field, String value);

    Video getVideoById(String id);

    Result delete(String[] ids);

    Result updateAll(String id, String videoDesc, String videoPath, String likeCounts, String status);

    Result getByDate(String date);

    List<String> getChoice(String value);

    List<String> getChoicePre();
}
