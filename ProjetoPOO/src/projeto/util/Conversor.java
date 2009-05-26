package projeto.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import projeto.excecao.ExcecaoNegocio;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class Conversor {
	 /**
	* Converte uma String para um objeto java.sql.Date. Caso a String seja vazia ou nula,
	* retorna null – para facilitar em casos onde formulários podem ter campos
	* de datas vazios.
	*
	* @param strData String no formato dd/MM/yyyy a ser formatada
	* @return java.sql.Date
	* @throws Exception Caso a String esteja no formato errado
	*/
	public static Date parseDate(String strData) throws ExcecaoNegocio {
	if (strData == null || strData.equals("")) {
	return null;
	}
	java.util.Date date = null;
	try {
	DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
	date = (java.util.Date) f.parse(strData);
	} catch (ParseException e) {
	throw new ExcecaoNegocio("Data com formato inválido");
	} catch (java.text.ParseException e) {
		throw new ExcecaoNegocio("Data com formato inválido");
	}
	return date;
	}

	/**
	* Converte uma String para um objeto java.sql.Date. Caso a String seja vazia ou nula,
	* retorna null – para facilitar em casos onde formulários podem ter campos
	* de datas vazios.
	*
	* @param strData String no formato dd/MM/yyyy a ser formatada
	* @return java.sql.Date
	* @throws Exception Caso a String esteja no formato errado
	*/
	public static java.sql.Date parseDateSQL(String strData) throws ExcecaoNegocio {
	if (strData == null || strData.equals("")) {
	return null;
	}
	java.util.Date date = null;
	try {
	DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
	date = (java.util.Date) f.parse(strData);
	} catch (ParseException e) {
	throw new ExcecaoNegocio("Data com formato inválido");
	} catch (java.text.ParseException e) {
		throw new ExcecaoNegocio("Data com formato inválido");
	}
	return new java.sql.Date(date.getTime());
	} 
	
	public static  String formatDateSQL(java.sql.Date sqlData) throws ExcecaoNegocio {
		if (sqlData == null) {
		return null;
		}
		try {
		DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
		return f.format(new Date(sqlData.getTime()));
		} catch (ParseException e) {
		throw new ExcecaoNegocio("Data com formato inválido");
		}
		} 
}
