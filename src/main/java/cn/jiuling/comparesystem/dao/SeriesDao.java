package cn.jiuling.comparesystem.dao;

import java.util.List;

import cn.jiuling.comparesystem.model.Series;
import cn.jiuling.comparesystem.vo.SeriesVo;

public interface SeriesDao extends BaseDao<Series> {
	public List<SeriesVo> fetchSeries();
}
