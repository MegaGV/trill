package team.TAF.trill.service;

import team.TAF.trill.pojo.Video;

import java.util.List;

public interface VideoService {

    List<Video> getAll(Integer page, Integer limit);

    List<Video> getByDesc(String desc);
}
