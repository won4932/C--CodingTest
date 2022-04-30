#include<bits/stdc++.h>
using namespace std;

int idx;

int alph[26];

string S;

int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    fill_n(alph, 26, -1);
    
    cin >> S;
    
    for(int i = 0; i<S.size(); i++) {
    	idx = (int)S[i] - 97;
		
		if(alph[idx] == -1)  alph[idx] = i;
	}
	
	for(auto a : alph) cout << a << ' ';
}


