package org.yacare.bo.person.physical;

import java.util.ArrayList;
import java.util.List;

import org.cendra.commons.utiljdbc.ConnectionWrapper;
import org.yacare.bo.AbstractBo;
import org.yacare.model.academic.student.FamilyRelationshipType;

public class FamilyRelationshipTypeBo extends AbstractBo {

	private final String MSG_2 = "Error al tratar de obtener los Tipos de Relación Familiar.";

	public List<FamilyRelationshipType> getFamilyRelationshipTypes(Integer offset, Integer limit) {
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

			String sql = "SELECT * FROM yacare.f_family_relationship_type(?, ?);";

			List<Object> list = connectionWrapper.findToJsonArray(sql,
					FamilyRelationshipType.class, offset, limit);

			List<FamilyRelationshipType> familyRelationshipTypes = new ArrayList<FamilyRelationshipType>();

			for (Object o : list) {
				familyRelationshipTypes.add((FamilyRelationshipType) o);
			}

			connectionWrapper.close();

			return familyRelationshipTypes;

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(MSG_2);
		}
	}

}
