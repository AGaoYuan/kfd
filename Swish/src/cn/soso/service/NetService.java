package cn.soso.service;

import cn.soso.entity.MobileCard;

/**
 * 上网服务接口
 * @author Mr.Gao
 *
 */
public interface NetService {
	
	public int netPlay(int flow,MobileCard card) throws Exception;
	
}
