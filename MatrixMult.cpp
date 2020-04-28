#include <iostream>
#include <stdio.h>

using namespace std;

int main()
{
	int arr1[2][2]={2,4,5,9};
	int arr2[2][2]={10,1,9,2};
	int ans[2][2];

	for(int i =0; i<4; i++)
	{
		for(int j=0; j<4; j++)
		{
			for(int k =0; k<4; k++)
			{
				ans[i][j]=arr1[i][k]*arr2[j][k];
			}
		}
		}
	


	for(int i =0; i<4;i++)
	{
		for(int j=0; j<4;j++)
		{
			cout<<ans[i][j]<<endl;
		}

		
	}
}