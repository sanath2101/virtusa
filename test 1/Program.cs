using System;
using System.Collections.Generic;

class GFG
{

static String CHARS = "abcdefghijklmnopqrstuvwxyz";
static int MAX = 26;

static String getString(char[] str, int n)
{
	Dictionary<char,
			char> uMap = new Dictionary<char,
										char>();
	for (int i = 0; i < MAX; i++)
	{
		if(!uMap.ContainsKey(CHARS[i]))
			uMap.Add(CHARS[i], CHARS[(i + 3)%MAX]);
		else
			uMap[CHARS[i]] = CHARS[(i + 3)%MAX ];
	}

	for (int i = 0; i < n; i++)
	{
		str[i] = uMap[str[i]];
	}
	return String.Join("", str);
}

public static void Main(String []args)
{
    Console.WriteLine("enter a string:");
    string String = Console.ReadLine();
	int n = String.Length;

	Console.WriteLine(getString(String.ToCharArray(), n));
}
}

