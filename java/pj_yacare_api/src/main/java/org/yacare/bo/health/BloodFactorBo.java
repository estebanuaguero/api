package org.yacare.bo.health;

import java.util.ArrayList;
import java.util.List;

import org.cendra.commons.utiljdbc.ConnectionWrapper;
import org.yacare.bo.AbstractBo;
import org.yacare.model.health.BloodFactor;

public class BloodFactorBo extends AbstractBo {

	private final String MSG_2 = "Error al tratar de obtener los Factores Sanguineos.";

	public List<BloodFactor> getBloodFactors(Integer offset, Integer limit) {
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

			String sql = "SELECT * FROM yacare.f_blood_factor(?, ?);";

			List<Object> list = connectionWrapper.findToJsonArray(sql,
					BloodFactor.class, offset, limit);

			List<BloodFactor> bloodFactors = new ArrayList<BloodFactor>();

			for (Object o : list) {
				bloodFactors.add((BloodFactor) o);
			}

			connectionWrapper.close();

			return bloodFactors;

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(MSG_2);
		}
	}

}
