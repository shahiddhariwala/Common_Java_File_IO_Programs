package searchInsideFiles;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

class Indices {
	String fileName;
	int lineNumber;
	public Indices(String s,int n)
	{
		this.fileName=s;
		this.lineNumber=n;
	}
	public String toString()
	{
		return "File "+fileName+" lineNumber "+lineNumber;
	}
}

public class Searching_Words_Inside_File {

	public static boolean searchWord(String str)
	{
		if(wordIndexMap.containsKey(str))
		{
			ArrayList<Indices> tempList = wordIndexMap.get(str);
			for(Indices i : tempList)
			{
				System.out.println(i);
			}
			return true;
		}
		else
		{
			System.out.println("Word not found");
			return false;
		}
			
	}
	public static int getWordCount(String word)
	{
		return wordIndexMap.get(word).size();
	}
	public static HashMap<String, ArrayList<Indices>> wordIndexMap = new HashMap<String, ArrayList<Indices>>();
//bhai ka gyan this is also called as Inverted Index
	public static void main(String[] args) throws FileNotFoundException, IOException {
		// there are 3 files we have to find number of times a word occurs

		
		FileInputStream in;
		BufferedReader br ;
		String path;
		//traversing the files
		for(int i=1;i<=3;i++)
		{
			path = "src/searchInsideFiles/file"+i+".txt";
			in = new FileInputStream(path);
			br = new BufferedReader(new InputStreamReader(in));
			int lineNumber=0;
			//traversing line and ceating the index;
			String currentLine = br.readLine();
			while (currentLine != null) {
				lineNumber++;
				String arr[] = currentLine.split(" ");
				
				for(String str : arr)
				{
					if(!wordIndexMap.containsKey(str))
					{
						ArrayList<Indices> temp = new ArrayList<Indices>();
						temp.add(new Indices("file"+i+".txt",lineNumber));
						wordIndexMap.put(str,temp);
					}
					else
					{
						wordIndexMap.get(str).add(new Indices("file"+i+".txt",lineNumber));
					}
				}
				currentLine = br.readLine();
			}
			br.close();
		}
		
		BufferedReader kin = new BufferedReader(new InputStreamReader(System.in));
		int option;
		do
		{
			System.out.println("My Local Search Engine: ");
			System.out.println("\t1. Search a Word");
			System.out.println("\t2. Get Number of Count of Word");
			System.out.println("\t3. EXIT");
			option =Integer.parseInt(kin.readLine());
			switch(option)
			{
			case 1:
				System.out.println("Enter a word");
				String word=kin.readLine();
				searchWord(word);
				break;
			case 2:
				System.out.println("Enter a word to get word count");
				String wordc=kin.readLine();
				if(searchWord(wordc))
				{
					System.out.println("Count "+getWordCount(wordc));
				}
				break;
			case 3:
				System.out.println("Sayonara");
				System.exit(0);
				break;
			default:
				System.out.println("Please Enter Valid Option");
				break;
			}
			
		}while(option !=3);
		
		

	}

}
