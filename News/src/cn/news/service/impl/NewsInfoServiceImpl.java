package cn.news.service.impl;

import java.util.List;

import cn.news.dao.impl.NewsInfoDAOImpl;
import cn.news.entity.NewsInfo;
import cn.news.entity.UserInfo;
import cn.news.service.INewsInfoService;

public class NewsInfoServiceImpl implements INewsInfoService {
	//´´½¨dao²ãÊµÀý
	NewsInfoDAOImpl ndi = new NewsInfoDAOImpl();
	@Override
	public List<NewsInfo> findAll(NewsInfo newsInfo) throws Exception {
		return ndi.findAll(newsInfo);
	}
	@Override
	public NewsInfo getNews(int id) throws Exception {
		return ndi.getNews(id);
	}
	@Override
	public boolean updateNews(NewsInfo newsInfo) throws Exception {
		return ndi.updateNews(newsInfo);
	}
	@Override
	public boolean delete(String uid) throws Exception {
		return ndi.delete(uid);
	}
	@Override
	public boolean save(NewsInfo userInfo) throws Exception {
		return ndi.save(userInfo);
	}
	@Override
	public List<NewsInfo> getOnePageData(int pageIndex, int pageSize) throws Exception {
		return ndi.getOnePageData(pageIndex, pageSize);
	}
	@Override
	public int getTotalNews() throws Exception {
		return ndi.getTotalNews();
	}

}
