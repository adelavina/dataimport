package com.globant.data.imp;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class CSVDataSource implements DataSourceInterface {
	private List<String> lines;
	Iterator<String> ite;
	String[] heads;
	
	/*
	 * New CSV Data Source Constructor
	 * @param f file CSV file to read
	 * @author: Alejandro de la Viña <a.delavina@globant.com>
	 */
	public CSVDataSource (File f) throws IOException
	{
		this.lines = FileUtils.readLines(f);
		ite = this.lines.iterator();
		
		heads = ite.next().split(",");
	}
	
	/*
	 * Method that retrieves a Map with the next data structure.<p>
	 * For this implementation a map that will always bring the same Keys and a set of Values per line
	 * @author Alejandro de la Viña <a.delavina@globant.com>
	 */
	@Override
	public HashMap<String,String> getNextRecord() {
		int i;
		if (ite.hasNext())
		{
			String[] line = ite.next().split(",");
			HashMap<String,String> hm = new HashMap<String,String>();
			for(i=0; i<=line.length; i++)
				hm.put(heads[i], line[i]);
			
			return hm;
		}
		return null;
		
	}

}
