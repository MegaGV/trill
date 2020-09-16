package team.TAF.trill.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import team.TAF.trill.pojo.Video;

public interface VideoMapper {
    int deleteByPrimaryKey(String id);

    int insert(Video record);

    Video selectByPrimaryKey(String id);

    List<Video> selectAll(@Param("page") Integer page, @Param("limit") Integer limit);

    int updateByPrimaryKey(Video record);

    List<Video> getByDesc(@Param("desc") String desc);
}