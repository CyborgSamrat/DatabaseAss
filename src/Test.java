public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String path = "/home/samrat/Desktop/yoochoose-data/yoochoose-clicks.dat";
		Reader reader = new Reader();
		reader.readCSV(path);

	}

}
