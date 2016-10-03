package org.yacare.bo.communication_options.phone;

import java.util.ArrayList;
import java.util.List;

import org.cendra.commons.utiljdbc.ConnectionWrapper;
import org.yacare.bo.AbstractBo;
import org.yacare.model.person.communication_options.phone.PhoneType;

public class PhoneTypeBo extends AbstractBo {

	private final String MSG_2 = "Error al tratar de obtener los Tipos de Teléfonos.";

	public List<PhoneType> getTypesOfPhones(Integer offset, Integer limit) {
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

			String sql = "SELECT * FROM yacare.f_phone_type(?, ?);";

			List<Object> list = connectionWrapper.findToJsonArray(sql,
					PhoneType.class, offset, limit);	
			

			List<PhoneType> typesOfPhones = new ArrayList<PhoneType>();

			for (Object o : list) {
				typesOfPhones.add((PhoneType) o);
			}

			connectionWrapper.close();			

			return typesOfPhones;

		} catch (Exception e) {
			
			e.printStackTrace();
			throw new RuntimeException(MSG_2);
		}
	}

}
