package org.yacare.model.academic.student.legal_guardian;

import java.util.ArrayList;
import java.util.List;

import org.cendra.commons.utiljdbc.ConnectionWrapper;
import org.yacare.bo.AbstractBo;

public class EducationLevelBo extends AbstractBo {

	private final String MSG_2 = "Error al tratar de obtener los tipos de nivel educativo.";

	public List<EducationLevel> getEducationLevels(Integer offset, Integer limit) {
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

			String sql = "SELECT * FROM yacare.f_education_level_type(?, ?);";

			List<Object> list = connectionWrapper.findToJsonArray(sql,
					EducationLevel.class, offset, limit);

			List<EducationLevel> educationLevels = new ArrayList<EducationLevel>();

			for (Object o : list) {
				educationLevels.add((EducationLevel) o);
			}

			connectionWrapper.close();

			return educationLevels;

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(MSG_2);
		}
	}

}
