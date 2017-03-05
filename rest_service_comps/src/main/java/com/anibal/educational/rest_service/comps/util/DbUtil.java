package com.anibal.educational.rest_service.comps.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.odhoman.api.utilities.db.DatabaseConnection;

public class DbUtil {

	public final static String MASCARA_TIMESTAMP = "YYYY-MM-DD HH24:MI:SS.FF";
	public final static String MIN_TIMESTAMP = "1900-01-01 00:00:00.0";
	public final static String MAX_TIMESTAMP = "9999-12-31 00:00:00.0";

	public DbUtil() {
	}

	/**
	 * Devuelve el proximo valor de la sequencias pasada como parametro.
	 * 
	 * @param DatabaseConnection
	 *            con la conexion a la db. seqName nombre de la secuencia
	 * @return Long nextval de la sequencia En caso de error devuelve SQLException para que sea manejada desde el metodo
	 *         que invoca.
	 */
	public static Long getNewSequenceKey(DatabaseConnection db, String seqName) throws SQLException {
		Long nKey = null;

		String sql;
		PreparedStatement ps = null;
		ResultSet rs = null;

		// Busca en la sequencia para SubObjetoReclamos el proximo valor.
		// sql = " select nextval('" + seqName + "') as n_key";

		sql = " select " + seqName + ".NEXTVAL as n_key from DUAL";

		ps = db.prepare(sql);
		rs = ps.executeQuery();
		if (rs.next())
			nKey = Long.valueOf(rs.getLong("n_key"));
		rs.close();
		ps.close();

		return nKey;
	}

	/**
	 * Devuelve la descripcion correspondiente a los datos pasados como parametro.
	 * 
	 * @param DatabaseConnection
	 *            con la conexion a la db. tableName nombre de la tabla colKey columna clave colDes columna con la
	 *            descripcion a recuperar valKey valor de la clave
	 * @return String descripcion recuperada En caso de error devuelve SQLException para que sea manejada desde el
	 *         metodo que invoca.
	 */
	public static String getDescriptionByKey(DatabaseConnection db, String tableName, String colKey, String colDes,
			Long valKey) throws SQLException {
		String valDes = "";
		String sql;
		PreparedStatement ps = null;
		ResultSet rs = null;

		// sql
		sql = " select " + colDes + " from " + tableName + " where " + colKey + " = " + valKey.toString();
		ps = db.prepare(sql);
		rs = ps.executeQuery();
		if (rs.next())
			valDes = rs.getString(colDes);
		rs.close();
		ps.close();
		return valDes;
	}

	/**
	 * Devuelve la clausula WHERE para filtrar los registros habilitados
	 * 
	 * @param campoHabilitado el campo que debe contener lo valores pasados por parametros
	 * @param params parametros que especifican cuales son los valores habilitados
	 * @param withWhere String de la clausula WHERE que se aplicara en la consulta a la tabla, si tiene
	 */
	public static String getClausulaWhereHabilitados(String campoHabilitado, String params) {
		return getClausulaHabilitados(campoHabilitado, params, " where");
	}
	
	/**
	 * Devuelve la clausula del campo que tiene habilitado con sus valores
	 * 
	 * @param campoHabilitado el campo que debe contener lo valores pasados por parametros
	 * @param params parametros que especifican cuales son los valores habilitados
	 * @param prefix String un prefijo que se aplicara en la consulta a la tabla, si tiene
	 */
	public static String getClausulaHabilitados(String campoHabilitado, String params, String prefix) {
		String codigos = "";
		String[] strCodesHabilitados = params.split(",");
		for (int i=0; i < strCodesHabilitados.length; i++){
			codigos += "'" + strCodesHabilitados[i] + "'";
			if (i+1 < strCodesHabilitados.length)
				codigos += ","; 
		}
		
		if(prefix==null){
			prefix="";
		}
		
		return prefix+" "+campoHabilitado+" IN (" + codigos + ") ";
	}
	
	 public static byte[] incrementalByteCopy(InputStream inputStream) throws IOException {
		 
		 byte[] chunk = new byte[4096]; //leo de a 4k
	       
		 int cant = 1;
	     byte[] result = new byte[0]; //leo de a 4k

	     while ((cant=inputStream.read(chunk))>0) {
	    		 
	    	 byte[] cadenaTem = new byte[result.length];
	    		 
	    	 //salvo lo que lei hasta ahora en cadena tem
	    		 
	    	 System.arraycopy(result , 0, cadenaTem , 0,
	                                 result .length);

	    	 //declaro cadenaTotal con el tama�o que tenia + el que acabo de leer
	    	 result  = new byte[cadenaTem.length +cant];

	    	 //le vuelvo a copiar lo que tenia
	    	 System.arraycopy(cadenaTem, 0, result , 0,
	                              cadenaTem.length);
	    	 // ahora le copio lo nuevo que lei
	    	 System.arraycopy(chunk , 0, result , cadenaTem.length,
	                               cant);
	     }
	    	 
	     inputStream.close();
	            
	     return result;
	 }
}
