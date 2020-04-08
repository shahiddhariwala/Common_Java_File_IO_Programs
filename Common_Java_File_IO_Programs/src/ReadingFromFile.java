/*
Code by  : Shahid Dhariwala
LinkedIn : https://www.linkedin.com/in/shahiddhariwala/
Twitter  : https://twitter.com/shahiddhariwala
*/
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadingFromFile {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		FileInputStream in = new FileInputStream("src/SampleInput.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(in));

		String currentLine = br.readLine();
		while (currentLine != null) {

			System.out.println(currentLine);
			currentLine = br.readLine();
		}
		br.close();
	}

}
