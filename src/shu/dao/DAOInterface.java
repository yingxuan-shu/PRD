package shu.dao;

import java.util.List;

public interface DAOInterface {

	/**
	 * Read datas from the file csv
	 * 
	 * @param filePath The path of the file
	 * @return get all the data in the file
	 */
	static List<List<String>> readTxtFile(String filePath) {
		return null;
	}
	
	/**
	 * Get the file name when write the results
	 * 
	 * @param inputFileName This is input file name
	 * @return Output file name
	 */
	static String getOutputFileName(String inputFileName) {
		return null;
	}
	
	/**
	 * Write the results in a file txt
	 * 
	 * @param listResultat This is a list of results
	 * @param filePath This is the output file path
	 */
	static void writeTxtFile(List<List<Integer>> listResultat, String filePath) {
	}
}
