package com;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

public class CSVreader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//List<Employee> files=readFileFromCsv("input.csv");
		String z="C:\\Users\\User\\eclipse-workspace\\csv1\\inputfile.csv";
		List<Employee1> files = CSVreader.readCSVfile(z);
		//for(Employee1 f: files)
		//
			//System.out.println(f.getFirst_name());
		//}
		
		List<Employee> A = Sortedlist(files);
		for(Employee ab: A)
		{
			System.out.println(ab.getFirst_name());
		}
		//filterFileBasedOnCity(files);
		for(Employee1 b: files)
		{
			if(b.getCity().equals("New York"))
			{
				System.out.println(b.getFirst_name()+" "+b.getLast_name()+" "+b.getCompany_name());
			}
		}
	}
	public static List<Employee> Sortedlist(List<Employee1> l)
	{
		
		for(int i=0;i<l.size()-1;i++)
		{
			for(int j=0;j<l.size()-1;j++)
			{
				if(l.get(i).getFirst_name().compareTo(l.get(j).getFirst_name())<0)
				{
					Collections.swap(l,i,j);
				}
					
			}
		}
		return l;
	
	}
public CSVreader()
{
	super();
}
	private static List<Employee> readCSVfile(String fileName)
	{
		List<Employee> files=new ArrayList<>();
		Path PathtofFile=Paths.get(fileName);//to get the filepath
		try
		//(BufferedReader br=Files.newBufferedReader(Pathtofile,StandardCharsets.US_ASCII))
		{ 
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line=br.readLine();
			while(line!=null)
			{
				String[] attributes = line.split(",");
				Employee file = createList(attributes);
				files.add(file);
				line=br.readLine();
			}
		} catch(IOException ioe)
		{
			ioe.printStackTrace(); //it prints the error class and error line
		}
		return files;
	}
	
	/*private static Employee create_files(String[] attributes) {
		// TODO Auto-generated method stub
		return null;
	}*/

	private static Employee createList(String[] metadata)
	{
		String first_name=metadata[0];
		String last_name=metadata[1];
		String company_name=metadata[2];
		String address=metadata[3];
		String city=metadata[4];
		String country=metadata[5];
		String state=metadata[6];
		String zip=metadata[7];
		String phone_num1=metadata[8];
		String phone_num2=metadata[9];
		String e_mail=metadata[10];
		String web=metadata[11];
		return new Employee(first_name.replace("\"", ""),last_name.replace("\"", ""),company_name.replace("\"", ""),address.replace("\"", ""),city.replace("\"", ""),country.replace("\"", ""),state.replace("\"", ""),zip.replace("\"", ""),phone_num1.replace("\"", ""),phone_num2.replace("\"", ""),e_mail.replace("\"", ""),web.replace("\"", ""));
	
	}
	
	
	
	}

