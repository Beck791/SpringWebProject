package tw.leonchen.model;

import java.util.List;

public interface IHouseBeanDAO {
	public HouseBean insert(HouseBean hBean);

	public HouseBean queryData(int id);

	public List<HouseBean> queryAllData();

	public HouseBean update(int id, String houseName);

	public boolean delete(int id);
}
