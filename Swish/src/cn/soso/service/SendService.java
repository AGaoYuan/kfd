package cn.soso.service;

import cn.soso.entity.MobileCard;

/**
 * 短信服务接口
 * @author Mr.Gao
 *
 */
public interface SendService {
	
	public int send(int Count,MobileCard card) throws Exception;
	
}
