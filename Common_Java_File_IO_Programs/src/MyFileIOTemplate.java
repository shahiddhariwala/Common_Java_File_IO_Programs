/*
Code by  : Shahid Dhariwala
LinkedIn : https://www.linkedin.com/in/shahiddhariwala/
Twitter  : https://twitter.com/shahiddhariwala
*/

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
		String in;
		while ((in = br.readLine()) != null)
		{
			bw.write("#" + in + "\n");
		}
		br.close();
		bw.close();
	}

}
