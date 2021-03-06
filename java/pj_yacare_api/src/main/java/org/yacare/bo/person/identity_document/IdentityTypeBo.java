package org.yacare.bo.person.identity_document;

import java.util.ArrayList;
import java.util.List;

import org.cendra.commons.utiljdbc.ConnectionWrapper;
import org.yacare.bo.AbstractBo;
import org.yacare.model.person.identity_document.IdentityType;

public class IdentityTypeBo extends AbstractBo {

	private final String MSG_2 = "Error al tratar de obtener los Tipos de Documentos de Identidad.";

	public List<IdentityType> getIdentityTypes(Integer offset, Integer limit) {
		try {

			if(offset == null){
				offset = 0;
			}
			if(limit == null){
				limit = 5;
			}
			
			if(limit > 100){
				limit = 100;
			}
			
			ConnectionWrapper connectionWrapper = this.getDataSourceWrapper()
					.getConnectionWrapper();

			String sql = "SELECT * FROM yacare.f_identity_type(?, ?);";

			List<Object> list =  connectionWrapper
					.findToJsonArray(sql, IdentityType.class, offset, limit);
			
			List<IdentityType> identityTypes = new ArrayList<IdentityType>();
			
			for(Object o : list){
				identityTypes.add((IdentityType)o);
			}

			connectionWrapper.close();

			return identityTypes;

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(MSG_2);
		}
	}

}
