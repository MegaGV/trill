package team.TAF.trill.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import team.TAF.trill.dto.VideoDto;
import team.TAF.trill.dto.VideoLike;
import team.TAF.trill.pojo.Video;

public interface VideoMapper {
    int deleteByPrimaryKey(String id);

    int insert(Video record);

    Video selectByPrimaryKey(String id);

    List<Video> selectAll(@Param("page") Integer page, @Param("limit") Integer limit);

    int updateByPrimaryKey(Video record);

    List<Video> getByDesc(@Param("desc") String desc);

    List<VideoDto> getByIdDesc(@Param("id") String id, @Param("desc")  String desc);

    int count();

    List<VideoDto> getResult(@Param("page") Integer page, @Param("limit") Integer limit);

    void update(@Param("id") String vid, @Param("field") String field, @Param("value") String value);

    int countByIdDesc(@Param("id") String id, @Param("desc") String desc);

    List<VideoDto> getByDate(@Param("start") String start, @Param("end") String end);

    int countByDate(@Param("start") String start, @Param("end") String end);

    List<String> getChoice(@Param("value")String value);

    List<String> getChoicePre();

    List<VideoLike> getVideoLike();
}