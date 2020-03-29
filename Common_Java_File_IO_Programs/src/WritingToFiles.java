import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.stream.Stream;

public class WritingToFiles {

	public static void main(String[] args) throws IOException {
		System.out.println("We will write some things in file :P");
		
		
		File myFile = new File("src/SampleOutput.txt");
		if(myFile.createNewFile())
		{
			System.out.println("File Created "+myFile.getName());
		}
		else
		{
			System.out.println("File Already Exist");
		}
		FileWriter fileWriter = new FileWriter(myFile);
		for(int i=1;i<=10;i++)
		{
			fileWriter.append("Something\n");
			fileWriter.flush();
		}
		//reading from file 
		FileReader inputFile = new FileReader(myFile);
		BufferedReader br = new BufferedReader(inputFile);
		br.lines().forEach(s-> System.out.println(s));
		br.close();
		fileWriter.close();
		//without flushing or closing stream  data wont be added into file after exit
	}

}
