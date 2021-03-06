package org.yacare.bo.academic.student.annual_enrollment;

import java.util.ArrayList;
import java.util.List;

import org.cendra.commons.utiljdbc.ConnectionWrapper;
import org.yacare.bo.AbstractBo;
import org.yacare.model.academic.student.annual_enrollment.AnnualEnrollment;

public class AnnualEnrollmentBo extends AbstractBo {

	private final String MSG_2 = "Error al tratar de obtener las matrículas anuales.";

	public List<AnnualEnrollment> getAnnualEnrollments(Integer offset,
			Integer limit, String idStudent, Boolean lastAdmission) {
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

			String sql = null;

			List<Object> list = null;

			if (idStudent == null || idStudent.trim().length() == 0
					&& lastAdmission == null) {

				sql = "SELECT * FROM yacare.f_annual_enrollment(?, ?);";
				list = connectionWrapper.findToJsonArray(sql,
						AnnualEnrollment.class, offset, limit);

			} else if (idStudent != null && idStudent.trim().length() > 0
					&& lastAdmission == null) {

				sql = "SELECT * FROM yacare.f_annual_enrollment(?, ?, ?);";
				list = connectionWrapper.findToJsonArray(sql,
						AnnualEnrollment.class, offset, limit, idStudent);
			} else if (idStudent != null && idStudent.trim().length() > 0
					&& lastAdmission != null) {

				sql = "SELECT * FROM yacare.f_annual_enrollment(?, ?, ?, ? );";
				list = connectionWrapper.findToJsonArray(sql,
						AnnualEnrollment.class, offset, limit, idStudent,
						lastAdmission);
			} else if (idStudent == null || idStudent.trim().length() == 0
					&& lastAdmission != null) {

				sql = "SELECT * FROM yacare.f_annual_enrollment(?, ?, ? );";
				list = connectionWrapper.findToJsonArray(sql,
						AnnualEnrollment.class, offset, limit, lastAdmission);

			}

			List<AnnualEnrollment> annualEnrollments = new ArrayList<AnnualEnrollment>();

			for (Object o : list) {
				annualEnrollments.add((AnnualEnrollment) o);
			}

			connectionWrapper.close();

			return annualEnrollments;

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(MSG_2);
		}
	}

}
