package org.cendra.commons.utiljdbc;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Types;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.cendra.commons.utiljdbc.ex.ExFindDao;
import org.cendra.commons.utiljdbc.ex.ExFindJsonDao;
import org.cendra.commons.utiljdbc.ex.ExUnexpectedResult;
import org.cendra.commons.utiljdbc.ex.ExUpdateInsertDao;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;

public class UtilJdbc {

	private boolean verbose = false;

	public boolean isVerbose() {
		return verbose;
	}

	public void setVerbose(boolean verbose) {
		this.verbose = verbose;
	}

	// ///////////////////////////////////////////////////////////////////

	public int update(ConnectionWrapper connectionWrapper, String sql,
			Object... args) {

		try {

			PreparedStatement preparedStatement = connectionWrapper
					.getConnection().prepareStatement(sql);

			if (args != null) {
				for (int i = 0; i < args.length; i++) {
					set(preparedStatement, args[i], (i + 1));
				}
			}

			sql = preparedStatement.toString();

			connectionWrapper.add(sql);

			// System.out.println(connectionWrapper.getSql()); // Con esta linea
			// podemos ver todos los sql que se ejecutaron con la misma
			// conexión.

			return executeUpdateByExample(preparedStatement);

		} catch (Exception e) {
			ExUpdateInsertDao ex = new ExUpdateInsertDao(this.getClass(), e,
					connectionWrapper);

			// ex.setFirstTrace(e, this.getClass());

			throw ex;
		}

	}

	// ///////////////////////////////////////////////////////////////////

	public boolean isExitsById(ConnectionWrapper connectionWrapper,
			String table, String id) {

		try {

			String sql = "SELECT COUNT(*) FROM " + table + " WHERE id = ?;";

			PreparedStatement preparedStatement = connectionWrapper
					.getConnection().prepareStatement(sql);

			if (id != null) {
				set(preparedStatement, id, 1);
			}

			sql = preparedStatement.toString();

			connectionWrapper.add(sql);

			return executeQueryByExampleForLong(preparedStatement) > 0;

		} catch (Exception e) {
			ExFindDao ex = new ExFindDao(this.getClass(), e, connectionWrapper);

			// ex.setFirstTrace(e, this.getClass());

			throw ex;
		}
	}

	// ///////////////////////////////////////////////////////////////////

	@SuppressWarnings("rawtypes")
	public Object findToJsonById(ConnectionWrapper connectionWrapper,
			String sql, Class clazz, String id) {

		Object[] listT = findToJson(connectionWrapper, sql, clazz, id);

		if (listT.length == 1) {
			return listT[0];
		}

		if (listT.length == 0) {

			return null;
		}

		ExUnexpectedResult e = new ExUnexpectedResult(this.getClass(),
				listT.length);

		ExFindDao ex = new ExFindDao(this.getClass(), e, connectionWrapper);

		// ex.setFirstTrace(e, this.getClass());

		throw ex;

	}

	@SuppressWarnings("rawtypes")
	public Object findToJsonByExample(ConnectionWrapper connectionWrapper,
			String sql, Class clazz, Object... args) {

		Object[] listT = findToJson(connectionWrapper, sql, clazz, args);

		if (listT.length == 1) {
			return listT[0];
		}

		if (listT.length == 0) {

			return null;
		}

		ExUnexpectedResult e = new ExUnexpectedResult(this.getClass(),
				listT.length);

		ExFindDao ex = new ExFindDao(this.getClass(), e, connectionWrapper);

		// ex.setFirstTrace(e, this.getClass());

		throw ex;

	}

	@SuppressWarnings("rawtypes")
	public Object[] findToJson(ConnectionWrapper connectionWrapper, String sql,
			Class clazz, Object... args) {

		try {

			PreparedStatement preparedStatement = connectionWrapper
					.getConnection().prepareStatement(sql);

			for (int i = 0; i < args.length; i++) {
				set(preparedStatement, args[i], (i + 1));
			}

			sql = preparedStatement.toString();

			connectionWrapper.add(sql);

			// System.out.println(connectionWrapper.getSql()); // Con esta linea
			// podemos ver todos los sql que se ejecutaron con la misma
			// conexión.

			return executeQueryToJson(connectionWrapper, preparedStatement,
					clazz);

		} catch (ExFindJsonDao ex) {
			throw ex;
		} catch (Exception e) {
			ExFindDao ex = new ExFindDao(this.getClass(), e, connectionWrapper);

			// ex.setFirstTrace(e, this.getClass());

			throw ex;
		}

	}

	@SuppressWarnings("rawtypes")
	public List<Object> findToJsonArray(ConnectionWrapper connectionWrapper,
			String sql, Class clazz, Object... args) {

		try {

			PreparedStatement preparedStatement = connectionWrapper
					.getConnection().prepareStatement(sql);

			for (int i = 0; i < args.length; i++) {
				set(preparedStatement, args[i], (i + 1));
			}

			sql = preparedStatement.toString();

			connectionWrapper.add(sql);

			// System.out.println(connectionWrapper.getSql()); // Con esta linea
			// podemos ver todos los sql que se ejecutaron con la misma
			// conexión.

			return executeQueryToJsonArray(connectionWrapper,
					preparedStatement, clazz);

		} catch (ExFindJsonDao ex) {
			throw ex;
		} catch (Exception e) {
			ExFindDao ex = new ExFindDao(this.getClass(), e, connectionWrapper);

			// ex.setFirstTrace(e, this.getClass());

			throw ex;
		}

	}

	public Object[][] findToTable(ConnectionWrapper connectionWrapper,
			String sql, Object... args) {

		try {

			PreparedStatement preparedStatement = connectionWrapper
					.getConnection().prepareStatement(sql);

			if (args != null) {
				for (int i = 0; i < args.length; i++) {
					set(preparedStatement, args[i], (i + 1));
				}
			}

			sql = preparedStatement.toString();

			connectionWrapper.add(sql);

			// System.out.println(connectionWrapper.getSql()); // Con esta linea
			// podemos ver todos los sql que se ejecutaron con la misma
			// conexión.

			return executeQueryToTable(preparedStatement);

		} catch (Exception e) {
			ExFindDao ex = new ExFindDao(this.getClass(), e, connectionWrapper);

			// ex.setFirstTrace(e, this.getClass());

			throw ex;
		}

	}

	public ResultList findToResultList(ConnectionWrapper connectionWrapper,
			String sql, String sqlCount, int offSet, int limit, Object... args) {

		try {

			PreparedStatement preparedStatement = connectionWrapper
					.getConnection().prepareStatement(sql);

			int c = 1;

			if (args != null) {
				for (int i = 0; i < args.length; i++) {
					set(preparedStatement, args[i], (i + 1));
				}

				c = args.length + 1;
			}

			set(preparedStatement, offSet, c);
			c++;
			set(preparedStatement, limit, c);

			sql = preparedStatement.toString();

			connectionWrapper.add(sql);

			Object[][] listT = executeQueryToTable(preparedStatement);

			// =====================================================================

			preparedStatement = connectionWrapper.getConnection()
					.prepareStatement(sqlCount);

			if (args != null) {
				for (int i = 0; i < args.length; i++) {
					set(preparedStatement, args[i], (i + 1));
				}
			}

			sql = preparedStatement.toString();

			connectionWrapper.add(sql);

			// =====================================================================

			Long rowCount = executeQueryByExampleForLong(preparedStatement);

			Long cantPages = 0L;

			if (listT.length > 0) {
				cantPages = 1L;
			}

			if (limit > 0) {
				cantPages = rowCount / limit;
				if ((rowCount % limit) > 0) {
					cantPages++;
				}
			}

			ResultList resultList = new ResultList();

			resultList.setList(listT);
			resultList.setCantPages(cantPages);
			resultList.setNumberOfRecords(rowCount);

			return resultList;

		} catch (Exception e) {
			ExFindDao ex = new ExFindDao(this.getClass(), e, connectionWrapper);

			// ex.setFirstTrace(e, this.getClass());

			throw ex;
		}

	}

	// ///////////////////////////////////////////////////////////////////

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private Object[] executeQueryToJson(ConnectionWrapper connectionWrapper,
			PreparedStatement preparedStatement, Class clazz) {

		String json = null;

		try {
			List<Object> listT = new ArrayList<Object>();

			printSQL(preparedStatement);

			ResultSet resultSet = preparedStatement.executeQuery();

			printSQLEnd();

			ObjectMapper mapper = buidlObjectMapper();

			while (resultSet.next()) {

				json = resultSet.getString(1);
				Object o = mapper.readValue(json, clazz);

				// Object o = xstream.fromXML(resultSet.getString(1));
				listT.add(o);

				// listT.add(resultSet.getString(1));
			}

			// if (resultSet != null && resultSet.isClosed() == false) {
			// resultSet.close();
			// }

			// if (preparedStatement != null && preparedStatement.isClosed() ==
			// false) {
			// preparedStatement.close();
			// }

			printEnd();

			return listT.toArray();

		} catch (Exception e) {
			ExFindJsonDao ex = new ExFindJsonDao(this.getClass(), e,
					connectionWrapper, json);

			// ex.setFirstTrace(e, this.getClass());

			throw ex;

		}

	}

	@SuppressWarnings("rawtypes")
	private List<Object> executeQueryToJsonArray(
			ConnectionWrapper connectionWrapper,
			PreparedStatement preparedStatement, Class clazz) {

		String json = null;

		try {
			List<Object> listT = null;

			printSQL(preparedStatement);

			ResultSet resultSet = preparedStatement.executeQuery();

			printSQLEnd();

			ObjectMapper mapper = buidlObjectMapper();

			while (resultSet.next()) {

				json = resultSet.getString(1);
				listT = mapper.readValue(json, mapper.getTypeFactory()
						.constructCollectionType(ArrayList.class, clazz));

			}

			if (listT == null) {
				listT = new ArrayList<Object>();
			}

			// if (resultSet != null && resultSet.isClosed() == false) {
			// resultSet.close();
			// }

			// if (preparedStatement != null && preparedStatement.isClosed() ==
			// false) {
			// preparedStatement.close();
			// }

			printEnd();

			return listT;

		} catch (Exception e) {
			ExFindJsonDao ex = new ExFindJsonDao(this.getClass(), e,
					connectionWrapper, json);

			// ex.setFirstTrace(e, this.getClass());

			throw ex;

		}

	}

	private Object[][] executeQueryToTable(PreparedStatement preparedStatement)
			throws SQLException {

		List<Object[]> listT = new ArrayList<Object[]>();

		printSQL(preparedStatement);

		ResultSet resultSet = preparedStatement.executeQuery();

		printSQLEnd();

		int c = resultSet.getMetaData().getColumnCount();

		while (resultSet.next()) {
			Object[] row = new Object[c];

			for (int j = 0; j < c; j++) {
				row[j] = resultSet.getObject((j + 1));
			}

			listT.add(row);
		}

		// if (resultSet != null && resultSet.isClosed() == false) {
		// resultSet.close();
		// }

		// if (preparedStatement != null && preparedStatement.isClosed() ==
		// false) {
		// preparedStatement.close();
		// }

		Object[][] table = new Object[listT.size()][c];

		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < c; j++) {
				table[i][j] = listT.get(i)[j];
			}

		}

		printEnd();

		return table;
	}

	// ///////////////////////////////////////////////////////////////////

	private int executeUpdateByExample(PreparedStatement preparedStatement)
			throws SQLException {

		printSQL(preparedStatement);

		int r = preparedStatement.executeUpdate();

		// if (preparedStatement.isClosed() == false) {
		// preparedStatement.close();
		// }

		return r;
	}

	// ///////////////////////////////////////////////////////////////////

	private Long executeQueryByExampleForLong(
			PreparedStatement preparedStatement) throws SQLException {

		Long l = 0L;

		printSQL(preparedStatement);

		ResultSet resultSet = preparedStatement.executeQuery();

		while (resultSet.next()) {
			l = resultSet.getLong(1);
		}

		// if (resultSet.isClosed() == false) {
		// resultSet.close();
		// }
		//
		// if (preparedStatement.isClosed() == false) {
		// preparedStatement.close();
		// }

		return l;
	}

	@SuppressWarnings("rawtypes")
	private void set(PreparedStatement preparedStatement, Object value,
			Integer i) throws SQLException {

		if (value != null) {

			if (value instanceof String) {

				preparedStatement.setString(i, (String) value);

			} else if (value instanceof Boolean) {

				preparedStatement.setBoolean(i, (Boolean) value);

			} else if (value instanceof Short) {

				preparedStatement.setShort(i, (Short) value);

			} else if (value instanceof Integer) {

				preparedStatement.setInt(i, (Integer) value);

			} else if (value instanceof Long) {

				preparedStatement.setLong(i, (Long) value);

			} else if (value instanceof Float) {

				preparedStatement.setFloat(i, (Float) value);

			} else if (value instanceof Double) {

				preparedStatement.setDouble(i, (Double) value);

			} else if (value instanceof BigDecimal) {

				preparedStatement.setBigDecimal(i, (BigDecimal) value);

			} else if (value instanceof Date) {

				preparedStatement.setDate(i, (Date) value);

			} else if (value instanceof Timestamp) {

				preparedStatement.setTimestamp(i, (Timestamp) value);

			} else if (value instanceof Time) {

				preparedStatement.setTime(i, (Time) value);

			} else if (value instanceof Class) {

				Class c = (Class) value;

				if (c.equals(String.class)) {
					preparedStatement.setNull(i, Types.VARCHAR);
				} else if (c.equals(Boolean.class)) {
					preparedStatement.setNull(i, Types.BOOLEAN);
				} else if (c.equals(Short.class)) {
					preparedStatement.setNull(i, Types.SMALLINT);
				} else if (c.equals(Integer.class)) {
					preparedStatement.setNull(i, Types.INTEGER);
				} else if (c.equals(Long.class)) {
					preparedStatement.setNull(i, Types.BIGINT);
				} else if (c.equals(Float.class)) {
					preparedStatement.setNull(i, Types.REAL);
				} else if (c.equals(Double.class)) {
					preparedStatement.setNull(i, Types.FLOAT);
				} else if (c.equals(BigDecimal.class)) {
					preparedStatement.setNull(i, Types.NUMERIC);
				} else if (c.equals(Date.class)) {
					preparedStatement.setNull(i, Types.DATE);
				} else if (c.equals(Timestamp.class)) {
					preparedStatement.setNull(i, Types.TIMESTAMP);
				} else if (c.equals(Time.class)) {
					preparedStatement.setNull(i, Types.TIME);
				} else {
					throw new RuntimeException(
							"Se pretende agregar un parámetro a una sentencia sql que posee un tipo de dato desconocido. Se recibió "
									+ value
									+ ", y se espera String | Boolean | Short | Integer | Long | Float | Double | BigDecimal | Date | Timestamp | Time");
				}

			} else {
				throw new RuntimeException(
						"Se pretende agregar un parámetro a una sentencia sql que posee un tipo de dato desconocido. Se recibió "
								+ value
								+ ", y se espera String | Boolean | Short | Integer | Long | Float | Double | BigDecimal | Date | Timestamp | Time");
			}
		}
	}

	private void printSQL(PreparedStatement preparedStatement) {
		printSQL(preparedStatement.toString());
	}

	private void printSQL(String sql) {

		if (isVerbose()) {
			System.out
					.println("\n--------------------- START - SQL --------------------------- "
							+ new Timestamp(System.currentTimeMillis()) + "\n");
			System.out.println(sql);
		}

	}

	private void printSQLEnd() {

		// if (isVerbose()) {
		// System.out.println(new Timestamp(System.currentTimeMillis()));
		// }

		if (isVerbose()) {
			System.out
					.println("\n---------------------  END - SQL ---------------------------- "
							+ new Timestamp(System.currentTimeMillis()) + "\n");
		}

	}

	private void printEnd() {

		if (isVerbose()) {
			// System.out.println("---------------------  END - SQL ---------------------------- "
			// + new Timestamp(System.currentTimeMillis()) + "\n");
		}

	}

	private ObjectMapper buidlObjectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		
		SimpleDateFormat sdf = new SimpleDateFormat(
				"yyyy-MM-dd'T'HH:mm:ss.SSSz");
		// mapper.setDateFormat(sdf);
		 mapper.getDeserializationConfig().withDateFormat(sdf);
//		mapper.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS,
//				false);

		return mapper;

	}

}
