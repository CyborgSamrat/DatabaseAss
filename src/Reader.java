import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Reader {

	int category;
	int dayQuardent;

	int counter = 0;

	public void readCSV(String path) {
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		String[] array = new String[5];

		try {

			br = new BufferedReader(new FileReader(path));
			while ((line = br.readLine()) != null) {
				if (counter == 50)
					break;
				counter++;

				// use comma as separator
				String[] rows = line.split(cvsSplitBy);
				array[0] = rows[2];
				array[1] = getCategory(rows[3]);

				System.out.println("ItemID = " + rows[0] + " , Category = "
						+ rows[3] + ", Time = " + rows[1]);

				fileWriter(array);

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	String getCategory(String s) {
		String c = "";

		if (s.compareTo("s") == 0)
			c = s;
		else if (Integer.parseInt(s) > 9999999
				|| Integer.parseInt(s) < 999999999)
			c = "14";
		else if (Integer.parseInt(s) >= 0 && Integer.parseInt(s) <= 12)
			c = s;

		return c;
	}

	void fileWriter(String[] array) {
		BufferedWriter writer = null;

		File path = new File("/media/samrat/Programming/test.txt");

		try {
			writer = new BufferedWriter(new FileWriter(path));
		} catch (Exception e) {
			System.out.print(e);
		}

		for (int i = 0; i < 4; i++) {
			try {
				writer.write("ItemID = " + array[0] + ", Category = "
						+ array[1]);
			} catch (Exception e) {
				System.out.print(e);
			}

		}

	}

}
