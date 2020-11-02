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

	public HouseBean insert(HouseBean hBean) { // ?��?�session?��行新�?(已�?�該筆就不新�?)
		HouseBean myBean = getSession().get(HouseBean.class, hBean.getHouseid());
		if (myBean == null) {
			this.getSession().save(hBean);
			return hBean;
		}
		return null;
	}

	public HouseBean queryData(int id) { // ?��?�session?��行查詢單筆�?��?��?��?��?��?��?�傳null
		HouseBean myBean = getSession().get(HouseBean.class, id);
		return myBean;
	}

	public List<HouseBean> queryAllData() { // ?��?�session?��行查詢�?��?��?��??
		Query<HouseBean> query = getSession().createQuery("from HouseBean", HouseBean.class);
		List<HouseBean> list = query.list();
		return list;
	}

	public HouseBean update(int id, String housename) { // ?��?�session?��行修?��
		HouseBean myBean = getSession().get(HouseBean.class, id);
		if (myBean != null) {
			myBean.setHousename(housename);
			getSession().update(myBean);
		}
		return myBean;
	}

	public boolean delete(int id) { // ?��?�session?��行刪?��
		HouseBean myBean = getSession().get(HouseBean.class, id);
		if (myBean != null) {
			getSession().delete(myBean);
			return true;
		}
		return false;
	}
}
