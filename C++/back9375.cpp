#include<bits/stdc++.h>
using namespace std;

int tc, n;

string clothes;

int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> tc;
    
    for(int i = 0; i<tc; i++) {
    	
//    	map<pair<string, string> > closet;
    	vector<pair<string, string> > closet;
    	cin >> n;
    	for(int j =0; j<n; j++) {
    		string temp[2];
    		for(int x = 0; x<2; x++) {
    			cin >> clothes;
				temp[x] = clothes;
			}
			
    		closet.push_back({temp[1], temp[0]});
			
			cout << closet[j].first << "\n";
			cout << closet[j].second << "\n";
		}
		
//		for(int x = 0; x<closet.size(); x++) {
//			cout << closet[i].first << " : " << closet[i].second << "\n";
//		}
//		for(map<string, string>::iterator it = closet.begin(); it != closet.end(); it++ ) {
//		cout << it->first << " : " << it->second << "\n";		
//		}

	}
}


