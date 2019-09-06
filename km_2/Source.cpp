#include <iostream>
#include <string>
#include <algorithm>
#include <ctime>
using namespace std;

int n = 26;

int Ceasar_code(int s1, int s2)
{
	if (s1 >= 'a' && s1 <= 'z')
		return (s1 - 'a' + s2) % n + 'a';
}

string code(string s1, int s2)
{
	for (int i = 0; i < s1.length(); ++i)
	{
		s1[i] = Ceasar_code(s1[i], s2);
	}
	return s1;
}

int decode_symb(int s1, int s2)
{
	int res = s1 - 'a' - s2;
	while (res < 0) 
		res += n;
	return res % n + 'a';
}

string decode(string s1, int s2)
{
	for (int i = 0; i < s1.length(); ++i)
	{
		s1[i] = decode_symb(s1[i], s2);
	}
	return s1;
}
char* perestanovka(string str, int key)
{
	int index;
	char* matr=new char[str.length()+1];
	int col = ((str.length() - 1) / key) + 1;
	for (int i = 0; i < str.length(); i++)
	{
		index = key * (i%col) + (i / col);
		matr[index] = str[i];
	}
	
	matr[str.length()] = '\0';
	return matr;
}

char* deperestanovka(char* str, int key)
{
	int index;
	int col = key;
	char* matr = new char[strlen(str) + 1];
	key = ((strlen(str) - 1) / col) + 1;
	for (int i = 0; i < strlen(str); i++)
	{
		index = key * (i%col) + (i / col);
		matr[index] = str[i];
	}

	matr[strlen(str)] = '\0';
	return matr;
}


int main()
{
	string str,s1, s2, matr;
	char* matr2;

	int key = 3, index;
		str.clear();
		cout << "Input latin lower text: "<< endl;
		cin >> str;
		cout << "Coded text(Ceasar): "<< (s1 = code(str, key))<< endl;
		cout << "Decoded code(Ceasar): "<< (s2 = decode(s1, key)) << endl;
		matr2 = perestanovka(str, key);	
		cout << "Coded text: " << matr2 <<endl;
		matr2 = deperestanovka( matr2, key);
		cout << "Decoded text: " << matr2 << endl;

		system("pause");
	return 0;
}

