#include<bits/stdc++.h>
using namespace std;

int sum;

char num;

int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> N;
    
    for(int i = 0; i<N; i++) {
		cin >> num;
		sum+= num - '0';
	}
	
	cout << sum;
}


