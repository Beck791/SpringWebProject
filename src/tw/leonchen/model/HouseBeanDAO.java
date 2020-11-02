package tw.leonchen.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class HouseBeanDAO implements IHouseBeanDAO{
	private Session session;

	public HouseBeanDAO(Session session) {
		this.session = session;
	}

	public Session getSession() {
		return session;
	}

	public HouseBean insert(HouseBean hBean) { // ?é?session?Ÿ·è¡Œæ–°å¢?(å·²æ?‰è©²ç­†å°±ä¸æ–°å¢?)
		HouseBean myBean = getSession().get(HouseBean.class, hBean.getHouseid());
		if (myBean == null) {
			this.getSession().save(hBean);
			return hBean;
		}
		return null;
	}

	public HouseBean queryData(int id) { // ?é?session?Ÿ·è¡ŒæŸ¥è©¢å–®ç­†è?‡æ?™ï?Œæ?’æ?‰å?‡å?å‚³null
		HouseBean myBean = getSession().get(HouseBean.class, id);
		return myBean;
	}

	public List<HouseBean> queryAllData() { // ?é?session?Ÿ·è¡ŒæŸ¥è©¢å?šç?†è?‡æ??
		Query<HouseBean> query = getSession().createQuery("from HouseBean", HouseBean.class);
		List<HouseBean> list = query.list();
		return list;
	}

	public HouseBean update(int id, String housename) { // ?é?session?Ÿ·è¡Œä¿®?”¹
		HouseBean myBean = getSession().get(HouseBean.class, id);
		if (myBean != null) {
			myBean.setHousename(housename);
			getSession().update(myBean);
		}
		return myBean;
	}

	public boolean delete(int id) { // ?é?session?Ÿ·è¡Œåˆª?™¤
		HouseBean myBean = getSession().get(HouseBean.class, id);
		if (myBean != null) {
			getSession().delete(myBean);
			return true;
		}
		return false;
	}
}
