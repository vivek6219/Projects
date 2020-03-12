import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javax.crypto.Mac;

import sun.security.util.Length;

public class L2Switch 
{

	@SuppressWarnings("null")
	public static void main(String args[])
	{
		int pktCounter =1;

		int[] mACtable = new int[3];
		//port 0= [destination address]

		mACtable[0] =0;
		mACtable[1] =0;
		mACtable[2] = 0;

		//				String line2 = Files.readAllLines(Paths.get(csvFile)).get(2);
		//System.out.println(br.readLine());
		//System.out.println(" "+pktCounter +" "+br.readLine());
		String csvFile = "E:/Users/Vivek/Workspace/Project2Switch/src/packets.csv";
		String line = "";

		try {
			FileReader readfile = new FileReader(csvFile);
			BufferedReader br = new BufferedReader(readfile);
			System.out.println("pkt "+pktCounter  + " port 0 " + " port1 " + " port 2 " + " port3 ");
			while((line =br.readLine())!= null)
			{
				String[] cols = line.split(csvFile);
				String getString= cols[0].toString();
				String getSource="";
				int getDest=0;
				for(int i =0; i<getString.length(); i++)
				{
					if(getString.charAt(i) == ',')
					{
						getSource=getString.substring(i+1,getString.length());
						break;
					}

				}

				for(int i =0; i<getString.length(); i++)
				{

					if(getString.charAt(i) == ',')
					{
						getDest=getString.indexOf(i, getString.length());
					}
				}
				for(int i =0; i<50; i++)
				{
					for(int j =0; j<3; j++)
					{
						if(mACtable[0] ==0)
						{
							//if the port 0 source address doesn't exist then flood the entire switch table.
							//System.out.println(pktCounter + "[xx,xx]" + []);
							mACtable[1]=getDest;
							System.out.println(pktCounter + " " + "[xx,xx]" + " ["+ getSource +"] " + " [" +getSource +"] " +" [" + getSource +"]");
							break;
						}
						else if(mACtable[1]==0)
						{
							mACtable[1]=getDest;
							System.out.println(pktCounter + " " + "["+ getSource +"]" + " [xx,xx]" + " [" +getSource +"] " +" [" + getSource +"]");
							break;
						}
						else if(mACtable[2] ==0)
						{
							mACtable[1]=getDest;
							System.out.println(pktCounter + " " + "["+ getSource +"]" + "[" +getSource +"] " + " [" +getSource +"] " +" [xx,xx]");
							break;

						}
						else if(mACtable[j] == getDest)
						{  
							if(mACtable[0]==getDest) {
								System.out.println(pktCounter + " " + "["+ getDest+"]" + "[xx,xx] " + " [xx,xx] " +" [xx,xx]");
								break;

							}
							else if(mACtable[1] ==getDest)
							{
								System.out.println(pktCounter + " " + "[xx,xx]" + "[" +getDest+"] " + " [xx,xx] " +" [xx,xx]");
								break;

							}
							else if(mACtable[2] ==getDest)
							{
								System.out.println(pktCounter + " " + "[xx,xx]" + " [xx,xx]" + " [xx,xx] " +" [" + getDest+"]");
								break;

							}
						}

					}


				}
				pktCounter++;

			}


		}catch (IOException e)
		{
			e.printStackTrace();
		}

	}



}
