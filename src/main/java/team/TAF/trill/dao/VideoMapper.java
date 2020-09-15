package team.TAF.trill.dao;

import java.util.List;
import team.TAF.trill.pojo.Video;

public interface VideoMapper {
    int deleteByPrimaryKey(String id);

    int insert(Video record);

    Video selectByPrimaryKey(String id);

    List<Video> selectAll();

    int updateByPrimaryKey(Video record);
}