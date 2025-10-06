package utilititiesClass;

import java.io.IOException;
import java.util.Arrays;

import org.testng.annotations.DataProvider;

public class dataProvider {
	
	@DataProvider(name = "Login")

	public String[][] getLoginData() throws IOException {
		String LoginData[][] = null;
		try {
			String path = ".\\testData\\Login_datadriventestnew.xlsx";

			excelUtility excelutil = new excelUtility(path);
			int rows = excelutil.get_totalrows("sheet1");
			int cols = excelutil.get_totalcells("sheet1", 1);

			System.out.println("total rows--> " + rows);
			System.out.println("total cols--> " + cols);

			LoginData = new String[rows][cols];
			for (int i = 1; i <=rows; i++) {
				for (int j = 0; j < cols; j++) {
					LoginData[i - 1][j] = excelutil.get_cellvalue("sheet1", i, j);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("login data array" + Arrays.deepToString(LoginData));
		return LoginData;
	}

}
