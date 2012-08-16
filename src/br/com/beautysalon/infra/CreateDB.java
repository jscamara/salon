package br.com.beautysalon.infra;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class CreateDB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration conf = new Configuration();
		conf.configure();
		SchemaExport export = new SchemaExport(conf);
		export.create(true, true);
	}

}
