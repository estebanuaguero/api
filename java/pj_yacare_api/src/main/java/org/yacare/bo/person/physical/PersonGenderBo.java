package org.yacare.bo.person.physical;

import java.util.ArrayList;
import java.util.List;

import org.cendra.commons.utiljdbc.ConnectionWrapper;
import org.yacare.bo.AbstractBo;
import org.yacare.model.person.physical.PersonGender;

public class PersonGenderBo extends AbstractBo {

	private final String MSG_2 = "Error al tratar de obtener los Géneros.";

	public List<PersonGender> getGenders(Integer offset, Integer limit) {
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

			String sql = "SELECT * FROM yacare.f_gender(?, ?);";

			List<Object> list = connectionWrapper.findToJsonArray(sql,
					PersonGender.class, offset, limit);

			List<PersonGender> genders = new ArrayList<PersonGender>();

			for (Object o : list) {
				genders.add((PersonGender) o);
			}

			connectionWrapper.close();

			return genders;

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(MSG_2);
		}
	}

}
