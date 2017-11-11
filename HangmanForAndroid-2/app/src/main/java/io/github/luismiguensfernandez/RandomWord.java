package io.github.luismiguensfernandez;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.content.Context;

public class RandomWord {

	public static String get(Context context) throws Exception
	{		
		InputStream input = context.getAssets().open("words.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(input));
		List<String> words = new ArrayList<String>();
	    
		String word;
	    while ((word = reader.readLine()) != null) 
	    {
	        words.add(word);
	    }
	    reader.close();
	    
	    Random randomGenerator = new Random();
	    return words.get(randomGenerator.nextInt(words.size())); 
	}
}
