
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MyFileIOTemplate
{

	public static void main(String[] args) throws IOException
	{
		// Input
		File input = new File("Input.txt");
		File output = new File("Output.txt");
		input.createNewFile();
		output.createNewFile();
		// return false if file exist
		// System.out.println("File Creation Done");

		// Reading from File
		BufferedReader br = new BufferedReader(new FileReader(input));
		// Writing to file
		BufferedWriter bw = new BufferedWriter(new FileWriter(output));
		for (int i = 0; i < 10; i++)
		{
			String num = br.readLine();
			bw.write("from input file " + num + "\n");
		}
		br.close();
		bw.close();
	}

}
