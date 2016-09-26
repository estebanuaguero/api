package org.yacare.bo.health;

import java.util.ArrayList;
import java.util.List;

import org.utiljdbc.ConnectionWrapper;
import org.yacare.bo.AbstractBo;
import org.yacare.model.health.BloodGroup;

public class BloodGroupBo extends AbstractBo {

	private final String MSG_2 = "Error al tratar de obtener los Grupos Sanguineos.";

	public List<BloodGroup> getBloodGroups(Integer offset, Integer limit) {
		try {

			if (offset == null) {
				offset = 0;
			}
			if (limit == null) {
				limit = 5;
			}

			if (limit > 100) {
				limit = 100;
			}

			ConnectionWrapper connectionWrapper = this.getDataSourceWrapper()
					.getConnectionWrapper();

			String sql = "SELECT * FROM yacare.f_blood_group(?, ?);";

			List<Object> list = connectionWrapper.findToJsonArray(sql,
					BloodGroup.class, offset, limit);

			List<BloodGroup> bloodGroups = new ArrayList<BloodGroup>();

			for (Object o : list) {
				bloodGroups.add((BloodGroup) o);
			}

			connectionWrapper.close();

			return bloodGroups;

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(MSG_2);
		}
	}

}
