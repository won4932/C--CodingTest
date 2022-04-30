#include<bits/stdc++.h>
using namespace std;

int tc, n;

string name, catag;
map<string, int> m;
int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> tc;
    
    for(int i = 0; i<tc; i++) {
       
       map<string, int> closet;

       cin >> n;
       for(int j =0; j<n; j++) {
       	
       	cin >> name >> catag;
       	
       	if(closet.find(catag) == closet.end()) closet.insert({catag, 1});
       	else closet[catag]++;
      }
      
      int result = 1;
      
      for(auto iter : closet){
      	result *= (iter.second + 1);
	  }
	  
	  result -= 1;
	  cout << result << "\n";
   }
}
