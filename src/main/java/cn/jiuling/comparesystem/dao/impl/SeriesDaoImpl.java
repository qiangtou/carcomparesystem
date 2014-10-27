package cn.jiuling.comparesystem.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import cn.jiuling.comparesystem.dao.SeriesDao;
import cn.jiuling.comparesystem.model.Series;
import cn.jiuling.comparesystem.vo.SeriesVo;

@Repository("seriesDao")
public class SeriesDaoImpl extends BaseDaoImpl<Series> implements SeriesDao {

	@Override
	public List<SeriesVo> fetchSeries() {
		String queryString = "select new cn.jiuling.comparesystem.vo.SeriesVo(s.id,s.brand.id,s.name,s.brand.shortName,s.brand.name) from Series s ";
		List list = super.getHibernateTemplate().find(queryString);
		return list;
	}

}
