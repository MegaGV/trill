package team.TAF.trill.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import team.TAF.trill.dto.VideoDto;
import team.TAF.trill.pojo.Video;

public interface VideoMapper {
    int deleteByPrimaryKey(String id);

    int insert(Video record);

    Video selectByPrimaryKey(String id);

    List<Video> selectAll(@Param("page") Integer page, @Param("limit") Integer limit);

    int updateByPrimaryKey(Video record);

    List<Video> getByDesc(@Param("desc") String desc);

    List<Video> getByIdDesc(@Param("id") String id, @Param("desc")  String desc);

    int count();

    List<Video> getResult(@Param("page") Integer page, @Param("limit") Integer limit);

    void updateStatus(@Param("id") String vid, @Param("status") Integer status);
}