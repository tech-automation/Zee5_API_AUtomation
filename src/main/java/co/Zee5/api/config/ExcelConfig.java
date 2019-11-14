package co.Zee5.api.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * Excel configuration class to get the test data from the excel sheets
 *
 * @author Ooviya
 *
 */
public class ExcelConfig implements Constants {

	static Workbook workbook;
	static Sheet worksheet;
	static GoogleSheetAPI sheetAPI = new GoogleSheetAPI();
	static String sourceClass = ExcelConfig.class.getName();
	static Logger LOGGER = Logger.getLogger(sourceClass);
	static String sourceMethod;

	// TODO: We can remove this method once all the data provider are used with
	// "getTestDataAsMap" method
	/**
	 * Return TestData as String array object
	 *
	 * @param sheetName
	 * @return testData as String Object[][]
	 */
	public static Object[][] getTestData(String sheetName) {
		sourceMethod = "getTestData";
		LOGGER.entering(sourceClass, sourceMethod);

		FileInputStream file = null;

		try {
			file = new FileInputStream(XL_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			workbook = WorkbookFactory.create(file);
		} catch (Exception e) {
			e.printStackTrace();
		}

		worksheet = workbook.getSheet(sheetName);
		LOGGER.info("Number of Rows: " + worksheet.getLastRowNum() + " Number of Cells : "
				+ worksheet.getRow(0).getLastCellNum());
		Object[][] data = new Object[worksheet.getLastRowNum()][worksheet.getRow(0).getLastCellNum()];

		for (int i = 0; i < worksheet.getLastRowNum(); i++) {
			for (int k = 0; k < worksheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = worksheet.getRow(i + 1).getCell(k).toString();
			}
		}
		LOGGER.exiting(sourceClass, sourceMethod);
		return data;
	}

	// TODO: We can remove this method if it is no where used
	/**
	 * Returns cell value of given sheet, row and column
	 *
	 * @param xlPath
	 * @param sheetName
	 * @param row
	 * @param col
	 * @return Cell value as String
	 */
	public static String getCellValue(String xlPath, String sheetName, int row, int col) {
		sourceMethod = "getCellValue";
		LOGGER.entering(sourceClass, sourceMethod);

		LOGGER.info("Given xlpath: " + xlPath + " Sheet name: " + sheetName + " Row: " + row + " Column: " + col);
		String str = null;
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(xlPath));
			str = wb.getSheet(sheetName).getRow(row).getCell(col).toString();
			LOGGER.info("Value of cell : " + str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		LOGGER.info("str value is " + str);
		LOGGER.exiting(sourceClass, sourceMethod);
		return str;
	}

	/**
	 * Returns test data as Map with column name as "key" and cell values as "value"
	 *
	 * @author Ooviya
	 * @param sheetName
	 * @return Test data as Map
	 */
	public static Object[][] getTestDataAsMap(String fileName, String sheetName) {
		sourceMethod = "getTestDataAsMap";
		LOGGER.entering(sourceClass, sourceMethod);

		FileInputStream file = null;

		try {
			file = new FileInputStream(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			workbook = WorkbookFactory.create(file);
		} catch (Exception e) {
			e.printStackTrace();
		}

		worksheet = workbook.getSheet(sheetName);
		LOGGER.info("Number of Rows: " + worksheet.getLastRowNum() + " Number of Cells : "
				+ worksheet.getRow(0).getLastCellNum());

		Object[][] data = new Object[worksheet.getLastRowNum()][worksheet.getRow(0).getLastCellNum()];

		for (int i = 0; i < worksheet.getLastRowNum(); i++) {
			Map<Object, Object> dataMap = new HashMap<>();
			for (int j = 0; j < worksheet.getRow(0).getLastCellNum(); j++) {
				LOGGER.info("Row : " + (i + 1) + " Key: " + worksheet.getRow(0).getCell(j).toString() + " Value: "
						+ worksheet.getRow(i + 1).getCell(j).toString());
				dataMap.put(worksheet.getRow(0).getCell(j).toString(), worksheet.getRow(i + 1).getCell(j).toString());
			}
			data[i][0] = dataMap;

		}
		LOGGER.exiting(sourceClass, sourceMethod);
		return data;
	}

	/**
	 * Get test data from Google spreadsheet API
	 *
	 * @author Ooviya
	 * @param spreadsheetId
	 * @param range
	 * @return Test data as Map objects
	 */
	public static Object[][] getTestDataFromGoogleSheet(String spreadsheetId, String range) {
		List<List<Object>> values = null;
		try {
			values = sheetAPI.getSpreadSheetRecords(spreadsheetId, range);
		} catch (IOException e) {
			e.printStackTrace();
		}

		LOGGER.info("Number of Rows: " + (values.size() - 1) + " Number of Column : " + (values.get(0).size()));

		Object[][] data = new Object[values.size() - 1][values.get(0).size()];

		for (int i = 1; i < values.size(); i++) {
			Map<Object, Object> dataMap = new HashMap<Object, Object>();
			for (int j = 0; j < values.get(i).size(); j++) {
				LOGGER.info("Row : " + (i) + " Key: " + values.get(0).get(j) + " Value: " + values.get(i).get(j));
				dataMap.put(values.get(0).get(j), values.get(i).get(j));

			}
			data[i - 1][0] = dataMap;
		}
		return data;
	}

}