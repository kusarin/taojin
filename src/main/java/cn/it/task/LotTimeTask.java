package cn.it.task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import cn.it.dao.LotDao;
import cn.it.pojo.Lot;
import cn.it.service.OrderService;

@Component
public class LotTimeTask {

	@Autowired
	private LotDao lotDao;
    @Autowired
    private OrderService orderService;
	
	@Scheduled(cron = "0 0/1 * * * ? ")
	public void lotTask() {
		lotDao.timeControl();
		List<Lot> lot = lotDao.getOver();

		for (Lot l : lot) {
			if (l.getUser_id() == 0) {
				l.setStatus(2);
				lotDao.LotUpdate(l);
			} else {
				// 生成订单
				int lot_id=l.getLot_id();
				orderService.productLotOrder(lot_id);
				l.setStatus(1);
				lotDao.LotUpdate(l);
			}
		}
	}
}
