package team.TAF.trill.dao;

import java.util.List;
import team.TAF.trill.pojo.Bgm;

public interface BgmMapper {
    int deleteByPrimaryKey(String id);

    int insert(Bgm record);

    Bgm selectByPrimaryKey(String id);

    List<Bgm> selectAll();

    int updateByPrimaryKey(Bgm record);
}